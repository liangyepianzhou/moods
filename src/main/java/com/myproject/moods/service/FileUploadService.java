package com.myproject.moods.service;

import com.myproject.moods.dao.mapper.SaysMapper;
import com.myproject.moods.dao.mapper.UsermMapper;
import com.myproject.moods.pojo.Userm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        usermMapper.updateByUsername(userm);
    }
    /**
     * 负责所有的文件上传到服务器保存的工作
     * @param inputStream
     * @param ToWhere
     * @throws IOException
     */
    public void storeFile(InputStream inputStream,String ToWhere) throws IOException {
        BufferedInputStream bufferedInputStream =new BufferedInputStream(inputStream);
        File file =new File(ToWhere);
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(new FileOutputStream(file));
        byte []buffer =new byte[1024];
        executorService.submit(()->{
            try {
                while (true) {
                bufferedInputStream.read(buffer);
                if (buffer.length != 0) {
                    bufferedOutputStream.write(buffer);
                    bufferedOutputStream.flush();
                }
                else
                    break;}
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void storeAvatar(MultipartFile file,File file1,String username){
            executorService.submit(()->{
                try {
                    file.transferTo(file1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
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
