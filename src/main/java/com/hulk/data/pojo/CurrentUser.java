package com.hulk.data.pojo;

import com.hulk.data.model.Agent;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by vijayvar on 10/17/15.
 */
public class CurrentUser extends User {

    @Getter
    private Agent agent;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CurrentUser(Agent agent) {
        super(agent.getLoginId(), agent.getHashedPassword(), AuthorityUtils.createAuthorityList(agent.getRole().name()));
        this.agent = agent;
    }
}
