package com.example.mapper.testDemo;

import com.example.domain.Student;
import com.example.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {
    @Autowired
   private StudentMapper studentMapper;
    @Test
    public void test1(){
        List<Student> students = studentMapper.selectAll();
        System.out.println(students);
    }
}
