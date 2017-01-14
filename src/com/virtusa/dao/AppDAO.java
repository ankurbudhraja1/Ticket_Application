package com.virtusa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.virtusa.model.Bank;
import com.virtusa.model.Dataset;
import com.virtusa.model.Ticket;

public interface AppDAO {
	
	public List<Ticket> getAllTicket();
	public Float getScore(String resource);
	public ArrayList<String> getAssigneScore();
	public JSONArray getJSONdata(String schema);
	public List<Dataset> getAllDetails();
	public List<Bank> getBankDetails();
	public String AssignResource(HashMap h);
	
	public List<Ticket> getSelectedTickets(String[] ticketNumber);
		

}
