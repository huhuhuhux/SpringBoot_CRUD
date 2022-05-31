package com.huhuhu.Config;

import com.huhuhu.controller.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
        //记录日志
        //同知运维
        //通知开发

        //控制台打印信息
        ex.printStackTrace();
        return new R("服务器故障,请稍后再试!");
    }
}
