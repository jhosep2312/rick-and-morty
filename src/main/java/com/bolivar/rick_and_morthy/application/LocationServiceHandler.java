package com.bolivar.rick_and_morthy.application;

import com.bolivar.rick_and_morthy.application.port.in.LocationService;
import com.bolivar.rick_and_morthy.application.port.out.LocationRepository;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.provider.RickAndMortyProvider;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.ResponseEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.bolivar.rick_and_morthy.infraestructure.provider.mapper.RequestProviderMapper.toDomain;
import static com.bolivar.rick_and_morthy.infraestructure.utils.Constants.*;
import static com.bolivar.rick_and_morthy.infraestructure.utils.Constants.RESOURCE_SAVED;
import static com.bolivar.rick_and_morthy.infraestructure.utils.FunctionUtils.updateEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceHandler implements LocationService {

    private final LocationRepository locationRepository;
    private final RickAndMortyProvider rickAndMortyProvider;

    @Override
    public PageResponse<Location> getAllLocation(int page, int size) {
        log.debug("getAllLocation({},{})", page, size);
        return locationRepository.findAllPaginated(page, size);
    }

    @Override
    public ResponseEvent<Location> getSingleLocation(Long id) {
        log.debug("getSingleLocation({}})", id);
        return locationRepository.findById(id)
                .map(loc -> new ResponseEvent<Location>().ok(SUCCESS, loc))
                .orElseGet(() -> new ResponseEvent<Location>().errorNotFound(RESOURCE_NOT_FOUND));
    }

    @Override
    public ResponseEvent<Location> create(Location location) {

        return locationRepository.findById(location.getId())
                .map(c -> new ResponseEvent<Location>().error(RESOURCE_EXIST))
                .orElseGet(() -> {
                    var foundLocation = toDomain(rickAndMortyProvider.retrieveSingleLocation(location.getId()));
                    Location savedLocation = locationRepository.save(foundLocation);
                    return new ResponseEvent<Location>().created(RESOURCE_SAVED, savedLocation);
                });
    }

    @Override
    public ResponseEvent<Location> update(Long id, Location location) {
        return locationRepository.findById(id).map(foundLocation -> {
            updateEntity(foundLocation, location);
            locationRepository.save(foundLocation);
            return new ResponseEvent<Location>().ok(RESOURCE_UPDATED, foundLocation);
        }).orElseGet(() -> new ResponseEvent<Location>().errorNotFound(RESOURCE_NOT_FOUND));
    }

    @Override
    @Transactional
    public ResponseEvent<Location> deleteById(Long id) {
        return locationRepository.findById(id).map(foundLocation -> {
            locationRepository.deleteById(id);
            return new ResponseEvent<Location>().ok(RESOURCE_DELETED, foundLocation);
        }).orElseGet(() -> new ResponseEvent<Location>().errorNotFound(RESOURCE_NOT_FOUND));
    }
}
