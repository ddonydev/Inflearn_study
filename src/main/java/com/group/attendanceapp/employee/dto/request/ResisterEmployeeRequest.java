package com.group.attendanceapp.employee.dto.request;

import com.group.attendanceapp.employee.domain.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ResisterEmployeeRequest {
    private long id;
    private String name;
    private String teamName;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;
}
