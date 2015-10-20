package com.hulk.controller.rest;

import com.hulk.data.model.Agent;
import com.hulk.data.model.CallInfo;
import com.hulk.data.model.CallStatusChange;
import com.hulk.enums.CallStatus;
import com.hulk.service.CallInfoService;
import com.hulk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vijayvar on 10/20/15.
 */
@RestController
@RequestMapping("/call")
public class CallInfoController {

    @Autowired
    private CallInfoService callInfoService;

    @RequestMapping(value = "/changeCallStatus", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void changeCallStatus(@RequestParam Long callInfoId, @RequestParam CallStatus newStatus) {
        CallInfo callInfo = new CallInfo();
        callInfo.setId(callInfoId);

        Agent agent = new Agent();
        agent.setId(Utils.getCurrentAgentId());

        CallStatusChange callStatusChange = new CallStatusChange();
        callStatusChange.setCallInfo(callInfo);
        callStatusChange.setChangedByAgent(agent);
        callStatusChange.setNewStatus(newStatus);

        callInfoService.changeCallStatus(callStatusChange);
    }
}