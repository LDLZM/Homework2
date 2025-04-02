package com.ldl.Service.impl;

import com.ldl.Service.PersonService;
import com.ldl.dao.PersonMapper;
import com.ldl.entity.Person;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper pm;

    @Override
    public List<Person> findAll() {
        return pm.findAll();
    }

    @Override
    public Person get(Integer id) {
        return pm.get(id);
    }

    @Override
    public void insert(Person p) {
        pm.insert(p);

    }

    @Override
    public void update(Person p) {
        pm.update(p);
    }

    @Override
    public void deleteById(Integer id) {
        pm.deleteById(id);
    }
}
