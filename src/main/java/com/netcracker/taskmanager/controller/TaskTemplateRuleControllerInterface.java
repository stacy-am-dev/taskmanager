package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.TaskTemplateRule;

import java.util.Collection;

public interface TaskTemplateRuleControllerInterface {
    /**
     * Function create and receives task template rule
     * @param taskTemplateRule
     * @return TaskTemplateRule
     * @throws TaskManagerException
     */
    TaskTemplateRule createTaskTemplateRule(TaskTemplateRule taskTemplateRule) throws TaskManagerException;

    /**
     * Function update and receives task template rule
     * @param taskTemplateRule
     * @return TaskTemplateRule
     * @throws TaskManagerException
     */
    TaskTemplateRule updateTaskTemplateRule(TaskTemplateRule taskTemplateRule) throws TaskManagerException;

    /**
     * Function delete task template rule
     * @param taskTemplateRuleId
     * @throws TaskManagerException
     */
    void deleteTaskTemplateRule(Long taskTemplateRuleId) throws TaskManagerException;

    /**
     * Function delete task template rule
     * @param taskTemplateRule
     * @throws TaskManagerException
     */
    void deleteTaskTemplateRule(TaskTemplateRule taskTemplateRule) throws TaskManagerException;

    /**
     * Function receives task template rule by identifier
     * @param taskTemplateRuleId
     * @return TaskTemplateRule
     * @throws TaskManagerException
     */
    TaskTemplateRule getTaskTemplateRuleByTaskTemplateRuleId(Long taskTemplateRuleId) throws TaskManagerException;

    /**
     * Function receives collection of task template rules by identifier of task template
     * @param taskTemplateId
     * @return Collection<TaskTemplateRule>
     * @throws TaskManagerException
     */
    Collection<TaskTemplateRule> getTaskTemplateRulesByTaskTemplateId(Long taskTemplateId) throws TaskManagerException;

    /**
     * Function receives collection of task template rules
     * @return Collection<TaskTemplateRule>
     * @throws TaskManagerException
     */
    Collection<TaskTemplateRule> getAllTaskTemplateRules() throws TaskManagerException;

}
