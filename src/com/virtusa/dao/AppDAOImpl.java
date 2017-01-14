package com.virtusa.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;

import com.virtusa.model.Bank;
import com.virtusa.model.Dataset;
import com.virtusa.model.Ticket;

import java.lang.*;



public class AppDAOImpl implements AppDAO {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
public List<Dataset> getAllDetails(){

		List<Dataset> rowList = new ArrayList<Dataset>();
		Connection con = null;
			try{  
				
				con = dataSource.getConnection();
				Statement stmt=con.createStatement();   			    			
				ResultSet rs=stmt.executeQuery("select * from dataset"); 
				
				ResultSetMetaData metaData = rs.getMetaData();
		        int columns = metaData.getColumnCount();
				
				while (rs.next()) {
					
					Dataset dataset = new Dataset();	
					dataset.setDataset_name(rs.getString("dataset_name"));
					dataset.setDomain(rs.getString("domain"));
					dataset.setDescription(rs.getString("description"));
					dataset.setAnalytics_model(rs.getString("analytics_model"));
					dataset.setUrl(rs.getString("url"));
					dataset.setSchema(rs.getString("schema"));

				rowList.add(dataset);
				System.out.println("exact dataset is" + dataset);
				}
				
				con.close();  
				}
			
			catch(Exception e){ 
				System.out.println(e);
				}  
			
			return rowList;
}

public List<Bank> getBankDetails(){	 
		
		List<Bank> rowList = new ArrayList<Bank>();
				Connection con = null;
				
		  		try{  
		  			con = dataSource.getConnection();

		  			Statement stmt=con.createStatement();   			    			
		  			ResultSet rs=stmt.executeQuery("select dataset_name, field, age, job, marital, education, defaulter, average_deposit, house, row_id from bank");

		  			ResultSetMetaData metaData = rs.getMetaData();
		  	        int columns = metaData.getColumnCount();
		
		  			while (rs.next()) {

		  				Bank data = new Bank();
		  				data.setAge(rs.getString("age"));
		  				data.setJob(rs.getString("job"));
		  				data.setMarital(rs.getString("marital"));
		  				data.setEducation(rs.getString("education"));
		  				data.setDefaulter(rs.getString("defaulter"));
		  				data.setAverage_deposit(rs.getString("average_deposit"));
		  				data.setHouse(rs.getString("house"));
		  				data.setDataset_name(rs.getString("dataset_name"));
		  				data.setField(rs.getString("field"));
		  				data.setRow_id(rs.getInt("row_id"));
		  				
		  			  rowList.add(data);
		  			}

		  			con.close();  
		  			}
		  		
		  		catch(Exception e){ 
		  			System.out.println(e);
		  			}  
		  		
		  		return rowList;
}

public List<Ticket> getAllTicket() {	
	
	List<Ticket> rowList = new ArrayList<Ticket>();
			Connection con = null;
	  		try{  
	  			con = dataSource.getConnection();
	  			Statement stmt=con.createStatement();   			    			
	  			ResultSet rs=stmt.executeQuery("select * from ticket");

	  			ResultSetMetaData metaData = rs.getMetaData();
	  	        int columns = metaData.getColumnCount();
	
	  			while (rs.next()) {
	  				
	  				Ticket ticketdata = new Ticket();
	  				ticketdata.setTicket_number(rs.getInt("ticket_Number"));
	  				ticketdata.setPriority(rs.getString("priority"));
	  				ticketdata.setOpened(rs.getDate("opened"));
	  				ticketdata.setResolved(rs.getDate("resolved"));
	  				ticketdata.setClosed(rs.getDate("closed"));
	  				ticketdata.setAssignment_group(rs.getString("assignment_group"));
	  				ticketdata.setApp_name(rs.getString("app_Name"));
	  				ticketdata.setLine_of_business(rs.getString("line_of_Business"));
	  				ticketdata.setPrimary_application(rs.getString("Primary_Application"));
	  				ticketdata.setTicket_description(rs.getString("ticket_Description"));
	  				ticketdata.setResolution_description(rs.getString("resolution_description"));
	  				ticketdata.setIncident_state(rs.getString("incident_state"));
	  				ticketdata.setAssignee(rs.getString("assignee"));
	  				ticketdata.setResolution_category(rs.getString("resolution_category"));
	  				
	  			  rowList.add(ticketdata);
	  			}

	  			con.close();  
	  			}
	  		
	  		catch(Exception e){ 
	  			}  
	  		
	  		return rowList;
}

public JSONArray getJSONdata(String schema) {	
	
	JSONObject obj = new JSONObject();
	JSONArray arr = new JSONArray();
	
        Connection con = null;
		  		try{  
  			con = dataSource.getConnection();
  			Statement stmt=con.createStatement();  
  			
  			ResultSet rs1=stmt.executeQuery("select dataset_name,count(dataset_name) from " + schema + " ");
  			
  	           while (rs1.next()) { 	        	
  	       	{
  	       	   	obj.put("label", rs1.getString(1));
  	       	    obj.put("value", rs1.getString(2));
  	       	   
  	       	    arr.put(obj);

  	       	    obj = new JSONObject();
  	       	}
 	  
  	    	  	  }
      
  			con.close();  
  			}
  		
  		catch(Exception e){ 
  			}  
  		
  		return arr;
}

public Float getScore(String resource) {	
	
			Connection con = null;
			String category = null;
			int count = 0;
			float score = 0;
			
			//Assigning weightage
			int x1=4;
			int x2=3;
			int x3=2;
			
	  		try{  
	  			con = dataSource.getConnection();
	  			Statement stmt=con.createStatement();   			    			
	  			ResultSet rs=stmt.executeQuery("select Resolution_category, count(Resolution_category) as count from ticket where assignee = '"+resource+"' group by Resolution_category");
	  			
	  			ResultSetMetaData metaData = rs.getMetaData();
	  	        int columns = metaData.getColumnCount();

	  	    Map<String, Integer> map = new HashMap<String, Integer>();
	  	    
	  	    	while(rs.next()) {
	  	    		
	  	    		category = rs.getString(1);
	  	    		count = rs.getInt(2);
	  	    		map.put(category, count);

	  	      }
	  	    		 
	  	    	String data,sw,hd;
	  	    	int db = 0,software = 0,hardware = 0;
	  	    	
	  	    	 if(map.get("DB Update")!=null){
	  	    	 data=map.get("DB Update").toString();
	  	    	 db=Integer.parseInt(data);
	  	    	}
	  	    	
	  	    	if(map.get("Software")!=null){
	  	    	sw=map.get("Software").toString();
	  	    	software=Integer.parseInt(sw);
	  	    	}
	  	    	
	  	    	if(map.get("Hardware Update")!=null){
	  	    	 hd=map.get("Hardware Update").toString();
	  	    	 hardware=Integer.parseInt(hd);
	  	    	}
	  	    	 	    		
	  	    	score = (x1*db)+(x2*software)+(x3*hardware);
	  	    	
	  			con.close();  
	  			}
	  		
	  		catch(Exception e){ 
	  			}  
	  		
	  		return score;
}


@Override
public ArrayList<String> getAssigneScore() {
	Connection con = null;
	String category = null;
	int count = 0;
	float score = 0;
	
	//Assigning weightage
	int x1=4;
	int x2=3;
	int x3=2;
	HashMap<String,Float> nameScore=new HashMap<String,Float>();
	ArrayList<String> names=new ArrayList<String>();
	String resource1=null;
		try{  
			con = dataSource.getConnection();
			
			
			Statement stmt1=con.createStatement();
		ResultSet rs1=stmt1.executeQuery("SELECT DISTINCT Assignee FROM dev.ticket;");
		
		while(rs1.next()){
			names.add(rs1.getString(1));
		
		resource1=rs1.getString(1);
		
		


			Statement stmt=con.createStatement();   			    			
  			ResultSet rs=stmt.executeQuery("select Resolution_category, count(Resolution_category) as count from ticket where assignee = '"+resource1+"' group by Resolution_category");
  			ResultSetMetaData metaData = rs.getMetaData();
  	        int columns = metaData.getColumnCount();
		
		

	    Map<String, Integer> map = new HashMap<String, Integer>();
	    
	    	while(rs.next()) {
	    		
	    		category = rs.getString(1);
	    		count = rs.getInt(2);
	    		map.put(category, count);

	      }
	    		 
	    	String data,sw,hd;
	    	int db = 0,software = 0,hardware = 0;
	    	
	    	 if(map.get("DB Update")!=null){
	    	 data=map.get("DB Update").toString();
	    	 db=Integer.parseInt(data);
	    	}
	    	
	    	if(map.get("Software")!=null){
	    	sw=map.get("Software").toString();
	    	software=Integer.parseInt(sw);
	    	}
	    	
	    	if(map.get("Hardware Update")!=null){
	    	 hd=map.get("Hardware Update").toString();
	    	 hardware=Integer.parseInt(hd);
	    	}
	    	 	    		
	    	score = (x1*db)+(x2*software)+(x3*hardware);
	    	System.out.println(score);
	    	
	    	nameScore.put(rs1.getString(1), score);
			}con.close(); 
			System.out.println();
			System.out.println(nameScore);
		}
		catch(Exception e){ 
			}  	
		return names;
	
}



public List<Ticket> getSelectedTickets(String[] ticketNumber) {	
	
	List<Ticket> rowList = new ArrayList<Ticket>();
			Connection con = null;
		
	  		try{  
	  			
			StringBuilder sb= new StringBuilder();
			String tickets = "";
			for(int i=0;i<ticketNumber.length;i++){  
			 sb.append( "'"+ticketNumber[i]+"'," );
			}
			tickets = sb.toString();
			tickets = tickets.substring(0, tickets.length()-1);

			
	  			con = dataSource.getConnection();
	  			Statement stmt=con.createStatement();   	
	  			
	  			ResultSet rs=stmt.executeQuery("select * from ticket where ticket_number in ("+tickets+")");

	  			ResultSetMetaData metaData = rs.getMetaData();
	  	        int columns = metaData.getColumnCount();

	  			while (rs.next()) {
	  				
	  				Ticket ticketdata = new Ticket();
	  				ticketdata.setTicket_number(rs.getInt("ticket_Number"));
	  				ticketdata.setPriority(rs.getString("priority"));
	  				ticketdata.setOpened(rs.getDate("opened"));
	  				ticketdata.setResolved(rs.getDate("resolved"));
	  				ticketdata.setClosed(rs.getDate("closed"));
	  				ticketdata.setAssignment_group(rs.getString("assignment_group"));
	  				ticketdata.setApp_name(rs.getString("app_Name"));
	  				ticketdata.setLine_of_business(rs.getString("line_of_Business"));
	  				ticketdata.setPrimary_application(rs.getString("Primary_Application"));
	  				ticketdata.setTicket_description(rs.getString("ticket_Description"));
	  				ticketdata.setResolution_description(rs.getString("resolution_description"));
	  				ticketdata.setIncident_state(rs.getString("incident_state"));
	  				ticketdata.setAssignee(rs.getString("assignee"));
	  				ticketdata.setResolution_category(rs.getString("resolution_category"));
	  				
	  			  rowList.add(ticketdata);
	  			}
	  			con.close();  
	  			}
	  		
	  		catch(Exception e){ 
	  			}  
	  		
	  		return rowList;
}


public String AssignResource(HashMap h) {	
	
	
	
			Connection con = null;
	  		try{  
	  			con = dataSource.getConnection();
	  			Statement stmt=con.createStatement();  
	  		
	  			System.out.println("h is"+h);
	  			
	  			HashMap<String,String> t= new HashMap<String,String>();
	  			t=h;
	  			
	  			System.out.println("t is"+t);
	  			
	  			
	  			String string1 = null;
	  			String string2 = null;
	  			
	  			for (Entry<String, String> entry : t.entrySet()) 
	  			{
	  			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	  			    string1=entry.getKey();
	  			    string2=entry.getValue();
	  			    
	  			  stmt.executeUpdate("UPDATE ticket SET assignee='"+string1+"' WHERE Ticket_Number='"+string2+"'");
	  			}
	  			
	  			
	  		

	  			System.out.println("map in daoimpl"+h);
	  			
	  			con.close();  
	  			}
	  		
	  		catch(Exception e){ 
	  			}  
	  		
	  		return "assignment done";
}


}