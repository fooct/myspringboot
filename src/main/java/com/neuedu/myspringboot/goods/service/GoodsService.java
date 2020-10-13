package com.neuedu.myspringboot.goods.service;

import com.neuedu.myspringboot.goods.entity.GoodsEntity;
import com.neuedu.myspringboot.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    public List<GoodsEntity> list(){

        return goodsMapper.selectAll();


    }

}
