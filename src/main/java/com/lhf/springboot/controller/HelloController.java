package com.lhf.springboot.controller;

import com.lhf.springboot.config.LimitConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName: LuckMoneyController
 * @Description:  http://localhost:8081/luckmoney/swagger-ui.html
 * @Author: liuhefei
 * @Date: 2019/5/13
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
//@RestController
@Controller   //@ResponseBody + @Controller = @RestController
@Api("Hello Api接口")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    /**
     * 多路径访问
     * @return
     */
    //http://localhost:8081/luckmoney/money
    @GetMapping({"/hi", "/hello"})
    @ResponseBody
    @ApiOperation("hello1 API接口")
    public String hello(){
        return "最少" + limitConfig.getMinMoney() + "，最多" + limitConfig.getMaxMoney() + ", 说明：" + limitConfig.getDescription() ;
    }

    @GetMapping("/hello/hi")
    @ResponseBody
    @ApiOperation("hello2 API接口")
    public String hello1(){
        return "说明：" + limitConfig.getDescription() ;
    }

    @RequestMapping("/say")
    @ResponseBody
    @ApiOperation("hello2 API接口")
    public String hello2(){
        return "说明：" + limitConfig.getDescription() ;
    }

    //http://localhost:8081/luckmoney/hello/100
    @GetMapping("/hello/{id}")
    @ResponseBody
    @ApiOperation("hello3 API接口")
    public String hello3(@PathVariable("id") Integer id){
        return "编号：" + id + ", 说明：" + limitConfig.getDescription() ;
    }

    //http://localhost:8081/luckmoney/hello?id=1000
    @GetMapping("/hello")
    @ResponseBody
    @ApiOperation("hello4 API接口")
    public String hello4(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        return "编号：" + id + ", 说明：" + limitConfig.getDescription() ;
    }

    //http://localhost:8081/luckmoney/index
    @GetMapping("/index")
    @ApiOperation("web页面Api")
    public String index(){
        return "index";
    }

}
