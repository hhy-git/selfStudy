package com.infiniteskills.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.infiniteskills.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		System.out.println("Invoking add");
		if (1 == 1) {
			throw new RuntimeException("There was an error");
		}
		return "resource_add";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleException(HttpServletRequest request) {
		return "controller_error";
	}

	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource) {
		System.out.println("Invoking review");
		return "resource_review";
	}
	
	@ModelAttribute(value="checkOptions")
	public List<String> getChecks() {
		List<String> checks = new LinkedList<>(Arrays.asList(new String[]{
				"Lead Time", "Special Rate", "Requires Approval"	
			}));
		System.out.println("binding checks");
		return checks;
	}
	
	@ModelAttribute("resource")
	public Resource getResource() {
		System.out.println("Adding a new resource to the model");
		return new Resource();
	}
	@ModelAttribute(value="typeOptions")
	public List<String> getTypeOptions() {
		return new LinkedList<>(Arrays.asList(new String[] {
				"Material", "Other", "Staff", "Technical Equipment" }));
	}
	
	@ModelAttribute(value="radioOptions")
	public List<String> getRadioOptions() {
		return new LinkedList<>(Arrays.asList(new String[]{
				"Hours", "Piece", "Tons"	
			}));
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource, SessionStatus sessionStatus) {
		System.out.println("Invoking save");
		System.out.println(resource);
		sessionStatus.setComplete();
		return "redirect:/resource/add";
	}
	
	@RequestMapping("/request")
	public @ResponseBody String request(@RequestBody String resource) {
		System.out.println(resource);
		return "The request has been sent for approval";
	}
}
