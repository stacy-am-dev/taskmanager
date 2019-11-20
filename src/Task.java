    import java.util.Date;

    public class Task {
        private String status; // enum Status
        private String id;
        private String description;
        private Date supposedTimeExecute;
        private Date actualTimeExecute;
        private Date startTime;
        private String type;
        private String employee;
        private int level;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Date getSupposedTimeExecute() {
            return supposedTimeExecute;
        }

        public void setSupposedTimeExecute(Date supposedTimeExecute) {
            this.supposedTimeExecute = supposedTimeExecute;
        }

        public Date getActualTimeExecute() {
            return actualTimeExecute;
        }

        public void setActualTimeExecute(Date actualTimeExecute) {
            this.actualTimeExecute = actualTimeExecute;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEmployee() {
            return employee;
        }

        public void setEmployee(String employee) {
            this.employee = employee;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
