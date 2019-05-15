package com.Java.bak.middle.ssmBak.SSM.src.com.zpark.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zpark.web.pojo.Student;

public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> list();
}