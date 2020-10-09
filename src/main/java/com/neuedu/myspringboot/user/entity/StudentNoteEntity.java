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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
