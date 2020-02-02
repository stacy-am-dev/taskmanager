package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Employee;

import java.util.List;

public interface EmployeeControllerInterface{
    /**
     *Function creates and receives new employee
     */
    Employee createEmployee();
    /**
     *Function updates employee
     *@param employeeId
     *@param employee
     *@return Employee
     */
    Employee updateEmployee (Long employeeId, Employee employee);
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
    Employee getEmployee(Long employeeId);
    /**
     *Function receives employee
     *@param username
     *@return Employee
     */
    Employee getEmployee(String username);
    /**
     *Function receives list of employees
     *@return List<Employee>
     */
    List<Employee> getAllEmployees();
}
