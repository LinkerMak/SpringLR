package com.example.spring.tcp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String nameS;

    public Section() {}

    public Section(String name) {
        this.nameS = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String name) {
        this.nameS = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + nameS + '\'' +
                '}';
    }



}
