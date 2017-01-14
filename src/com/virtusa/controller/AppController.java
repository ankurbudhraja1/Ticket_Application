package com.virtusa.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.model.Bank;
import com.virtusa.model.Dataset;
import com.virtusa.model.Ticket;
import com.virtusa.service.AppServiceImpl;

import java.lang.*;

@Controller
public class AppController {

	@RequestMapping("/home")
	public ModelAndView homepage() throws IOException{

		AppServiceImpl AppServ = new AppServiceImpl();
		List<Dataset> mod = AppServ.getAllDetails();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("data",mod);
		return new ModelAndView("homepage","model",model);
	}
	
	
	@RequestMapping("/home2")
	public ModelAndView homepage2(@RequestParam("resource") String test) throws IOException{

	System.out.println("Hi");
	System.out.println(test);
	//System.out.println(ticketNumber);
	
	String[] output = test.split("\\,");

	HashMap<String,String> h= new HashMap<String,String>();
	
	for(int i=0;i<=output.length-1;i+=2){
	
			
			System.out.println("printing i"+output[i]);
			System.out.println("printing j"+output[i+1]);
			h.put(output[i], output[i+1]);
		}
		
	
	System.out.println(h);
	
	AppServiceImpl AppServ = new AppServiceImpl();
	String message = AppServ.AssignResource(h);
	return new ModelAndView("allTicket","message",message);
	
	
	}
	
	@RequestMapping(value = "/bankpage", method = RequestMethod.GET)
	public ModelAndView details() {

		AppServiceImpl AppServ = new AppServiceImpl();
		List<Bank> data = AppServ.getBankDetails();
		return new ModelAndView("bankloan","data",data);
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public ModelAndView details1(@RequestParam("getschema") String schema) throws IOException {
      
		AppServiceImpl AppServ = new AppServiceImpl();
		
		List<Dataset> data = AppServ.getAllDetails();
		String graphdata= AppServ.getJSONdata(schema);	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("data",data);
		model.put("graphData", graphdata);
	    return new ModelAndView("homepage", "model", model);
		}
	
	@RequestMapping("/ticket")
	public ModelAndView allticket() throws IOException{

		AppServiceImpl AppServ = new AppServiceImpl();
		List<Ticket> mod = AppServ.getAllTicket();
		Map<String, Object> ticket = new HashMap<String, Object>();
		ticket.put("data",mod);
		return new ModelAndView("allTicket","ticket",ticket);

	}
	
	@RequestMapping("/scorepage")
	public ModelAndView score() throws IOException{

		AppServiceImpl AppServ = new AppServiceImpl();
		List<Ticket> mod = AppServ.getAllTicket();
		Map<String, Object> ticket = new HashMap<String, Object>();
		ticket.put("data",mod);
		return new ModelAndView("scorepage","ticket",ticket);

	}
	
	@RequestMapping("/scorecalculation")
	public ModelAndView scorecalculation(@RequestParam("resource") String resource) throws IOException{

		AppServiceImpl AppServ = new AppServiceImpl();
		String score = AppServ.getScore(resource);
		List<Ticket> mod = AppServ.getAllTicket();
		
		Map<String, Object> ticket = new HashMap<String, Object>();
		ticket.put("data",mod);
		ticket.put("score",score);
		return new ModelAndView("scorepage","ticket",ticket);
	}
	
//	@RequestMapping("/selectedTickets")
//	public ModelAndView selectedTickets(@RequestParam("selectedItems") String[] ticketNumber) throws IOException{
//	
//		
//		// String[] ids=request.getParameterValues("list");
//		    // this will get array of values of all checked checkboxes
////		    for(String id:ids){
////		     
////		    	
////		    	
////		    }
//	
//		
//		
//		AppServiceImpl AppServ = new AppServiceImpl();
//		System.out.println(ticketNumber.toString());
//		//String[] ticketNumber={"1001","1002","1003","1004"};
//		
//		//List ticketNumber =  Arrays.asList(ticketNumber); 
//		List<Ticket> mod = AppServ.getSelectedTickets(ticketNumber);
//		
//		Map<String, Object> ticket = new HashMap<String, Object>();
//		ticket.put("data",mod);
//		
//		return new ModelAndView("selectedTicket","ticket",ticket);
//
//	}
//	
	

		@RequestMapping("/selectedTickets")
			//public ModelAndView selectedTickets() throws IOException{
			public ModelAndView selectedTickets(@RequestParam("selectedItems") String[] ticketNumber) throws IOException{
			
				
				// String[] ids=request.getParameterValues("list");
				    // this will get array of values of all checked checkboxes
//				    for(String id:ids){
//				     
//				    	
//				    	
//				    }
				
				
				
				
				AppServiceImpl AppServ = new AppServiceImpl();
				System.out.println(ticketNumber.toString());
				//String[] ticketNumber={"1001","1002","1003","1004"};
				
				//List ticketNumber =  Arrays.asList(ticketNumber); 
				List<Ticket> mod = AppServ.getSelectedTickets(ticketNumber);
				
				
				ArrayList<String> names=AppServ.getAssigneScore();
				System.out.println(names);
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				
				
				Map<String, Object> ticket = new HashMap<String, Object>();
				ticket.put("data",mod);
				ticket.put("names", names);
				
				return new ModelAndView("selectedTicket","ticket",ticket);

			}
			

		

	
	
	
	
	
	

}
