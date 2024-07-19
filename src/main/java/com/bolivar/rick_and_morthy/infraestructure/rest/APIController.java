package com.bolivar.rick_and_morthy.infraestructure.rest;

import com.bolivar.rick_and_morthy.infraestructure.rest.dto.ResponseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class APIController {

    public static <T> ResponseEntity<ResponseEvent<T>> buildHttpResponse(ResponseEvent<T> responseEvent, HttpStatus status) {
        log.debug("method: buildHttpResponse({})", responseEvent);
        return new ResponseEntity<>(responseEvent, status);
    }

}
