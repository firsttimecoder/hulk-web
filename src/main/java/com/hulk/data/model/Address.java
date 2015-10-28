package com.hulk.data.model;

import com.hulk.enums.IndianCity;
import com.hulk.enums.IndianState;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by vijayvar on 10/10/15.
 */
@Entity
@Getter
@Setter
public class Address extends BaseHibernateEntity {

    @NotNull
    @Column(nullable = false)
    private String firstLine;

    @Column
    private String secondLine;

    @Column
    private String landmark;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private IndianCity city;

    @NotNull
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private IndianState state;

    @NotNull
    @Length(min = 6, max = 6)
    @Column(length = 6, nullable = false)
    private String pincode;

    @Column
    private String phoneNumber;
}
