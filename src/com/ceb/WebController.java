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

import com.ceb.database.DataAccess;
import com.ceb.models.Bill;
import com.ceb.models.EnergyConsumption;
import com.ceb.models.User;
import com.ceb.models.User.userDAO;
import com.google.gson.Gson;
import com.mysql.cj.x.json.JsonArray;

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
	      return "redirect: /admin";
	   }
	   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
		public String saveUser(@ModelAttribute("SpringWeb")User userIn,HttpServletRequest req) {
		   	System.out.println("adduserworking");
		   	String firstName = (req.getParameter("firstName"));
		   	String lastName = (req.getParameter("lastName"));
		   	String nameWithInitials = (req.getParameter("nameWithInitials"));
		   	String address = (req.getParameter("address"));
		   	String NIC = (req.getParameter("NIC"));
		   	String phoneNumber = (req.getParameter("phoneNumber"));
		   	String email = (req.getParameter("email"));
		   	String password = (req.getParameter("password"));
		 	
		 	User user = new User();
		 	user.setFirstName(firstName);
		 	user.setLastName(lastName);
		 	user.setNameWithInitials(nameWithInitials);
		 	user.setAddress(address);
		 	user.setNIC(NIC);
		 	user.setPhoneNumber(phoneNumber);
		 	user.setEmail(email);
		 	user.setPassword(password);
		 	
		 	System.out.println("User email ::::"+email);
		 	
		 	boolean u=userDAO.addUser(user);
		 	if(u){
		 		return "dashboard";
		 	}else{
		 		return "dashboard";
		 	}
		 	
		 	

		}
   
   

   
   
//   Complaint and Request Handling
   
   /*@RequestMapping(value = "/make_complaint", method = RequestMethod.GET)
   public String make_complaint() {
      return "make_complaint";
   }*/
   @RequestMapping(value = "/view_complaints", method = RequestMethod.GET)
   public String view_complaints() {
      return "view_complaints";
   }
   

}
