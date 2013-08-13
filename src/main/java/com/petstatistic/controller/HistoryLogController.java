package com.petstatistic.controller;

import com.petstatistic.domain.HistoryLog;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/historylogs")
@Controller
@RooWebScaffold(path = "historylogs", formBackingObject = HistoryLog.class)
public class HistoryLogController {
}
