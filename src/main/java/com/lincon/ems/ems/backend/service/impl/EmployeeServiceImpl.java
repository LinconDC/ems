package com.lincon.ems.ems.backend.service.impl;

import com.lincon.ems.ems.backend.dto.EmployeeDto;
import com.lincon.ems.ems.backend.entity.Employee;
import com.lincon.ems.ems.backend.mapper.EmployeeMapper;
import com.lincon.ems.ems.backend.repository.EmployeeRepository;
import com.lincon.ems.ems.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
