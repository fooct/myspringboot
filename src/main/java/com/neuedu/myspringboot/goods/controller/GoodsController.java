package com.neuedu.myspringboot.goods.controller;


import com.neuedu.myspringboot.goods.common.AppResuldBuider;
import com.neuedu.myspringboot.goods.common.AppResult;
import com.neuedu.myspringboot.goods.entity.GoodsEntity;
import com.neuedu.myspringboot.goods.service.GoodsService;
import com.neuedu.myspringboot.user.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;
    @PostMapping("/list")
    public AppResult list(){
        List<GoodsEntity> goodsEntities = goodsService.list();
        return AppResuldBuider.success(goodsEntities);
    }

}
