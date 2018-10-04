package com.api.worldtravelguide.domain.country;

import com.api.worldtravelguide.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "country", indexes = {
        @Index(name = "name_idx", columnList = "name"),
        @Index(name = "binary_code_idx", columnList = "binary_code"),
        @Index(name = "triple_code_idx", columnList = "triple_code"),
        @Index(name = "phone_code_idx", columnList = "phone_code")
}, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"binary_code"}),
        @UniqueConstraint(columnNames = {"triple_code"}),
        @UniqueConstraint(columnNames = {"phone_code"})
})
public class Country extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "binary_code")
    private String binaryCode;

    @Column(name = "triple_code")
    private String tripleCode;

    @Column(name = "phone_code")
    private String phoneCode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;
}
