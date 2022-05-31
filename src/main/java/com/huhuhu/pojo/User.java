package com.huhuhu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId
    private Long user_id;
    @TableField("card_type")
    private String card_type;
    @TableField("card_no")
    private String card_no;
    @TableField("user_name")
    private String user_name;
    @TableField("user_sex")
    private Integer user_sex;
    @TableField("user_age")
    private String user_age;
    @TableField("user_role")
    private String user_role;
}
