package com.neuedu.myspringboot.user.service;

import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.mapper.StudentMapper;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentMapper studentMapper;
    public List<StudentEntity> queryStudent(Integer id, String name) {

        List<StudentEntity> studentList = studentMapper.queryStudent(id, name);
        return studentList;

    }

    public List<StudentEntity> queryStudent2(StudentEntity studentEntity) {
        studentEntity.setUserName("rtdtfcjk");
        List<StudentEntity>  studentList=studentMapper.queryStudent2(studentEntity);
        return  studentList;
    }

}
