package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Describes the workflow. Process contains a description, name, starDate, endDate,expectationStartDate,expectationEndDate,status
 */
@XmlRootElement(name = "process")
public class Process {



    /**
     * process identifier
     */
    @XmlAttribute(name = "processId")
    private long processId;
    /**
     * Identifier of process template
     */
    private Long processTemplateId;
    /**
     * process description
     */
    private String description;
    /**
     *  process name
     */
    @XmlElement
    private String name;
    /**
     * process starDate
     */
    private LocalDateTime startDate;
    /**
     * process endDate
     */
    private LocalDateTime endDate;
    /**
     * process expectationStarDate
     */
    private LocalDateTime expectationStartDate;
    /**
     * Process expectationEndDate
     */
    private LocalDateTime expectationEndDate;
    /**
     * Process status
     */
    private ProcessStatus status;


    /**
       *Constructor creates new object with definite values
     * @param params
     * @see Process#Process()
     */
    public Process(HashMap<String, String> params){

       this.processId= Long.getLong(params.get("processId"));
       this.description = params.get("description");
       this.name = params.get("name");
       this.startDate = LocalDateTime.parse(params.get("startDate"));
       this.endDate = LocalDateTime.parse(params.get("endDate"));
       this.expectationStartDate= LocalDateTime.parse(params.get("exceptionStartDate"));
       this.expectationEndDate = LocalDateTime.parse(params.get("exceptionEndDate"));
       this.processTemplateId = Long.getLong(params.get("processTemplateId"));
    }
    /**
     * Constructor creates new object
     */
    public Process(){

    }
    /**
     *Function receives value of field{@link Process#processId}
     *@return processId
     */

    public long getprocessId() {
        return processId;
    }
    /**
     *Function defines value of field {@link Process#processId}
     *@param processId
     */

    public void setId(long processId) {
        this.processId = processId;
    }
    /**
     *Function receives value of description{@link Process#description}
     *@return description
     */

    public String getDescription() {
        return description;
    }
    /**
     *Function defines value of field {@link Process#description}
     *@param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *Function defines value of field {@link Process#name}
     *@param name
     */
    public void setName(String name){
        this.name=name;
    }
    /**
     *Function receives value of description{@link Process#name}
     *@return name
     */
    public String getName(){
        return name;
    }

    public LocalDateTime getExceptionStartDate() {
        return expectationStartDate;
    }

    public void setExceptionStartDate(LocalDateTime exceptionStartDate) {
        this.expectationStartDate = exceptionStartDate;
    }

    public LocalDateTime getExpectationEndDate() {
        return expectationEndDate;
    }

    /**
     * Function of setting the actual runtime
     * @param expectationEndDate runtime

     */
    public void setExpectationEndDate(LocalDateTime expectationEndDate) {
        this.expectationEndDate = expectationEndDate;
    }

    /**
     *Function of obtaining start time procecss
      * @return startDate the start time of the process
     */
    public LocalDateTime getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate){
        this.endDate=endDate;
    }

    public long getProcessId() {
        return processId;
    }

    public void setProcessId(long processId) {
        this.processId = processId;
    }

    public Long getProcessTemplateId() {
        return processTemplateId;
    }

    public void setProcessTemplateId(Long processTemplateId) {
        this.processTemplateId = processTemplateId;
    }

    public LocalDateTime getExpectationStartDate() {
        return expectationStartDate;
    }

    public void setExpectationStartDate(LocalDateTime expectationStartDate) {
        this.expectationStartDate = expectationStartDate;
    }

    public ProcessStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessStatus status) {
        this.status = status;
    }

    public void saveToFile(OutputStream out){

    }
    public void upload(InputStream in){

    }
}