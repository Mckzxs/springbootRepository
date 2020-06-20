package com.example.controller;

import com.example.domain.Area;
import com.example.domain.Params;
import com.example.domain.Student;
import com.example.pojo.StudentDTO;
import com.example.service.StudentService;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 接口约定URL:
     * 增加： /student/add
     * 修改：/student/edit
     * 删除： /student/delete
     * 查询： /student/query
     * 导出： /student/export
     */


    //查询： /student/query
    @GetMapping("/student/query")
    public PageInfo<Student> queryPageStudents(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                               @RequestParam(name = "rows", defaultValue = "10") Integer rows) {

        PageInfo<Student> studentPageInfo = studentService.studentPage(page, rows);
        return studentPageInfo;
    }

        @GetMapping("/student/list")
    public List<Student> selectA(){
        PageInfo<Student> studentPageInfo = studentService.studentPage(1, 10);
        List<Student> list = studentPageInfo.getList();
        String toString = list.toString();

        stringRedisTemplate.opsForValue().set("string","string");

            HashMap<String, String> map = new HashMap<>();
            map.put("s1","one1");
            map.put("s2","two");
            stringRedisTemplate.opsForValue().multiSet(map);


            Long aLong1 = stringRedisTemplate.opsForList().leftPushAll("list1", "L1", "L2", "L3", "L4");
            Long aLong = stringRedisTemplate.opsForList().rightPushAll("list2", "a", "b", "c", "d");
            System.out.println("========================?"+aLong1);
            System.out.println("========================?"+aLong);

            return list;
    }


    //增加： /student/add
    @PutMapping("/student/add")
    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    // 修改：/student/edit
    @GetMapping("/student/edit")
    public void editStudent(Student student) {
        studentService.editStudent(student);
    }

    // 删除： /student/delete
    @GetMapping("/student/delete")
    public void deleteStudent(Integer id) {
        studentService.deleteStudentById(id);
    }

    // /student/selctAll

//    @HystrixCommand(
//            //服务降级方法
//            fallbackMethod = "listUserFallback",
//            //修改线程隔离的超时时间，默认为1秒，在HystrixCommandProperties类里面找配置名。
//            commandProperties = {
//                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
//            }
//    )
    @PostMapping("/student/selectAll")
    public List<StudentDTO> selectAll(@RequestBody Params info) {
        List<StudentDTO> studentDTOS = studentService.selectAll(info);
        System.out.println("============>" + info);
        return studentDTOS;
    }


};
