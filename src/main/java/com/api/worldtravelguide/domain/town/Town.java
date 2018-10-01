package com.api.worldtravelguide.domain.town;

import com.api.worldtravelguide.domain.BaseEntity;
import com.api.worldtravelguide.domain.province.Province;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "town")
public class Town extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "code")
    private String code;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}
