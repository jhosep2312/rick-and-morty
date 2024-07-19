package com.bolivar.rick_and_morthy.infraestructure.provider;

import com.bolivar.rick_and_morthy.infraestructure.provider.dto.CharacterProviderResponseDto;
import com.bolivar.rick_and_morthy.infraestructure.provider.dto.LocationProviderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "RickAndMortyClient", url = "${provider.api.rick-and-morty.url}")
public interface RickAndMortyProvider {

    @GetMapping(value = "${provider.api.rick-and-morty.path}" + "/character/{id}")
    CharacterProviderResponseDto retrieveSingleCharacter(@PathVariable("id") Long id);

    @GetMapping(value = "${provider.api.rick-and-morty.path}" + "/location/{id}")
    LocationProviderResponseDto retrieveSingleLocation(@PathVariable("id") Long id);

}
