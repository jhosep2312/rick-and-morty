package com.bolivar.rick_and_morthy.infraestructure.rest;


import com.bolivar.rick_and_morthy.application.port.in.CharacterService;
import com.bolivar.rick_and_morthy.domain.Character;
import com.bolivar.rick_and_morthy.domain.PageResponse;
import com.bolivar.rick_and_morthy.infraestructure.rest.dto.CharacterRequestDto;
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
@RequestMapping("/api/v1/character")
@RequiredArgsConstructor
@Validated
@Tag(name = "Characters", description = "Characters management APIs")
public class CharactersController extends APIController {


    private final CharacterService characterService;


    @GetMapping
    @Operation(summary = "Get all characters to Bolivar")
    public PageResponse<Character> getAllCharacters(
            @RequestParam(required = false, value = "page", defaultValue = "0") int page,
            @RequestParam(required = false, value = "size", defaultValue = "10") int size) {
        log.info("[getAllCharacters()] ");
        final var response = characterService.getAllCharacter(page,size);
        log.info("[getAllCharacters(): {} ] ", response);
        return response;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a single character to Bolivar")
    public ResponseEntity<ResponseEvent<Character>> getCharacterById(@PathVariable Long id) {
        log.info("[getCharacterById()] ");
        final ResponseEvent<Character> response = characterService.getSingleCharacter(id);
        log.info("[getCharacterById(): {} ] ", response);
        return buildHttpResponse(response, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a single character to Bolivar")
    public ResponseEntity<ResponseEvent<Character>> createCharacter(@RequestBody @Validated CharacterRequestDto requestDto) {
        log.info("[createCharacter({})]", requestDto);
        final ResponseEvent<Character> response = characterService.create(toDomain(requestDto) );
        log.info("[createCharacter({}): {} ] ",requestDto, response);
        return buildHttpResponse(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update a single character to Bolivar")
    public ResponseEntity<ResponseEvent<Character>> updateCharacter(
            @PathVariable Long id,
            @RequestBody @Validated(OnUpdate.class) CharacterRequestDto requestDto) {
        log.info("[updateCharacter({})]", requestDto);
        final ResponseEvent<Character> response = characterService.update(id, toDomain(requestDto) );
        log.info("[updateCharacter({}): {} ] ",requestDto, response);
        return buildHttpResponse(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a single character to Bolivar")
    public ResponseEntity<ResponseEvent<Character>> deleteCharacter(@PathVariable Long id) {
        log.info("[deleteCharacter({})]", id);
        final ResponseEvent<Character> response = characterService.deleteById(id);
        log.info("[deleteCharacter({}): {} ] ",id, response);
        return buildHttpResponse(response,HttpStatus.OK);
    }


}
