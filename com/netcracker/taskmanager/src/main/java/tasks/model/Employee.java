package main.java.tasks.model;

/*
 *Class describes  employees with such properties as <b>employeeId</b>,
 * <b>email</b>, <b>username</b>, <b>password</b>, <b>firstName</b>, <b>lastName</b>.
 * @version 1.0
 */
public class Employee {
    /**
     * Employee's identifier
     */
    private Long employeeId;
    /**
     * Employee's username
     */
    private String username;
    /**
     * Employee's password
     */
    private String password;
    /**
     * Employee's name
     */
    private String firstName;
    /**
     * Employee's surname
     */
    private String lastName;
    /**
     * Employee's email
     */
    private String email;

    /*
     *Constructor creates new object
     * @see Employee#Employee(String, String)
     */
    public Employee() {
    }

    /*
     *Constructor creates new object with definite values
     * @param firstName - name of employee
     * @param lastName - surname of employee
     * @see Employee#Employee()
     */
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
     *Function receives value of field {@link Employee#employeeId}
     *@return employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /*
     *Procedure defines value of field {@link Employee#employeeId}
     *@param employeeId
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    /*
     *Function receives value of field {@link Employee#username}
     *@return username
     */
    public String getUsername() {
        return username;
    }

    /*
     *Procedure defines value of field {@link Employee#username}
     *@param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /*
     *Function receives value of field {@link Employee#password}
     *@return password
     */
    public String getPassword() {
        return password;
    }

    /*
     *Procedure defines value of field {@link Employee#password}
     *@param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     *Function receives value of field {@link Employee#firstName}
     *@return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /*
     *Procedure defines value of field {@link Employee#firstName}
     *@param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
     *Function receives value of field {@link Employee#LastName}
     *@return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /*
     *Procedure defines value of field {@link Employee#lastName}
     *@param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     *Function receives value of field {@link Employee#email}
     *@return email
     */
    public String getEmail() {
        return email;
    }

    /*
     *Procedure defines value of field {@link Employee#email}
     *@param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
