package com.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    private String sname;
    private Date birthdate;
    private String tel;
    private String jiguan;
    private String school;
    private String xueli;
    private String zhuanye;
    private String sex;
    private String mname;//政治面貌
    private String jgname;//任职机构
    private String zname;//职务
}

