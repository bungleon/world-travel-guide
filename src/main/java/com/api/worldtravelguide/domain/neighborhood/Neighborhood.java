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
    private String neighborhood;

    private String code;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "original_name")
    private String originalName;

    private String latitude;

    private String longitude;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}
