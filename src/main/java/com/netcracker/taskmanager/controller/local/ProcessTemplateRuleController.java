package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.ProcessTemplateRuleControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.ProcessTemplateRule;

import java.util.Collection;

public class ProcessTemplateRuleController implements ProcessTemplateRuleControllerInterface {
    @Override
    public ProcessTemplateRule createProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException {
        return null;
    }

    @Override
    public ProcessTemplateRule updateProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException {
        return null;
    }

    @Override
    public void deleteProcessTemplateRule(Long processTemplateRuleId) throws TaskManagerException {

    }

    @Override
    public void deleteProcessTemplateRule(ProcessTemplateRule processTemplateRule) throws TaskManagerException {

    }

    @Override
    public ProcessTemplateRule getProcessTemplateRuleByProcessTemplateRuleId(Long processTemplateRuleId) throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<ProcessTemplateRule> getProcessTemplateRulesByProcessTemplateId(Long processTemplateId) throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<ProcessTemplateRule> getAllProcessTemplateRules() throws TaskManagerException {
        return null;
    }
}
