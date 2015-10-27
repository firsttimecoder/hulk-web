package com.hulk.controller.rest;

import com.hulk.data.model.Agent;
import com.hulk.data.pojo.AgentDTO;
import com.hulk.data.pojo.CreateAgentDTO;
import com.hulk.service.AgentService;
import com.hulk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by vijayvar on 10/14/15.
 */
@RestController
@RequestMapping("/agent")
public class AgentRestController {

    @Autowired
    private AgentService agentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Agent createAgent(@RequestBody @Valid CreateAgentDTO createAgentDTO) {
        Agent agent = agentService.createAgent(createAgentDTO);
        return agent;
    }

/*
    @RequestMapping(value = "/getAssignedCalls", method = RequestMethod.GET)
    public @ResponseBody List<CreateCallInfoDTO> getAssignedCalls() {
        List<CallInfo> callInfoList = agentService.getAllAssignedCalls(Utils.getCurrentAgentId());

        return callInfoList.stream()
                .map(CreateCallInfoDTO::from)
                .collect(Collectors.toList());
    }
*/

    @RequestMapping(value = "/getMyDetails", method = RequestMethod.GET)
    public @ResponseBody AgentDTO getMyDetails() {
        Agent agent = Utils.getCurrentUser().getAgent();
        return AgentDTO.from(agent);
    }
}
