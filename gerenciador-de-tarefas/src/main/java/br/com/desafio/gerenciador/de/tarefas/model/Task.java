package br.com.desafio.gerenciador.de.tarefas.model;

import br.com.desafio.gerenciador.de.tarefas.dto.TaskDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String descrption;
    private LocalDateTime dateCreated;
    private String status;
    private LocalDate dueDate;

    public Task(String title, String descrption, LocalDateTime dateCreated,
                String status, LocalDate dueDate) {
        this.title = title;
        this.descrption = descrption;
        this.dateCreated = dateCreated;
        this.status = status;
        this.dueDate = dueDate;
    }
}
