package com.hulk.data.model;

import com.google.common.collect.Sets;
import com.hulk.enums.EntityType;
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
public class Entity extends BaseHibernateEntity {

    @Column(insertable = false, updatable = false)
    private LocalDateTime creationTime;

    @Column(nullable = false)
    private String name;

    @Column
    private String displayName;

    @Column
    @Enumerated(value = EnumType.STRING)
    private EntityType type;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    @ManyToMany
    @JoinTable(name = "EntityAgentMapping",
            joinColumns = {@JoinColumn(name = "entityId")},
            inverseJoinColumns = {@JoinColumn(name = "agentId")})
    private Set<Agent> agents = Sets.newHashSet();
}
