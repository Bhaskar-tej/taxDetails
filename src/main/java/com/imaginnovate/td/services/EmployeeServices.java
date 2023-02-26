package com.imaginnovate.td.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.imaginnovate.td.entity.Employee;
import com.imaginnovate.td.models.EmployeeTax;

@Component
public interface EmployeeServices {

	public Employee createEmployee(Employee employee);

	List<EmployeeTax> getEmployeesTaxDeduction();
}
