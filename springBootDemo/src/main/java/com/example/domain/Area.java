package com.example.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "area")
public class Area {
    @Id
    private Integer id;
    private String name;
    private Integer pid;


}
