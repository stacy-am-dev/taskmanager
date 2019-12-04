package com.netcracker.taskmanager.tasks.model;

public interface EmployeeProxyInterface {
    /*
     *Function receives value of employee's identifier
     *@return employeeId
     */
    Long getEmployeeId();
    /*
     *Procedure defines value of employee's identifier
     *@param employeeId
     */
    void setEmployeeId(long employeeId);

    /*
     *Function receives value of employee's username
     *@return username
     */
    String getUsername();

    /*
     *Procedure defines value employee's username
     *@param username
     */
    void setUsername(String username);

    /*
     *Function receives value of employee's password
     *@return password
     */
    String getPassword();

    /*
     *Procedure defines value of field employee's password
     *@param password
     */
    void setPassword(String password);

    /*
     *Function receives value of employee's name
     *      *@return firstName
     */
    String getFirstName();

    /*
     *Procedure defines value of employee's name
     *@param firstName
     */
    void setFirstName(String firstName);

    /*
     *Function receives value of employee's surname
     *@return lastName
     */
    String getLastName();

    /*
     *Procedure defines value of employee's surname
     *@param lastName
     */
    void setLastName(String lastName);

    /*
     *Function receives value of employee's email
     *@return email
     */
    String getEmail();

    /*
     *Procedure defines value of employee's email
     *@param email
     */
    void setEmail(String email) ;

}
