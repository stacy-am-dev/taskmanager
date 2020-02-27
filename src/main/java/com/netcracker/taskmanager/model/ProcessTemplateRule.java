package com.netcracker.taskmanager.model;

import com.netcracker.taskmanager.model.ProcessTemplate;
import com.netcracker.taskmanager.model.TaskTemplate;

import java.util.Map;

public class ProcessTemplateRule {
    private Long processTemplateRuleId;
    private ProcessTemplate processTemplate;
    private String name;
    private String description;
    private String ruleClass;
    private Integer order;

    ProcessTemplateRule() {
    }

    public Long getProcessTemplateRuleId() {
        return processTemplateRuleId;
    }

    public void setProcessTemplateRuleId(Long processTemplateRuleId) {
        this.processTemplateRuleId = processTemplateRuleId;
    }

    public ProcessTemplate getProcessTemplate() {
        return processTemplate;
    }

    public void setProcessTemplate(ProcessTemplate processTemplate) {
        this.processTemplate = processTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuleClass() {
        return ruleClass;
    }

    public void setRuleClass(String ruleClass) {
        this.ruleClass = ruleClass;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}