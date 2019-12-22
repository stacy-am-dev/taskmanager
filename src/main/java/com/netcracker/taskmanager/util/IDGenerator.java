package com.netcracker.taskmanager.util;

/**
 * Class describes generator identifier with such properties as <b>last</b>, <b>step</b>
 */
public class IDGenerator {
    /**
     * Last identifier
     */
    private long last;

    /**
     * Increase step
     */
    private long step;

    /**
     * Constructor creates new object
     * @see IDGenerator#IDGenerator()
     */
    public IDGenerator(){
        this(1, 1);
    }

    /**
     * Constructor creates new object with definite value
     * @param last
     * @param step
     */
    public IDGenerator(long last, long step){
        this.last = last;
        this.step = step;
    }

    /**
     * Function receives value of field {@link IDGenerator#step}
     * @return step
     */
    public long getStep() {
        return step;
    }

    /**
     * Procedure defines value of field {@link IDGenerator#step}
     * @param step
     */
    public void setStep(long step) {
        this.step = step;
    }

    /**
     * Function receives value of field {@link IDGenerator#last}
     * @return last
     */
    public long getLast(){
        return last;
    }

    /**
     * Procedure defines value of field {@link IDGenerator#last}
     * @param last
     */
    public void setLast(long last) {
        this.last = last;
    }

    /**
     * Function returns new value of last identifier
     * @param step
     * @return last
     */
    public long generate(long step){
        return this.last += step;
    }
}
