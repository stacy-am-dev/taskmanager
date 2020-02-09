package com.netcracker.taskmanager.model;

import java.util.HashMap;

public class ProcessTemplate {
    private String name;
    private String description;
    private HashMap<String, String> parameters;

    ProcessTemplate() {
    }
    ProcessTemplate(String name, String description) {
        this.setDescription(description);
        this.setName(name);
        this.addParameter("First","1");
        this.addParameter("Second","2");
    }
    ProcessTemplate(String name, String description, HashMap<String, String> parameters) {
        this.setDescription(description);
        this.setName(name);
        this.addParameter("First","1");
        this.addParameter("Second","2");
        this.parameters.putAll(parameters);
    }

    public Process createProcessFromTemplate() {
        Process process = new Process(getParameters());

        return process;
    }
    public void changeParameter(String key, String value) {
        parameters.replace(key, value);
    }

    public void changeFirstParameter(String value)
    {
        parameters.replace("First", value);
    }
    public void changeSecondParameter(String value)
    {
        parameters.replace("Second", value);
    }

    public void addParameter(String key, String value) {
        parameters.put(key, value);
    }

    public void removeParameter(String key) {
        parameters.remove(key);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}