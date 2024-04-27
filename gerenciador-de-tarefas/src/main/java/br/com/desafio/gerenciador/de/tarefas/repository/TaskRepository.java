package br.com.desafio.gerenciador.de.tarefas.repository;

import br.com.desafio.gerenciador.de.tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDateCreated(LocalDateTime localDateTime);
    List<Task> findByStatus(String status);
    List<Task> findByDueDate(LocalDate dueDate);
    Optional<Task> findById(Long id);
}
