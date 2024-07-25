package com.example.testinterview.api;

import com.example.testinterview.exception.ReadCsvException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(ReadCsvException.class)
    public ResponseEntity<ApiResponse<Void>> handleReadCsvException(ReadCsvException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        ApiResponse<Void> response = ApiResponse.<Void>builder().apiError(apiError).build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ApiResponse<Void>> handleNumberFormatException(NumberFormatException ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid input: " + ex.getMessage() + ". Id is invalid",
                request.getDescription(false)
        );
        ApiResponse<Void> response = ApiResponse.<Void>builder().apiError(apiError).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
