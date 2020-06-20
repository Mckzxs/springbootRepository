package com.example.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "renzhijigou")
public class Renzhijigou {
    @Id
    private Integer rid;
    private String jgname;

}
