package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Employee;
import com.netcracker.taskmanager.model.EmployeeSkill;

import java.util.Collection;

public interface EmployeeControllerInterface{
    /**
     *Function creates and receives employee
     *@param employee
     *@param employeeSkills
     *@return Employee
     */
    Employee createEmployee(Employee employee, Collection<EmployeeSkill> employeeSkills ) throws TaskManagerException;
    /**
     *Function updates and receives employee
     *@param employee
     *@return Employee
     */
    Employee updateEmployee ( Employee employee) throws TaskManagerException;
    /**
     *Function updates and receives employee
     *@param employee
     *@param employeeSkills
     *@return Employee
     */
    Employee updateEmployee ( Employee employee,Collection<EmployeeSkill> employeeSkills) throws TaskManagerException;
    /**
     *Procedure deletes employee by identifier
     *@param employeeId
     */
    void deleteEmployee(Long employeeId) throws TaskManagerException;
    /**
     *Procedure deletes employee
     *@param employee
     */
    void deleteEmployee(Employee employee) throws TaskManagerException;
    /**
     *Function receives employee by identifier
     *@param employeeId
     *@return Employee
     */
    Employee getEmployeeByEmployeeId(Long employeeId) throws TaskManagerException;
    /**
     *Function receives employee by username
     *@param username
     *@return Employee
     */
    Employee getEmployeeByUsername(String username) throws TaskManagerException;
    /**
     *Function receives list of employees
     *@return Collection<Employee>
     */
    Collection<Employee> getAllEmployees() throws TaskManagerException;
    /**
     *Function receives list of employee's skills by employee's identifier
     *@param employeeId
     *@return Collection<EmployeeSkill>
     */
    Collection<EmployeeSkill> getEmployeeSkillsByEmployeeId(Long employeeId);
}
