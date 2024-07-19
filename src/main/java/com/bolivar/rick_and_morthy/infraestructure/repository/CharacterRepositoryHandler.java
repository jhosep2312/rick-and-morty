package com.bolivar.rick_and_morthy.infraestructure.repository;

import com.bolivar.rick_and_morthy.application.port.out.CharacterRepository;
import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.repository.jpa.CharacterEntityRepository;
import com.bolivar.rick_and_morthy.infraestructure.repository.mapper.CharacterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.bolivar.rick_and_morthy.infraestructure.repository.mapper.CharacterMapper.toDomain;
import static com.bolivar.rick_and_morthy.infraestructure.repository.mapper.CharacterMapper.toEntity;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CharacterRepositoryHandler implements CharacterRepository {

    private final CharacterEntityRepository repository;

    @Override
    public Character save(Character character) {
        return toDomain(repository.save(toEntity(character)));
    }

    @Override
    public Character update(Character character) {
        return null;
    }

    @Override
    public Optional<Character> findById(Long id) {
        return repository.findById(id).map(CharacterMapper::toDomain);
    }

    @Override
    public PageResponse<Character> findAllPaginated(int page, int size) {
        log.info("findAllPaginated page: {}, size: {}", page, size);
        return toDomain(repository.findAll(PageRequest.of(page, size)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
