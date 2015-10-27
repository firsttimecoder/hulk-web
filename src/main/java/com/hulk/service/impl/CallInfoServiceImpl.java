package com.hulk.service.impl;

import com.hulk.data.model.Agent;
import com.hulk.data.model.CallInfo;
import com.hulk.data.model.CallStatusChange;
import com.hulk.data.model.Entity;
import com.hulk.data.repository.CallInfoRepository;
import com.hulk.data.repository.CallStatusChangeRepository;
import com.hulk.service.CallInfoService;
import com.hulk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vijayvar on 10/11/15.
 */
@Service
@Transactional
public class CallInfoServiceImpl implements CallInfoService {

    @Autowired
    private CallInfoRepository callInfoRepository;

    @Autowired
    private CallStatusChangeRepository callStatusChangeRepository;

    @Override
    public Long createCall(CallInfo callInfo) {
        Agent currentAgent = Utils.getCurrentUser().getAgent();
        Entity currentEntity = currentAgent.getAnyEntity();

        if (callInfo.getAssignedEntity() == null) {
            callInfo.setAssignedEntity(currentEntity);
        }
        if (callInfo.getOwnerEntity() == null) {
            callInfo.setOwnerEntity(currentEntity);
        }

        CallInfo savedCallInfo = callInfoRepository.save(callInfo);
        return savedCallInfo.getId();
    }

    @Override
    public void assignCallToAgent(Long callInfoId, Long agentId) {
        callInfoRepository.setAssignedAgentIdForId(callInfoId, agentId);
    }

    @Override
    public void changeCallStatus(CallStatusChange callStatusChange) {
        CallStatusChange savedCallStatusChange = callStatusChangeRepository.save(callStatusChange);

        callInfoRepository.setCallStatusChangeIdForId(savedCallStatusChange.getCallInfo().getId(),
                savedCallStatusChange.getId());
    }

    @Override
    public List<CallStatusChange> getAllCallStatusChanges(Long callInfoId) {
        return callStatusChangeRepository.findByCallInfoId(callInfoId,
                new Sort(Sort.Direction.DESC, "creationTime"));
    }
}
