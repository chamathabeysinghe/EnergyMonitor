package com.ceb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
/*import org.springframework.web.bind.annotation.GetMapping;*/
import org.springframework.web.bind.annotation.ModelAttribute;
/*import org.springframework.web.bind.annotation.PostMapping;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceb.database.ComplaintDAO;
import com.ceb.models.Complaint;
import com.ceb.models.Location;

@Controller
public class LocationController {
	@RequestMapping(value = "/addLocation", method = RequestMethod.GET)
    public String makeComplaintForm(Model model) {
		Location location = new Location();
        model.addAttribute("location", location);
        return "addLocation";
    }
	@RequestMapping(value = "/postLocation", method = RequestMethod.POST)
	public String complaintSubmit(@ModelAttribute Location location,BindingResult result) {
		Location.LocationDAO.saveNewLocation(location);
		
		System.out.println("Your Region is "+location.getProvince());
		return "redirect: /admin";
		//ComplaintDAO.saveNewComplaint(complaint);
		//return "make_complaint";
    }
}