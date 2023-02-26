package com.imaginnovate.td.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.td.entity.Employee;
import com.imaginnovate.td.models.EmployeeTax;
import com.imaginnovate.td.services.EmployeeServices;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeService;

	@PostMapping("/add")
	public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {

		try {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.badRequest().body(bindingResult.getAllErrors().get(0).getDefaultMessage());
			} else {
				Employee savedEmployee = employeeService.createEmployee(employee);
				if (savedEmployee != null) {
					return ResponseEntity.ok("Employer created successfully");

				} else {
					return ResponseEntity.ok("Employer Not created successfully");
				}

			}
		} catch (ConstraintViolationException ex) {
			List<String> errorMessages = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errorMessages.toString());
		}
	}

	@GetMapping("/tax")
	public ResponseEntity<List<EmployeeTax>> getTaxDetails() {

		return ResponseEntity.ok(employeeService.getEmployeesTaxDeduction());
	}
}
