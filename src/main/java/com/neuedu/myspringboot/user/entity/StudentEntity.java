package com.neuedu.myspringboot.user.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "student")
public class StudentEntity implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String name;
    private Integer chinese;
    private Integer math;
    private Integer english;
    private String note;
    private String ids;

    private List ids2;
    private List IdList;




}
