package com.neuedu.myspringboot.user.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.neuedu.myspringboot.common.exp.Student;
import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.entity.StudentVO;
import com.neuedu.myspringboot.user.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest'fulStudentController")
@Slf4j
@Api(tags = "Restful 风格的学生用户模块")
public class RestfulStudentController {


    @Autowired
    private StudentService studentService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    /*查询*/
    @GetMapping("/student")
    @ApiOperation(value = "查询学生信息", notes = "介绍一下查询费向西方法", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", required = false, dataType = "int"),
            @ApiImplicitParam(name = "name", value = "学生姓名", required = false, dataType = "String")
        })
    public List<StudentEntity> queryStudent(Integer id, String name) {
        log.info("进入学生类controller");
        String key = "student:queryStudent:all";
        // 根据 key 判断缓存是否存在
        boolean hasKey = stringRedisTemplate.hasKey(key);
        List<StudentEntity> studentList = null;

        if (hasKey){

            log.info("进入 Redis 查询缓存");
            String studentListString = stringRedisTemplate.opsForList().get(key);
            studentList = JSON.parseObject(studentListString, new TypeReference<List<StudentEntity>>(){});

        }else {

            log.info("进入 sql 语句查询");
            studentList = studentService.queryStudent(id, name);
            if (!studentList.isEmpty()) stringRedisTemplate.opsForValue().set(key, JSON.toJSON(studentList));

        }
        return studentList;
    }

    @GetMapping("/student2")
    public List<StudentEntity> queryStudent2(Integer id, String name) {
        log.info("进入学生类controller2");
        String key = "student:queryStudent:redisTemplate";
        ListOperations<String, StudentEntity> operations = redisTemplate.opsForList();
        // 根据 key 判断缓存是否存在
        boolean hasKey = redisTemplate.hasKey(key);
        List<StudentEntity> studentList = null;

        if (hasKey){

            log.info("进入 Redis 查询缓存2");
            studentList = operations.range(key, 0, -1);

        }else {

            log.info("进入 sql 语句查询2");
            studentList = studentService.queryStudent(id, name);
            if (!studentList.isEmpty()) operations.leftPushAll(key, studentList);
        }
        return studentList;
    }

    @GetMapping("/student3")
    @CacheEvict(value = "mycache", key = "#name", beforeInvocation = true)
    public List<StudentEntity> queryStudent3(Integer id, String name) {

        log.info("进入查询 sql 3");
        List<StudentEntity> studentList = studentService.queryStudent(id, name);
        return studentList;

    }

    @GetMapping("/student/delete")
    public String studentDelete(){

        stringRedisTemplate.delete("student.queryStudent:redisTemplate");
        stringRedisTemplate.delete("student.queryStudent:stringRedisTemplate");
        return "删除成功";
    }

    @GetMapping("/student/delete2")
    @CacheEvict(value = "mycache", allEntries = true, beforeInvocation = true)
    public String studentDelete2(){

        return "删除成功";

    }

    /*添加*/
    @PostMapping("/student")
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
    /*修改*/
    @PatchMapping("/student/{id}")
    public String  updateStudent(@PathVariable("id") int id,@RequestParam("name") String name) {
        log.info("进入学生成绩修改方法");
        String resultMessage="修改成功";
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(name);
        int num= studentService.updateStudent(studentEntity);
        return resultMessage;
    }
    /*删除*/
    @DeleteMapping("/student/{id}")
    public String  deleteStudent(@PathVariable("id") int id) {
        log.info("进入学生成绩删除方法");
        String resultMessage=null;
        StudentVO studentVO=new StudentVO();
        studentVO.setIds(String.valueOf(id));
        int num= studentService.deleteStudent(studentVO);
        if(num>0){
            resultMessage="删除删除了"+num+"条记录";
        }else {
            resultMessage="删除失败";
        }
        return resultMessage;
    }


}
