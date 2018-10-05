package com.api.worldtravelguide.controller.town;

import com.api.worldtravelguide.handler.town.TownDetailHandler;
import com.api.worldtravelguide.handler.town.TownListHandler;
import com.api.worldtravelguide.handler.town.TownUpdateHandler;
import com.api.worldtravelguide.message.request.town.TownDetailRequest;
import com.api.worldtravelguide.message.request.town.TownListRequest;
import com.api.worldtravelguide.message.request.town.TownUpdateRequest;
import com.api.worldtravelguide.message.response.town.TownDetailResponse;
import com.api.worldtravelguide.message.response.town.TownListResponse;
import com.api.worldtravelguide.message.response.town.TownUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/town")
public class TownController {
    private final TownDetailHandler townDetailHandler;
    private final TownListHandler townListHandler;
    private final TownUpdateHandler townUpdateHandler;

    public TownController(TownDetailHandler townDetailHandler,
                          TownListHandler townListHandler,
                          TownUpdateHandler townUpdateHandler) {
        this.townDetailHandler = townDetailHandler;
        this.townListHandler = townListHandler;
        this.townUpdateHandler = townUpdateHandler;
    }

    @PostMapping("/detail")
    public TownDetailResponse getTownDetail(@Valid @RequestBody TownDetailRequest request) {
        return townDetailHandler.execute(request);
    }

    @PostMapping("/list")
    public TownListResponse getTownList(@Valid @RequestBody TownListRequest request) {
        return townListHandler.execute(request);
    }

    @PostMapping("/update")
    public TownUpdateResponse updateTown(@Valid @RequestBody TownUpdateRequest request) {
        return townUpdateHandler.execute(request);
    }
}
