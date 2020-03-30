package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.SkillControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Skill;
import com.netcracker.taskmanager.util.ModelFacade;

import java.util.Collection;

public class SkillController implements SkillControllerInterface {
    @Override
    public Skill createSkill(Skill skill) throws TaskManagerException {
        if (skill.getMaxLevel() < skill.getMinLevel())
            throw new TaskManagerException(new Throwable(""), 345);
        else {
            skill.setSkillId(ModelFacade.getInstance().getModel().getIdGenerator().generate());
            return skill;
        }
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
        Skill skillResult = ModelFacade.getInstance().getModel().getSkills().stream()
                .filter(skill -> skill.getSkillId().equals(skillId))
                .findAny()
                .orElse(null);
        if (skillResult == null)
            throw new TaskManagerException(new Throwable("Not found"), 404);
        else return skillResult;
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
