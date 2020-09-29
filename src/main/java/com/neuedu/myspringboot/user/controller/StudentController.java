package com.neuedu.myspringboot.user.controller;


import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.service.StudentService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/studentController")
@ResponseBody
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/queryStudent")
    public List<StudentEntity> queryStudent(Integer id, String name){

        System.out.println("进入学生类controller");
        List<StudentEntity> studentList = studentService.queryStudent(id, name);
        return studentList;

    }

    @GetMapping("/queryStudent2")
    public List<StudentEntity> queryStudent2(StudentEntity studentEntity) {
        System.out.println("进入学生类controller");
        List<StudentEntity>  studentList= studentService.queryStudent2(studentEntity);
        return studentList;
    }


    @GetMapping("/queryStudent3")
    public List<StudentEntity> queryStudent3(@NonNull @RequestParam("id")Integer id, @RequestParam(value = "name",required = false,defaultValue = "张三")String name) {
        System.out.println("进入学生类controller");
        List<StudentEntity>  studentList= studentService.queryStudent(id,name);
        return studentList;
    }

}
