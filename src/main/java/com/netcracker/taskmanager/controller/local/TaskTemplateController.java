package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.TaskTemplateControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.TaskTemplate;
import com.netcracker.taskmanager.util.ModelFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static com.netcracker.taskmanager.Constants.NAME_OF_TASK_TEMPLATE_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_TASK_TEMPLATE;

public class TaskTemplateController implements TaskTemplateControllerInterface {

    @Autowired
    private ModelFacade modelFacade;

    @Override
    public TaskTemplate createTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException {
        if(ModelFacade.getInstance().getModel().getTaskTemplates().stream().anyMatch(taskTemplate1 -> taskTemplate1.getName().equals(taskTemplate.getName())))
            throw new TaskManagerException(new Throwable(), NAME_OF_TASK_TEMPLATE_INCORRECT);
        taskTemplate.setTaskTemplateId(ModelFacade.getInstance().getModel().getMatchMap().get(TaskTemplate.class).generate());
        ModelFacade.getInstance().getModel().getTaskTemplates().add(taskTemplate);
        return taskTemplate;
    }

    @Override
    public TaskTemplate updateTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException {
        if(ModelFacade.getInstance().getModel().getTaskTemplates().stream().anyMatch(taskTemplate1 -> taskTemplate1.getName().equals(taskTemplate.getName())))
            throw new TaskManagerException(new Throwable(), NAME_OF_TASK_TEMPLATE_INCORRECT);
        return ModelFacade.getInstance().getModel().getTaskTemplates().stream()
                .filter(taskTemplate1 -> taskTemplate1.getTaskTemplateId() == taskTemplate.getTaskTemplateId())
                .peek(taskTemplate1 -> taskTemplate1 = taskTemplate)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(), NO_SUCH_TASK_TEMPLATE));
    }

    @Override
    public void deleteTaskTemplate(Long taskTemplateId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getTaskTemplates().removeIf(taskTemplate -> taskTemplate.getTaskTemplateId() == taskTemplateId);
    }

    @Override
    public void deleteTaskTemplate(TaskTemplate taskTemplate) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getTaskTemplates().remove(taskTemplate);
    }

    @Override
    public TaskTemplate getTaskTemplateByTaskTemplateId(Long taskTemplateId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTaskTemplates().stream()
                .filter(taskTemplate -> taskTemplate.getTaskTemplateId() == taskTemplateId)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(), NO_SUCH_TASK_TEMPLATE));
    }

    @Override
    public Collection<TaskTemplate> getAllTaskTemplates() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTaskTemplates();
    }
}
