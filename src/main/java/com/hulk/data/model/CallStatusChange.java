package com.hulk.data.model;

import com.hulk.enums.CallStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by vijayvar on 10/10/15.
 */
@Entity
@Getter
@Setter
public class CallStatusChange extends BaseHibernateEntity {

    @Column(insertable = false, updatable = false)
    private LocalDateTime creationTime;

    @Column
    @Enumerated(value = EnumType.STRING)
    private CallStatus newStatus;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "changedByAgentId")
    private Agent changedByAgent;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "callInfoId")
    private CallInfo callInfo;
}
