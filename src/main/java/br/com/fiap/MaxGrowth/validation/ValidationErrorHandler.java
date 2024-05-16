package br.com.fiap.MaxGrowth.validation;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ValidationErrorHandler {
    
    record ValidationError(String campo, String mensagem){
        public ValidationError(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    public List<ValidationError>handle (MethodArgumentNotValidException exception){
        return exception
                .getFieldErrors()
                .stream()
                .map(ValidationError::new)
                .toList();
    }
}
