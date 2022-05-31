package com.huhuhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huhuhu.pojo.Student;

//继承IService<T>获取接口中的增删改查方法
public interface IStudentService extends IService<Student> {
    IPage<Student> getPage(int currentPage, int pageSize);
    //条件查询
    IPage<Student> getPage(int currentPage, int pageSize, Student student);
}
