package com.hulk.service.impl;

import com.hulk.data.model.Agent;
import com.hulk.data.pojo.CurrentUser;
import com.hulk.data.repository.AgentRepository;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vijayvar on 10/17/15.
 */
@Service
@Transactional
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isNotBlank(username)) {
            Agent agent = agentRepository.findByLoginId(username);
            if (agent != null) {
                Hibernate.initialize(agent.getEntities());
                return new CurrentUser(agent);
            }
        }

        throw new UsernameNotFoundException("Username: " + username + " not found!");
    }
}
