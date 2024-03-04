package com.group.attendanceapp.employee.service;

import com.group.attendanceapp.employee.domain.Employee;
import com.group.attendanceapp.employee.domain.EmployeeRepository;
import com.group.attendanceapp.employee.domain.Role;
import com.group.attendanceapp.employee.dto.request.ResisterEmployeeRequest;
import com.group.attendanceapp.employee.dto.response.EmployeeListResponse;
import com.group.attendanceapp.team.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final TeamService teamService;

    public EmployeeService(EmployeeRepository repository, TeamService teamService) {
        this.repository = repository;
        this.teamService = teamService;
    }

    @Transactional
    public void insertEmployee(ResisterEmployeeRequest request) {
        repository.findById(request.getId()).ifPresent(employee -> {
            throw new IllegalArgumentException("이미 등록된 회원입니다.");
        });


        repository.save(new Employee(request.getName(), request.getTeamName(),
                request.getRole(), request.getBirthday(), request.getWorkStartDate()));

        if (Role.MANAGER.equals(request.getRole())) {
            teamService.updateManager(request.getTeamName(), request.getName());
        }

        teamService.updateEmployeeCnt(request.getTeamName());
    }

    public List<EmployeeListResponse> selectEmployeeList() {
        return repository.findAll().stream()
                .map(employee -> new EmployeeListResponse(employee.getName(), employee.getTeamName(),
                        employee.getRole(), employee.getBirthday(), employee.getWorkStartDate()))
                .collect(Collectors.toList());
    }
}
