package com.imaginnovate.td.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "phoneNumber")
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phoneNumberId;

	@NotBlank(message = "Phone number(s) is required")
	@Size(min = 1, message = "Phone number(s) must have at least 1 entry")
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
	private String number;

	public Long getPhoneNumberId() {
		return phoneNumberId;
	}

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(Long phoneNumberId, String number) {
		super();
		this.phoneNumberId = phoneNumberId;
		this.number = number;
	}

	public void setPhoneNumberId(Long phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}