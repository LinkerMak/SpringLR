package com.example.spring.tcp.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee_section")
public class EmployeeSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "section_id")
    private int section_id;

    public EmployeeSection(int employeeID, int sectionID) {
        this.employee_id = employeeID;
        this.section_id = sectionID;
    }

    public EmployeeSection() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }
}
