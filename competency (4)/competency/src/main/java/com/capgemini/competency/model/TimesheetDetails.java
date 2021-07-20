package com.capgemini.competency.model;

public class TimesheetDetails {
	
	private int empId;
	private String EmpName;
	private String email;
	private String managerName;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	@Override
	public String toString() {
		return "TimesheetDetails [empId=" + empId + ", EmpName=" + EmpName + ", email=" + email + ", managerName="
				+ managerName + "]";
	}

}
