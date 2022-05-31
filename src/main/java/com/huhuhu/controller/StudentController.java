package com.huhuhu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huhuhu.controller.utils.R;
import com.huhuhu.pojo.Student;
import com.huhuhu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping
    public R save(@RequestBody Student student){
        return new R(studentService.save(student),null);
    }

    @DeleteMapping("{id}")
    public R deleteById(@PathVariable Integer id)  {


        return new  R(studentService.removeById(id),null);
    }

    @PutMapping
    public R updateById(@RequestBody Student student) throws IOException {
        //定义一个异常
        boolean b = studentService.updateById(student);
        return new R(b,null,b?"添加成功":"添加失败");
    }

    @GetMapping
    public R selectAll(){
        return new R(true,studentService.list());
    }

    @GetMapping("{id}")
    public R selectById(@PathVariable Integer id){
        return new R(true,studentService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    //springmvc可以自动解析注入student
    public R selectPage(@PathVariable int currentPage,@PathVariable int pageSize ,Student student){

        IPage<Student> page;
        //因为Integer默认有值,所以需要手工判断,要不然查的时候会根据id=null来查
        if (student.getId()==null&&student.getName()==""&&student.getHome()==""){
             page = studentService.getPage(currentPage,pageSize);
            if (currentPage>page.getPages()){
                //如果当前页码大于了总页码值,那么重新执行查询操作,使用最大页码值作为当前页码值
                page = studentService.getPage((int)page.getPages(),pageSize);
            }
        }else {
             page = studentService.getPage(currentPage, pageSize, student);
            if (currentPage > page.getPages()) {
                //如果当前页码大于了总页码值,那么重新执行查询操作,使用最大页码值作为当前页码值
                page = studentService.getPage((int) page.getPages(), pageSize, student);
            }
        }
        return new R(true,page);
    }

}
