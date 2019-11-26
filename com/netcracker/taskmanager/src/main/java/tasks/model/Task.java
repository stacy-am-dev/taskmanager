package main.java.tasks.model;

import java.time.LocalDateTime;

public class Task {
    private Enum status;
    private long id;
    private String description;
    private LocalDateTime supposedTimeExecute;
    private LocalDateTime actualTimeExecute;
    private LocalDateTime startTime;
    private long type;
    private long employee;
    private int level;
    private long process;

    public Task(){}

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

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

    public LocalDateTime getSupposedTimeExecute() {
        return supposedTimeExecute;
    }

    public void setSupposedTimeExecute(LocalDateTime supposedTimeExecute) {
        this.supposedTimeExecute = supposedTimeExecute;
    }

    public LocalDateTime getActualTimeExecute() {
        return actualTimeExecute;
    }

    public void setActualTimeExecute(LocalDateTime actualTimeExecute) {
        this.actualTimeExecute = actualTimeExecute;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private long getProcess(){ return process;}

    private void setProcess(long process){ this.process = process;}
}
