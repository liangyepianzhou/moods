package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.SaysMapper;
import com.myproject.moods.dao.mapper.UsermMapper;
import com.myproject.moods.pojo.Says;
import com.myproject.moods.pojo.Userm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.concurrent.*;

/**
 * @author 孟祥迎
 * @version 1.0
 * @Date 2021-04-09
 */
@Service
public class FileUploadService {
    @Autowired
    UsermMapper usermMapper;
    @Autowired
    SaysMapper saysMapper;
    final  int cores =Runtime.getRuntime().availableProcessors();
    ExecutorService executorService =new ThreadPoolExecutor(cores+1,cores*2,6000,
            TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(), new ThreadPoolExecutor.CallerRunsPolicy());

    InputStream inputStream;

    /**
     * 将上传成功的头像地址存入数据库
     * @param avatarUrl
     * @param username
     */
    public  void  avatarUpload(String avatarUrl,String username){
        Userm userm= Userm.builder().avatar(avatarUrl).username(username).build();
        usermMapper.updateByPrimaryKeySelective(userm);
    }



    /**
     * 负责所有的文件上传到服务器保存的工作
     *
     * @throws IOException
     */
    public void storeFile(MultipartFile file,File file1) throws IOException {
        executorService.submit(()->{
            try {
                if(!file1.exists()){
                    file1.getParentFile().mkdirs();
                }
                file.transferTo(file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void storeAvatar(MultipartFile file,File file1,String username){
         Future future= executorService.submit(()->{
                try {
                    if(!file1.exists()){
                     file1.getParentFile().mkdirs();
                    }
                    file.transferTo(file1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        avatarUpload(file1.getPath(),username);
    }

    /**
     * 删除文件操作
     * @param fileUrl
     */
    public  void  deleteFile(String fileUrl){
        File file =new File(fileUrl);
        if(file.exists()&&file.isFile()) {
            deleteFile(fileUrl);
        }
    }




}
