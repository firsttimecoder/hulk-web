package com.hulk.service;

import com.hulk.data.pojo.CreateAgentDTO;
import com.hulk.data.model.Agent;
import com.hulk.data.model.CallInfo;

import java.util.List;

/**
 * Created by vijayvar on 10/11/15.
 */
public interface AgentService {

    Agent createOrUpdateAgent(CreateAgentDTO createAgentDTO);

    Agent get(Long agentId);

    List<CallInfo> getAllAssignedCalls(Long agentId);
}
