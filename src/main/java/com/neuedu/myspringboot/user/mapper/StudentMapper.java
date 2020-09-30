package com.neuedu.myspringboot.user.mapper;

import com.neuedu.myspringboot.user.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<StudentEntity> {

     List<StudentEntity> queryStudent(@Param("id") Integer id, @Param("userName") String username);
     List<StudentEntity> queryStudent2(StudentEntity studentEntity);


}
