package tn.iteam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import tn.iteam.dtos.ErrorResponseDTO; // Assure-toi que cet import est présent

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAcountExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleCompteAlreadyExistsException(UserAcountExistException exception,
                                                                               WebRequest webRequest) {
        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(tn.iteam.exception.ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFound(tn.iteam.exception.ResourceNotFoundException exception,
                                                                   WebRequest webRequest) {
        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
