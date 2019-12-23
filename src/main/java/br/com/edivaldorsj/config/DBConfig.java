package br.com.edivaldorsj.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("br.com.edivaldorsj.mapper")
public class DBConfig {

}
