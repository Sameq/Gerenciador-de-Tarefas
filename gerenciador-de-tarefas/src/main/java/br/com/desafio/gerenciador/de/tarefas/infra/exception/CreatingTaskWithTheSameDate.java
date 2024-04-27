package br.com.desafio.gerenciador.de.tarefas.infra.exception;

public class CreatingTaskWithTheSameDate extends RuntimeException {
    public CreatingTaskWithTheSameDate(){
        super("Error creating task");
    }

    public CreatingTaskWithTheSameDate(String message){
        super(message);
    }

}
