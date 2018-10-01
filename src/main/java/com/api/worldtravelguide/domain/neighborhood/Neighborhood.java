package com.api.worldtravelguide.domain.neighborhood;

import com.api.worldtravelguide.domain.BaseEntity;
import com.api.worldtravelguide.domain.district.District;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "neighborhood")
public class Neighborhood extends BaseEntity {
    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "code")
    private String code;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}
