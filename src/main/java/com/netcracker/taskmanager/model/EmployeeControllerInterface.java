package com.netcracker.taskmanager.model;

import com.netcracker.taskmanager.exception.NoSuchEmployee;
import com.netcracker.taskmanager.exception.TaskManagerException;

import java.util.List;

public interface EmployeeControllerInterface{
    /*
     *Procedure creates new employee
     */
    Employee createEmployee();
    /*
     *Procedure updates employee
     *@param employeeId
     *@param employee
     */
    Employee updateEmployee (Long employeeId, Employee employee);
    /*
     *Procedure deletes employee
     *@param employeeId
     */
    void deleteEmployee(Long employeeId) throws TaskManagerException;
    /*
     *Function receives employee
     *@param employeeId
     *@return employee
     */
    void deleteEmployee(Employee employee) throws TaskManagerException;
    /*
     *Function receives employee
     *@param employeeId
     *@return employee
     */
    Employee getEmployee(Long employeeId);

    Employee getEmployee(String username);

    List<Employee> getAllEmployees();
}
