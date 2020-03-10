package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.TaskTemplateControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.TaskTemplate;

import java.util.Collection;

public class TaskTemplateController implements TaskTemplateControllerInterface {
    @Override
    public TaskTemplate createTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException {
        return null;
    }

    @Override
    public TaskTemplate updateTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException {
        return null;
    }

    @Override
    public void deleteTaskTemplate(Long taskTemplateId) throws TaskManagerException {

    }

    @Override
    public void deleteTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException {

    }

    @Override
    public TaskTemplate getTaskTemplateByTaskTemplateId(Long taskTemplateId) throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<TaskTemplate> getAllTaskTemplates() throws TaskManagerException {
        return null;
    }
}
