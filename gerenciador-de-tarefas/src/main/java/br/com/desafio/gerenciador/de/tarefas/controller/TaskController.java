package br.com.desafio.gerenciador.de.tarefas.controller;

import br.com.desafio.gerenciador.de.tarefas.dto.TaskDto;
import br.com.desafio.gerenciador.de.tarefas.model.Task;
import br.com.desafio.gerenciador.de.tarefas.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;


    @Operation(summary = "Create Task", description = "Endpoint to create Task")
    @PostMapping("/create-task")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){
        return ResponseEntity.ok(this.taskService.createTask(taskDto));
    }

    @Operation(summary = "Get all Task", description = "Endpoint to get all Task saved on Database")
    @GetMapping("/all-task")
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok(this.taskService.getAllTask());
    }

    @Operation(summary = "Update task", description = "Endpoint to update the Task")
    @PutMapping("/upDate-task/{id}")
    public ResponseEntity<Task> upDataTask(@RequestBody TaskDto taskDto, @PathVariable Long id){
        return ResponseEntity.ok(this.taskService.upDateTask(taskDto, id));
    }

    @Operation(summary = "Found Task by Status", description = "Endpoint to search Task by Status")
    @GetMapping("/find-task-status/{status}")
    public ResponseEntity<List<Task>> findTaskByStatus(@PathVariable String status){
        return ResponseEntity.ok(this.taskService.findByStatus(status));
    }

    @Operation(summary = "Task search by creation date", description = "Endpoint to search Task by  data of criation")
    @GetMapping("/find-task-data/{localDateTime}")
    public ResponseEntity<List<Task>> findTaskByDateCreation(@PathVariable LocalDateTime localDateTime){
        return ResponseEntity.ok(this.taskService.findByDateCreated(localDateTime));
    }

    @Operation(summary = "Task search by expiration date", description = "Endpoint to search Task by expiration date")
    @GetMapping("/find-task-due-data/{data}")
    public ResponseEntity<List<Task>> findTaskByDueDate(@PathVariable LocalDate data){
        return ResponseEntity.ok(this.taskService.findByDueDate(data));
    }

    @Operation(summary = "Delet task by Id", description = "Endpoint to delete Task by Id")
    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        return ResponseEntity.ok(this.taskService.deleteTask(id));
    }
}
