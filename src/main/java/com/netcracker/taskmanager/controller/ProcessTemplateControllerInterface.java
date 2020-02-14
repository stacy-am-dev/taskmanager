package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.ProcessTemplate;

import java.util.Collection;

public interface ProcessTemplateControllerInterface {
    /**
     *Function creates and receives process template
     *@param processTemplate
     *@return ProcessTemplate
     */
    ProcessTemplate createProcessTemplate(ProcessTemplate processTemplate) throws TaskManagerException;
    /**
     *Function updates and receives process template
     *@param processTemplate
     *@return ProcessTemplate
     */
    ProcessTemplate updateEmployee (ProcessTemplate processTemplate) throws TaskManagerException;

    /**
     *Procedure deletes process template by identifier
     *@param processTemplateId
     */
    void deleteProcessTemplate(Long processTemplateId) throws TaskManagerException;
    /**
     *Procedure deletes process template
     *@param processTemplate
     */
    void deleteProcessTemplate(ProcessTemplate processTemplate) throws TaskManagerException;
    /**
     *Function receives process template by identifier
     *@param processTemplateId
     *@return ProcessTemplate
     */
    ProcessTemplate getProcessTemplateByProcessTemplateId(Long processTemplateId) throws TaskManagerException;
    /**
     *Function receives process template by name
     *@param name
     *@return ProcessTemplate
     */
    ProcessTemplate getProcessTemplateByName(String name) throws TaskManagerException;
    /**
     *Function receives collection of all process templates
     *@return Collection<processTemplate>
     */
    Collection<ProcessTemplate> getAllProcessTemplates() throws TaskManagerException;
}
