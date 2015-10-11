package com.hulk.service;

import com.hulk.data.model.CallInfo;
import com.hulk.data.model.CallStatusChange;
import com.hulk.enums.CallStatus;

import java.util.List;

/**
 * Created by vijayvar on 10/11/15.
 */
public interface CallInfoService {

    Long createOrUpdateCall(CallInfo callInfo);

    void assignCallToAgent(Long callInfoId, Long agentId);

    void changeCallStatus(CallStatusChange callStatusChange);

    CallStatus getCurrentCallStatus(Long callInfoId);

    List<CallStatusChange> getAllCallStatusChanges(Long callInfoId);
}
