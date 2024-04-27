package br.com.desafio.gerenciador.de.tarefas.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Setter
@Getter
public class TaskDto {
    private String title;
    private String descrption;
    private LocalDateTime dateCreated;
    private String status;
    private LocalDate dueDate;
}
