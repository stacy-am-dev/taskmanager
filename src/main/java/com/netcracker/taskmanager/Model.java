package com.netcracker.taskmanager;

import com.netcracker.taskmanager.model.*;


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
    private Collection<TaskSkill> taskSkills;
    private Collection<TaskDependency> taskDependencies;

   public  Model() {
        employees = new ArrayList<>();
        processes = new ArrayList<>();
        skills = new ArrayList<>();
        tasks = new ArrayList<>();
        employeeSkills = new ArrayList<>();
        taskSkills = new ArrayList<>();
        taskDependencies = new ArrayList<>();
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

    public Collection<TaskSkill> getTaskSkills() {
        return taskSkills;
    }

    public void setTaskSkills(Collection<TaskSkill> taskSkills) {
        this.taskSkills = taskSkills;
    }

    public Collection<TaskDependency> getTaskDependencies() {
        return taskDependencies;
    }

    public void setTaskDependencies(Collection<TaskDependency> taskDependencies) {
        this.taskDependencies = taskDependencies;
    }

}
