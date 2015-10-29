package com.hulk.data.model;

import com.google.common.collect.Sets;
import com.hulk.data.pojo.CreateOrUpdateCallInfoDTO;
import com.hulk.enums.CallStatus;
import com.hulk.util.Utils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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


    @Column(nullable = false)
    private String customerName;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address address;


    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productDefect;

    @Column
    private Integer priority;


    @OneToMany(mappedBy = "callInfo")
    private Set<CallStatusChange> callStatusChanges = Sets.newHashSet();

    @Transient
    public CallStatus getLatestCallStatus() {
        return (lastStatusChange == null) ? CallStatus.CREATED : lastStatusChange.getNewStatus();
    }

    public static CallInfo from(CreateOrUpdateCallInfoDTO createOrUpdateCallInfoDTO) {
        CallInfo callInfo = new CallInfo();
        BeanUtils.copyProperties(createOrUpdateCallInfoDTO, callInfo, "id");

        if (Utils.isValidLongId(createOrUpdateCallInfoDTO.getId())) {
            callInfo.setId(createOrUpdateCallInfoDTO.getId());
        }

        if (Utils.isValidLongId(createOrUpdateCallInfoDTO.getAssignedAgentId())) {
            Agent agent = new Agent();
            agent.setId(createOrUpdateCallInfoDTO.getAssignedAgentId());
            callInfo.setAssignedAgent(agent);
        }

        return callInfo;
    }
}
