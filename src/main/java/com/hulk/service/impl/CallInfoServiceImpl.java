package com.hulk.service.impl;

import com.hulk.data.model.CallInfo;
import com.hulk.data.model.CallStatusChange;
import com.hulk.data.repository.CallInfoRepository;
import com.hulk.data.repository.CallStatusChangeRepository;
import com.hulk.enums.CallStatus;
import com.hulk.service.CallInfoService;
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
    public Long createOrUpdateCall(CallInfo callInfo) {
        if (callInfo.getCurrentStatus() == null) {
            callInfo.setCurrentStatus(CallStatus.CREATED);
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
    public CallStatus getCurrentCallStatus(Long callInfoId) {
        return callInfoRepository.getOne(callInfoId).getCurrentStatus();
    }

    @Override
    public List<CallStatusChange> getAllCallStatusChanges(Long callInfoId) {
        return callStatusChangeRepository.findByCallInfoId(callInfoId,
                new Sort(Sort.Direction.DESC, "creationTime"));
    }
}
