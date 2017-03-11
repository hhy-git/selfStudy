package com.infiniteskills.mvc.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.services.ProjectService;
import com.infiniteskills.mvc.data.validators.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/find")
	public String find(Model model) {
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/{projectId}")
	public String findProject(Model model, @PathVariable("projectId") Long projectId) {
		model.addAttribute("project", this.projectService.find(projectId));
		return "project";
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addProject(HttpSession session, Model model) {
		System.out.println("Invoking addProject");
		session.setAttribute("token", "12345");
		
		model.addAttribute("project", new Project());
		
		
		return "project_add";
	}
	
	@ModelAttribute(value="types")
	public List<String> getTypes() {
		List<String> types = new LinkedList<String>();
		types.add("Single Year");
		types.add("Multi-Year");
		return types;
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors) {
		if (errors.hasErrors()) {
			System.out.println("Thid project did NOT validate.");
			return "project_add";
		}
		else {
			System.out.println("Thid project validated.");
		}
		
		System.out.println("Invoking saveProject");
		System.out.println(project.getName());
		System.out.println(project.toString());
//		System.out.println(session.getAttribute("token"));
		return "project_add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi", "special"})
	public String processMultiProject() {
		System.out.println("Invoking processMultiProject");
		return "project_add";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}
}
