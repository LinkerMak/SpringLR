package com.example.spring.tcp.service;

import com.example.spring.tcp.entity.Section;

import javax.transaction.Transactional;
import java.util.List;

public interface SectionService {

    public List<Section> getAllSection();

    public void save(Section section);

    List<Section> getAllSectionsByIdS(List<Integer> idS);
}
