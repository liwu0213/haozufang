package cn.itcast.haoke.dubbo.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class AdServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdServiceApplication.class,args);
    }
}
