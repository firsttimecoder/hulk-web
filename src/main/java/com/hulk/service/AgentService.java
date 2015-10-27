package com.hulk.service;

import com.hulk.data.model.Agent;
import com.hulk.data.model.CallInfo;
import com.hulk.data.pojo.CreateAgentDTO;

import java.util.List;

/**
 * Created by vijayvar on 10/11/15.
 */
public interface AgentService {

    Agent createAgent(CreateAgentDTO createAgentDTO);

    Agent get(Long agentId);

    List<CallInfo> getAllAssignedCalls(Long agentId);

    List<Agent> getAllTechniciansForEntity(Long entityId);
}
