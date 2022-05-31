package com.huhuhu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huhuhu.mapper.StudentMapper;
import com.huhuhu.pojo.Student;
import com.huhuhu.service.IStudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//业务层实现类要继承ServiceImpl<Mapper,pojo> 和实现类的接口来调用mybatis的增删改查方法
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements IStudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        return studentMapper.selectPage(page,null);
    }

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize, Student student) {
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<Student>();
        lqw.like(Student::getId,student.getId());
        lqw.like(Strings.isNotEmpty(student.getName()),Student::getName,student.getName());
        lqw.like(Strings.isNotEmpty(student.getHome()),Student::getHome,student.getHome());
        IPage page = new Page(currentPage,pageSize);
        studentMapper.selectPage(page,lqw);
        return page;
    }
}
