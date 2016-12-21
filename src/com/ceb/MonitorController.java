package com.ceb;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceb.models.Bill;
import com.ceb.models.EnergyConsumption;
import com.ceb.models.ModelUtility;
import com.ceb.models.User;
import com.google.gson.Gson;

@Controller
public class MonitorController {
	
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
		try {
			HttpSession session = request.getSession(false);
			User loggedUser;
			loggedUser = (User) session.getAttribute("user");
			if (loggedUser.getUserType().equalsIgnoreCase("customer")) {
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	@RequestMapping(value = "/usage", method = RequestMethod.GET)
	public String consumerUsage(ModelMap model,HttpServletRequest request) {		
		if(!authenticateAdmin(request)){
			return "redirect: /login";
		}
		HttpSession session = request.getSession(false);
		User loggedUser=(User)session.getAttribute("user");
		model.addAttribute("userName",loggedUser.getFirstName()+" "+loggedUser.getLastName());
		int id=loggedUser.getId();
		HashMap<Integer,String> connectionIDs=Bill.BillDAO.getConnectionIDs(1);
		
		System.out.println(connectionIDs.keySet().iterator().next());
		String results[] = Bill.getUsageRepor(connectionIDs.keySet().iterator().next(), 2016);
		String results2[]=Bill.getBillReport(connectionIDs.keySet().iterator().next(), 2016);
		model.addAttribute("usageList", results);
		model.addAttribute("billList",results2);
		model.addAttribute("connectionIDs",connectionIDs);
		
		
		return "consumerUsage";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminDashboard(ModelMap model,HttpServletRequest request) {

		if(!authenticateAdmin(request)){
			return "redirect: /login";
		}
		HttpSession session = request.getSession(false);
		User loggedUser=(User)session.getAttribute("user");
		model.addAttribute("userName",loggedUser.getFirstName()+" "+loggedUser.getLastName());
		model.addAttribute("complaints",ModelUtility.ModelUtilityDAO.getComplainCount());
		model.addAttribute("newConnection",ModelUtility.ModelUtilityDAO.getConnectionRequestCount());
		model.addAttribute("changeConnection",ModelUtility.ModelUtilityDAO.getConnectionChangeCount());
		model.addAttribute("customerCount",ModelUtility.ModelUtilityDAO.getCustomerCount());
		return "admindashboard";
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String consumerDashboard(ModelMap model,HttpServletRequest request) {
		if(!authenticateAdmin(request)){
			return "redirect: /login";
		}
		HttpSession session = request.getSession(false);
		User loggedUser=(User)session.getAttribute("user");
		model.addAttribute("userName",loggedUser.getFirstName()+" "+loggedUser.getLastName());
		int id=loggedUser.getId();
		model.addAttribute("userName",loggedUser.getFirstName()+" "+loggedUser.getLastName());
		model.addAttribute("complaints",ModelUtility.ModelUtilityDAO.getComplainCount(id));
		model.addAttribute("newConnection",ModelUtility.ModelUtilityDAO.getConnectionRequestCount(id));
		model.addAttribute("changeConnection",ModelUtility.ModelUtilityDAO.getConnectionChangeCount(id));
		model.addAttribute("customerCount",(int)ModelUtility.ModelUtilityDAO.remainingBalance(id));		
		return "consumerDasboard";
	}
	
	@RequestMapping(value = "/ajaxBillYearChange", method = RequestMethod.POST, produces = "plain/text")
	@ResponseBody
	public String ajaxBillYearChange(@RequestBody String data) {
		
		int intYear = Integer.parseInt(data.split(":::")[0]);
		int connectionID = Integer.parseInt(data.split(":::")[1]);
		
		String results[] = Bill.getUsageRepor(connectionID, intYear);
		String results2[]=Bill.getBillReport(connectionID, intYear);

		return results[1]+"::"+results2[1];
	}

	@RequestMapping(value = "/consumption", method = RequestMethod.GET)
	public String locationUsage(ModelMap model,HttpServletRequest request) {
		
		if(!authenticateAdmin(request)){
			return "redirect: /login";
		}
		HttpSession session = request.getSession(false);
		User loggedUser=(User)session.getAttribute("user");
		model.addAttribute("userName",loggedUser.getFirstName()+" "+loggedUser.getLastName());

		
		String totlaUsageByYear[] = EnergyConsumption.EnergyConsumptionDAO.getEnergyConsumptionRecordByYear();
		model.addAttribute("usageList", totlaUsageByYear);

		String totlaUsageByTime[] = EnergyConsumption.EnergyConsumptionDAO
				.getCountryEnergyConsumptionCategorizedByTime();
		model.addAttribute("usageListByTime", totlaUsageByTime);

		String totlaUsageByProvince[] = EnergyConsumption.EnergyConsumptionDAO
				.getCountryEnergyConsumptionCategorizedByProvince();
		model.addAttribute("usageListByProvince", totlaUsageByProvince);
		System.out.println(Arrays.toString(totlaUsageByProvince));
		return "electricConsumption";
	}

	@RequestMapping(value = "/ajaxConsumptionForProvince", method = RequestMethod.POST, produces = "plain/text")
	@ResponseBody
	public String ajaxConsumptionForProvince(@RequestBody String province) {
		HashMap<String, String> resultsForTotalUsage = EnergyConsumption.EnergyConsumptionDAO
				.getEnergyConsumptionRecordByYearForProvince(province);
		HashMap<String, String> resultsForUsageByTime = EnergyConsumption.EnergyConsumptionDAO
				.getCountryEnergyConsumptionCategorizedByTimeForProvince(province);
		HashMap<String, HashMap<String, String>> l = new HashMap<String, HashMap<String, String>>();
		l.put("TotalUsage", resultsForTotalUsage);
		l.put("TimeUsage", resultsForUsageByTime);
		
		
		
		double intercept=EnergyConsumption.EnergyConsumptionDAO.getElectricConsumptionInterceptForYearByProvince(province);
		double slope=EnergyConsumption.EnergyConsumptionDAO.getElectricConsumptionSlopeForYearByProvince(province);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		HashMap<String,String> predictedConsumptionByYear=new HashMap<String,String>();
		for(int i=year+1;i<year+6;i++){
			predictedConsumptionByYear.put(String.valueOf(i), String.valueOf(i*slope+intercept));
		}
		l.put("PredictedUsage", predictedConsumptionByYear);
		Gson gson = new Gson();
		String json = gson.toJson(l);
		return json;
	}
	
	
	
}
