package com.example.springdemo;

import com.example.springdemo.rabbitmq.RabbitService;
import com.example.springdemo.replace.OldValueCalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
@PropertySource(value = "classpath:/test.properties")
//@EnableLoadTimeWeaving(aspectjWeaving=AUTODETECT)
public class SpringdemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));

        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @Autowired
    RabbitService rabbitService;

    @RequestMapping("/test123")
    public Object test(boolean test) throws InterruptedException {
        rabbitService.send("test");
        return "hello world";
    }


   @RequestMapping("/upload")
    public Object upload(MultipartFile file) throws InterruptedException {
        rabbitService.send("test");
        return "hello world";
    }

    @Autowired
    OldValueCalculate oldValueCalculate;

    @Override
    public void run(String... args) throws Exception {
        String hello_world = oldValueCalculate.computeValue("hello world");

        System.out.println(hello_world);
    }


}
