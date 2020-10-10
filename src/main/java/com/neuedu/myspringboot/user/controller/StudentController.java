package com.neuedu.myspringboot.user.controller;


import com.github.pagehelper.PageInfo;
import com.neuedu.myspringboot.common.exp.Student;
import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.entity.StudentVO;
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
    public List<StudentEntity> queryStudent(Integer id,String name) {
        log.info("进入学生类controller");
        List<StudentEntity> studentList = studentService.queryStudent(id, name);
        return studentList;
    }
    @PostMapping("/queryStudent2")
    public PageInfo<StudentEntity> queryStudent2(StudentEntity studentEntity, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "0")int pageSize){
        System.out.println("进入学生类controller");
        PageInfo<StudentEntity>  studentList= studentService.queryStudent2(studentEntity,pageNum,pageSize);
        return studentList;
    }
    @GetMapping("/queryStudent3")
    public List<StudentEntity> queryStudent3(@NonNull @RequestParam("id")Integer id, @RequestParam(value = "name",required = false,defaultValue = "张三")String name) {
        System.out.println("进入学生类controller");
        List<StudentEntity>  studentList= studentService.queryStudent(id,name);
        return studentList;
    }
    @GetMapping("/queryStudent4")
    public List<StudentEntity> queryStudent4() {
        System.out.println("进入学生类controller");
        List<StudentEntity>  studentList= studentService.queryStudent4();
        return studentList;
    }
    /*保存*/
    @PostMapping("/saveStudent")
    public String  saveStudent(StudentEntity studentEntity) {
        log.info("进入学生成绩新增方法");
        String resultMessage=null;
        int num= studentService.saveStudent(studentEntity);
        if(num>0){
            resultMessage="新增成功了"+num+"条记录";
        }else {
            resultMessage="新增失败";
        }
        return resultMessage;
    }
    /*删除 逗号分隔*/
    @PostMapping("/deleteStudent")
    public String  deleteStudent(StudentVO studentEntity) {
        log.info("进入学生成绩删除方法");
        String resultMessage=null;
        int num= studentService.deleteStudent3(studentEntity);
        if(num>0){
            resultMessage="删除删除了"+num+"条记录";
        }else {
            resultMessage="删除失败";
        }
        return resultMessage;
    }
    @PostMapping("/updateStudent")
    public String  updateStudent(StudentEntity studentEntity) {
        log.info("进入学生成绩修改方法");
        String resultMessage="修改成功";
        int num= studentService.updateStudent(studentEntity);
        return resultMessage;
    }

}
