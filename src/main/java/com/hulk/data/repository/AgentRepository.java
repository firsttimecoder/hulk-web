package com.hulk.data.repository;

import com.hulk.data.model.Agent;
import com.hulk.enums.AgentRole;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vijayvar on 10/10/15.
 */
public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent findByLoginId(String loginId);

    List<Agent> findByRole(AgentRole agentRole, Sort sort);
}
