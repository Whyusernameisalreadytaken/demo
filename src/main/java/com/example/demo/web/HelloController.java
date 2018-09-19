package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

@RestController
public class HelloController {

    private static final String DATA_IMG_PREFIX = "data:image/jpeg;base64,";

    @Value("${random.string}")
    private String randomString;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/randomString")
    public String randdomString(){
        return randomString;
    }

    @RequestMapping("/springApplicationJson")
    public String springApplicationJson(){
        return System.getProperty("SPRING_APPLICATION_JSON");
    }

    @RequestMapping("/img")
    public String img() throws IOException {
        File file = new File("/Users/yingbaby/Downloads/车牌.JPG");
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int len;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        byte[] res = outputStream.toByteArray();

        outputStream.close();
        inputStream.close();
        Base64.Encoder encoder = Base64.getMimeEncoder();
        return DATA_IMG_PREFIX+encoder.encodeToString(res);
    }

}
