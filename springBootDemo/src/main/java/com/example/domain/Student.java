package com.example.domain;

import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer sno;
    private String sname;
    private Date birthdate;
    private String tel;
    private String jiguan;
    private String school;
    private String xueli;
    private String zhuanye;
    private String sex;
    private Integer mid;
    private Integer rzjgid;
    private Integer zwid;
    private Integer aid;
}

