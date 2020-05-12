package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Describes the workflow. Process contains a description, name, starDate, endDate,expectationStartDate,expectationEndDate,status
 */
@XmlRootElement(name = "process")
@XmlAccessorType(XmlAccessType.FIELD)
public class Process implements Serializable {
    /**
     * process identifier
     */
    @XmlAttribute(name = "process_id")
    private Long processId;
    /**
     * Identifier of process template
     */
    @XmlElement(name = "process_template_id")
    private Long processTemplateId;
    /**
     * process description
     */
    @XmlElement(name = "description")
    private String description;
    /**
     * process name
     */
    @XmlElement(name = "name")
    private String name;
    /**
     * process starDate
     */
    @XmlElement(name = "start_date")
    private LocalDateTime startDate;
    /**
     * process endDate
     */
    @XmlElement(name = "end_date")
    private LocalDateTime endDate;
    /**
     * process expectationStarDate
     */
    @XmlElement(name = "expectation_start_date")
    private LocalDateTime expectationStartDate;
    /**
     * Process expectationEndDate
     */
    @XmlElement(name = "expectation_end_date")
    private LocalDateTime expectationEndDate;
    /**
     * Process status
     */
    @XmlElement(name = "status")
    private ProcessStatus status;
    /**
     * Parameters of Process
     */
    @XmlElement(name = "parameters")
    private Map<String, String> parameters = new HashMap<>();

    /**
     * Constructor creates new object
     */
    public Process() {

    }

    /**
     * Function receives value of field{@link Process#processId}
     *
     * @return processId
     */

    public Long getProcessId() {
        return processId;
    }

    /**
     * Function defines value of field {@link Process#processId}
     *
     * @param processId
     */

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    /**
     * Function receives value of field{@link Process#processTemplateId}
     *
     * @return processTemplateId
     */

    public Long getProcessTemplateId() {
        return processTemplateId;
    }

    /**
     * Function defines value of field {@link Process#processTemplateId}
     *
     * @param processTemplateId
     */
    public void setProcessTemplateId(Long processTemplateId) {
        this.processTemplateId = processTemplateId;
    }

    /**
     * Function receives value of description{@link Process#description}
     *
     * @return description
     */

    public String getDescription() {
        return description;
    }

    /**
     * Function defines value of field {@link Process#description}
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Function defines value of field {@link Process#name}
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function receives value of description{@link Process#name}
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Function receives value of description{@link Process#expectationStartDate}
     *
     * @return expectationStartDate
     */
    public LocalDateTime getExpectationStartDate() {
        return expectationStartDate;
    }

    /**
     * Function defines value of field {@link Process#expectationStartDate}
     *
     * @param expectationStartDate
     */
    public void setExpectationStartDate(LocalDateTime expectationStartDate) {
        this.expectationStartDate = expectationStartDate;
    }

    /**
     * Function receives value of description{@link Process#expectationEndDate}
     *
     * @return expectationEndDate
     */
    public LocalDateTime getExpectationEndDate() {
        return expectationEndDate;
    }

    /**
     * Function defines value of field {@link Process#expectationEndDate}
     *
     * @param expectationEndDate
     */
    public void setExpectationEndDate(LocalDateTime expectationEndDate) {
        this.expectationEndDate = expectationEndDate;
    }

    /**
     * Function receives value of description{@link Process#startDate}
     *
     * @return startDate
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Function defines value of field {@link Process#startDate}
     *
     * @param startDate
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Function receives value of description{@link Process#endDate}
     *
     * @return endDate
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * Function defines value of field {@link Process#endDate}
     *
     * @param endDate
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Function receives value of description{@link Process#status}
     *
     * @return status
     */
    public ProcessStatus getStatus() {
        return status;
    }

    /**
     * Function defines value of field {@link Process#status}
     *
     * @param status
     */
    public void setStatus(ProcessStatus status) {
        this.status = status;
    }
    /**
     * Function receives value of description{@link Process#parameters}
     *
     * @return parameters
     */
    public Map<String, String> getParameters() {
        return parameters;
    }
    /**
     * Function defines value of field {@link Process#parameters}
     *
     * @param parameters
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}