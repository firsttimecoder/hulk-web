package com.hulk.data.pojo;

import com.hulk.enums.IndianCity;
import com.hulk.enums.IndianState;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by vijayvar on 10/19/15.
 */
@Data
public class AddressDTO {

    private Long id;

    @NotNull
    private String firstLine;

    private String secondLine;

    @NotNull
    private IndianCity city;

    @NotNull
    private IndianState state;

    @NotNull
    @Length(min = 6, max = 6)
    private String pincode;

    private String phoneNumber;
}
