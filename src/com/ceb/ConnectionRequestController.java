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

import com.ceb.database.ConnectionRequestDAO;
import com.ceb.models.ConnectionRequest;

@Controller
public class ConnectionRequestController {
	@RequestMapping(value = "/make_connection_request", method = RequestMethod.GET)
    public String makeConnectionRequestForm(Model model) {
		int id = ConnectionRequestDAO.getId() + 1; 
		System.out.println(id);
		ConnectionRequest connectionRequest = new ConnectionRequest();
		connectionRequest.setId(id); 
        model.addAttribute("connectionRequest", connectionRequest);
        model.addAttribute("id", id);
        return "make_connection_request";
    }
	@RequestMapping(value = "/make_connection_request", method = RequestMethod.POST)
	public String complaintSubmit(@ModelAttribute ConnectionRequest connectionRequest,BindingResult result) {
		ConnectionRequestDAO.saveConnectionRequest(connectionRequest);
		return "make_connection_request";
    }
}