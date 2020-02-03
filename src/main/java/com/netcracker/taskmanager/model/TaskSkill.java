package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class describes relation between skills and tasks with such properties as <b>taskId</b>,
 * <b>skillId</b>, <b>levelSkill</b>
 */
@XmlRootElement(name = "skillOfTask")
public class TaskSkill {
    /**
     * Task identifier
     */
    @XmlAttribute(name = "taskId")
    private long taskId;
    /**
     * Skill identifier
     */
    @XmlAttribute(name = "skillId")
    private long skillId;
    /**
     * Level of skill
     */
    @XmlElement
    private int levelSkill;

    /**
     * Constructor creates new object
     */
    public TaskSkill() {
    }

    /**
     * Function receives value of field {@link TaskSkill#taskId}
     * @return taskId
     */
    public long getTaskId() {
        return taskId;
    }

    /**
     * Procedure defines value of field {@link TaskSkill#taskId}
     * @param taskId
     */
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    /**
     * Function receives value of field {@link TaskSkill#skillId}
     * @return skillId
     */
    public long getSkillId() {
        return skillId;
    }

    /**
     * Procedure defines value of field {@link TaskSkill#skillId}
     * @param skillId
     */
    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    /**
     * Function receives value of field {@link TaskSkill#levelSkill}
     * @return levelSkill
     */
    public int getLevelSkill() {
        return levelSkill;
    }

    /**
     * Procedure defines value of field {@link TaskSkill#levelSkill}
     * @param levelSkill
     */
    public void setLevelSkill(int levelSkill) {
        this.levelSkill = levelSkill;
    }

}
