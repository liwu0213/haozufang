package cn.itcast.haoke.dubbo.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "cn.itcast.haoke.dubbo.server")
@EnableDubbo
public class DubboProvider {

    public static void main(String[] args) {

        SpringApplication.run(DubboProvider.class,args);
    }
}
