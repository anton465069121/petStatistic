package com.petstatistic.controller;

import com.petstatistic.domain.Admin;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admins")
@Controller
@RooWebScaffold(path = "admins", formBackingObject = Admin.class)
public class AdminController {
}
