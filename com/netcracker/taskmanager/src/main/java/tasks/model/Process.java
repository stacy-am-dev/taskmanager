package main.java.tasks.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;


public class Process {

    private long processId;
    private String description;
    private String name;
    private LocalDateTime starDate;
    private LocalDateTime endDate;
    private LocalDateTime excpectaionStartDate;
    private LocalDateTime excpectaionEndDate;
    private String status;
    public Process(){

    }
    public long getprocessId() {
        return processId;
    }

    public void setId(long processId) {
        this.processId = processId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
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
    public void saveToFile(OutputStream out){

    }
    public void upload(InputStream out){

    }
}