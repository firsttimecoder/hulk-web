package com.hulk.data.pojo;

import com.hulk.enums.IndianCity;
import com.hulk.enums.IndianState;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by vijayvar on 10/19/15.
 */
@Data
public class AddressDTO {

    private Long id;

    @NotBlank
    private String firstLine;

    private String secondLine;

    private String landmark;

    @NotNull
    private IndianCity city;

    @NotNull
    private IndianState state;

    @NotNull
    @Length(min = 6, max = 6)
    private String pincode;

    private String phoneNumber;
}
