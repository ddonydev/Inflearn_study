package com.group.attendanceapp.employee.dto.response;

import com.group.attendanceapp.employee.domain.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeListResponse {
    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public EmployeeListResponse(String name, String teamName, Role role, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }
}
