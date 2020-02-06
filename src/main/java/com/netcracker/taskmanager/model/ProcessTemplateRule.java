package com.netcracker.taskmanager.model;

import com.netcracker.taskmanager.exception.TaskManagerException;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Map;

import static com.netcracker.taskmanager.Constants.TASK_INITIALIZATION_ERROR;

public class ProcessTemplateRule {
    Task task = new Task();

    public Task Check(Map<String, String> parameters) throws TaskManagerException, ParseException {
        if (parameters.containsKey("priority")) {
            String prior = parameters.get("priority");
            if (!prior.equals("BLOCKER") && !prior.equals("LOW") &&
                    !prior.equals("NORMAL") && !prior.equals("MAJOR") && !prior.equals("CRITICAL")) {

                throw new TaskManagerException(null, TASK_INITIALIZATION_ERROR);
            } else {
                task.setPriority(TaskPriority.valueOf(prior));
            }
        }
        if (parameters.containsKey("type")) {
            String type = parameters.get("type");
            if ((!type.equals("ACTION_COMMAND") && !type.equals("DEFAULT") && !type.equals("SELECTED"))) {
                throw new TaskManagerException(null, TASK_INITIALIZATION_ERROR);
            } else task.setType(TaskType.valueOf(type));
        }

        if (parameters.containsKey("status")) {
            String status = parameters.get("status");
            if ((!status.equals("OCCUPIED") && !status.equals("FREE") && !status.equals("STARTED") && !status.equals("IN_PROGRESS")
                    && !status.equals("WAITING") && !status.equals("DELAYED") && !status.equals("FINISHED"))) {
                throw new TaskManagerException(null, TASK_INITIALIZATION_ERROR);
            } else task.setStatus(TaskStatus.valueOf(status));
        }
        if (parameters.containsKey("expectationEndDate") && parameters.containsKey("expectationStartDate")) {
            LocalDateTime endDate = LocalDateTime.parse(parameters.get("expectationEndDate"));
            LocalDateTime startDate = LocalDateTime.parse(parameters.get("expectationStartDate"));
            if (endDate.isBefore(startDate) || endDate.isEqual(startDate)) {
                throw new TaskManagerException(null, TASK_INITIALIZATION_ERROR);
            } else {
                task.setExpectationEndDate(endDate);
                task.setExpectationStartDate(startDate);
            }
        }
        if (parameters.containsKey("endDate") && parameters.containsKey("startDate")) {
            LocalDateTime endDate = LocalDateTime.parse(parameters.get("endDate"));
            LocalDateTime startDate = LocalDateTime.parse(parameters.get("startDate"));
            if (endDate.isBefore(startDate) || endDate.isEqual(startDate)) {
                throw new TaskManagerException(null, TASK_INITIALIZATION_ERROR);
            } else {
                task.setEndDate(endDate);
                task.setStartDate(startDate);
            }
        }
        return task;
    }
}
