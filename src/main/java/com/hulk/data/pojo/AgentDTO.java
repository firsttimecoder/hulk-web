package com.hulk.data.pojo;

import com.hulk.data.model.Address;
import com.hulk.data.model.Agent;
import com.hulk.enums.AgentRole;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * Created by vijayvar on 10/25/15.
 */
@Data
public class AgentDTO {

    private String email;

    private String loginId;

    private AgentRole role;

    private LocalDateTime dateOfBirth;

    private String firstName;

    private String lastName;

    private Address address;

    public static AgentDTO from(Agent agent) {
        AgentDTO agentDTO = new AgentDTO();
        BeanUtils.copyProperties(agent, agentDTO);

        return agentDTO;
    }
}
