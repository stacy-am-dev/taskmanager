package com.netcracker.taskmanager;

import com.netcracker.taskmanager.model.*;
import com.netcracker.taskmanager.tasks.model.SkillOfTask;


import java.lang.Process;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
//
    private Collection<Employee> employees;
    private Collection<Process> processes;
    private Collection<Skill> skills;
    private Collection<Task> tasks;
    private Collection<EmployeeSkill> employeeSkills;
    private Collection<SkillOfTask> skillOfTasks;
    private Collection<TaskDependencies> taskDependencies;

    Model() {
        employees = new ArrayList<>();
        processes = new ArrayList<>();
        skills = new ArrayList<>();
        tasks = new ArrayList<>();
        employeeSkills = new ArrayList<>();
        skillOfTasks = new ArrayList<>();
        taskDependencies = new ArrayList<>();
    }

    public Model(ArrayList<Employee> employees, ArrayList<Process> processes, ArrayList<Skill> skills,
                 ArrayList<Task> tasks, ArrayList<EmployeeSkill> employeeSkills, ArrayList<SkillOfTask> skillOfTasks,
                 ArrayList<TaskDependencies> taskDependencies) {
        this.employees = employees;
        this.processes = processes;
        this.skills = skills;
        this.tasks = tasks;
        this.employeeSkills = employeeSkills;
        this.skillOfTasks = skillOfTasks;
        this.taskDependencies = taskDependencies;
    }

    public Collection<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(Collection<Process> processes) {
        this.processes = processes;
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public Collection<EmployeeSkill> getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(Collection<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public Collection<SkillOfTask> getSkillOfTasks() {
        return skillOfTasks;
    }

    public void setSkillOfTasks(Collection<SkillOfTask> skillOfTasks) {
        this.skillOfTasks = skillOfTasks;
    }

    public Collection<TaskDependencies> getTaskDependencies() {
        return taskDependencies;
    }

    public void setTaskDependencies(Collection<TaskDependencies> taskDependencies) {
        this.taskDependencies = taskDependencies;
    }

}
