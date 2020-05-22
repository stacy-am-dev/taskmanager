package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.SkillControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Skill;
import com.netcracker.taskmanager.util.ModelFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.netcracker.taskmanager.Constants.FIELDS_OF_SKILL_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_SKILL;

public class SkillController implements SkillControllerInterface {

    @Autowired
    private ModelFacade modelFacade;

    @Override
    public Skill createSkill(Skill skill) throws TaskManagerException {
        if ((skill.getMaxLevel() < skill.getMinLevel()) || (ModelFacade.getInstance().getModel().getSkills().stream().anyMatch(skill1 -> skill1.getSkillName().equals(skill.getSkillName()))))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_SKILL_INCORRECT);
        skill.setSkillId(ModelFacade.getInstance().getModel().getMatchMap().get(Skill.class).generate());
        ModelFacade.getInstance().getModel().getSkills().add(skill);
        return skill;
    }

    @Override
    public Skill updateSkill(Skill skill) throws TaskManagerException {
        if((skill.getMaxLevel() < skill.getMinLevel()) || (ModelFacade.getInstance().getModel().getSkills().stream().anyMatch(skill1 -> skill1.getSkillName().equals(skill.getSkillName()))))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_SKILL_INCORRECT);
        return ModelFacade.getInstance().getModel().getSkills().stream()
                .filter(skill1 -> skill1.getSkillId() == skill.getSkillId())
                .peek(skill1 -> skill1 = skill)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_SKILL));
    }

    @Override
    public void deleteSkill(Long skillId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getSkills().removeIf(skill -> skill.getSkillId() == skillId);
    }

    @Override
    public void deleteSkill(Skill skill) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getSkills().remove(skill);
    }

    @Override
    public Skill getSkillById(Long skillId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getSkills().stream()
                .filter(skill -> skill.getSkillId() == skillId)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_SKILL));
    }

    @Override
    public Skill getSkillByName(String skillName) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getSkills().stream()
                .filter(skill -> skill.getSkillName().equals(skillName))
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_SKILL));
    }

    @Override
    public Collection<Skill> getSkillsByName(String skillName) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getSkills().stream()
                .filter(skill -> skill.getSkillName().contains(skillName))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Skill> getAllSkill() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getSkills();
    }
}
