package com.ldl.Service;

import com.ldl.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {
    // 获取人员列表
    List<Person> findAll();
    // 获得一个 Person 对象
    Person get(Integer id) ;
    // 新增人员信息
    void insert(Person p) ;
    // 修改人员信息
    void update(Person p);
    // 删除单条记录
    void deleteById(Integer id);
}
