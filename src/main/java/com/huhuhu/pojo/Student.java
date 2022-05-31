package com.huhuhu.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("student")
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String home;
    private Integer number;
}
