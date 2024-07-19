package com.bolivar.rick_and_morthy.application.port.out;

import com.bolivar.rick_and_morthy.domain.PageResponse;

import java.util.Optional;

public interface GenericRepository<T> {

    T save(T t);

    T update(T t);

    Optional<T> findById(Long id);

    PageResponse<T> findAllPaginated(int page, int size);

    void deleteById(Long id);

}
