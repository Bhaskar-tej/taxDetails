package com.imaginnovate.td.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.td.entity.Employee;
import com.imaginnovate.td.models.EmployeeTax;
import com.imaginnovate.td.repository.EmployeeRepository;

@Service
public class EmployeeServicesImplement implements EmployeeServices {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	public List<EmployeeTax> getEmployeesTaxDeduction() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeTax> EmployeeTaxs = new ArrayList<>();

		for (Employee employee : employees) {
			LocalDate joiningDate = employee.getDoj();

			double yearlySalary;
			double totalSalary = employee.getSalary() * 12;
			double totalSalaryPerDay = employee.getSalary() / 30;

			if (joiningDate.getMonthValue() == 5 && joiningDate.getDayOfMonth() == 16) {
				yearlySalary = totalSalary - totalSalaryPerDay * 45;
			} else {
				yearlySalary = totalSalary;
			}

			double taxAmount = 0;
			if (totalSalary <= 250000) {
				taxAmount = 0;
			} else if (totalSalary > 250000 && totalSalary <= 500000) {
				taxAmount = (totalSalary - 250000) * 0.05;
			} else if (totalSalary > 500000 && totalSalary <= 1000000) {
				taxAmount = 12500 + (totalSalary - 500000) * 0.1;
			} else {
				taxAmount = 112500 + (totalSalary - 1000000) * 0.2;
			}

			double cessAmount = 0;
			if (totalSalary > 2500000) {
				cessAmount = (totalSalary - 2500000) * 0.02;
			}

			EmployeeTax EmployeeTax = new EmployeeTax();
			EmployeeTax.setEmployerId(employee.getEmployeeId());
			EmployeeTax.setFirstName(employee.getFirstName());
			EmployeeTax.setLastName(employee.getLastName());
			EmployeeTax.setYearlySalary(yearlySalary);
			EmployeeTax.setTaxAmount(taxAmount);
			EmployeeTax.setCessAmount(cessAmount);
			EmployeeTaxs.add(EmployeeTax);
		}

		return EmployeeTaxs;
	}

}
