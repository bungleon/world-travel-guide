package com.api.worldtravelguide.controller.district;

import com.api.worldtravelguide.handler.district.DistrictDetailHandler;
import com.api.worldtravelguide.handler.district.DistrictListHandler;
import com.api.worldtravelguide.handler.district.DistrictUpdateHandler;
import com.api.worldtravelguide.message.request.district.DistrictDetailRequest;
import com.api.worldtravelguide.message.request.district.DistrictListRequest;
import com.api.worldtravelguide.message.request.district.DistrictUpdateRequest;
import com.api.worldtravelguide.message.response.district.DistrictDetailResponse;
import com.api.worldtravelguide.message.response.district.DistrictListResponse;
import com.api.worldtravelguide.message.response.district.DistrictUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/district")
public class DistrictController {
    private final DistrictListHandler districtListHandler;
    private final DistrictDetailHandler districtDetailHandler;
    private final DistrictUpdateHandler districtUpdateHandler;

    public DistrictController(DistrictListHandler districtListHandler, DistrictDetailHandler districtDetailHandler, DistrictUpdateHandler districtUpdateHandler) {
        this.districtListHandler = districtListHandler;
        this.districtDetailHandler = districtDetailHandler;
        this.districtUpdateHandler = districtUpdateHandler;
    }

    @PostMapping("/list")
    public DistrictListResponse getDistrictList(@Valid @RequestBody DistrictListRequest request) {
        return districtListHandler.execute(request);
    }

    @PostMapping("/detail")
    public DistrictDetailResponse getDistrictDetail(@Valid @RequestBody DistrictDetailRequest request) {
        return districtDetailHandler.execute(request);
    }

    @PostMapping("/update")
    public DistrictUpdateResponse updateDistrict(@Valid @RequestBody DistrictUpdateRequest request) {
        return districtUpdateHandler.execute(request);
    }
}
