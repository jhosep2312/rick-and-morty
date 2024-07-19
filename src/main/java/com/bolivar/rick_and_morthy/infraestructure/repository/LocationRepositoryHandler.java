package com.bolivar.rick_and_morthy.infraestructure.repository;

import com.bolivar.rick_and_morthy.application.port.out.LocationRepository;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.domain.Location;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.repository.jpa.LocationEntityRepository;
import com.bolivar.rick_and_morthy.infraestructure.repository.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.bolivar.rick_and_morthy.infraestructure.repository.mapper.LocationMapper.toDomain;
import static com.bolivar.rick_and_morthy.infraestructure.repository.mapper.LocationMapper.toEntity;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LocationRepositoryHandler implements LocationRepository {
    
    private final LocationEntityRepository repository;
    
    @Override
    public Location save(Location location) {
        return toDomain(repository.save(toEntity(location)));
    }

    @Override
    public Location update(Location location) {
        return null;
    }

    @Override
    public Optional<Location> findById(Long id) {
        return repository.findById(id).map(LocationMapper::toDomain);
    }

    @Override
    public PageResponse<Location> findAllPaginated(int page, int size) {
        log.info("findAllPaginated page: {}, size: {}", page, size);
        return toDomain(repository.findAll(PageRequest.of(page, size)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
