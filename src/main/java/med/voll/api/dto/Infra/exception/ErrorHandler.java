package med.voll.api.dto.Infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.model.ExceptionValidation;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handler404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handler400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorHandler::new).toList());
    }

    @ExceptionHandler(ExceptionValidation.class)
    public ResponseEntity handlerErroRegraDeNegocio(ExceptionValidation ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    private record DataErrorHandler(String field, String message) {
        public DataErrorHandler(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
