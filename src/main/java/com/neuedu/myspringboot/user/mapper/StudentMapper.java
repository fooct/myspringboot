package com.neuedu.myspringboot.user.mapper;

import com.neuedu.myspringboot.user.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentMapper {

     List<StudentEntity> queryStudent();

}
