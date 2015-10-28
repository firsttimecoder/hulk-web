package com.hulk.data.pojo;

import com.hulk.data.model.Address;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by vijayvar on 10/20/15.
 */
@Data
public class CreateCallInfoDTO {

    private Long assignedAgentId;

    @NotBlank
    private String customerName;

    @NotNull
    @Valid
    private Address address;

    @NotBlank
    private String productName;

    @NotBlank
    private String productDefect;

    private Integer priority;
}
