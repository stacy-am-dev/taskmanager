package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.TaskTemplateRuleControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.TaskTemplateRule;
import com.netcracker.taskmanager.util.ModelFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.netcracker.taskmanager.Constants.NAME_OF_TASK_TEMPLATE_RULE_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_TASK_TEMPLATE_RULE;

public class TaskTemplateRuleController implements TaskTemplateRuleControllerInterface {

    @Autowired
    private ModelFacade modelFacade;

    @Override
    public TaskTemplateRule createTaskTemplateRule(TaskTemplateRule taskTemplateRule) throws TaskManagerException {
        if(ModelFacade.getInstance().getModel().getTaskTemplateRules().stream().anyMatch(taskTemplateRule1 -> taskTemplateRule1.getName().equals(taskTemplateRule.getName())))
            throw new TaskManagerException(new Throwable(""), NAME_OF_TASK_TEMPLATE_RULE_INCORRECT);
        taskTemplateRule.setTaskTemplateRuleId(ModelFacade.getInstance().getModel().getMatchMap().get(TaskTemplateRule.class).generate());
        ModelFacade.getInstance().getModel().getTaskTemplateRules().add(taskTemplateRule);
        return taskTemplateRule;    }

    @Override
    public TaskTemplateRule updateTaskTemplateRule(TaskTemplateRule taskTemplateRule) throws TaskManagerException {
        if(ModelFacade.getInstance().getModel().getTaskTemplateRules().stream().anyMatch(taskTemplateRule1 -> taskTemplateRule1.getName().equals(taskTemplateRule.getName())))
            throw new TaskManagerException(new Throwable(""), NAME_OF_TASK_TEMPLATE_RULE_INCORRECT);
        return ModelFacade.getInstance().getModel().getTaskTemplateRules().stream()
                .filter(taskTemplateRule1 -> taskTemplateRule1.getTaskTemplateRuleId() == taskTemplateRule.getTaskTemplateRuleId())
                .peek(taskTemplateRule1 -> taskTemplateRule1 = taskTemplateRule)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_TASK_TEMPLATE_RULE));    }

    @Override
    public void deleteTaskTemplateRule(Long taskTemplateRuleId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getTaskTemplateRules().removeIf(taskTemplateRule -> taskTemplateRule.getTaskTemplateRuleId() == taskTemplateRuleId);

    }

    @Override
    public void deleteTaskTemplateRule(TaskTemplateRule taskTemplateRule) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getTaskTemplateRules().remove(taskTemplateRule);
    }

    @Override
    public TaskTemplateRule getTaskTemplateRuleByTaskTemplateRuleId(Long taskTemplateRuleId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTaskTemplateRules().stream()
                .filter(taskTemplateRule -> taskTemplateRule.getTaskTemplateRuleId() == taskTemplateRuleId)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_TASK_TEMPLATE_RULE));
    }

    @Override
    public Collection<TaskTemplateRule> getTaskTemplateRulesByTaskTemplateId(Long taskTemplateId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTaskTemplateRules().stream()
                .filter(taskTemplateRule -> taskTemplateRule.getTaskTemplateId() == taskTemplateId)
                .collect(Collectors.toList());    }

    @Override
    public Collection<TaskTemplateRule> getAllTaskTemplateRules() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTaskTemplateRules();
    }
}
