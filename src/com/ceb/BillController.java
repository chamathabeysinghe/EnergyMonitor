package com.ceb;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ceb.models.Bill;
import com.ceb.models.Bill.BillDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.x.json.JsonArray;
//import com.fasterxml.jackson.databind.ObjectMapper;


//import com.google.gson.Gson;


@RestController
public class BillController {

	@RequestMapping(value = "/addBill", method = RequestMethod.GET)
	   public ModelAndView addBill() {
		   return new ModelAndView("addBill");
	   }
	@RequestMapping(value = "/findBill", method = RequestMethod.GET)
	   public ModelAndView findBill() {
		   return new ModelAndView("searchBill");
	   }

	 @RequestMapping(value = "findBill", method = RequestMethod.POST, produces={"application/json"})
		public @ResponseBody String findBill(HttpServletRequest req, ModelMap model) {
		 	System.out.println(req.getParameter("connectionID"));
		 	int connectionID=Integer.parseInt(req.getParameter("connectionID"));
		 	int billID=Integer.parseInt(req.getParameter("billID"));
		 	int year=Integer.parseInt(req.getParameter("year"));
		 	int month=Integer.parseInt(req.getParameter("month"));
		 	Object[] bills=BillDAO.getBill(billID, connectionID, year, month).toArray();
//		 	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		 	String jasonArray="";
		 	System.out.println(bills[0]);
	//	 	Gson gson=new GsonBuilder().create();
		   // String jsonArray=gson.toJson(sentences);
		 	return jasonArray;
		 	
		 	
		

		}
	 @RequestMapping(value = "/saveBill", method = RequestMethod.POST)
		public String saveBill(HttpServletRequest req) {
		 	int connectionID=Integer.parseInt(req.getParameter("connectionID"));
		 	int year=Integer.parseInt(req.getParameter("year"));
		 	String month=req.getParameter("month");
		 	double usage=Double.parseDouble(req.getParameter("usage"));
		 	double amount=Double.parseDouble(req.getParameter("amount"));
		 	Bill bill =new Bill();
		 	bill.setAmount(amount);
		 	bill.setUsage(usage);
		 	bill.setConnectionID(connectionID);
		 	bill.setMonth(month);
		 	bill.setYear(year);
		 	
		 	boolean b=BillDAO.addBill(bill);
		 	if(b){
		 		return "Data added successfully";
		 	}else{
		 		return "Error occured";
		 	}
		 	
		 	
		 	//System.out.println("working"+data);
//		 	BufferedReader reader = null;
//			try {
//				reader = req.getReader();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		 	Gson gson = new Gson();
//		 	Bill bill=gson.fromJson(reader, Bill.class);
//		 	System.out.println("working"+bill);
			//AjaxResponseBody result = new AjaxResponseBody();

//			if (isValidSearchCriteria(search)) {
//				List<User> users = findByUserNameOrEmail(search.getUsername(), search.getEmail());
//
//				if (users.size() > 0) {
//					result.setCode("200");
//					result.setMsg("");
//					result.setResult(users);
//				} else {
//					result.setCode("204");
//					result.setMsg("No user!");
//				}
//			
//			} else {
//				result.setCode("400");
//				result.setMsg("Search criteria is empty!");
//			}

			//AjaxResponseBody will be converted into json format and send back to the request.
		

		}
	 
}