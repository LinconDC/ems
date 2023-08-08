package com.lincon.ems.ems.backend.service;

import com.lincon.ems.ems.backend.dto.EmployeeDto;
import com.lincon.ems.ems.backend.entity.Employee;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
