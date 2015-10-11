package com.hulk.service.impl;

import com.hulk.data.model.Agent;
import com.hulk.data.model.CallInfo;
import com.hulk.data.repository.AgentRepository;
import com.hulk.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vijayvar on 10/11/15.
 */
@Service
@Transactional
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public void createOrUpdateAgent(Agent agent) {
        agentRepository.save(agent);
    }

    @Override
    public Agent get(Long agentId) {
        return agentRepository.getOne(agentId);
    }

    @Override
    public List<CallInfo> getAllAssignedCalls(Long agentId) {
        return null;
    }
}
