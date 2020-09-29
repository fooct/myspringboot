package com.neuedu.myspringboot.user.controller;


import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/studentController")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/queryStudent")
    public List<StudentEntity> queryStudent(){

        System.out.println("进入学生类controller");
        List<StudentEntity> studentList = studentService.queryStudent();
        return studentList;

    }

}
