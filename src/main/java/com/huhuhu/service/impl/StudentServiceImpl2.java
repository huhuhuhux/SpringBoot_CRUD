package com.huhuhu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huhuhu.mapper.StudentMapper;
import com.huhuhu.pojo.Student;
import com.huhuhu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl2 implements StudentService {

    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper){
        this.studentMapper=studentMapper;
    }

    @Override //增加数据
    public Boolean init(Student student) {
        return studentMapper.insert(student)> 0;
    }

    @Override  //删除数据
    public Boolean deleteById(Integer id) {
        return studentMapper.deleteById(id) > 0;
    }

    @Override //改
    public Boolean updateById(Student student) {
       return studentMapper.updateById(student)>0;
    }

    @Override //查
    public List<Student> selectAll() {
        return studentMapper.selectList(null);
    }

    @Override //id查
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override //分页查
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage iPage = new Page(currentPage,pageSize);
        return studentMapper.selectPage(iPage,null);//null是查询条件，要用LambdaQueryWrapper对象查询
    }


}
