package com.lhf.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName: Luckmoney
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/5/13
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Luckmoney {

    @Id
    @GeneratedValue
    private Integer id;  //主键

    private BigDecimal money;  //红包金额

    private String producer;  //发送方

    private String consumer;  //接收方
}
