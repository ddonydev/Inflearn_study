package com.group.attendanceapp.team.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String manager;
    @Column(nullable = false)
    private long employeeCnt;

    protected Team(){}

    public Team(String name, String manager, long employeeCnt) {
        this.name = name;
        this.manager = manager;
        this.employeeCnt = employeeCnt;
    }


    public void updateEmployeeCnt() {
        this.employeeCnt++;
    }

    public void updateManager(String name) {
        this.manager = name;
    }
}
