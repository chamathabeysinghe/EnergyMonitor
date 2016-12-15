package com.ceb;

import java.util.List;

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
   public String signup() {
	   return "signup";
   }
   
   @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
   public String dashboard() {
      return "dashboard";
   }
   @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
   public String logUser(@ModelAttribute("SpringWeb")User user,ModelMap model) {
      model.addAttribute("name", user.getName());
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
