package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Employee;

import java.util.List;

public interface EmployeeControllerInterface{
    /**
     *Function creates and receives new employee
     */
    Employee createEmployee(Employee employee) throws TaskManagerException;
    /**
     *Function updates employee
     *@param employeeId
     *@param employee
     *@return Employee
     */
    Employee updateEmployee (Long employeeId, Employee employee) throws TaskManagerException;
    /**
     *Procedure deletes employee
     *@param employeeId
     */
    void deleteEmployeeByEmployeeTd(Long employeeId) throws TaskManagerException;
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
     *Function receives employee
     *@param email
     *@return Employee
     */
    Employee getEmployeeByEmail(String email) throws TaskManagerException;
    /**
     *Function receives list of employees
     *@return List<Employee>
     */
    List<Employee> getAllEmployees() throws TaskManagerException;
}
