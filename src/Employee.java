import java.util.HashMap;

public class Employee {
    private long employeeID;
    private String firstName;
    private String lastName;
    private HashMap<Skill, Integer> EmployeeSkill;

    public Employee() {}
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void deleteSkill(Skill skill) {
      EmployeeSkill.remove(skill);
    }

    public void addSkill(Skill skill, int level) {
        EmployeeSkill.put(skill,level);
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
