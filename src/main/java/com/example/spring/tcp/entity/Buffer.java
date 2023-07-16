package com.example.spring.tcp.entity;

import java.util.List;
import java.util.Map;

public class Buffer {
    private List<Section> sectionList;
    private String [] sections;

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public String[] getSections() {
        return sections;
    }

    public void setSections(String[] sections) {
        this.sections = sections;
    }


}
