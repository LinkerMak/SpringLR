package com.example.spring.tcp.service;

import com.example.spring.tcp.entity.EmployeeSection;
import com.example.spring.tcp.entity.Section;

import java.util.List;

public interface EmployeeSectionService {

    public void addPairs(int employeeID,int [] sectionsID);
    public void addPair(EmployeeSection employeeSection);

    public List<Integer> getSectionsByEmployee(int id);

    public List<Integer> getEmployeesBySection(int id);

    void deleteByEmployeeId(int id);
}
