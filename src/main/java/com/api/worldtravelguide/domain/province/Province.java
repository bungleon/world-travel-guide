package com.api.worldtravelguide.domain.province;

import com.api.worldtravelguide.domain.BaseEntity;
import com.api.worldtravelguide.domain.country.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "province")
public class Province extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "phone_code")
    private String phoneCode;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
