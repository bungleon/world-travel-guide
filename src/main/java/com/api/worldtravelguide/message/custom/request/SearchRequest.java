package com.api.worldtravelguide.message.custom.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SearchRequest {
    Integer pageNumber;
    Object equals;
    Object equalsNull;
    List<BetweenRequest> between;
    List<AfterRequest> after;
    List<OrderByRequest> orderBy;
    List<BeforeRequest> before;
    List<GreaterThanRequest> greaterThan;
    List<LessThanRequest> lessThan;
}
