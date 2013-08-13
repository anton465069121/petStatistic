package com.petstatistic.controller;

import com.petstatistic.domain.UsageState;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usagestates")
@Controller
@RooWebScaffold(path = "usagestates", formBackingObject = UsageState.class)
public class UsageStateController {
}
