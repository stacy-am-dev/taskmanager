package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.ProcessTemplateControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.ProcessTemplate;
import com.netcracker.taskmanager.util.ModelFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static com.netcracker.taskmanager.Constants.FIELDS_OF_PROCESS_TEMPLATE_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_PROCESS_TEMPLATE;

public class ProcessTemplateController implements ProcessTemplateControllerInterface {

    @Autowired
    private ModelFacade modelFacade;

    @Override
    public ProcessTemplate createProcessTemplate(ProcessTemplate processTemplate) throws TaskManagerException {
        if( ModelFacade.getInstance().getModel().getProcessTemplates().stream().anyMatch(processTemplate1 ->  processTemplate1.getName().equals(processTemplate.getName())))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_PROCESS_TEMPLATE_INCORRECT);
        processTemplate.setProcessTemplateId(ModelFacade.getInstance().getModel().getMatchMap().get(ProcessTemplate.class).generate());
        ModelFacade.getInstance().getModel().getProcessTemplates().add(processTemplate);
        return processTemplate;
    }

    @Override
    public ProcessTemplate updateProcessTemplate(ProcessTemplate processTemplate) throws TaskManagerException {
        if(ModelFacade.getInstance().getModel().getProcessTemplates().stream().anyMatch(processTemplate1 -> processTemplate1.getName().equals(processTemplate.getName())))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_PROCESS_TEMPLATE_INCORRECT);
        return ModelFacade.getInstance().getModel().getProcessTemplates().stream()
                .filter(processTemplate1 ->  processTemplate1.getProcessTemplateId() == processTemplate.getProcessTemplateId())
                .peek(processTemplate1 -> processTemplate1 = processTemplate)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS_TEMPLATE));
    }

    @Override
    public void deleteProcessTemplate(Long processTemplateId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getProcesses().removeIf(processTemplate -> processTemplate.getProcessTemplateId() == processTemplateId);
    }

    @Override
    public void deleteProcessTemplate(ProcessTemplate processTemplate) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getProcesses().remove(processTemplate);

    }

    @Override
    public ProcessTemplate getProcessTemplateByProcessTemplateId(Long processTemplateId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcessTemplates().stream()
                .filter(processTemplate -> processTemplate.getProcessTemplateId() == processTemplateId)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS_TEMPLATE));
    }

    @Override
    public ProcessTemplate getProcessTemplateByName(String name) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcessTemplates().stream()
                .filter(processTemplate -> processTemplate.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_PROCESS_TEMPLATE));
    }

    @Override
    public Collection<ProcessTemplate> getAllProcessTemplates() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getProcessTemplates();
    }
}
