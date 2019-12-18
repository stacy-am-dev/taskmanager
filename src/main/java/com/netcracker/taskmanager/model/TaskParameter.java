package com.netcracker.taskmanager.model;

public class TaskParameter {
    /**
     * Id of task
     */
    private Long taskId;
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
     * @see TaskParameter#TaskParameter(String, String)
     */
    public TaskParameter(){}
    /**
     *Constructor creates new object with definite values
     * @param parameterName - name of parameter
     * @param parameterValue - value of parameter
     * @see TaskParameter#TaskParameter()
     */
    public TaskParameter(String parameterName, String parameterValue)
    {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }
    /**
     *Function receives value of field {@link TaskParameter#taskId}
     *@return taskId
     */
    public Long getTaskId() {
        return taskId;
    }
    /**
     *Procedure defines value of field {@link TaskParameter#taskId}
     *@param taskId
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    /**
     *Function receives value of field {@link TaskParameter#parameterName}
     *@return parameterName
     */
    public String getParameterName() {
        return parameterName;
    }
    /**
     *Procedure defines value of field {@link TaskParameter#parameterName}
     *@param parameterName
     */
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    /**
     *Function receives value of field {@link TaskParameter#parameterValue}
     *@return parameterValue
     */
    public String getParameterValue() {
        return parameterValue;
    }
    /**
     *Procedure defines value of field {@link TaskParameter#parameterValue}
     *@param parameterValue
     */
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
}
