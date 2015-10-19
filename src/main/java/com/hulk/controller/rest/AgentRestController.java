package com.hulk.controller.rest;

import com.hulk.data.pojo.CreateAgentDTO;
import com.hulk.data.model.Agent;
import com.hulk.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vijayvar on 10/14/15.
 */
@RestController
@RequestMapping("/agents")
public class AgentRestController {

    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Agent createAgent(@RequestBody CreateAgentDTO createAgentDTO) {
        Agent agent = agentService.createOrUpdateAgent(createAgentDTO);
        return agent;
    }
}
