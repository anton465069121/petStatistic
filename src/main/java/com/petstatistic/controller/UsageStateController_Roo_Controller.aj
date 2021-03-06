// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.controller;

import com.petstatistic.controller.UsageStateController;
import com.petstatistic.domain.UsageState;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect UsageStateController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String UsageStateController.create(@Valid UsageState usageState, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, usageState);
            return "usagestates/create";
        }
        uiModel.asMap().clear();
        usageState.persist();
        return "redirect:/usagestates/" + encodeUrlPathSegment(usageState.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String UsageStateController.createForm(Model uiModel) {
        populateEditForm(uiModel, new UsageState());
        return "usagestates/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String UsageStateController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("usagestate", UsageState.findUsageState(id));
        uiModel.addAttribute("itemId", id);
        return "usagestates/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String UsageStateController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("usagestates", UsageState.findUsageStateEntries(firstResult, sizeNo));
            float nrOfPages = (float) UsageState.countUsageStates() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("usagestates", UsageState.findAllUsageStates());
        }
        return "usagestates/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String UsageStateController.update(@Valid UsageState usageState, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, usageState);
            return "usagestates/update";
        }
        uiModel.asMap().clear();
        usageState.merge();
        return "redirect:/usagestates/" + encodeUrlPathSegment(usageState.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String UsageStateController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, UsageState.findUsageState(id));
        return "usagestates/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String UsageStateController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        UsageState usageState = UsageState.findUsageState(id);
        usageState.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/usagestates";
    }
    
    void UsageStateController.populateEditForm(Model uiModel, UsageState usageState) {
        uiModel.addAttribute("usageState", usageState);
    }
    
    String UsageStateController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
