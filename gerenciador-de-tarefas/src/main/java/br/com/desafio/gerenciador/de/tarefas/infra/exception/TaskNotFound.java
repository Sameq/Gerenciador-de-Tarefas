package br.com.desafio.gerenciador.de.tarefas.infra.exception;

public class TaskNotFound extends RuntimeException{

    public TaskNotFound(){
        super("Task not found");
    }

    public TaskNotFound(String message){
        super(message);
    }
}
