package com.example.spring.tcp.dao;

import com.example.spring.tcp.entity.EmployeeSection;
import com.example.spring.tcp.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Repository
@EnableTransactionManagement
public class EmployeeSectionDAOImpl implements EmployeeSectionDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addPair(EmployeeSection employeeSection) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employeeSection);
    }

    @Override
    public List<Integer> getSectionsByEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery("select section_id from EmployeeSection where employee_id =:ID", Integer.class);
        query.setParameter("ID", id);
        query.list();

        return query.getResultList();
    }

    @Override
    public List<Integer> getEmployeesBySection(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery("select employee_id from EmployeeSection where section_id =:ID", Integer.class);
        query.setParameter("ID", id);
        query.list();


        return query.getResultList();
    }

    @Override
    public void deleteByEmployeeId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<EmployeeSection> query = session.createQuery("delete from EmployeeSection where employee_id =:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
