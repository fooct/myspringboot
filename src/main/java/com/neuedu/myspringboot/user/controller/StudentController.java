package com.neuedu.myspringboot.user.controller;


import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.service.StudentService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/studentController")
@ResponseBody

@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/queryStudent")
    public List<StudentEntity> queryStudent(Integer id, String name){

        log.info("进入学生类controller");
        log.error("");
        List<StudentEntity> studentList = studentService.queryStudent(id, name);
        return studentList;

    }

    @PostMapping("/queryStudent2")
    public List<StudentEntity> queryStudent2(StudentEntity studentEntity) {
        log.info("进入学生类controller");
        List<StudentEntity>  studentList= studentService.queryStudent2(studentEntity);
        return studentList;
    }


    @GetMapping("/queryStudent3")
    public List<StudentEntity> queryStudent3(@NonNull @RequestParam("id")Integer id, @RequestParam(value = "name",required = false,defaultValue = "张三")String name) {
        log.info("进入学生类controller");
        List<StudentEntity>  studentList= studentService.queryStudent(id,name);
        return studentList;
    }

}
