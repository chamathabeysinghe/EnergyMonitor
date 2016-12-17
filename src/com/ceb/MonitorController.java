package com.ceb;

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
import com.google.gson.Gson;

@Controller
public class MonitorController {

	@RequestMapping(value = "/usage", method = RequestMethod.GET)
	public String consumerUsage(ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.setAttribute("userID", 1);
		
		
		String results[] = Bill.getUsageRepor(1, 2016);
		model.addAttribute("usageList", results);
		return "consumerUsage";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminDashboard(ModelMap model,HttpServletRequest request) {
		model.addAttribute("complaints",ModelUtility.ModelUtilityDAO.getComplainCount());
		model.addAttribute("newConnection",ModelUtility.ModelUtilityDAO.getConnectionRequestCount());
		model.addAttribute("changeConnection",ModelUtility.ModelUtilityDAO.getConnectionChangeCount());
		model.addAttribute("customerCount",ModelUtility.ModelUtilityDAO.getCustomerCount());
		
		HttpSession session = request.getSession(false);
		int id=(Integer)(session.getAttribute("userID"));
		
		return "admindashboard";
	}

	@RequestMapping(value = "/ajaxBillYearChange", method = RequestMethod.POST, produces = "plain/text")
	@ResponseBody
	public String ajaxBillYearChange(@RequestBody String year) {
		int intYear = Integer.parseInt(year);
		String results[] = Bill.getUsageRepor(1, intYear);
		return results[1];
	}

	@RequestMapping(value = "/consumption", method = RequestMethod.GET)
	public String locationUsage(ModelMap model) {

		String totlaUsageByYear[] = EnergyConsumption.EnergyConsumptionDAO.getEnergyConsumptionRecordByYear();
		model.addAttribute("usageList", totlaUsageByYear);

		String totlaUsageByTime[] = EnergyConsumption.EnergyConsumptionDAO
				.getCountryEnergyConsumptionCategorizedByTime();
		model.addAttribute("usageListByTime", totlaUsageByTime);

		String totlaUsageByProvince[] = EnergyConsumption.EnergyConsumptionDAO
				.getCountryEnergyConsumptionCategorizedByProvince();
		model.addAttribute("usageListByProvince", totlaUsageByProvince);
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
