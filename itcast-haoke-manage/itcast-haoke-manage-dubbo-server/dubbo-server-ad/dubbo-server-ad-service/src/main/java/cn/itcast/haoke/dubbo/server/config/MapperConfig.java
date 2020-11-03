package cn.itcast.haoke.dubbo.server.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.itcast.haoke.dubbo.server.mapper")
public class MapperConfig {

    @Bean
    public PaginationInterceptor pagination(){
        PaginationInterceptor pageConfig = new PaginationInterceptor();
        pageConfig.setDialectType("mysql");
        return pageConfig;
    }
}
