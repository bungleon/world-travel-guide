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
    private String name;
    private String code;

    @Column(name = "phone_code")
    private String phoneCode;

    @Column(name = "original_name")
    private String originalName;

    private String latitude;

    private String longitude;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
