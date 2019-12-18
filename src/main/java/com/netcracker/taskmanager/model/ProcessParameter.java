package com.netcracker.taskmanager.model;

public class ProcessParameter {
    /**
     * Id of Process
     */
    private Long processId;
    /**
     * Name of parameter
     */
    private String parameterName;
    /**
     * Value of parameter
     */
    private String parameterValue;
    /**
     *Constructor creates new object
     * @see ProcessParameter#ProcessParameter(String, String)
     */
    public ProcessParameter(){}
    /**
     *Constructor creates new object with definite values
     * @param parameterName - name of parameter
     * @param parameterValue - value of parameter
     * @see ProcessParameter#ProcessParameter()
     */
    public ProcessParameter(String parameterName, String parameterValue)
    {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }
    /**
     *Function receives value of field {@link ProcessParameter#processId}
     *@return ProcessId
     */
    public Long getProcessId() {
        return processId;
    }
    /**
     *Procedure defines value of field {@link ProcessParameter#processId}
     *@param processId
     */
    public void setProcessId(Long processId) {
        this.processId = processId;
    }
    /**
     *Function receives value of field {@link ProcessParameter#parameterName}
     *@return parameterName
     */
    public String getParameterName() {
        return parameterName;
    }
    /**
     *Procedure defines value of field {@link ProcessParameter#parameterName}
     *@param parameterName
     */
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    /**
     *Function receives value of field {@link ProcessParameter#parameterValue}
     *@return parameterValue
     */
    public String getParameterValue() {
        return parameterValue;
    }
    /**
     *Procedure defines value of field {@link ProcessParameter#parameterValue}
     *@param parameterValue
     */
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
}
