package com.example.service;

import com.example.common.BeanHelper;
import com.example.domain.*;
import com.example.mapper.AreaMapper;
import com.example.mapper.RenzhijigouMapper;
import com.example.mapper.StudentMapper;
import com.example.mapper.ZhiwuMapper;
import com.example.pojo.InfoVTM;
import com.example.pojo.StudentDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private RenzhijigouMapper renzhijigouMapper;
    @Autowired
    private ZhiwuMapper zhiwuMapper;

    public PageInfo<Student> studentPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Student> studentList = studentMapper.selectAll();
        if (studentList.isEmpty()) {
            throw new RuntimeException("分页查询为空");
        }
        return new PageInfo<>(studentList);
    }

    public void addStudent(Student student) {
        int insert = studentMapper.insert(student);
        if (insert == 0) {
            throw new RuntimeException("添加失败");
        }
    }

    public void editStudent(Student student) {
        int i = studentMapper.updateByPrimaryKeySelective(student);
        if (i == 0) {
            throw new RuntimeException("更新失败");
        }
    }

    public void deleteStudentById(Integer id) {
        int i = studentMapper.deleteByPrimaryKey(id);
        if (i == 0) {
            throw new RuntimeException("删除失败");
        }
    }

    public List<StudentDTO> selectAll(Params info) {
        Area area = new Area();
        area.setName(info.getQuyu());
        Area areaSelect = areaMapper.selectOne(area);
        Integer aid = areaSelect.getId();

        Renzhijigou renzhijigou = new Renzhijigou();
        renzhijigou.setJgname(info.getJigou());
        Renzhijigou renzhijigou1 = renzhijigouMapper.selectOne(renzhijigou);
        Integer rid = renzhijigou1.getRid();

        Zhiwu zhiwu = new Zhiwu();
        zhiwu.setZname(info.getZhiwu());
        Zhiwu zhiwu1 = zhiwuMapper.selectOne(zhiwu);
        Integer zid = zhiwu1.getZid();


        Student record = new Student();
        record.setAid(aid);
        record.setRzjgid(rid);
        record.setZwid(zid);
        List<Student> select = studentMapper.select(record);
        List<StudentDTO> studentDTOS = BeanHelper.copyWithCollection(select, StudentDTO.class);

        return studentDTOS;
    }
}
