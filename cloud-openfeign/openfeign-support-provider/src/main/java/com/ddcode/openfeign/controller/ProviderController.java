package com.ddcode.openfeign.controller;

import com.ddcode.openfeign.pojo.User;
import com.ddcode.openfeign.support.MockMultipartFile;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;

@RestController
@Slf4j
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/openfeign/provider")
    public String echo1(@RequestParam("name") String name, @RequestParam(value= "pwd", required = false) String pwd) {
        return "openfeign provider name : " + name + " pwd : "+pwd+", server port: " + serverPort;
    }

    @GetMapping("/openfeign/provider2")
    public String echo2(@RequestParam Map<String, Object> paramMap) {
        return "openfeign provider2 paramMap : " + paramMap +", server port: " + serverPort;
    }

    @GetMapping("/openfeign/provider3")
    public String echo3(User user){
        return "openfeign provider3 User : " + user +", server port: " + serverPort;
    }

    @PostMapping("/openfeign/provider4")
    public String echo4(User user){
        return "openfeign provider4 User : " + user +", server port: " + serverPort;
    }

    @PostMapping("/openfeign/provider5")
    public String echo5(@RequestBody String userJson){
        return "openfeign provider5 userJson : " + userJson +", server port: " + serverPort;
    }

    @PostMapping(value = "/openfeign/provider6", produces = {
            MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String echo6(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name) throws IOException {
        File files = new File("E:\\1.jpg");
        file.transferTo(files);
        return "openfeign provider6 name : " + name +", fileName : " + file.getOriginalFilename() +" ,server port: " + serverPort;
    }

    @PostMapping(value = "/openfeign/provider7", produces = {
            MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String echo7(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name) throws IOException {
        MockMultipartFile mf;
        mf=new MockMultipartFile(file.getOriginalFilename(),file.getBytes());
        new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(2000);
                log.info("文件异步上传开始");
                File files = new File("E:\\1.jpg");
                mf.transferTo(files);
                log.info("文件异步上传结束");
            }
        }.start();

        return "openfeign provider7 name : " + name +", fileName : " + file.getOriginalFilename() +" ,server port: " + serverPort;
    }

    @PostMapping("/openfeign/provider8")
    public String echo8(@RequestParam("name") String name, @RequestParam(value= "pwd", required = false) String pwd) {
        return "openfeign provider name : " + name + " pwd : "+pwd+", server port: " + serverPort;
    }

    @PostMapping("/openfeign/provider9")
    public String echo9(User user){
        return "openfeign provider3 User : " + user +", server port: " + serverPort;
    }

}
