package com.lhf.springboot.repository;

import com.lhf.springboot.entity.Luckmoney;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: LuckmoneyRepository
 * @Description: jpa操作
 * @Author: liuhefei
 * @Date: 2019/5/13
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public interface LuckmoneyRepository extends JpaRepository<Luckmoney, Integer> {

}
