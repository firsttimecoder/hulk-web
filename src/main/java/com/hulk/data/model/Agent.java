package com.hulk.data.model;

import com.google.common.collect.Sets;
import com.hulk.enums.AgentRole;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EntityAgentMapping",
            joinColumns = {@JoinColumn(name = "agentId")},
            inverseJoinColumns = {@JoinColumn(name = "entityId")})
    private Set<Entity> entities = Sets.newHashSet();
}
