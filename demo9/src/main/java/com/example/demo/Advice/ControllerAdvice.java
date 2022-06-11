package com.example.demo.Advice;

import com.example.demo.Exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgument(MethodArgumentNotValidException methodArgumentNVE) {
        logger.warn("MethodArgumentNotValidException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(methodArgumentNVE.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrity(DataIntegrityViolationException dataIntegrityVE) {
        logger.warn("DataIntegrityViolationException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((dataIntegrityVE.getCause().getMessage()));
    }

    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity handleDataIntegrity(InvalidException invalidException) {
        logger.warn("InvalidException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidException.getCause().getMessage());
    }

    @ExceptionHandler(value = CompanyNotFoundException.class)
    public ResponseEntity handleDataIntegrity(CompanyNotFoundException companyNotFoundException) {
        logger.warn("BookNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(companyNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = InvoiceNotFoundException.class)
    public ResponseEntity handleDataIntegrity(InvoiceNotFoundException invoiceNotFoundException) {
        logger.warn("InvoceNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invoiceNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = ServiceEvaluationNotFoundException.class)
    public ResponseEntity handleDataIntegrity(ServiceEvaluationNotFoundException serviceEvaluationNotFoundException) {
        logger.warn("ProductNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceEvaluationNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity handleDataIntegrity(ProductNotFoundException productNotFoundException) {
        logger.warn("ProductNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = TroublesNotFoundException.class)
    public ResponseEntity handleDataIntegrity(TroublesNotFoundException troublesNotFoundException) {
        logger.warn("ProductNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(troublesNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity handleDataIntegrity(UserNotFoundException userNotFoundException) {
        logger.warn("ProductNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception) {
        logger.error("Exception");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getCause().getMessage());


    }
}
