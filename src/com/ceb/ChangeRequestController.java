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

import com.ceb.database.ChangeRequestDAO;
import com.ceb.models.ChangeRequest;

@Controller
public class ChangeRequestController {
	@RequestMapping(value = "/make_change_request", method = RequestMethod.GET)
    public String makeChangeRequestForm(Model model) {
		int id = ChangeRequestDAO.getId() + 1; 
		System.out.println(id);
		ChangeRequest changeRequest = new ChangeRequest();
		changeRequest.setId(id); 
        model.addAttribute("changeRequest", changeRequest);
        model.addAttribute("id", id);
        return "make_change_request";
    }
	@RequestMapping(value = "/make_change_request", method = RequestMethod.POST)
	public String changeRequestSubmit(@ModelAttribute ChangeRequest changeRequest,BindingResult result) {
		ChangeRequestDAO.saveNewChangeRequest(changeRequest);
		return "make_change_request";
    }
}