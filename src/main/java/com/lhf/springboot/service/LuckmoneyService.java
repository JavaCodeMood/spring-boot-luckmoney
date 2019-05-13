package com.lhf.springboot.service;

import com.lhf.springboot.entity.Luckmoney;
import com.lhf.springboot.repository.LuckmoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @ClassName: LuckmoneyService
 * @Description: 使用事务，只有两个红包同时发送成功，才算成功，否则失败
 * @Author: liuhefei
 * @Date: 2019/5/13
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@Service
public class LuckmoneyService {

    @Autowired
    private LuckmoneyRepository repository;

    /**
     * 同时发送两个红包
     * 事务：这里指的是MySQl的事务，MySQL的InnoDB引擎才支持事务
     */
    @Transactional
    public String createTwo(String producer, String consumer){
        //首先查出MySQL表的记录总数
        long count = repository.count();
        //插入两条数据
        Luckmoney luckmoney1 = new Luckmoney();
        luckmoney1.setProducer(producer);
        luckmoney1.setMoney(new BigDecimal("520"));
        luckmoney1.setConsumer(consumer);
        repository.save(luckmoney1);

        Luckmoney luckmoney2 = new Luckmoney();
        luckmoney2.setProducer(producer);
        luckmoney2.setMoney(new BigDecimal("1314"));
        luckmoney2.setConsumer(consumer);
        repository.save(luckmoney2);

        //此时判断最新的记录总数是否大于count，如果大于表示插入成功
        if(count + 2 == repository.count()){
            return "红包发送成功";
        }else{
            return "红包发送失败";
        }
    }
}
