package com.netcracker.taskmanager.services;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.EmployeeSkill;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskSkill;
import com.netcracker.taskmanager.model.TaskType;
import com.netcracker.taskmanager.util.ModelFacade;

public class TaskExecutorService {
    private static TaskExecutorService taskExecutorService;

    private TaskExecutorService() throws TaskManagerException {

    }

    public static synchronized TaskExecutorService getTaskExecutorService() throws TaskManagerException {
        if(taskExecutorService == null)
            taskExecutorService = new TaskExecutorService();
        return taskExecutorService;
    }

    public void startTask() throws TaskManagerException {
        Task task = TaskStartQueueService.getTaskStartQueueService().getTask();
        if(task.getType() == TaskType.MANUAL){
            TaskSkill taskSkill = ModelFacade.getInstance().getModel().getTaskSkills().stream()
                    .filter(taskSkill1 -> taskSkill1.getTaskId() == task.getTaskId())
                    .findAny()
                    .orElseThrow(() -> new TaskManagerException(new Throwable(""), 234));
            EmployeeSkill employeeSkill = ModelFacade.getInstance().getModel().getEmployeeSkills().stream()
                    .filter(employeeSkill1 -> employeeSkill1.getSkillLevel() == taskSkill.getLevelSkill())
                    .findAny()
                    .orElseThrow(() -> new TaskManagerException(new Throwable(""), 234));
            new Task().setAssigneeId(employeeSkill.getEmployeeId());
        }
        else if(task.getType() == TaskType.JAVA_ACTION)
            new TaskActionService().setTaskAction(task);
    }
}
