package com.lincon.ems.ems.backend.service.impl;

import com.lincon.ems.ems.backend.dto.EmployeeDto;
import com.lincon.ems.ems.backend.entity.Employee;
import com.lincon.ems.ems.backend.exception.ResourceNotFoundException;
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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
