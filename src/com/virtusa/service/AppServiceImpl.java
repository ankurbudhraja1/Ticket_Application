package com.virtusa.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.dao.AppDAOImpl;
import com.virtusa.model.Bank;
import com.virtusa.model.Dataset;
import com.virtusa.model.Ticket;

@Path("/UserService")
public class AppServiceImpl {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
	AppDAOImpl AppDao = (AppDAOImpl)context.getBean("AppDAO");
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}	
	
@GET
@Path("/AllDatasets")
@Produces(MediaType.APPLICATION_XML)	
public List<Dataset> getAllDetails(){
			
		   System.out.println(AppDao.getAllDetails());
		   return AppDao.getAllDetails();
}
	
@GET
@Path("/BankDetails")
@Produces(MediaType.APPLICATION_XML)	  	
public List<Bank> getBankDetails() {	
  		return AppDao.getBankDetails();	
  	}

@GET
@Path("/AllTickets")
@Produces(MediaType.APPLICATION_XML)
public List<Ticket> getAllTicket(){	
  		return AppDao.getAllTicket();	
}	


@GET
@Path("/GraphData/{schema}")
@Produces(MediaType.APPLICATION_JSON)
public String getJSONdata(@PathParam("schema") String schema) {
	// TODO Auto-generated method stub
	return  AppDao.getJSONdata(schema).toString();
}

@GET
@Path("/Score/{resource}")
@Produces(MediaType.APPLICATION_JSON)
public String getScore(@PathParam("resource") String resource){
	return  AppDao.getScore(resource).toString();
}



@GET
@Path("/SelectedTickets")
@Produces(MediaType.APPLICATION_XML)
public List<Ticket> getSelectedTickets(String[] ticketNumber){	
	    return AppDao.getSelectedTickets(ticketNumber);	
	    
  		//return AppDao.getAllTicket();	
}	


public ArrayList<String> getAssigneScore(){
	return AppDao.getAssigneScore();
	
}

public String AssignResource(HashMap h){
	return AppDao.AssignResource(h);
	
}
} 
