package com.netcracker.taskmanager.model;

import com.netcracker.taskmanager.model.ProcessTemplate;
import com.netcracker.taskmanager.model.TaskTemplate;

import java.util.Map;

public class ProcessTemplateRule {
    /**
     * Identifier of process template rule
     */
    private Long processTemplateRuleId;
    /**
     * Identifier of process template
     */
    private Long processTemplateId;
    /**
     * Name of process template rule
     */
    private String name;
    /**
     * Description of process template rule
     */
    private String description;
    /**
     * Name of rule class
     */
    private String ruleClass;
    /**
     * Number of process template rule
     */
    private Integer order;

    /**
     * Constructor creates new object
     */
    ProcessTemplateRule() {
    }
    /**
     * Function receives value of field {@link ProcessTemplateRule#processTemplateRuleId}
     *
     * @return processTemplateRuleId
     */
    public Long getProcessTemplateRuleId() {
        return processTemplateRuleId;
    }
    /**
     * Procedure defines value of field {@link ProcessTemplateRule#processTemplateRuleId}
     *
     * @param processTemplateRuleId
     */
    public void setProcessTemplateRuleId(Long processTemplateRuleId) {
        this.processTemplateRuleId = processTemplateRuleId;
    }
    /**
     * Function receives value of field {@link ProcessTemplateRule#processTemplateId}
     *
     * @return processTemplateId
     */
    public Long getProcessTemplateId() {
        return processTemplateId;
    }
    /**
     * Procedure defines value of field {@link ProcessTemplateRule#processTemplateId}
     *
     * @param processTemplateId
     */
    public void setProcessTemplateId(Long processTemplateId) {
        this.processTemplateId = processTemplateId;
    }
    /**
     * Function receives value of field {@link ProcessTemplateRule#name}
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Procedure defines value of field {@link ProcessTemplateRule#name}
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Function receives value of field {@link ProcessTemplateRule#description}
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Procedure defines value of field {@link ProcessTemplateRule#description}
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Function receives value of field {@link ProcessTemplateRule#ruleClass}
     *
     * @return ruleClass
     */
    public String getRuleClass() {
        return ruleClass;
    }
    /**
     * Procedure defines value of field {@link ProcessTemplateRule#ruleClass}
     *
     * @param ruleClass
     */
    public void setRuleClass(String ruleClass) {
        this.ruleClass = ruleClass;
    }
    /**
     * Function receives value of field {@link ProcessTemplateRule#order}
     *
     * @return order
     */
    public Integer getOrder() {
        return order;
    }
    /**
     * Procedure defines value of field {@link ProcessTemplateRule#order}
     *
     * @param order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
}