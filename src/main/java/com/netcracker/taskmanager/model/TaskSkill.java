package com.netcracker.taskmanager.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Class describes relation between skills and tasks with such properties as <b>taskId</b>,
 * <b>skillId</b>, <b>levelSkill</b>
 */
@XmlRootElement(name = "task_skill")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskSkill implements Serializable {
    /**
     * Task identifier
     */
    @XmlAttribute(name = "task_id")
    private long taskId;
    /**
     * Skill identifier
     */
    @XmlAttribute(name = "skill_id")
    private long skillId;
    /**
     * Level of skill
     */
    @XmlElement(name = "skill_level")
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
