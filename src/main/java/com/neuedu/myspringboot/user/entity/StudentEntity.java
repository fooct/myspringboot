package com.neuedu.myspringboot.user.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "student")
public class StudentEntity implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
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
