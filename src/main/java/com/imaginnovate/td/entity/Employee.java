package com.imaginnovate.td.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;

	@NotBlank(message = "First name is required")
	@Size(max = 50, message = "First name must be up to 50 characters")
	@Column(name = "firstName", nullable = false)
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Size(max = 50, message = "Last name must be up to 50 characters")
	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Email(message = "Email is not valid")
	@NotBlank(message = "Email is required")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull(message = "Date of Joining is required")
	@Column(name = "doj", nullable = false)
	private LocalDate doj;

	@Positive(message = "Salary must be a positive number")
	@Column(name = "salary", nullable = false)
	private double salary;

	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(referencedColumnName = "employeeId", name = "employee_Id")
	private List<PhoneNumber> phoneNumbers = new ArrayList<>();

	public Employee() {

	}

	public Employee(int employeeId, String firstName, String lastName, String email, LocalDate doj, double salary,
			List<PhoneNumber> phoneNumbers) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.doj = doj;
		this.salary = salary;
		this.phoneNumbers = phoneNumbers;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
