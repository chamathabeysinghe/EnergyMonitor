package com.ceb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	//login and sign up 

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView user() {
      return new ModelAndView("login", "command", new User());
   }
   
   @RequestMapping(value = "/signup", method = RequestMethod.GET)
   public ModelAndView signup() {
	   return new ModelAndView("signup", "command", new User());
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
	 	
	 	User user = new User();
	 	user.setFirstName(firstName);
	 	user.setLastName(lastName);
	 	user.setNameWithInitials(nameWithInitials);
	 	user.setAddress(address);
	 	user.setNIC(NIC);
	 	user.setPhoneNumber(phoneNumber);
	 	user.setEmail(email);
	 	user.setPassword(password);
	 	
	 	System.out.println("dsfg");
	 	
	 	boolean u=userDAO.addUser(user);
	 	if(u){
	 		return "dashboard";
	 	}else{
	 		return "dashboard";
	 	}
	 	
	 	

	}
   
   
   @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
   public String dashboard() {
      return "dashboard";
   }
   @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
   public String logUser(@ModelAttribute("SpringWeb")User user,ModelMap model) {
      model.addAttribute("name", user.getFirstName());
      return "dashboard";
   }
   
   @RequestMapping(value="/usage",method=RequestMethod.GET)
   public String consumerUsage(ModelMap model){
	   String results[]=Bill.getUsageRepor(1,2016);
	   model.addAttribute("usageList",results);
	   return "consumerUsage";
   }
   

   @RequestMapping(value="/ajaxBillYearChange",method=RequestMethod.POST,produces = "plain/text")
   @ResponseBody
   public String ajaxBillYearChange(@RequestBody String year){
	   int intYear=Integer.parseInt(year);
	   String results[]=Bill.getUsageRepor(1,intYear);
	   return results[1];
   }
   
   @RequestMapping(value="/consumption",method=RequestMethod.GET)
   public String locationUsage(ModelMap model){
	   
	   String totlaUsageByYear[]=EnergyConsumption.EnergyConsumptionDAO.getEnergyConsumptionRecordByYear();
	   model.addAttribute("usageList",totlaUsageByYear);
	   
	   String totlaUsageByTime[]=EnergyConsumption.EnergyConsumptionDAO.getCountryEnergyConsumptionCategorizedByTime();
	   model.addAttribute("usageListByTime",totlaUsageByTime);
	   
	   String totlaUsageByProvince[]=EnergyConsumption.EnergyConsumptionDAO.getCountryEnergyConsumptionCategorizedByProvince();
	   model.addAttribute("usageListByProvince",totlaUsageByProvince);
	   
	   return "electricConsumption";
	   
   }


   
   
//   Complaint and Request Handling
   
   @RequestMapping(value = "/make_complaint", method = RequestMethod.GET)
   public String make_complaint() {
      return "make_complaint";
   }
   @RequestMapping(value = "/view_complaints", method = RequestMethod.GET)
   public String view_complaints() {
      return "view_complaints";
   }
   @RequestMapping(value = "/make_request", method = RequestMethod.GET)
   public String make_request() {
      return "make_request";
   }
   

}
