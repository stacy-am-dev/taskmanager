package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.ProcessTemplateRuleControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.ProcessTemplateRule;
import com.netcracker.taskmanager.util.ModelFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.netcracker.taskmanager.Constants.NAME_OF_PROCESS_TEMPLATE_RULE_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_PROCESS_TEMPLATE_RULE;

public class ProcessTemplateRuleController implements ProcessTemplateRuleControllerInterface {

    @Autowired
    private ModelFacade modelFacade;

    @Override
    public ProcessTemplateRule createProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException {
        if(ModelFacade.getInstance().getModel().getProcessTemplateRules().stream().anyMatch(processTemplateRule1 -> processTemplateRule1.getName().equals(processTemplateRule.getName())))
            throw new TaskManagerException(new Throwable(""), NAME_OF_PROCESS_TEMPLATE_RULE_INCORRECT);
        processTemplateRule.setProcessTemplateRuleId(ModelFacade.getInstance().getModel().getMatchMap().get(ProcessTemplateRule.class).generate());
        ModelFacade.getInstance().getModel().getProcessTemplateRules().add(processTemplateRule);
        return processTemplateRule;
    }

    @Override
    public ProcessTemplateRule updateProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException {
        if(ModelFacade.getInstance().getModel().getProcessTemplateRules().stream().anyMatch(processTemplateRule1 -> processTemplateRule1.getName().equals(processTemplateRule.getName())))
            throw new TaskManagerException(new Throwable(""), NAME_OF_PROCESS_TEMPLATE_RULE_INCORRECT);
        return ModelFacade.getInstance().getModel().getProcessTemplateRules().stream()
                .filter(processTemplateRule1 -> processTemplateRule1.getProcessTemplateRuleId() == processTemplateRule.getProcessTemplateRuleId())
                .peek(processTemplateRule1 -> processTemplateRule1 = processTemplateRule)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS_TEMPLATE_RULE));
    }

    @Override
    public void deleteProcessTemplateRule(Long processTemplateRuleId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getProcessTemplateRules().removeIf(processTemplateRule -> processTemplateRule.getProcessTemplateRuleId() == processTemplateRuleId);
    }

    @Override
    public void deleteProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getProcessTemplateRules().remove(processTemplateRule);
    }

    @Override
    public ProcessTemplateRule getProcessTemplateRuleByProcessTemplateRuleId(Long processTemplateRuleId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcessTemplateRules().stream()
                .filter(processTemplateRule -> processTemplateRule.getProcessTemplateRuleId() == processTemplateRuleId)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS_TEMPLATE_RULE));
    }

    @Override
    public Collection<ProcessTemplateRule> getProcessTemplateRulesByProcessTemplateId(Long processTemplateId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcessTemplateRules().stream()
                .filter(processTemplateRule -> processTemplateRule.getProcessTemplateId() == processTemplateId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<ProcessTemplateRule> getAllProcessTemplateRules() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcessTemplateRules();
    }
}
