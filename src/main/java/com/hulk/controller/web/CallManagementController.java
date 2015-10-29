package com.hulk.controller.web;

import com.hulk.data.model.Agent;
import com.hulk.data.model.Entity;
import com.hulk.service.AgentService;
import com.hulk.service.CallInfoService;
import com.hulk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vijayvar on 10/26/15.
 */
@Controller
@RequestMapping(value = "/callManagement")
public class CallManagementController {

    @Autowired
    private CallInfoService callInfoService;

    @Autowired
    private AgentService agentService;

    @RequestMapping(method = RequestMethod.GET)
    public String doCallManagement(Model model) {
        Agent currentAgent = Utils.getCurrentUser().getAgent();
        Entity entityForAgent = currentAgent.getAnyEntity();

        model.addAttribute("technicians", agentService
                .getAllTechniciansForEntity(entityForAgent.getId()));
        model.addAttribute("callInfoList", callInfoService
                .getAllCallsForOwnerOrAssignedEntity(entityForAgent.getId()));

        return "callManagement";
    }
}
