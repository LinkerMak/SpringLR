package com.example.spring.tcp.service;

import com.example.spring.tcp.dao.EmployeeSectionDAO;
import com.example.spring.tcp.entity.EmployeeSection;
import com.example.spring.tcp.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeSectionServiceImpl implements EmployeeSectionService{

    @Autowired
    EmployeeSectionDAO DAO;

    @Override
    @Transactional
    public void addPairs(int employeeID, int[] sectionsID) {
        for(int sectionId : sectionsID) {
            DAO.addPair(new EmployeeSection(employeeID, sectionId));
        }
    }

    @Override
    @Transactional
    public void addPair(EmployeeSection employeeSection) {
        DAO.addPair(employeeSection);
    }

    @Override
    @Transactional
    public List<Integer> getSectionsByEmployee(int id) {
       return DAO.getSectionsByEmployee(id);
    }

    @Override
    @Transactional
    public List<Integer> getEmployeesBySection(int id) {
        return DAO.getEmployeesBySection(id);
    }

    @Override
    @Transactional
    public void deleteByEmployeeId(int id) {
        DAO.deleteByEmployeeId(id);
    }
}
