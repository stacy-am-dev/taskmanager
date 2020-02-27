package com.netcracker.taskmanager.util;

import com.netcracker.taskmanager.model.*;
import com.netcracker.taskmanager.model.Process;


import java.util.*;

public class Model {

    private Map<Employee, IDGenerator> employees;
    private Map<Process, IDGenerator> processes;
    private Map<Skill, IDGenerator> skills;
    private Map<Task, IDGenerator> tasks;
    private Collection<EmployeeSkill> employeeSkills;
    private Collection<TaskSkill> taskSkills;
    private Collection<TaskDependency> taskDependencies;
    private Map<TaskTemplate, IDGenerator> taskTemplates;
    private Map<ProcessTemplate, IDGenerator> processTemplates;


    public Model() {
        employees = new HashMap<>();
        processes = new HashMap<>();
        skills = new HashMap<>();
        tasks = new HashMap<>();
        employeeSkills = new ArrayList<>();
        taskSkills = new ArrayList<>();
        taskDependencies = new ArrayList<>();
        taskTemplates = new HashMap<>();
        processTemplates = new HashMap<>();
    }

    public Map<Employee, IDGenerator> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Employee, IDGenerator> employees) {
        this.employees = employees;
    }

    public Map<Process, IDGenerator> getProcesses() {
        return processes;
    }

    public void setProcesses(Map<Process, IDGenerator> processes) {
        this.processes = processes;
    }

    public Map<Skill, IDGenerator> getSkills() {
        return skills;
    }

    public void setSkills(Map<Skill, IDGenerator> skills) {
        this.skills = skills;
    }

    public Map<Task, IDGenerator> getTasks() {
        return tasks;
    }

    public void setTasks(Map<Task, IDGenerator> tasks) {
        this.tasks = tasks;
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

    public Map<TaskTemplate, IDGenerator> getTaskTemplates() {
        return taskTemplates;
    }

    public void setTaskTemplates(Map<TaskTemplate, IDGenerator> taskTemplates) {
        this.taskTemplates = taskTemplates;
    }

    public Map<ProcessTemplate, IDGenerator> getProcessTemplates() {
        return processTemplates;
    }

    public void setProcessTemplates(Map<ProcessTemplate, IDGenerator> processTemplates) {
        this.processTemplates = processTemplates;
    }
}