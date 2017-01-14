package com.virtusa.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ticket")
public class Ticket implements Serializable{
	
	private int ticket_number;
	private String dataset_name;
	private String priority;
	private Date opened;
	private Date resolved;
	private Date closed;
	private String assignment_group;
	private String app_name;
	private String line_of_business;
	private String primary_application;
	private String ticket_description;
	private String resolution_description;
	private String incident_state;
	private String assignee;
	private String resolution_category;
	
	public int getTicket_number() {
		return ticket_number;
	}
	
	@XmlElement
	public void setTicket_number(int ticket_number) {
		this.ticket_number = ticket_number;
	}
	
	public String getDataset_name() {
		return dataset_name;
	}
	
	@XmlElement
	public void setDataset_name(String dataset_name) {
		this.dataset_name = dataset_name;
	}
	
	public String getPriority() {
		return priority;
	}
	
	@XmlElement
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public Date getOpened() {
		return opened;
	}
	
	@XmlElement
	public void setOpened(Date opened) {
		this.opened = opened;
	}
	
	public Date getResolved() {
		return resolved;
	}
	
	@XmlElement
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	
	public Date getClosed() {
		return closed;
	}
	
	@XmlElement
	public void setClosed(Date closed) {
		this.closed = closed;
	}
	
	public String getAssignment_group() {
		return assignment_group;
	}
	
	@XmlElement
	public void setAssignment_group(String assignment_group) {
		this.assignment_group = assignment_group;
	}
	
	public String getApp_name() {
		return app_name;
	}
	
	@XmlElement
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	
	public String getLine_of_business() {
		return line_of_business;
	}
	
	@XmlElement
	public void setLine_of_business(String line_of_business) {
		this.line_of_business = line_of_business;
	}
	
	public String getPrimary_application() {
		return primary_application;
	}
	
	@XmlElement
	public void setPrimary_application(String primary_application) {
		this.primary_application = primary_application;
	}
	
	public String getTicket_description() {
		return ticket_description;
	}
	
	@XmlElement
	public void setTicket_description(String ticket_description) {
		this.ticket_description = ticket_description;
	}
	
	public String getResolution_description() {
		return resolution_description;
	}
	
	@XmlElement
	public void setResolution_description(String resolution_description) {
		this.resolution_description = resolution_description;
	}
	
	public String getIncident_state() {
		return incident_state;
	}
	
	@XmlElement
	public void setIncident_state(String incident_state) {
		this.incident_state = incident_state;
	}
	
	public String getAssignee() {
		return assignee;
	}
	
	@XmlElement
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	
	public String getResolution_category() {
		return resolution_category;
	}
	
	@XmlElement
	public void setResolution_category(String resolution_category) {
		this.resolution_category = resolution_category;
	}
	public Ticket(int ticket_number, String dataset_name, String priority,
			Date opened, Date resolved, Date closed, String assignment_group,
			String app_name, String line_of_business,
			String primary_application, String ticket_description,
			String resolution_description, String incident_state,
			String assignee, String resolution_category) {
		super();
		this.ticket_number = ticket_number;
		this.dataset_name = dataset_name;
		this.priority = priority;
		this.opened = opened;
		this.resolved = resolved;
		this.closed = closed;
		this.assignment_group = assignment_group;
		this.app_name = app_name;
		this.line_of_business = line_of_business;
		this.primary_application = primary_application;
		this.ticket_description = ticket_description;
		this.resolution_description = resolution_description;
		this.incident_state = incident_state;
		this.assignee = assignee;
		this.resolution_category = resolution_category;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ticket [ticket_number=" + ticket_number + ", dataset_name="
				+ dataset_name + ", priority=" + priority + ", opened="
				+ opened + ", resolved=" + resolved + ", closed=" + closed
				+ ", assignment_group=" + assignment_group + ", app_name="
				+ app_name + ", line_of_business=" + line_of_business
				+ ", primary_application=" + primary_application
				+ ", ticket_description=" + ticket_description
				+ ", resolution_description=" + resolution_description
				+ ", incident_state=" + incident_state + ", assignee="
				+ assignee + ", resolution_category=" + resolution_category
				+ "]";
	}
	

	
	
	
}
