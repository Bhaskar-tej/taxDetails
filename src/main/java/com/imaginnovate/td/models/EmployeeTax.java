package com.imaginnovate.td.models;

public class EmployeeTax {
	
	 private int employerId;
	    private String firstName;
	    private String lastName;
	    private double yearlySalary;
	    private double taxAmount;
	    private double cessAmount;
	    
	    public EmployeeTax() {
	    	
	    }


		public EmployeeTax(int employerId, String firstName, String lastName, double yearlySalary, double taxAmount,
				double cessAmount) {
			super();
			this.employerId = employerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.yearlySalary = yearlySalary;
			this.taxAmount = taxAmount;
			this.cessAmount = cessAmount;
		}


		public int getEmployerId() {
			return employerId;
		}


		public void setEmployerId(int employerId) {
			this.employerId = employerId;
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


		public double getYearlySalary() {
			return yearlySalary;
		}


		public void setYearlySalary(double yearlySalary) {
			this.yearlySalary = yearlySalary;
		}


		public double getTaxAmount() {
			return taxAmount;
		}


		public void setTaxAmount(double taxAmount) {
			this.taxAmount = taxAmount;
		}


		public double getCessAmount() {
			return cessAmount;
		}


		public void setCessAmount(double cessAmount) {
			this.cessAmount = cessAmount;
		}
		
		
	    
	    
	    
	    
	    

}
