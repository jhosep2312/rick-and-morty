package com.bolivar.rick_and_morthy.application.port.in;

import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.ResponseEvent;

public interface LocationService {

    PageResponse<Location> getAllLocation(int page, int size);

    ResponseEvent<Location> getSingleLocation(Long id);

    ResponseEvent<Location> create(Location location);

    ResponseEvent<Location> update(Long id, Location location);

    ResponseEvent<Location> deleteById(Long id);
}
