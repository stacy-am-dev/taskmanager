import java.time.LocalDateTime;

public class Process {
    ArrayList <String> tasks=new ArrayList<>();
    private long id;
    private String description;
    private LocalDateTime supposedTimeExecute;
    private LocalDateTime actualTimeExecute;
    private LocalDateTime startTime;
    public Process(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSupposedTimeExecute() {
        return supposedTimeExecute;
    }

    public void setSupposedTimeExecute(LocalDateTime supposedTimeExecute) {
        this.supposedTimeExecute = supposedTimeExecute;
    }

    public LocalDateTime getActualTimeExecute() {
        return actualTimeExecute;
    }

    public void setActualTimeExecute(LocalDateTime actualTimeExecute) {
        this.actualTimeExecute = actualTimeExecute;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public void saveToFile(OutputStream out){

    }
    public void upload(InputStram out){

    }
}