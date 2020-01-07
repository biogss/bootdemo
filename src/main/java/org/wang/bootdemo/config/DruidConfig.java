package org.wang.bootdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DruidConfig
 * @Description 配置Druid的监控
 * @Author wangHao
 * @DATE 2020/1/6 23:11
 * @Version 1.0
 */
@Configuration
public class DruidConfig {

}
