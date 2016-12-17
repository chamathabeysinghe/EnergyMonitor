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

@Controller
public class ComplaintController {
	@RequestMapping(value = "/make_complaint", method = RequestMethod.GET)
    public String makeComplaintForm(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "make_complaint";
    }
	@RequestMapping(value = "/make_complaint", method = RequestMethod.POST)
	public String complaintSubmit(@ModelAttribute Complaint complaint, BindingResult result) {
        ComplaintDAO.saveNewComplaint(complaint);
		return "make_complaint";
    }

}