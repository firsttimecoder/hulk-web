package com.hulk.data.model;

import com.google.common.collect.Sets;
import com.hulk.enums.EntityType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by vijayvar on 10/10/15.
 */
@javax.persistence.Entity
@Getter
@Setter
public class Entity extends BaseHibernateEntity {

    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EntityAgentMapping",
            joinColumns = {@JoinColumn(name = "entityId")},
            inverseJoinColumns = {@JoinColumn(name = "agentId")})
    private Set<Agent> agents = Sets.newHashSet();
}
