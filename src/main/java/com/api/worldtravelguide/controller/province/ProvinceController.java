package com.api.worldtravelguide.controller.province;

import com.api.worldtravelguide.handler.province.ProvinceDetailHandler;
import com.api.worldtravelguide.handler.province.ProvinceListHandler;
import com.api.worldtravelguide.handler.province.ProvinceUpdateHandler;
import com.api.worldtravelguide.message.request.province.ProvinceDetailRequest;
import com.api.worldtravelguide.message.request.province.ProvinceListRequest;
import com.api.worldtravelguide.message.request.province.ProvinceUpdateRequest;
import com.api.worldtravelguide.message.response.province.ProvinceDetailResponse;
import com.api.worldtravelguide.message.response.province.ProvinceListResponse;
import com.api.worldtravelguide.message.response.province.ProvinceUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/province")
public class ProvinceController {
    private final ProvinceListHandler provinceListHandler;
    private final ProvinceDetailHandler provinceDetailHandler;
    private final ProvinceUpdateHandler provinceUpdateHandler;

    public ProvinceController(ProvinceListHandler provinceListHandler,
                              ProvinceDetailHandler provinceDetailHandler,
                              ProvinceUpdateHandler provinceUpdateHandler) {
        this.provinceListHandler = provinceListHandler;
        this.provinceDetailHandler = provinceDetailHandler;
        this.provinceUpdateHandler = provinceUpdateHandler;
    }

    @PostMapping("/list")
    public ProvinceListResponse getProvinceList(@Valid @RequestBody ProvinceListRequest request) {
        return provinceListHandler.execute(request);
    }

    @PostMapping("/detail")
    public ProvinceDetailResponse getProvinceDetail(@Valid @RequestBody ProvinceDetailRequest request) {
        return provinceDetailHandler.execute(request);
    }

    @PostMapping("/update")
    public ProvinceUpdateResponse updateProvince(@Valid @RequestBody ProvinceUpdateRequest request) {
        return provinceUpdateHandler.execute(request);
    }
}
