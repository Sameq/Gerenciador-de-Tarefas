package br.com.desafio.gerenciador.de.tarefas.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TaskNotFound.class)
    private ResponseEntity<String> taskNotFoundHandler(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }

    @ExceptionHandler(CreatingTaskWithTheSameDate.class)
    private ResponseEntity<String> CreatingTaskWithTheSameDate(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating task");
    }
}
