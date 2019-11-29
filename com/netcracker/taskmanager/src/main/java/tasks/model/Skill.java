package main.java.tasks.model;

/*
 *Class describes skills of employees with such properties as <b>skillId</b>,
 * <b>skillName</b>, <b>minLevel</b>, <b>maxLevel</b>, <b>skillDescription</b>.
 * @version 1.0
 */
public class Skill {
    /**
     * Identifier of skill
     */
    private Long skillId;
    /**
     * Name of skill
     */
    private String skillName;
    /**
     * Minimal level of skill
     */
    private int minLevel;
    /**
     * Maximal level of skill
     */
    private int maxLevel;
    /**
     * Description of skill
     */
    private String skillDescription;

    /*
     *Constructor creates new object with definite values
     * @param skillId - ID of skill
     * @param skillName - name of skill
     * @param minLevel - minimal level of skill
     * @param maxLevel - maximal level of skill
     * @see Skill#Skill()
     */
    public Skill(Long skillId, String skillName, int min, int max) {
        this.skillId = skillId;
        this.skillName = skillName;
        minLevel = min;
        maxLevel = max;
    }

    /*
     *Constructor creates new object
     * @see Skill#Skill(Long, String, int, int)
     */
    public Skill() {
    }
    /*
     *Function receives value of field {@link Skill#skillId}
     *@return skillId
     */
    public Long getSkillId() {
        return skillId;
    }
    /*
     *Procedure defines value of field {@link Skill#skillId}
     *@param skillId
     */
    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    /*
     *Function receives value of field {@link Skill#skillName}
     *@return skillName
     */
    public String getSkillName() {
        return skillName;
    }

    /*
     *Procedure defines value of field {@link Skill#skillName}
     *@param skillName
     */
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    /*
     *Function receives value of field {@link Skill#minLevel}
     *@return minLevel
     */
    public int getMinLevel() {
        return minLevel;
    }

    /*
     *Procedure defines value of field {@link Skill#minLevel}
     *@param minLevel
     */
    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    /*
     *Function receives value of field {@link Skill#maxLevel}
     *@return maxLevel
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /*
     *Procedure defines value of field {@link Skill#maxLevel}
     *@param maxLevel
     */
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    /*
     *Function receives value of field {@link Skill#skillDescription}
     *@return skillDescription
     */
    public String getSkillDescription() {
        return skillDescription;
    }

    /*
     *Procedure defines value of field {@link Skill#skillDescription}
     *@param skillDescription
     */
    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }
}
