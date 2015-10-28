package com.hulk.data.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.hulk.data.model.Address;
import com.hulk.enums.AgentRole;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * Created by vijayvar on 10/14/15.
 */
@Data
public class CreateAgentDTO {

    @Email
    private String email;

    @NotNull
    @Length(min = 6, max = 15)
    @Pattern(regexp = "[\\w]+")     // allowed characters: alphabets, digits and underscores.
    private String loginId;

    @NotNull
    @Length(min = 6)
    private String plainTextPassword;

    @NotNull
    private String confirmPlainTextPassword;

    @NotNull
    private AgentRole role;

    @NotNull
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateOfBirth;

    @NotNull
    @Length(min = 3)
    private String firstName;

    private String lastName;

    @NotNull
    @Valid
    private Address address;
}
