package com.ceb;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ceb.models.Bill;
import com.ceb.models.Bill.BillDAO;
import com.ceb.models.Connection;
import com.ceb.models.Connection.ConnectionDAO;
import com.ceb.models.Payment;
import com.ceb.models.Payment.PaymentDAO;
import com.ceb.models.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.mysql.cj.x.json.JsonArray;
//import com.fasterxml.jackson.databind.ObjectMapper;

//import com.google.gson.Gson;

@RestController
public class BillController {
	public boolean authenticateAdmin(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			User loggedUser;
			loggedUser = (User) session.getAttribute("user");
			if (loggedUser.getUserType().equalsIgnoreCase("admin")) {
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}

	}

	public boolean authenticateCustomer(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		User loggedUser = (User) session.getAttribute("user");
		if (loggedUser.getUserType().equalsIgnoreCase("customer")) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/addBill", method = RequestMethod.GET)
	public ModelAndView addBill(HttpServletRequest request) {
		// if (!authenticateAdmin(request)) {
		// System.out.println("Not Authenticated");
		// return new ModelAndView("redirect: /login");
		// }
		System.out.println("Authenticated");
		return new ModelAndView("addBill");
	}

	@RequestMapping(value = "/addPayment", method = RequestMethod.GET)
	public ModelAndView addPayment(HttpServletRequest request) {
		// if (!authenticateAdmin(request)) {
		// System.out.println("Not Authenticated");
		// return new ModelAndView("redirect: /login");
		// }
		return new ModelAndView("registerPayment");
	}

	@RequestMapping(value = "/addConnection", method = RequestMethod.GET)
	public ModelAndView addConnection(HttpServletRequest request) {
		// if (!authenticateAdmin(request)) {
		// System.out.println("Not Authenticated");
		// return new ModelAndView("redirect: /login");
		// }
		return new ModelAndView("addNewConnection");
	}

	@RequestMapping(value = "/findBill", method = RequestMethod.GET)
	public ModelAndView findBill(HttpServletRequest request) {
		// if (!authenticateAdmin(request)) {
		// System.out.println("Not Authenticated");
		// return new ModelAndView("redirect: /login");
		// }
		return new ModelAndView("searchBill");
	}

	// @RequestMapping(value = "findBill", method = RequestMethod.POST,
	// produces={"application/json"})
	// public @ResponseBody String findBill(HttpServletRequest req, ModelMap
	// model) {
	// System.out.println(req.getParameter("connectionID"));
	// int connectionID=Integer.parseInt(req.getParameter("connectionID"));
	// int billID=Integer.parseInt(req.getParameter("billID"));
	// int year=Integer.parseInt(req.getParameter("year"));
	// int month=Integer.parseInt(req.getParameter("month"));
	// Object[] bills=BillDAO.getBill(billID, connectionID, year,
	// month).toArray();
	//// ObjectWriter ow = new
	// ObjectMapper().writer().withDefaultPrettyPrinter();
	// String jasonArray="";
	// System.out.println(bills[0]);
	// // Gson gson=new GsonBuilder().create();
	// // String jsonArray=gson.toJson(sentences);
	// return jasonArray;
	//
	//
	//
	//
	// }
	@RequestMapping(value = "findBill", method = RequestMethod.POST)
	public ModelAndView findBill(HttpServletRequest req, ModelMap model) {

		int billId = -1;
		int connectionID = -1;
		int year = -1;
		int month = -1;
		if (req.getParameter("connectionID").matches("\\d+")) {
			connectionID = Integer.parseInt(req.getParameter("connectionID"));
		}
		if (req.getParameter("billID").matches("\\d+")) {
			billId = Integer.parseInt(req.getParameter("billID"));
		}
		if (req.getParameter("year").matches("\\d+")) {
			year = Integer.parseInt(req.getParameter("year"));
		}
		if (req.getParameter("month").matches("\\d+")) {
			month = Integer.parseInt(req.getParameter("month"));
		}
		// System.out.println(req.getParameter("connectionID"));

		List<Bill> bills = BillDAO.getBill(billId, connectionID, year, month);
		model.addAttribute("billList", bills);
		return new ModelAndView("viewSearchResult");

	}

	@RequestMapping(value = "/saveBill", method = RequestMethod.POST, produces = { "plain/text" })
	public String saveBill(HttpServletRequest req) {
		int connectionID = Integer.parseInt(req.getParameter("connectionID"));
		int year = Integer.parseInt(req.getParameter("year"));
		String month = req.getParameter("month");
		double usage = Double.parseDouble(req.getParameter("usage"));
		double amount = Double.parseDouble(req.getParameter("amount"));
		Bill bill = new Bill();
		bill.setAmount(amount);
		bill.setUsage(usage);
		bill.setConnectionID(connectionID);
		bill.setMonth(month);
		bill.setYear(year);

		boolean b = BillDAO.addBill(bill);
		if (b) {
			return "Data added successfully";
		} else {
			return "Error occured";
		}

	}

	@RequestMapping(value = "/saveConnection", method = RequestMethod.POST, produces = { "plain/text" })
	public String saveConnection(HttpServletRequest req) {
		String connectionAddress = req.getParameter("connectionAddress");
		int customerID = Integer.parseInt(req.getParameter("customerID"));
		int locationID = Integer.parseInt(req.getParameter("locationID"));
		String category = req.getParameter("category");

		Connection con = new Connection();
		con.setAddress(connectionAddress);
		con.setCategory(category);
		con.setCustomerID(customerID);
		con.setLocationID(locationID);

		boolean b = ConnectionDAO.addConnection(con);
		if (b) {
			return "Data added successfully";
		} else {
			return "Error occured";
		}

	}

	@RequestMapping(value = "/savePayment", method = RequestMethod.POST, produces = { "plain/text" })
	public String savePayment(HttpServletRequest req) {
		int connectionID = Integer.parseInt(req.getParameter("connectionID"));
		double amount = Double.parseDouble(req.getParameter("amount"));
		String date = req.getParameter("date");
		System.out.println("date : " + date + " con" + connectionID + "amount" + amount);
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date inputDate = null;
		try {
			inputDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date = new SimpleDateFormat("yyyy-mm-dd").format(inputDate);
		System.out.println("date : " + date + " con" + connectionID + "amount" + amount);
		Payment payment = new Payment();
		payment.setAmount(amount);
		payment.setConnectionID(connectionID);
		payment.setDate(date);
		boolean b = PaymentDAO.addPayment(payment);
		if (b) {
			return "Data added successfully";
		} else {
			return "Error occured";
		}

	}

	@RequestMapping(value = "/viewAllBills", method = RequestMethod.POST)
	public ModelAndView viewAllBills(HttpServletRequest req, ModelMap model) {
		HttpSession session = req.getSession(false);
		int id=1;
		try{
			id=(Integer)(session.getAttribute("userID"));
		}
		catch(NullPointerException e){
			
		}
		
		List<Bill> bills = BillDAO.getBillsByConnection(id);
		model.addAttribute("billList", bills);
		return new ModelAndView("viewAllBills");

	}

}
