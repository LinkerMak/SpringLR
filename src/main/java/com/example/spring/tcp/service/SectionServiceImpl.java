package com.example.spring.tcp.service;

import com.example.spring.tcp.dao.SectionDAO;
import com.example.spring.tcp.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService{

    @Autowired
    SectionDAO sectionDAO;

    @Override
    @Transactional
    public List<Section> getAllSection() {
        return sectionDAO.showAll();
    }

    @Override
    @Transactional
    public void save(Section section) {
        sectionDAO.save(section);
    }

    @Override
    @Transactional
    public List<Section> getAllSectionsByIdS(List<Integer> idS) {
        return sectionDAO.getSectionsByIdS(idS);
    }
}
