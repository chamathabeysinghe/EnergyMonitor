package com.ceb;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ceb.database.ChangeRequestDAO;
import com.ceb.database.ComplaintDAO;
import com.ceb.database.ConnectionRequestDAO;
import com.ceb.database.DataAccess;
import com.ceb.models.Bill;
import com.ceb.models.ChangeRequest;
import com.ceb.models.Complaint;
import com.ceb.models.ConnectionRequest;
import com.ceb.models.Customer;
import com.ceb.models.Customer.CustomerDAO;
import com.ceb.models.EnergyConsumption;
import com.ceb.models.User;
import com.ceb.models.User.userDAO;
import com.google.gson.Gson;
import com.mysql.cj.x.json.JsonArray;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

//@Controller
//@RequestMapping("/login")
//public class WebController{
// 
//   @RequestMapping(method = RequestMethod.GET)
//   public String printHello(ModelMap model) {
//      return "login";
//   }
//
//}


@Controller
public class WebController {

	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	   public ModelAndView user() {
	      return new ModelAndView("login", "command", new User());
	   }
	   
	   @RequestMapping(value = "/signup", method = RequestMethod.GET)
	   public ModelAndView signup() {
		   return new ModelAndView("signup", "command", new User());
	   }
	   @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	   public String logUser(@ModelAttribute("SpringWeb")User user,ModelMap model,HttpServletRequest request) {
		   System.out.println("Inside th postLoginjsdkfjakls dfjaklfjalkj "+user.getFirstName());
		  User loggedUser=User.userDAO.logUser(user);
		  if(loggedUser==null){
			  System.out.println("Incorrect Loging");
		  }
		  HttpSession session = request.getSession(false);
		  session.setAttribute("userID", loggedUser.getId());
		  session.setAttribute("userName", loggedUser.getFirstName()+" "+loggedUser.getLastName());
		  session.setAttribute("user", loggedUser);
		  session.setMaxInactiveInterval(60*60);
		  
		  model.addAttribute("name", user.getFirstName());
		  System.out.println("DFDLKJFLD");
		  if(loggedUser.getUserType().equalsIgnoreCase("customer")){
			  return "redirect: /customer";
		  }
		  else{
			  return "redirect: /admin";
		  }
	      
	   }
	   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
		public String saveUser(HttpServletRequest req) {
		   	System.out.println("adduserworking");
		   	String firstName = (req.getParameter("firstName"));
		   	String lastName = (req.getParameter("lastName"));
		   	String nameWithInitials = (req.getParameter("nameWithInitials"));
		   	String address = (req.getParameter("address"));
		   	String NIC = (req.getParameter("NIC"));
		   	String phoneNumber = (req.getParameter("phoneNumber"));
		   	String email = (req.getParameter("email"));
		   	String password = (req.getParameter("password"));
		   	String userType = (req.getParameter("userType"));
		 	
		 	User user = new User();
		 	user.setFirstName(firstName);
		 	user.setLastName(lastName);
		 	user.setNIC(NIC);
		 	user.setPhoneNumber(phoneNumber);
		 	user.setEmail(email);
		 	user.setPassword(password);
		 	user.setUserType(userType);
		 	
		 	
		 	System.out.println("User email ::::"+email+ "password "+password+" usertype"+userType);
		 	
		 	boolean u=userDAO.addUser(user);
		 	if(user.getUserType().equalsIgnoreCase("Customer")){
		 		Customer cus=new Customer();
			 	cus.setId(userDAO.getUserCount());
			 	cus.setName(nameWithInitials);
			 	cus.setAddress(address);
			 	boolean b=CustomerDAO.addCustomer(cus);
		 	}
		 	if ( u) {
				return "Data added successfully";
			} else {
				return "Error occured";
			}
		 	
		}
   
   

   
   
//   Complaint and Request Handling
   
   /*@RequestMapping(value = "/make_complaint", method = RequestMethod.GET)
   public String make_complaint() {
      return "make_complaint";
   }*/
   @RequestMapping(value = "/view_complaints", method = RequestMethod.GET)
   public String view_complaints(Model model) {
	   
	   List<Complaint> allcomplaints = ComplaintDAO.getAllComplaints();
	   model.addAttribute("allcomplaints", allcomplaints);
       for(Complaint complaint: allcomplaints){
       	 System.out.println("Complaint As : " + complaint.getId() + " " + complaint.getComplaintDetails());
       }
       
       List<ChangeRequest> allchangerequests = ChangeRequestDAO.getAllChangeRequests();
	   model.addAttribute("allchangerequests", allchangerequests);
       for(ChangeRequest changeRequest: allchangerequests){
       	 System.out.println("Change Request As : " + changeRequest.getId() + " " + changeRequest.getChangeDetails());
       }
       
       List<ConnectionRequest> allconnectionrequests = ConnectionRequestDAO.getAllConnectionRequests();
	   model.addAttribute("allconnectionrequests", allconnectionrequests);
       for(ConnectionRequest connectionrequest: allconnectionrequests){
       	 System.out.println("Connection Request As : " + connectionrequest.getId() + " " + connectionrequest.getNewConnectionDetails());
       }
       
      return "view_complaints";
   }
   

}
