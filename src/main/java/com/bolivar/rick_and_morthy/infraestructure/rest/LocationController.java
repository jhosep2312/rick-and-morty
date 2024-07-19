package com.bolivar.rick_and_morthy.infraestructure.rest;

import com.bolivar.rick_and_morthy.application.port.in.LocationService;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.LocationRequestDto;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.ResponseEvent;
import com.bolivar.rick_and_morthy.infraestructure.rest.validations.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.bolivar.rick_and_morthy.infraestructure.rest.mapper.RequestMapper.toDomain;

/**
 * @author <a href="mailto:jarrietab23@gmail.com">Jose Arrieta</a>
 * @version 0.0.1-SNAPSHOT 2024/07/17
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
@Validated
@Tag(name = "Location", description = "Location management APIs")
public class LocationController extends APIController{

    private final LocationService locationService;

    @GetMapping
    @Operation(summary = "Get all locations to Bolivar")
    public PageResponse<Location> getAllLocations(
            @RequestParam(required = false, value = "page", defaultValue = "0") int page,
            @RequestParam(required = false, value = "size", defaultValue = "10") int size) {
        log.info("[getAllLocations()] ");
        final var response = locationService.getAllLocation(page,size);
        log.info("[getAllLocations(): {} ] ", response);
        return response;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a single location to Bolivar")
    public ResponseEntity<ResponseEvent<Location>> getLocationById(@PathVariable Long id) {
        log.info("[getLocationById()] ");
        final ResponseEvent<Location> response = locationService.getSingleLocation(id);
        log.info("[getLocationById(): {} ] ", response);
        return buildHttpResponse(response, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a single location to Bolivar")
    public ResponseEntity<ResponseEvent<Location>> createLocation(@RequestBody @Validated LocationRequestDto requestDto) {
        log.info("[createLocation({})]", requestDto);
        final ResponseEvent<Location> response = locationService.create(toDomain(requestDto) );
        log.info("[createLocation({}): {} ] ",requestDto, response);
        return buildHttpResponse(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update a single location to Bolivar")
    public ResponseEntity<ResponseEvent<Location>> updateLocation(
            @PathVariable Long id,
            @RequestBody @Validated(OnUpdate.class) LocationRequestDto requestDto) {
        log.info("[updateLocation({})]", requestDto);
        final ResponseEvent<Location> response = locationService.update(id, toDomain(requestDto) );
        log.info("[updateLocation({}): {} ] ",requestDto, response);
        return buildHttpResponse(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a single location to Bolivar")
    public ResponseEntity<ResponseEvent<Location>> deleteLocation(@PathVariable Long id) {
        log.info("[deleteLocation({})]", id);
        final ResponseEvent<Location> response = locationService.deleteById(id);
        log.info("[deleteLocation({}): {} ] ",id, response);
        return buildHttpResponse(response,HttpStatus.OK);
    }

}
