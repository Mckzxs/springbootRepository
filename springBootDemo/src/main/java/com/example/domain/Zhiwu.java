package com.example.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "zhiwu")
public class Zhiwu {
    @Id
    private Integer zid;
    private String zname;

}
