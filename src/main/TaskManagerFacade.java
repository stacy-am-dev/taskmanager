package main;

import com.netcracker.taskmanager.tasks.model.Employee;
import com.netcracker.taskmanager.tasks.model.ProcessStatus;
import com.netcracker.taskmanager.tasks.model.Task;
import com.netcracker.taskmanager.tasks.model.Process;


import java.time.LocalDateTime;

public class TaskManagerFacade {

    public LocalDateTime generate(Task task){
        Employee employee = new Employee();
        Process process = new Process();
        process.setStatus(ProcessStatus.PLANNING);
        if(employee.getSkill().getSkillDescription().equals(task.getDescription())){
            process.setStatus(ProcessStatus.PLANNED);
            process.setEmployee(employee);
            process.setStatus(ProcessStatus.IN_PROGRESS);
            //process.setStartDate();

        }
        else{
            process.setStatus(ProcessStatus.ERROR);
        }
        return process.getEndDate();
    }
}

