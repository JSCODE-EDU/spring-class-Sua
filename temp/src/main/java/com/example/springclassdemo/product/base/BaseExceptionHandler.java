package com.example.springclassdemo.product.base;

import com.example.springclassdemo.product.base.exception.ProductNoneExsistsException;
import com.example.springclassdemo.product.base.exception.SameProductNameExsistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler({ProductNoneExsistsException.class})
    private ResponseEntity handleProductNoneExsistsException(ProductNoneExsistsException e) {
        return new ResponseEntity(BaseResponse.response(StatusCode.BAD_REQUEST, ResponseMessage.NOT_FOUND_PRODUCT), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SameProductNameExsistsException.class})
    private ResponseEntity handleSameProductNameExsistsException(SameProductNameExsistsException e) {
        return new ResponseEntity(BaseResponse.response(StatusCode.BAD_REQUEST, ResponseMessage.REGISTER_PRODUCT_FAIL), HttpStatus.BAD_REQUEST);
    }
}
