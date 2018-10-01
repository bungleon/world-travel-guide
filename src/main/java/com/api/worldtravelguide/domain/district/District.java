package com.api.worldtravelguide.domain.district;


import com.api.worldtravelguide.domain.BaseEntity;
import com.api.worldtravelguide.domain.town.Town;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "district")
public class District extends BaseEntity {
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
    @JoinColumn(name = "town_id")
    private Town town;
}
