package com.neuedu.myspringboot.user.controller;


import com.neuedu.myspringboot.common.exp.Student;
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

        log.info("进入学生类controller1");
        log.error("");
        List<StudentEntity> studentList = studentService.queryStudent(id, name);
        return studentList;

    }

    @PostMapping("/queryStudent2")
    public List<StudentEntity> queryStudent2(StudentEntity studentEntity) {
        log.info("进入学生类controller2");
        List<StudentEntity>  studentList= studentService.queryStudent2(studentEntity);
        return studentList;
    }


    @GetMapping("/queryStudent3")
    public List<StudentEntity> queryStudent3(@NonNull @RequestParam("id")Integer id, @RequestParam(value = "name",required = false,defaultValue = "张三")String name) {
        log.info("进入学生类controller3");
        List<StudentEntity>  studentList= studentService.queryStudent(id,name);
        return studentList;
    }

    @PostMapping("/saveStudent")
    public String saveStudent(StudentEntity studentEntity) {
        log.info("进入学生类controllersave");
        String resultMessages = null;
        int num = studentService.saveStudent(studentEntity);
        if (num > 0) resultMessages = "新增成功" + num + "条记录";
        else resultMessages = "新增失败";

        return resultMessages;
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(StudentEntity studentEntity){
        log.info("删除");

        String resultMessage = null;

        int num = studentService.deleteStudent2(studentEntity);

        if (num > 0)resultMessage = "删除了" + num + "条记录";
        else resultMessage = "删除失败";

        return resultMessage;
    }


    @PostMapping("/updateStudent")
    public String updateStudent(StudentEntity studentEntity) {
        log.info("修改");
        String resultMessage = null;
        int num = studentService.updateStudent(studentEntity);
        resultMessage = "修改成功";
        return resultMessage;
    }

}
