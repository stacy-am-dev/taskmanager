package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Skill;

import java.util.Collection;

public interface SkillControllerInterface {

    /**
     * Function creates new skill
     * @param skill
     * @return Skill
     */
    Skill createSkill(Skill skill) throws TaskManagerException;

    /**
     * Function update skill
     * @param skill
     * @return Skill
     */
    Skill updateSkill(Skill skill) throws TaskManagerException;

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
    Skill getSkillById(Long skillId) throws TaskManagerException;

    /**
     * Function receives skill
     * @param skillName
     * @return Skill
     */
    Skill getSkillByName(String skillName) throws TaskManagerException;

    /**
     * Function receives skill
     * @param skillName
     * @return Collection
     * @throws TaskManagerException
     */
    Collection getSkillsByName(String skillName) throws TaskManagerException;

    /**
     * Function receives list of skills
     * @return Collection
     */
    Collection getAllSkill() throws TaskManagerException;
}
