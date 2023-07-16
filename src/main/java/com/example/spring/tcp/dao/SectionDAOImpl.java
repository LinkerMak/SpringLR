package com.example.spring.tcp.dao;

import com.example.spring.tcp.entity.Employee;
import com.example.spring.tcp.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@Repository
@EnableTransactionManagement
public class SectionDAOImpl implements SectionDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Section> showAll() {
        Session session = sessionFactory.getCurrentSession();
        // List<Employee> allEmployees = session.createQuery("from Employee ", Employee.class).getResultList();
        Query<Section> query = session.createQuery("from Section", Section.class);
        List<Section> allSections = query.getResultList();

        return allSections;
    }



    @Override
    public void save(Section section) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(section);
    }

    @Override
    public List<Section> getSectionsByIdS(List<Integer> idS) {
        Session session = sessionFactory.getCurrentSession();
        List<Section> sections = new ArrayList<>();
        for(int id : idS) {
            sections.add(session.get(Section.class,id));
        }
        return sections;
    }

}
