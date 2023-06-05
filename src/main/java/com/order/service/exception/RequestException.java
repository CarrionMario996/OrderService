package com.order.service.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

@Data
public class RequestException extends  RuntimeException{
    private HttpStatus status;

    public RequestException(String message, HttpStatus status) {
        super(message);
        this.status=status;

    }

}
