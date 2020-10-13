package com.neuedu.myspringboot.goods.common;

import lombok.Data;

@Data
public class AppResult<T> {
    private String msg;
    private boolean result;
    private T list;
}
