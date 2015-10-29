package com.hulk.service;

import com.hulk.data.model.CallInfo;
import com.hulk.data.model.CallStatusChange;

import java.util.List;

/**
 * Created by vijayvar on 10/11/15.
 */
public interface CallInfoService {

    Long createCall(CallInfo callInfo);

    void assignCallToAgent(Long callInfoId, Long agentId);

    void changeCallStatus(CallStatusChange callStatusChange);

    List<CallStatusChange> getAllCallStatusChanges(Long callInfoId);

    List<CallInfo> getAllCallsForOwnerOrAssignedEntity(Long entityId);

    CallInfo getCallForEntity(Long callInfoId, Long entityId);
}
