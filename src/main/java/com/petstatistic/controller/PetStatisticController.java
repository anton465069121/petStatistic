package com.petstatistic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petstatistic.service.OverViewService;

@RequestMapping("/statistic")
@Controller
public class PetStatisticController {
	@Autowired
	OverViewService overViewService;
	
    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        return "petstatistic/index";
    }
    
    @RequestMapping("/overview")
    public String overview(HttpServletRequest request, HttpServletResponse response) {
    	request.getSession().setAttribute("overviews", overViewService.getViews());
        return "petstatistic/overview";
    }
    
}