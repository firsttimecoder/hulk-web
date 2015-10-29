package com.hulk.controller.rest;

import com.hulk.data.model.Agent;
import com.hulk.data.model.CallInfo;
import com.hulk.data.model.CallStatusChange;
import com.hulk.data.pojo.CallInfoDTO;
import com.hulk.data.pojo.CreateOrUpdateCallInfoDTO;
import com.hulk.enums.CallStatus;
import com.hulk.service.CallInfoService;
import com.hulk.util.Constants;
import com.hulk.util.Utils;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by vijayvar on 10/20/15.
 */
@RestController
@RequestMapping("/call")
public class CallInfoRestController {

    @Autowired
    private CallInfoService callInfoService;

    @RequestMapping(value = "/changeCallStatus", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void changeCallStatus(@RequestParam @NonNull Long callInfoId,
                                 @RequestParam @NonNull CallStatus newStatus) {
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

    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    public @ResponseBody CallInfoDTO getDetails(@RequestParam @NonNull Long callInfoId) {
        Agent currentAgent = Utils.getCurrentUser().getAgent();

        CallInfo callInfo = callInfoService.getCallForEntity(callInfoId, currentAgent.getAnyEntity().getId());
        return CallInfoDTO.from(callInfo);
    }

    @RequestMapping(value = "/createOrUpdateCall", method = RequestMethod.POST)
    public @ResponseBody String createOrUpdateCall(
            @RequestBody @Valid CreateOrUpdateCallInfoDTO createOrUpdateCallInfoDTO) {
        CallInfo callInfo = CallInfo.from(createOrUpdateCallInfoDTO);
        callInfoService.createCall(callInfo);

        return Constants.DEFAULT_SUCCESS_MSG;
    }
}
