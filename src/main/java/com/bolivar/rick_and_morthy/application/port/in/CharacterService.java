package com.bolivar.rick_and_morthy.application.port.in;

import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.ResponseEvent;


public interface CharacterService {

    PageResponse<Character> getAllCharacter(int page, int size);

    ResponseEvent<Character> getSingleCharacter(Long id);

    ResponseEvent<Character> create(Character character);

    ResponseEvent<Character> update(Long id, Character character);

    ResponseEvent<Character> deleteById(Long id);


}
