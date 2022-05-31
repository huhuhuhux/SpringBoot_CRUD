package com.huhuhu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huhuhu.mapper.StudentMapper;
import com.huhuhu.pojo.Student;
import com.huhuhu.service.impl.StudentServiceImpl;
import com.huhuhu.service.impl.StudentServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootSsmtApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentServiceImpl2 studentService;

    @Autowired
    StudentServiceImpl service;

    @Test
    //其他也一样可以都可以直接点处理,page()要传入page对象
    void deleteById2(){
        IPage iPage = new Page(1,3);
        service.page(iPage);
    }


    @Test
    void contextLoads() {
    }


    @Test
    void selectPage(){
        IPage page = new Page(0,5);
        studentMapper.selectPage(page,null);
        // 下面是page的一些属性
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        String name="1";
        //用LambdaQueryWrapper对象存放查询条件
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<>();
        //lqw.like(是否查询,查询什么,查询数值)
        //if(name != null) lqw.like(Student::getName,name);
        lqw.like(name!=null,Student::getNumber,name);
        studentMapper.selectList(lqw);

        //查询分页
        IPage page = new Page(0,5);
        studentMapper.selectPage(page,null);
        System.out.println( studentMapper.selectPage(page,lqw));
    }

    @Test
    void serviceInit(){
        Student student = new Student();
        student.setId(223234);
        student.setName("测试");
        student.setAge(18);
        student.setNumber(123456);
        student.setHome("xj");
        studentService.init(student);
    }

    @Test
    void deleteById(){
        System.out.println(studentService.deleteById(2233));
    }

    @Test
    void updateById(){
        Student student = new Student();
        student.setId(223234);
        student.setName("测试改");
        student.setAge(182);
        student.setNumber(126);
        student.setHome("gd");
        System.out.println(studentService.updateById(student));
    }

    @Test
    void selectById(){
        System.out.println(studentService.selectById(223234));
    }

    @Test
    void selectAll(){
        System.out.println(studentService.selectAll());
    }

    @Test
    void  getPage(){
        System.out.println(studentService.getPage(1,3));
    }


}
