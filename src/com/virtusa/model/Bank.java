package com.virtusa.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bank")
public class Bank implements Serializable  {

	private int row_id;
	private String dataset_name;
	private String field;
	private String age;
	private String job;
	private String marital;
	private String education;
	private String defaulter;
	private String average_deposit;
	private String house;
	
	public int getRow_id() {
		return row_id;
	}
	
	@XmlElement
	public void setRow_id(int row_id) {
		this.row_id = row_id;
	}
	
	public String getDataset_name() {
		return dataset_name;
	}
	
	@XmlElement
	public void setDataset_name(String dataset_name) {
		this.dataset_name = dataset_name;
	}
	
	public String getField() {
		return field;
	}
	
	@XmlElement
	public void setField(String field) {
		this.field = field;
	}
	
	public String getAge() {
		return age;
	}
	
	@XmlElement
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getJob() {
		return job;
	}
	
	@XmlElement
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getMarital() {
		return marital;
	}
	
	@XmlElement
	public void setMarital(String marital) {
		this.marital = marital;
	}
	
	public String getEducation() {
		return education;
	}
	
	@XmlElement
	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getDefaulter() {
		return defaulter;
	}
	
	@XmlElement
	public void setDefaulter(String defaulter) {
		this.defaulter = defaulter;
	}
	
	public String getAverage_deposit() {
		return average_deposit;
	}
	
	@XmlElement
	public void setAverage_deposit(String average_deposit) {
		this.average_deposit = average_deposit;
	}
	
	public String getHouse() {
		return house;
	}
	
	@XmlElement
	public void setHouse(String house) {
		this.house = house;
	}
	
	public Bank(int row_id, String dataset_name, String field, String age,
			String job, String marital, String education, String defaulter,
			String average_deposit, String house) {
		super();
		this.row_id = row_id;
		this.dataset_name = dataset_name;
		this.field = field;
		this.age = age;
		this.job = job;
		this.marital = marital;
		this.education = education;
		this.defaulter = defaulter;
		this.average_deposit = average_deposit;
		this.house = house;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [row_id=" + row_id + ", dataset_name=" + dataset_name
				+ ", field=" + field + ", age=" + age + ", job=" + job
				+ ", marital=" + marital + ", education=" + education
				+ ", defaulter=" + defaulter + ", average_deposit="
				+ average_deposit + ", house=" + house + "]";
	}
	
	
	
	
	
	

}
