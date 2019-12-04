package com.netcracker.taskmanager;

/**
 * Class describes generator identifier with such properties as <b>DEFAULT</b>,
 * <b>generatorId</b>, <>step</>
 */
public class IDGenerator {
    /**
     * Default identifier
     */
    private static final long DEFAULT = 1;
    /**
     * Generator identifier
     */
    private long generatorId;
    /**
     * Increase step
     */
    private int step;

    /**
     * Constructor creates new object with default value
     * @see IDGenerator#IDGenerator()
     */
    public IDGenerator(){
        generatorId = DEFAULT;
    }

    /**
     * Constructor creates new object with definite value
     * @param step
     */
    public IDGenerator(int step){
        this.step = step;
    }

    /**
     * Function receives value of field {@link IDGenerator#step}
     * @return step
     */
    public int getStep() {
        return step;
    }

    /**
     * Procedure defines value of field {@link IDGenerator#step}
     * @param step
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * Function receives value of field {@link IDGenerator#generatorId}
     * @return generatorId
     */
    public long getGeneratorId() {
        return generatorId;
    }
}
