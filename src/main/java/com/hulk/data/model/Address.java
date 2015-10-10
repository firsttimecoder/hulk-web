package com.hulk.data.model;

import com.hulk.enums.IndianCity;
import com.hulk.enums.IndianState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by vijayvar on 10/10/15.
 */
@Entity
@Getter
@Setter
public class Address extends BaseHibernateEntity {

    @Column(nullable = false)
    private String firstLine;

    @Column
    private String secondLine;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private IndianCity city;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private IndianState state;

    @Column(length = 6, nullable = false)
    private String pincode;

    @Column
    private String phoneNumber;
}
