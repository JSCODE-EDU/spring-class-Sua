package com.example.springclassdemo.product.base;

import com.example.springclassdemo.product.base.exception.ProductNoneExsistsException;
import com.example.springclassdemo.product.base.exception.SameProductNameExsistsException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
@AllArgsConstructor
@Builder
public class BaseResponse<T> {
    private int statusCode;
    private String responseMessage;
    private T data;

    public BaseResponse(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static<T> BaseResponse<T> response(final int statusCode, final String responseMessage) {
        return response(statusCode, responseMessage, null);
    }

    public static<T> BaseResponse<T> response(final int statusCode, final String responseMessage, final T t) {
        return BaseResponse.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }


}
