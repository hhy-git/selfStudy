package com.infiniteskills.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.entities.Sponsor;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	@ResponseBody
	public String goHome() {
		return "Welcome HOME";
	}
	
	@RequestMapping("/")
	public String goHomeJsp(Model model) {
		Project project = new Project();
		project.setName("First Project");
		Sponsor sponsor = new Sponsor();
		sponsor.setName("NASA");
		project.setSponsor(sponsor);
		project.setDescription("This is a simple project sponsored by NASA");
		
		model.addAttribute("currentProject", project);
		return "home";
	}
}
