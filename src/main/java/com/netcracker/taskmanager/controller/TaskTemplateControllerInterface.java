package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.TaskTemplate;

import java.util.Collection;

public interface TaskTemplateControllerInterface {
    /**
     *Function creates and receives task template
     *@param taskTemplate
     *@return TaskTemplate
     */
    TaskTemplate createTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException;
    /**
     *Function updates and receives task template
     *@param taskTemplate
     *@return TaskTemplate
     */
    TaskTemplate updateTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException;

    /**
     *Procedure deletes task template by identifier
     *@param taskTemplateId
     */
    void deleteTaskTemplate(Long taskTemplateId) throws TaskManagerException;
    /**
     *Procedure deletes task template
     *@param taskTemplate
     */
    void deleteTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException;
    /**
     *Function receives task template by identifier
     *@param taskTemplateId
     *@return TaskTemplate
     */
    TaskTemplate getTaskTemplateByTaskTemplateId(Long taskTemplateId) throws TaskManagerException;
     /**
     *Function receives collection of all task templates
     *@return Collection<TaskTemplate>
     */
    Collection<TaskTemplate> getAllTaskTemplates() throws TaskManagerException;
}
