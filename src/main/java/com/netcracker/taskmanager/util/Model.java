package com.netcracker.taskmanager.util;

import com.netcracker.taskmanager.model.Process;
import com.netcracker.taskmanager.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private Collection<Employee> employees;
    private Collection<Process> processes;
    private Collection<Skill> skills;
    private Collection<Task> tasks;
    private Collection<EmployeeSkill> employeeSkills;
    private Collection<TaskSkill> taskSkills;
    private Collection<TaskDependency> taskDependencies;
    private Collection<TaskTemplate> taskTemplates;
    private Collection<ProcessTemplate> processTemplates;
    private Collection<TaskTemplateRule> taskTemplateRules;
    private Collection<ProcessTemplateRule> processTemplateRules;
    private Map<Class, IDGenerator> matchMap;
    private IDGenerator idGenerator;

    public Model() {
        employees = new ArrayList<>();
        processes = new ArrayList<>();
        skills = new ArrayList<>();
        tasks = new ArrayList<>();
        employeeSkills = new ArrayList<>();
        taskSkills = new ArrayList<>();
        taskDependencies = new ArrayList<>();
        taskTemplates = new ArrayList<>();
        processTemplates = new ArrayList<>();
        taskTemplateRules = new ArrayList<>();
        processTemplateRules = new ArrayList<>();
        idGenerator = new IDGenerator();
        matchMap = new HashMap<>();
        matchMap.put(Employee.class, new IDGenerator());
        matchMap.put(Process.class, new IDGenerator());
        matchMap.put(Skill.class, new IDGenerator());
        matchMap.put(Task.class, new IDGenerator());
        matchMap.put(TaskTemplate.class, new IDGenerator());
        matchMap.put(ProcessTemplate.class, new IDGenerator());
        matchMap.put(TaskTemplateRule.class, new IDGenerator());
        matchMap.put(ProcessTemplateRule.class, new IDGenerator());

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

    public Collection<TaskTemplate> getTaskTemplates() {
        return taskTemplates;
    }

    public void setTaskTemplates(Collection<TaskTemplate> taskTemplates) {
        this.taskTemplates = taskTemplates;
    }

    public Collection<ProcessTemplate> getProcessTemplates() {
        return processTemplates;
    }

    public void setProcessTemplates(Collection<ProcessTemplate> processTemplates) {
        this.processTemplates = processTemplates;
    }

    public Collection<TaskTemplateRule> getTaskTemplateRules() {
        return taskTemplateRules;
    }

    public void setTaskTemplateRules(Collection<TaskTemplateRule> taskTemplateRules) {
        this.taskTemplateRules = taskTemplateRules;
    }

    public Collection<ProcessTemplateRule> getProcessTemplateRules() {
        return processTemplateRules;
    }

    public void setProcessTemplateRules(Collection<ProcessTemplateRule> processTemplateRules) {
        this.processTemplateRules = processTemplateRules;
    }

    public Map<Class, IDGenerator> getMatchMap() {
        return matchMap;
    }

    public void setMatchMap(Map<Class, IDGenerator> matchMap) {
        this.matchMap = matchMap;
    }

    public IDGenerator getIdGenerator() {
        return idGenerator;
    }
}
