package com.neuedu.myspringboot.user.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;


@Data
@Table(name = "student_note")
public class StudentNoteEntity implements Serializable {

    private Integer id;
    private Integer student_id;
    private String note;


}
