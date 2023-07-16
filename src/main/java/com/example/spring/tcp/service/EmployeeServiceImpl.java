package com.example.spring.tcp.service;

import com.example.spring.tcp.dao.EmployeeDAO;
import com.example.spring.tcp.dao.SectionDAO;
import com.example.spring.tcp.entity.Employee;
import com.example.spring.tcp.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    SectionDAO sectionDAO;

    @Override
    @Transactional
    public int getLast(){
        return employeeDao.getLastId();
    }
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        // String section = employee.getSect();
        //sectionDAO.save(new Section(section));
        employeeDao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployeesByIdS(List<Integer> idS) {
        return employeeDao.getSectionsByIdS(idS);
    }


}
