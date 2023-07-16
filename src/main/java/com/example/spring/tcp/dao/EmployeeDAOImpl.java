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
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int getLastId(){
        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery("select max(id) FROM Employee", Integer.class);
        List<Integer> employeeIds = query.getResultList();
        System.out.println(employeeIds);
        return employeeIds.get(0);
    }
    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
       // List<Employee> allEmployees = session.createQuery("from Employee ", Employee.class).getResultList();
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }

    @Override
    public List<Employee> getSectionsByIdS(List<Integer> idS) {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = new ArrayList<>();
        for(int id : idS) {
            employees.add(session.get(Employee.class,id));
        }
        return employees;
    }
}
