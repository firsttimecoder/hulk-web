package com.hulk.data.model;

import com.google.common.collect.Sets;
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
public class CallInfo extends BaseHibernateEntity {

    @Column(insertable = false, updatable = false)
    private LocalDateTime creationTime;

    @Column(nullable = false)
    private String customerName;

    @Column(insertable = false, updatable = false)
    private LocalDateTime lastUpdatedTime;

    @OneToOne(optional = false)
    @JoinColumn(name = "assignedEntityId")
    private Entity assignedEntity;

    @OneToOne(optional = false)
    @JoinColumn(name = "ownerEntityId")
    private Entity ownerEntity;

    @OneToOne
    @JoinColumn(name = "assignedAgentId")
    private Agent assignedAgent;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lastStatusChangeId")
    private CallStatusChange lastStatusChange;

    @Column
    private Integer priority;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address address;

    @OneToMany(mappedBy = "callInfo")
    private Set<CallStatusChange> callStatusChanges = Sets.newHashSet();
}
