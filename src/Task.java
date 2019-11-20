import java.time.LocalTime;

public class Task {
    private long status; // enum Status
    private long id;
    private long description;
    private LocalTime supposedTimeExecute;
    private LocalTime actualTimeExecute;
    private LocalTime startTime;
    private long type;
    private long employee;
    private int level;

    public Task(){}

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDescription() {
        return description;
    }

    public void setDescription(long description) {
        this.description = description;
    }

    public LocalTime getSupposedTimeExecute() {
        return supposedTimeExecute;
    }

    public void setSupposedTimeExecute(LocalTime supposedTimeExecute) {
        this.supposedTimeExecute = supposedTimeExecute;
    }

    public LocalTime getActualTimeExecute() {
        return actualTimeExecute;
    }

    public void setActualTimeExecute(LocalTime actualTimeExecute) {
        this.actualTimeExecute = actualTimeExecute;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
