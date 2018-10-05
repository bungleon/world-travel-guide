package com.api.worldtravelguide.controller.neighborhood;

import com.api.worldtravelguide.handler.neighborhood.NeighborhoodDetailHandler;
import com.api.worldtravelguide.handler.neighborhood.NeighborhoodListHandler;
import com.api.worldtravelguide.handler.neighborhood.NeighborhoodUpdateHandler;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodDetailRequest;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodListRequest;
import com.api.worldtravelguide.message.request.neighborhood.NeighborhoodUpdateRequest;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodDetailResponse;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodListResponse;
import com.api.worldtravelguide.message.response.neighborhood.NeighborhoodUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/neighborhood")
public class NeighborhoodController {
    private final NeighborhoodListHandler neighborhoodListHandler;
    private final NeighborhoodDetailHandler neighborhoodDetailHandler;
    private final NeighborhoodUpdateHandler neighborhoodUpdateHandler;

    public NeighborhoodController(NeighborhoodListHandler neighborhoodListHandler, NeighborhoodDetailHandler neighborhoodDetailHandler, NeighborhoodUpdateHandler neighborhoodUpdateHandler) {
        this.neighborhoodListHandler = neighborhoodListHandler;
        this.neighborhoodDetailHandler = neighborhoodDetailHandler;
        this.neighborhoodUpdateHandler = neighborhoodUpdateHandler;
    }

    @PostMapping("/list")
    public NeighborhoodListResponse getNeighborhoodList(@Valid @RequestBody NeighborhoodListRequest request) {
        return neighborhoodListHandler.execute(request);
    }

    @PostMapping("/detail")
    public NeighborhoodDetailResponse getNeighborhoodDetail(@Valid @RequestBody NeighborhoodDetailRequest request) {
        return neighborhoodDetailHandler.execute(request);
    }

    @PostMapping("/update")
    public NeighborhoodUpdateResponse updateNeighborhood(@Valid @RequestBody NeighborhoodUpdateRequest request) {
        return neighborhoodUpdateHandler.execute(request);
    }
}
