package com.ceb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
/*import org.springframework.web.bind.annotation.GetMapping;*/
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.PostMapping;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceb.database.ComplaintDAO;
import com.ceb.models.Complaint;
import com.ceb.models.User;

@Controller
public class ComplaintController {
	@RequestMapping(value = "/make_complaint", method = RequestMethod.GET)
    public String makeComplaintForm(Model model) {
		int id = ComplaintDAO.getId() + 1; 
		System.out.println(id);
		Complaint complaint = new Complaint();
		complaint.setId(id); 
        model.addAttribute("complaint", complaint);
        model.addAttribute("id", id);
        return "make_complaint";
    }
	@RequestMapping(value = "/make_complaint", method = RequestMethod.POST)
	public String complaintSubmit(@ModelAttribute Complaint complaint,BindingResult result,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		User loggedUser=(User)session.getAttribute("user");
		int id=loggedUser.getId();
		ComplaintDAO.saveNewComplaint(complaint,1);
		return "make_complaint";
    }
	@RequestMapping(value = "/done_complaint", method = RequestMethod.POST,produces = "plain/text")
	@ResponseBody
	public String donecomplaintSubmit(@RequestBody String data) {
		/*ComplaintDAO.saveNewComplaint(complaint);*/
		System.out.println("done complaint working "+data);
		data = data.replaceAll("\\D+","");
		int id = Integer.parseInt(data);
		ComplaintDAO.updateComplaint(id);
		System.out.println("Done Complaint ID" + id);
		return "view_complaints";
    }
}