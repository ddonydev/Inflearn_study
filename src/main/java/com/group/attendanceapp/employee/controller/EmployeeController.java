package com.group.attendanceapp.employee.controller;

import com.group.attendanceapp.employee.dto.request.ResisterEmployeeRequest;
import com.group.attendanceapp.employee.dto.response.EmployeeListResponse;
import com.group.attendanceapp.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/register_employee")
    public void resisterEmployee(@RequestBody ResisterEmployeeRequest request) {
        service.insertEmployee(request);
    }

    @GetMapping("/employee_list")
    public List<EmployeeListResponse> employeeList() {
        return service.selectEmployeeList();
    }


}
