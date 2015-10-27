package com.hulk.data.pojo;

import com.hulk.data.model.*;
import com.hulk.data.model.Entity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by vijayvar on 10/28/15.
 */
@Data
public class CallInfoDTO {

    private Long id;

    private LocalDateTime creationTime;

    private LocalDateTime lastUpdatedTime;

    private AgentDTO assignedAgent;

    private CallStatusChange lastStatusChange;

    private String customerName;

    private Address address;

    private String productName;

    private String productDefect;

    public static CallInfoDTO from(CallInfo callInfo) {
        CallInfoDTO callInfoDTO = new CallInfoDTO();
        BeanUtils.copyProperties(callInfo, callInfoDTO);

        callInfoDTO.setAssignedAgent(AgentDTO.from(callInfo.getAssignedAgent()));

        return callInfoDTO;
    }
}
