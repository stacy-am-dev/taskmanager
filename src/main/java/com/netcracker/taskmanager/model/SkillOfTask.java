package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class describes relation between skills and tasks with such properties as <b>taskId</b>,
 * <b>skillId</b>, <b>levelSkill</b>
 */
@XmlRootElement(name = "skillOfTask")
public class SkillOfTask {
    /**
     * Task identifier
     */
    @XmlAttribute
    private long taskId;
    /**
     * Skill identifier
     */
    private long skillId;
    /**
     * Level of skill
     */
    private int levelSkill;

    /**
     * Constructor creates new object
     */
    public SkillOfTask() {
    }

    /**
     * Function receives value of field {@link SkillOfTask#taskId}
     * @return taskId
     */
    public long getTaskId() {
        return taskId;
    }

    /**
     * Procedure defines value of field {@link SkillOfTask#taskId}
     * @param taskId
     */
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    /**
     * Function receives value of field {@link SkillOfTask#skillId}
     * @return skillId
     */
    public long getSkillId() {
        return skillId;
    }

    /**
     * Procedure defines value of field {@link SkillOfTask#skillId}
     * @param skillId
     */
    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    /**
     * Function receives value of field {@link SkillOfTask#levelSkill}
     * @return levelSkill
     */
    public int getLevelSkill() {
        return levelSkill;
    }

    /**
     * Procedure defines value of field {@link SkillOfTask#levelSkill}
     * @param levelSkill
     */
    public void setLevelSkill(int levelSkill) {
        this.levelSkill = levelSkill;
    }

}
