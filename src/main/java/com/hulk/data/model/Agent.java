package com.hulk.data.model;

import com.google.common.collect.Sets;
import com.hulk.data.pojo.CreateAgentDTO;
import com.hulk.enums.AgentRole;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by vijayvar on 10/10/15.
 */
@javax.persistence.Entity
@Getter
@Setter
public class Agent extends BaseHibernateEntity {

    @Column(insertable = false, updatable = false)
    private LocalDateTime creationTime;

    @Column
    private String email;

    @Column(length = 15, nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String hashedPassword;

    @Column
    @Enumerated(value = EnumType.STRING)
    private AgentRole role;

    @Column(nullable = false)
    private LocalDateTime dateOfBirth;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(optional = false, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    @ManyToMany(mappedBy = "agents")
    private Set<Entity> entities = Sets.newHashSet();

    @Transient
    public Entity getAnyEntity() {
        return entities.stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    @Transient
    public String getDisplayName() {
        return StringUtils.join(firstName, " ", lastName);
    }

    @Transient
    public String getFullDisplayInfo() {
        return String.format("%s (%s | %s)", getDisplayName(), loginId, address.getPhoneNumber());
    }

    public static Agent from(CreateAgentDTO createAgentDTO) {
        if (!StringUtils.equals(createAgentDTO.getPlainTextPassword(),
                createAgentDTO.getConfirmPlainTextPassword())) {
            throw new IllegalArgumentException("Passwords don't match!");
        }

        Agent agent = new Agent();
        BeanUtils.copyProperties(createAgentDTO, agent);

        agent.setHashedPassword(new BCryptPasswordEncoder().encode(createAgentDTO.getPlainTextPassword()));

        return agent;
    }
}
