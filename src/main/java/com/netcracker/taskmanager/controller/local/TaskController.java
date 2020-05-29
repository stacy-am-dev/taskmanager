package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.TaskControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskStatus;
import com.netcracker.taskmanager.util.ModelFacade;

import java.util.Collection;
import java.util.concurrent.PriorityBlockingQueue;

import static com.netcracker.taskmanager.Constants.*;

public class TaskController implements TaskControllerInterface {
    @Override
    public Task createTask(Task task) throws TaskManagerException {
        if ((task.getStartDate().compareTo(task.getEndDate()) > 0) || (ModelFacade.getInstance().getModel().getTasks().stream().anyMatch(task1 -> task1.getName().equals(task.getName()))))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_TASK_INCORRECT);
        task.setTaskId(ModelFacade.getInstance().getModel().getMatchMap().get(Task.class).generate());
        ModelFacade.getInstance().getModel().getTasks().add(task);
        return task;
    }

    @Override
    public Task updateTask(Task task) throws TaskManagerException {
        if ((task.getStartDate().compareTo(task.getEndDate()) > 0) || (ModelFacade.getInstance().getModel().getTasks().stream().anyMatch(task1 -> task1.getName().equals(task.getName()))))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_TASK_INCORRECT);
        return ModelFacade.getInstance().getModel().getTasks().stream()
                .filter(task1 -> task1.getTaskId() == task.getTaskId())
                .peek(task1 -> task1 = task)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_TASK));

    }

    @Override
    public void deleteTask(Long taskId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getTasks().removeIf(task -> task.getTaskId() == taskId);

    }

    @Override
    public void deleteTask(Task task) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getTasks().remove(task);
    }

    @Override
    public Task getTaskById(Long taskId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTasks().stream()
                .filter(task -> task.getTaskId() == taskId)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_TASK));

    }

    @Override
    public Task getTaskByName(String taskName) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTasks().stream()
                .filter(task -> task.getName().equals(taskName))
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_TASK));
    }

    @Override
    public Collection<Task> getAllTasks() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getTasks();
    }

    @Override
    public Collection<Task> getTasksByStatus(TaskStatus status) throws TaskManagerException {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
        for (Task task : ModelFacade.getInstance().getModel().getTasks()) {
            if (task.getStatus() == status) {
                priorityBlockingQueue.add(task);
            }
        }
        return priorityBlockingQueue;
    }

    @Override
    public Collection<Task> getTasksByProcessId(Long processId) throws TaskManagerException {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
        for (Task task : ModelFacade.getInstance().getModel().getTasks()) {
            if (task.getProcessId() == processId) {
                priorityBlockingQueue.add(task);
            }
        }
        return priorityBlockingQueue;
    }
}
