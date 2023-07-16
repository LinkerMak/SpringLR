package com.example.spring.tcp.dao;

import com.example.spring.tcp.entity.Employee;
import com.example.spring.tcp.entity.Section;

import java.util.List;

public interface SectionDAO {

    List<Section> showAll();
    void save(Section section);

    List<Section> getSectionsByIdS(List<Integer> idS);
}
