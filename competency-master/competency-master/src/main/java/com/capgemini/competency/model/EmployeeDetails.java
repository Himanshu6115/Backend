package com.capgemini.competency.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeDetails {
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int serialId;
	@Id
	private int globalId;
	private String empName;
	private String gender;
	private String jobTitle;
	private String empSubGroup;
	private String timesheetComplaince;
	private String supervisorName;
	private String clientTeam;
	private String emailId;
	private String baseLocation;
	private String personalArea;
	private String location;
	private String localId;
	public int getSerialId() {
		return serialId;
	}
	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	public int getGlobalId() {
		return globalId;
	}
	public void setGlobalId(int globalId) {
		this.globalId = globalId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmpSubGroup() {
		return empSubGroup;
	}
	public void setEmpSubGroup(String empSubGroup) {
		this.empSubGroup = empSubGroup;
	}
	public String getTimesheetComplaince() {
		return timesheetComplaince;
	}
	public void setTimesheetComplaince(String timesheetComplaince) {
		this.timesheetComplaince = timesheetComplaince;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getClientTeam() {
		return clientTeam;
	}
	public void setClientTeam(String clientTeam) {
		this.clientTeam = clientTeam;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getPersonalArea() {
		return personalArea;
	}
	public void setPersonalArea(String personalArea) {
		this.personalArea = personalArea;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocalId() {
		return localId;
	}
	public void setLocalId(String localId) {
		this.localId = localId;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [serialId=" + serialId + ", globalId=" + globalId + ", empName=" + empName + ", gender="
				+ gender + ", jobTitle=" + jobTitle + ", empSubGroup=" + empSubGroup + ", timesheetComplaince="
				+ timesheetComplaince + ", supervisorName=" + supervisorName + ", clientTeam=" + clientTeam + ", emailId="
				+ emailId + ", baseLocation=" + baseLocation + ", personalArea=" + personalArea + ", location=" + location
				+ ", localId=" + localId + "]";
	}



}
