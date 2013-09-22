package com.petstatistic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petstatistic.service.OverViewService;
import com.petstatistic.service.PetStatisticService;
import com.petstatistic.vo.OverView;

@RequestMapping("/statistic")
@Controller
public class PetStatisticController {
	@Autowired
	OverViewService overViewService;
	@Autowired
	PetStatisticService petStatisticService;
	
    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    
    }

    @RequestMapping
    public String index() {
        return "petstatistic/index";
    }
    
    @RequestMapping("/overview")
    public String overview(HttpServletRequest request, HttpServletResponse response) {
    	List<OverView> overviews = overViewService.getViews();
    	request.getSession().setAttribute("overviews", overviews);
    	
        return "petstatistic/overview";
    }
    
}
