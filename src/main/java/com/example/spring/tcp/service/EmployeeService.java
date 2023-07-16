package com.example.spring.tcp.service;


import com.example.spring.tcp.entity.Employee;
import com.example.spring.tcp.entity.Section;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {

    @Transactional
    int getLast();

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    List<Employee> getAllEmployeesByIdS(List<Integer> idS);}
