package com.neuedu.myspringboot.user.entity;


import lombok.Data;


import java.util.List;

@Data
public class StudentVO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private Integer chinese;
    private Integer math;
    private Integer english;
    private String ids;
    private List idList;

}
