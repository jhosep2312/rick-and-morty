package com.bolivar.rick_and_morthy.infraestructure.rest.dto;

import com.bolivar.rick_and_morthy.infraestructure.utils.ResponseCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseEvent<T> {

    private ResponseCode code;
    private String message;
    private T data;

    public ResponseEvent<T> ok(String message) {
        return ok(message, null);
    }

    public ResponseEvent<T> ok(String message, T data) {
        setCode(ResponseCode.OK);
        setMessage(message);
        setData(data);
        return this;
    }

    public ResponseEvent<T> created(String message, T data) {
        setCode(ResponseCode.CREATED);
        setMessage(message);
        setData(data);
        return this;
    }

    public ResponseEvent<T> error(String message) {
        setCode(ResponseCode.ERROR);
        setMessage(message);
        return this;
    }

    public ResponseEvent<T> errorNotFound(String message) {
        setCode(ResponseCode.NOT_FOUND);
        setMessage(message);
        return this;
    }

}
