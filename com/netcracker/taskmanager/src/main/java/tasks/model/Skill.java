package main.java.tasks.model;

public class Skill {
    private long skillID;
    private String nameSkill;
    private int minLevel;
    private int maxLevel;
    private String description;

    public long getSkillID() {
        return skillID;
    }

    public void setSkillID(long skillID) {
        this.skillID = skillID;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
