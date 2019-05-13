package com.lhf.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @ClassName: LimitConfig
 * @Description: Limit配置,加载读取属性配置(对象配置)
 * @Author: liuhefei
 * @Date: 2019/5/13
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "limit")  //设置前缀
public class LimitConfig {

    private BigDecimal minMoney;

    private BigDecimal MaxMoney;

    private String description;

}
