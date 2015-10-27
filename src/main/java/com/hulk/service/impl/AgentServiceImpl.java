package com.hulk.service.impl;

import com.hulk.data.model.Agent;
import com.hulk.data.model.CallInfo;
import com.hulk.data.pojo.CreateAgentDTO;
import com.hulk.data.repository.AgentRepository;
import com.hulk.data.repository.CallInfoRepository;
import com.hulk.enums.AgentRole;
import com.hulk.enums.CallStatus;
import com.hulk.service.AgentService;
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
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private CallInfoRepository callInfoRepository;

    @Override
    public Agent createAgent(CreateAgentDTO createAgentDTO) {
        Agent agent = Agent.from(createAgentDTO);

        Agent savedAgent = agentRepository.save(agent);
        savedAgent.setHashedPassword("");

        return savedAgent;
    }

    @Override
    public Agent get(Long agentId) {
        return agentRepository.getOne(agentId);
    }

    @Override
    public List<CallInfo> getAllAssignedCalls(Long agentId) {
        return callInfoRepository
                .findByAssignedAgentIdAndLastStatusChangeNullOrLastStatusChangeNewStatusNot(
                        agentId, CallStatus.COMPLETE);
    }

    @Override
    public List<Agent> getAllTechniciansForEntity(Long entityId) {
        // TODO: use entityId.

        return agentRepository.findByRole(AgentRole.TECHNICIAN,
                new Sort(Sort.Direction.ASC, "firstName", "lastName"));
    }
}
