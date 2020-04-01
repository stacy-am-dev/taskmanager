package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.SkillControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Skill;
import com.netcracker.taskmanager.util.Model;
import com.netcracker.taskmanager.util.ModelFacade;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.netcracker.taskmanager.Constants.*;

public class SkillController implements SkillControllerInterface {
    private Model getModel = ModelFacade.getInstance().getModel();

    @Override
    public Skill createSkill(Skill skill) throws TaskManagerException {
        if (skill.getMaxLevel() < skill.getMinLevel())
            throw new TaskManagerException(new Throwable(""), MAX_AND_MIN_LEVEL_OF_SKILL_INCORRECT);
        else {
            skill.setSkillId(getModel.getMatchMap().get(Skill.class).generate());
            getModel.getSkills().add(skill);
            return skill;
        }
    }

    @Override
    public Skill updateSkill(Skill skill) throws TaskManagerException {
        if(skill.getMaxLevel() < skill.getMinLevel())
            throw new TaskManagerException(new Throwable(""), MAX_AND_MIN_LEVEL_OF_SKILL_INCORRECT);
        else {
            getModel.getSkills().removeIf(skill1 -> skill1.getSkillId().equals(skill.getSkillId()));
            getModel.getSkills().add(skill);
            return skill;
        }
    }

    @Override
    public void deleteSkill(Long skillId) throws TaskManagerException {
        if(skillId == null)
            throw new TaskManagerException(new Throwable(""), NO_SUCH_IDENTIFIER_OF_SKILL);
        else {
            getModel.getSkills().removeIf(skill -> skill.getSkillId().equals(skillId));
        }
    }

    @Override
    public void deleteSkill(Skill skill) throws TaskManagerException {
        if(skill.getMaxLevel() < skill.getMinLevel())
            throw  new TaskManagerException(new Throwable(""), MAX_AND_MIN_LEVEL_OF_SKILL_INCORRECT);
        else {
            getModel.getSkills().removeIf(skill1 -> skill1.equals(skill));
        }
    }

    @Override
    public Skill getSkillById(Long skillId) throws TaskManagerException {
        Skill skillResult = getModel.getSkills().stream()
                .filter(skill -> skill.getSkillId().equals(skillId))
                .findAny()
                .orElse(null);
        if (skillResult == null)
            throw new TaskManagerException(new Throwable(""), NO_SUCH_SKILL);
        else return skillResult;
    }

    @Override
    public Skill getSkillByName(String skillName) throws TaskManagerException {
        Skill skillResult = getModel.getSkills().stream()
                .filter(skill -> skill.getSkillName().equals(skillName))
                .findAny()
                .orElse(null);
        if (skillResult == null)
            throw new TaskManagerException(new Throwable(""), NO_SUCH_SKILL);
        else return skillResult;
    }

    @Override
    public Collection<Skill> getSkillsByName(String skillName) throws TaskManagerException {
        return getModel.getSkills().stream()
                .filter(skill -> skill.getSkillName().equals(skillName))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Skill> getAllSkill() throws TaskManagerException {
        return getModel.getSkills();
    }
}
