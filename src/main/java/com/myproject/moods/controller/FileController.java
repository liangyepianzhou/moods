package com.myproject.moods.controller;

import com.myproject.moods.Util.Resultbean;
import com.myproject.moods.annotation.UserLoginToken;
import com.myproject.moods.dao.mapper.UsermMapper;
import com.myproject.moods.filter.SensitiveWordFilter;
import com.myproject.moods.pojo.Says;
import com.myproject.moods.service.FileUploadService;
import com.myproject.moods.service.SaysService;
//import com.sun.javafx.tools.packager.Log;
//import com.oracle.tools.packager.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-18
 */
@Api(value = "文件相关的接口")
@RestController

public class FileController {
    final  String avatarPath ="src/main/resources/file/avatar/";
    final  String adPath ="src/main/resources/file/ad/";
    final  String photoPath ="src/main/resources/file/photo/";
    /***
     * 可以考虑在数据库中只存储文件名，再加上路径拼接
     */

    @Autowired
    UsermMapper usermMapper;
    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    SaysService saysService;
//    @PostConstruct
//    private void init(){
//        ExecutorService executorService = new ThreadPoolExecutor(,)
//    }
    /**
     *
     * @param file
     * @param httpServletRequest
     * @return
     */
    @UserLoginToken
    @PostMapping("/files/avatar")
    @ApiOperation("头像上传")
    public Resultbean avatar(@ApiParam(name="file",value = "图像文件",required = true) @RequestParam(name = "file") MultipartFile file ,
                          @ApiParam(name = "filename",value = "文件名可选",required = false) @RequestParam(name = "filename",required = false) String filename
                        ,@ApiParam(name = "username",value = "用户名",required = true) @RequestParam(name = "username",required = true)  String username
                        ,HttpServletRequest httpServletRequest){
        String fileOriginName =file.getOriginalFilename();
//        Log.info("fileOriginName"+fileOriginName);
        String []filenames =fileOriginName.split("\\.");
        String newName = UUID.randomUUID()+"."+filenames[1];
//        Log.info("newPath"+newName);
        File file1 =new File(new File(avatarPath +newName).getAbsolutePath()) ;
        fileUploadService.storeAvatar(file,file1,username);
        return Resultbean.success();
    }
    @UserLoginToken
    @ApiOperation("说说上传的接口")
    @PostMapping("/files/says")
    public Resultbean uploadSays(@ApiParam(name = "photos",value = "多个图片文件，统一命名为photos",required = false) @RequestParam(name = "photos",required = false)  MultipartFile[] photos,
                                 @ApiParam(name = "ad",required = false,value = "视频文件") @RequestParam(name = "ad",required = false) MultipartFile ad,
                                 @ApiParam(name = "says",value = "说说文字/限长500字",required =  true)@RequestParam("says") String says,
                                 @ApiParam(name = "username",value = "用户名",required = true)@RequestParam("username") String username
                                 )  {

        String photoPaths;
        String adNewName;
        /**
         * 存储图片
         */
        if(photos!=null&&photos.length!=0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < photos.length; i++) {
                if (photos[i] != null) {
                    String originalFilename = photos[i].getOriginalFilename();
                    String[] originalFilenames = originalFilename.split("\\.");
                    String newName = UUID.randomUUID() + originalFilenames[1];
                    /**
                     * 文件名以加号连接后放入数据库
                     */
                    stringBuilder.append(newName).append("+");
                    File file1 =new File(new File( photoPath + newName).getAbsolutePath()) ;

                    try {
                        fileUploadService.storeFile(photos[i],file1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
             photoPaths = stringBuilder.toString();
        }
        else{
             photoPaths=null;
        }
        if(ad!=null){
            String originalFilename = ad.getOriginalFilename();
            String[] originalFilenames = originalFilename.split("\\.");
            String newName = UUID.randomUUID() + "."+originalFilenames[originalFilenames.length-1];
            File file1 =new File(new File( avatarPath + newName).getAbsolutePath()) ;
            try {
                fileUploadService.storeFile(ad,file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            adNewName =newName;
        }
        else
        {adNewName =null;}
        /**
         * 过滤说说文本，替换敏感词，将敏感词返回
         */
        Set set =SensitiveWordFilter.getSensitiveWord(says,1);
        says =SensitiveWordFilter.replaceSensitiveWord(says,"*",set);
        saysService.insertSays(Says.builder().picture(photoPaths).saywords(says).var(adNewName).username(username).build());
        HashMap hashMap =new HashMap();
        hashMap.put("sensitiveWord",set);
        return  Resultbean.success(hashMap);
    }












}
