package com.lhf.springboot.controller;

import com.lhf.springboot.entity.Luckmoney;
import com.lhf.springboot.repository.LuckmoneyRepository;
import com.lhf.springboot.service.LuckmoneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName: LuckmoneyController
 * @Description:
 * @Author: liuhefei
 * @Date: 2019/5/13
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
@Api("获取红包列表Api接口")
@RestController
public class LuckmoneyController {

    @Autowired
    private LuckmoneyRepository repository;

    @Autowired
    private LuckmoneyService luckmoneyService;

    @ApiOperation("获取红包列表接口")
    @GetMapping("/list")
    public List<Luckmoney> luckmoneyList(){
        return repository.findAll();
    }

    @ApiOperation("创建红包Api接口")
    @PostMapping("/luckmoneys")
    public Luckmoney create(@RequestParam("producer") @ApiParam("红包发送方") String producer,
                            @RequestParam("money") @ApiParam("红包金额") BigDecimal money){
        Luckmoney luckmoney = new Luckmoney();
        luckmoney.setProducer(producer);
        luckmoney.setMoney(money);
        return repository.save(luckmoney);
    }

    @ApiOperation("根据id查询红包信息")
    @GetMapping("/luckmoneys/{id}")
    public Luckmoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);

    }

    @ApiOperation("更新红包信息")
    @PutMapping("/luckmoneys/{id}")
    public Luckmoney updateLuckmoney(@PathVariable("id")Integer id,
                                     @RequestParam("consumer") @ApiParam("红包接收方") String consumer){
        //先查询出来再更新
        Optional<Luckmoney> optional = repository.findById(id);
        if(optional.isPresent()){  //如果有内容
            Luckmoney luckmoney = optional.get();
            luckmoney.setConsumer(consumer);
            return repository.save(luckmoney);
        }

        return null;
    }

    @ApiOperation("同时发送两个红包")
    @PostMapping("/luckmoneys/two")
    public String sendMoney(@RequestParam("producer") @ApiParam("红包发送方") String producer,
                            @RequestParam("consumer") @ApiParam("红包接收方") String consumer){
        return luckmoneyService.createTwo(producer, consumer);
    }



}
