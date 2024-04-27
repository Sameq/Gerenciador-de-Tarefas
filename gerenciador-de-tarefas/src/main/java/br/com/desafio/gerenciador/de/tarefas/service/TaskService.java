package br.com.desafio.gerenciador.de.tarefas.service;

import br.com.desafio.gerenciador.de.tarefas.dto.TaskDto;
import br.com.desafio.gerenciador.de.tarefas.infra.exception.CreatingTaskWithTheSameDate;
import br.com.desafio.gerenciador.de.tarefas.infra.exception.TaskNotFound;
import br.com.desafio.gerenciador.de.tarefas.model.Task;
import br.com.desafio.gerenciador.de.tarefas.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.annotations.NotFound;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository  taskRepository;
    public Task createTask(TaskDto taskDto){
        Task newTask =  Task.builder()
                .title(taskDto.getTitle())
                .descrption(taskDto.getDescrption())
                .dateCreated(LocalDateTime.now())
                .status("Pendente")
                .dueDate(taskDto.getDueDate())
                .build();

        if (checkDateIfTheyAreTheSame(newTask.getDateCreated(), newTask.getDueDate())){
            throw new CreatingTaskWithTheSameDate("Creation and delivery date are the same");
        }
        return this.taskRepository.save(newTask);
    }

    public Boolean checkDateIfTheyAreTheSame(LocalDateTime localDateTime, LocalDate dueDate){
        return localDateTime.toLocalDate().isEqual(dueDate);
    }

    public List<Task> findByStatus(String status){
        List<Task> taskList = this.taskRepository.findByStatus(status);
        if (taskList.isEmpty()){
            throw new TaskNotFound("Task not found");
        }
        return taskList;
    }

    public List<Task> findByDateCreated(LocalDateTime data){
        try {
            List<Task> taskList = this.taskRepository.findByDateCreated(data);
            return taskList;
        }catch (TaskNotFound e){
            throw new TaskNotFound("Task not found");
        }
    }

    public List<Task> findByDueDate(LocalDate data){
        List<Task> taskList = this.taskRepository.findByDueDate(data);
        if (taskList.isEmpty()){
            throw new TaskNotFound("Task not found");
        }
        return taskList;
    }

    public Task upDateTask(TaskDto taskDto, Long id){
        Optional<Task> taskOptional = this.taskRepository.findById(id);
        Task task = taskOptional.orElseThrow(() -> new TaskNotFound("Task not found"));
        task.setTitle(taskDto.getTitle());
        task.setDescrption(taskDto.getDescrption());
        task.setStatus(taskDto.getStatus());
        task.setDueDate(taskDto.getDueDate());
        this.taskRepository.save(task);
        return task;
    }

    public List<Task> getAllTask(){
        return this.taskRepository.findAll();
    }

    public Task deleteTask(Long id){
        Optional<Task> taskOptional = this.taskRepository.findById(id);
        Task task = taskOptional.orElseThrow(() -> new TaskNotFound("Task not found"));

        this.taskRepository.deleteById(id);
       return task;
    }
}
