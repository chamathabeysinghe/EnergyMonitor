package com.ceb;

import java.util.HashMap;
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
   @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
   public String dashboard() {
      return "dashboard";
   }
   @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
   public String logUser(@ModelAttribute("SpringWeb")User user,ModelMap model) {
      model.addAttribute("name", user.getName());
      return "dashboard";
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
   @RequestMapping(value = "/change_request", method = RequestMethod.GET)
   public String change_request() {
      return "change_request";
   }
   

}
