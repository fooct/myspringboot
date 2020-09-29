package com.neuedu.myspringboot.user.entity;

import java.io.Serializable;

public class StudentEntity implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;
    private String useName;
    private Integer chinese;
    private Integer math;

    public static long getSeriaVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public void setUserName(String rtdtfcjk) {
    }
}
