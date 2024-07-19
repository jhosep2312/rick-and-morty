package com.bolivar.rick_and_morthy.application;

import com.bolivar.rick_and_morthy.application.port.in.CharacterService;
import com.bolivar.rick_and_morthy.application.port.out.CharacterRepository;
import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.provider.RickAndMortyProvider;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.ResponseEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.bolivar.rick_and_morthy.infraestructure.provider.mapper.RequestProviderMapper.toDomain;
import static com.bolivar.rick_and_morthy.infraestructure.utils.Constants.*;
import static com.bolivar.rick_and_morthy.infraestructure.utils.FunctionUtils.updateEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterServiceHandler implements CharacterService {


    private final CharacterRepository characterRepository;
    private final RickAndMortyProvider rickAndMortyProvider;

    @Override
    public PageResponse<Character> getAllCharacter(int page, int size) {
        return characterRepository.findAllPaginated(page, size);
    }

    @Override
    public ResponseEvent<Character> getSingleCharacter(Long id) {

        return characterRepository.findById(id)
                .map(character -> new ResponseEvent<Character>().ok(SUCCESS, character))
                .orElseGet(() -> new ResponseEvent<Character>().errorNotFound(RESOURCE_NOT_FOUND));

    }

    @Override
    public ResponseEvent<Character> create(Character character) {

        return characterRepository.findById(character.getId())
                .map(c -> new ResponseEvent<Character>().error(RESOURCE_EXIST))
                .orElseGet(() -> {
                    var foundCharacter = toDomain(rickAndMortyProvider.retrieveSingleCharacter(character.getId()));
                    Character savedCharacter = characterRepository.save(foundCharacter);
                    return new ResponseEvent<Character>().created(RESOURCE_SAVED, savedCharacter);
                });
    }

    @Override
    public ResponseEvent<Character> update(Long id, Character character) {

        return characterRepository.findById(id).map(foundCharacter -> {
            updateEntity(foundCharacter, character);
            characterRepository.save(foundCharacter);
            return new ResponseEvent<Character>().ok(RESOURCE_UPDATED, foundCharacter);
        }).orElseGet(() -> new ResponseEvent<Character>().errorNotFound(RESOURCE_NOT_FOUND));

    }

    @Override
    @Transactional
    public ResponseEvent<Character> deleteById(Long id) {

        return characterRepository.findById(id).map(foundCharacter -> {
            characterRepository.deleteById(id);
            return new ResponseEvent<Character>().ok(RESOURCE_DELETED, foundCharacter);
        }).orElseGet(() -> new ResponseEvent<Character>().errorNotFound(RESOURCE_NOT_FOUND));
    }
}
