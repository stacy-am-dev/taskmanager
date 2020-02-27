package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.ProcessTemplateRule;

import java.util.Collection;

public interface ProcessTemplateRuleControllerInterface {
    /**
     *Function creates and receives process template rule
     *@param processTemplateRule
     *@return ProcessTemplateRule
     */
    ProcessTemplateRule createProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException;
    /**
     *Function updates and receives process template rule
     *@param processTemplateRule
     *@return ProcessTemplateRule
     */
    ProcessTemplateRule updateProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException;

    /**
     *Procedure deletes process template rule by identifier
     *@param processTemplateRuleId
     */
    void deleteProcessTemplateRule(Long processTemplateRuleId) throws TaskManagerException;
    /**
     *Procedure deletes process template rule
     *@param processTemplateRule
     */
    void deleteProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException;
    /**
     *Function receives process template rule by identifier
     *@param processTemplateRuleId
     *@return ProcessTemplateRule
     */
    ProcessTemplateRule getProcessTemplateRuleByProcessTemplateRuleId(Long processTemplateRuleId) throws TaskManagerException;
    /**
     *Function receives collection of process template rules by identifier of process template
     *@param processTemplateId
     *@return Collection<ProcessTemplateRule>
     */
    Collection<ProcessTemplateRule> getProcessTemplateRulesByProcessTemplateId(Long processTemplateId) throws TaskManagerException;
    /**
     *Function receives collection of all process templates rules
     *@return Collection<ProcessTemplateRule>
     */
    Collection<ProcessTemplateRule> getAllProcessTemplateRules() throws TaskManagerException;
}


