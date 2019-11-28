package main.java.tasks.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

/**
 * Describes the workflow. Process contains a description, name, starDate, endDate,excpectaionStartDate,excpectaionEndDate,status
 */
public class Process {

    /**
     * process identifier
     */
    private long processId;
    /**
     * process description
     */
    private String description;
    /**
     *  process name
     */
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
     * process excpectionStarDate
     */
    private LocalDateTime excpectaionStartDate;
    /**
     * Process excpectaionEndDate
     */
    private LocalDateTime excpectaionEndDate;
    /**
     * Process status
     */
    private ProcessStatus status;
    /**
       *Constructor creates new object with definite values
     * @param processId - ID of process
     * @param description - description of process
     * @param name - name of process
     * @param startDate - starDate of process
     * @param endDate - endDate of process
     * @param exceptionStartDate- exceptionStartDate of process
     * @param exceptionEndDate-exceptionsEndDate of process
     * @see Process#Process()
     */
    public Process(long processId,String description,String name,LocalDateTime startDate, LocalDateTime endDate, LocalDateTime exceptionStartDate,LocalDateTime exceptionEndDate){
       this.processId=processId;
       this.description=description;
       this.name=name;
       this.startDate=startDate;
       this.endDate=endDate;
       this.excpectaionStartDate=exceptionStartDate;
       this.excpectaionEndDate=exceptionEndDate;

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
        return excpectaionStartDate;
    }

    public void setExceptionStartDate(LocalDateTime exceptionStartDate) {
        this.excpectaionStartDate = exceptionStartDate;
    }

    public LocalDateTime getExcpectaionEndDate() {
        return excpectaionEndDate;
    }

    /**
     * Function of setting the actual runtime
     * @param excpectaionEndDate runtime

     */
    public void setExcpectaionEndDate(LocalDateTime excpectaionEndDate) {
        this.excpectaionEndDate = excpectaionEndDate;
    }

    /**
     *Function of obtaining start time procecss
      * @return starDate the start time of the process
     */
    public LocalDateTime getStartDate(){
        return startDate;
    }
    public void setStarDate(LocalDateTime startDate){
        this.startDate=startDate;
    }
    public LocalDateTime getEndDate(){
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate){
        this.endDate=endDate;
    }

    public void saveToFile(OutputStream out){

    }
    public void upload(InputStream out){

    }
}