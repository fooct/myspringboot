package com.neuedu.myspringboot.goods.common;

public class AppResuldBuider<T> {
    //返回无参成功
    public static <T> AppResult<T> successNoData() {
        AppResult<T> appResult = new AppResult<T>();
        appResult.setMsg("成功");
        appResult.setResult(true);
        return appResult;
    }

    //返回有参成功
    public static <T> AppResult<T> success(T t) {
        AppResult<T> appResult = new AppResult<T>();
        appResult.setMsg("成功");
        appResult.setResult(true);
        appResult.setList(t);
        return appResult;
    }

    //返回失败
    public static <T> AppResult<T> failed() {
        AppResult<T> appResult = new AppResult<T>();
        appResult.setMsg("失败");
        appResult.setResult(false);
        return appResult;
    }
}