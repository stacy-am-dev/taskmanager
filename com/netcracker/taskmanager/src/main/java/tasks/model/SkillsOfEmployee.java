package main.java.tasks.model;

public class SkillsOfEmployee {
    private long employeeID;
    private long skillID;
    private int levelSkill;

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getSkillID() {
        return skillID;
    }

    public void setSkillID(long skillID) {
        this.skillID = skillID;
    }

    public int getLevelSkill() {
        return levelSkill;
    }

    public void setLevelSkill(int levelSkill) {
        this.levelSkill = levelSkill;
    }
}
