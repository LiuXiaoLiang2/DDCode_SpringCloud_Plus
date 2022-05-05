package com.ddcode.openfeign.service;

import com.ddcode.openfeign.pojo.User;
import com.ddcode.openfeign.support.FeignMultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(name = "openfeign-quickstart-provider", configuration = FeignMultipartSupportConfig.class)
public interface OrderService {

    @GetMapping("/openfeign/provider")
    public String echo1(@RequestParam("name") String name, @RequestParam(value= "pwd", required = false) String pwd);

    @GetMapping("/openfeign/provider2")
    public String echo2(@RequestParam Map<String, Object> paramMap);

    @GetMapping("/openfeign/provider3")
    public String echo3(@SpringQueryMap User user);

    @PostMapping("/openfeign/provider4")
    public String echo4(@SpringQueryMap User user);

    @PostMapping("/openfeign/provider5")
    public String echo5(@RequestBody String userJson);

    @PostMapping(value = "/openfeign/provider6", produces = {
            MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String echo6(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name);

    @PostMapping(value = "/openfeign/provider7", produces = {
            MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String echo7(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name);

    @PostMapping("/openfeign/provider8")
    public String echo8(@RequestParam("name") String name, @RequestParam(value= "pwd", required = false) String pwd);

    @PostMapping("/openfeign/provider9")
    public String echo9(@SpringQueryMap User user);
}
