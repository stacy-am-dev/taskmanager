package com.netcracker.taskmanager.tasks.model;


public class SkillOfTask {
    private long idTask;
    private long idSkill;
    private int levelSkill;

    public SkillOfTask(){}

    public long getIdTask() {
        return idTask;
    }

    public void setIdTask(long idTask) {
        this.idTask = idTask;
    }

    public long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(long idSkill) {
        this.idSkill = idSkill;
    }

    public int getLevelSkill() {
        return levelSkill;
    }

    public void setLevelSkill(int levelSkill) {
        this.levelSkill = levelSkill;
    }
}