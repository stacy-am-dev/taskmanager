package com.netcracker.taskmanager.model;

public interface SkillProxy {
    /**
     * Function receives value of skill's identifier
     * @return skillID
     */
    long getSkillId();

    /**
     * Procedure defines value of skill's identifier
     * @param skillId
     */
    void setSkillId(long skillId);

    /**
     * Function receives value of skill's name
     * @return skillName
     */
    String getSkillName();

    /**
     * Procedure defines value of skill's name
     * @param skillName
     */
    void setSkillName(String skillName);

    /**
     * Function receives value of skill's minimum level
     * @return minLevel
     */
    int getMinLevel();

    /**
     * Procedure defines value of skill's minimum level
     * @param minLevel
     */
    void setMinLevel(int minLevel);

    /**
     * Function receives value of skill's maximum level
     * @return msxLevel
     */
    int getMaxLevel();

    /**
     * Procedure defines value of skill's maximum level
     * @param maxLevel
     */
    void setMaxLevel(int maxLevel);

    /**
     * Function receives value of skill's description
     * @return skillDescription
     */
    String getSkillDescription();

    /**
     * Procedure defines value of skill's description
     * @param skillDescription
     */
    void setSkillDescription(String skillDescription);

    /**
     * Function receives value of skill
     * @return skill
     */
    Skill getSkill();

    /**
     * Procedure defines value of skill
     * @param skillId
     * @param newSkill
     */
    void setSkill(long skillId, Skill newSkill);

    /**
     * Function creates skill
     */
    void createSkill();

    /**
     * Function add skill
     * @param skillId
     * @param newSkill
     */
    void addSkill(long skillId, Skill newSkill);

    /**
     * Function delete skill
     * @param skillId
     */
    void deleteSkill(long skillId);

}
