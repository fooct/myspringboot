package com.neuedu.myspringboot.goods.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_goods")
public class GoodsEntity {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String title;
    private String content;
    private String imagePath;
    private float price;

}
