package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Employee;

import java.util.Collection;

public interface EmployeeControllerInterface{
    /**
     *Function creates and receives new employee
     */
    Employee createEmployee(Employee employee) throws TaskManagerException;
    /**
     *Function updates employee
     *@param employee
     *@return Employee
     */
    Employee updateEmployee ( Employee employee) throws TaskManagerException;
    /**
     *Procedure deletes employee
     *@param employeeId
     */
    void deleteEmployee(Long employeeId) throws TaskManagerException;
    /**
     *Procedure deletes employee
     *@param employee
     */
    void deleteEmployee(Employee employee) throws TaskManagerException;
    /**
     *Function receives employee
     *@param employeeId
     *@return Employee
     */
    Employee getEmployeeByEmployeeId(Long employeeId) throws TaskManagerException;
    /**
     *Function receives employee
     *@param username
     *@return Employee
     */
    Employee getEmployeeByUsername(String username) throws TaskManagerException;
    /**
     *Function receives list of employees
     *@return List<Employee>
     */
    Collection<Employee> getAllEmployees() throws TaskManagerException;
}
