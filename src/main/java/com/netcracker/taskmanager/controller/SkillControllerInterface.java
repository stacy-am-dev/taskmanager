package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Skill;

import java.util.List;

public interface SkillControllerInterface {

    /**
     * Function creates new skill
     */
    Skill createSkill();

    /**
     * Function update skill
     * @param skillId
     * @param skill
     * @return Skill
     */
    Skill updateSkill(Long skillId, Skill skill);

    /**
     * Function delete skill
     * @param skillId
     * @throws TaskManagerException
     */
    void deleteSkill(Long skillId) throws TaskManagerException;

    /**
     * Function delete skill
     * @param skill
     * @throws TaskManagerException
     */
    void deleteSkill(Skill skill) throws TaskManagerException;

    /**
     * Function receives skill
     * @param skillId
     * @return Skill
     */
    Skill getSkill(Long skillId);

    /**
     * Function receives skill
     * @param skillName
     * @return Skill
     */
    Skill getSkill(String skillName);

    /**
     * Function receives list of skills
     * @return List<Skill>
     */
    List<Skill> getAllSkill();
}
