package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.SkillControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Skill;
import com.netcracker.taskmanager.util.IDGenerator;

import java.util.Collection;

public class SkillController implements SkillControllerInterface {
    @Override
    public Skill createSkill(Skill skill) throws TaskManagerException {
        if(skill.getMaxLevel() > skill.getMinLevel()) {
            IDGenerator idGenerator = new IDGenerator();
            skill.setSkillId(idGenerator.generate());
            return skill;
        }
        else
            throw new TaskManagerException(new Throwable(""), 345);
    }

    @Override
    public Skill updateSkill(Skill skill) throws TaskManagerException {
        return null;
    }

    @Override
    public void deleteSkill(Long skillId) throws TaskManagerException {

    }

    @Override
    public void deleteSkill(Skill skill) throws TaskManagerException {

    }

    @Override
    public Skill getSkillById(Long skillId) throws TaskManagerException {
        return null;
    }

    @Override
    public Skill getSkillByName(String skillName) throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<Skill> getSkillsByName(String skillName) throws TaskManagerException {
        return null;
    }

    @Override
    public Collection<Skill> getAllSkill() throws TaskManagerException {
        return null;
    }
}
