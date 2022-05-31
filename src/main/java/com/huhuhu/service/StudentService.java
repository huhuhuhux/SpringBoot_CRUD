package com.huhuhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huhuhu.pojo.Student;

import java.util.List;

public interface StudentService {
    Boolean init(Student student);
    Boolean deleteById(Integer id);
    Boolean updateById(Student student);
    List<Student> selectAll();
    Student selectById(Integer id);
    IPage<Student> getPage(int currentPage,int pageSize);
}
