package com.api.worldtravelguide.message.custom;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CountrySearch {
    String name;
    ProvinceSearch province;
}
