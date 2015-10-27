package com.hulk.data.pojo;

import com.hulk.data.model.*;
import com.hulk.data.model.Entity;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by vijayvar on 10/20/15.
 */
@Data
public class CreateCallInfoDTO {

    private Long id;

    private LocalDateTime creationTime;

    private LocalDateTime lastUpdatedTime;

    private Entity assignedEntity;

    private Entity ownerEntity;

    private Agent assignedAgent;

    private CallStatusChange lastStatusChange;

    @NotBlank
    private String customerName;

    @NotNull
    private Address address;


    @NotBlank
    private String productName;

    @NotBlank
    private String productDefect;

    private Integer priority;

    public static CreateCallInfoDTO from(CallInfo callInfo) {
        CreateCallInfoDTO callInfoDTO = new CreateCallInfoDTO();
        BeanUtils.copyProperties(callInfo, callInfoDTO);

        return callInfoDTO;
    }
}
