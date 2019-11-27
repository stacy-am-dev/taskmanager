package main.java.tasks.model;

import java.time.LocalDateTime;
import main.java.tasks.model.util.TaskStatus;
import main.java.tasks.model.util.TaskType;
import main.java.tasks.model.util.TaskPriority;

public class Task {
    private long id;
    private TaskStatus status;
    private TaskType type;
    private TaskPriority priority;
    private String name;
    private String description;
    private long idProcess;
    private long idEmployee;
    private LocalDateTime durationTimeExecute;
    private LocalDateTime actualTimeExecute;
    private LocalDateTime endTime;
    private String descriptionEmployee;


    public Task(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDurationTimeExecute() {
        return durationTimeExecute;
    }

    public void setDurationTimeExecute(LocalDateTime durationTimeExecute) {
        this.durationTimeExecute = durationTimeExecute;
    }

    public LocalDateTime getActualTimeExecute() {
        return actualTimeExecute;
    }

    public void setActualTimeExecute(LocalDateTime actualTimeExecute) {
        this.actualTimeExecute = actualTimeExecute;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public long getIdProcess(){ return idProcess;}

    public void setIdProcess(long idProcess){ this.idProcess = idProcess;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionEmployee() {
        return descriptionEmployee;
    }

    public void setDescriptionEmployee(String descriptionEmployee) {
        this.descriptionEmployee = descriptionEmployee;
    }
}
