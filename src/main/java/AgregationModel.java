import com.netcracker.taskmanager.model.Employee;
import com.netcracker.taskmanager.model.Skill;
import com.netcracker.taskmanager.model.Task;

import java.util.ArrayList;

public class AgregationModel {

    private ArrayList<Employee> employeeArrayList;
    private ArrayList<Process> processArrayList;
    private ArrayList<Skill> skillArrayList;
    private ArrayList<Task> taskArrayList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    public ArrayList<Process> getProcessArrayList() {
        return processArrayList;
    }

    public void setProcessArrayList(ArrayList<Process> processArrayList) {
        this.processArrayList = processArrayList;
    }

    public ArrayList<Skill> getSkillArrayList() {
        return skillArrayList;
    }

    public void setSkillArrayList(ArrayList<Skill> skillArrayList) {
        this.skillArrayList = skillArrayList;
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }
}
