package com.netcracker.taskmanager.model;

public interface EmployeeProxy{
    /*
     *Procedure creates new employee
     */
    void createEmployee();
    /*
     *Procedure updates employee
     *@param employeeId
     *@param employee
     */
    void updateEmployee (Long employeeId, Employee employee);
    /*
     *Procedure deletes employee
     *@param employeeId
     */
    void deleteEmployee(Long employeeId);
    /*
     *Function receives employee
     *@param employeeId
     *@return employee
     */
    Employee getEmployee(Long employeeId);
}
