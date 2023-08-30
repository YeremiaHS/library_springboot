package id.fazzbca.libraryjava.version.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;

@RestControllerAdvice
public class CustomExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> globalException(Exception e){
        return ResponseHandler.responseError(500, e.getMessage(), null);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgEx(IllegalArgumentException e) {
        return ResponseHandler.responseError(404, e.getMessage(), null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgNotValidEx(MethodArgumentNotValidException e){
        Map<String, Object> errorMap = new HashMap<>();

        e.getFieldErrors().forEach(err-> {
            errorMap.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseHandler.responseError(e.getStatusCode().value(), "error validation", errorMap);
    }
}
