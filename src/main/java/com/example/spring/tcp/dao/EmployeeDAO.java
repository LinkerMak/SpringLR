package com.example.spring.tcp.dao;


import com.example.spring.tcp.entity.Employee;
import com.example.spring.tcp.entity.Section;

import java.util.List;

public interface EmployeeDAO {
    int getLastId();

    public List<Employee>  getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> getSectionsByIdS(List<Integer> idS);
}
