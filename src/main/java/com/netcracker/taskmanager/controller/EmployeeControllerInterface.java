package com.netcracker.taskmanager.controller;

import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Employee;
import com.netcracker.taskmanager.model.EmployeeSkill;
import com.netcracker.taskmanager.model.Task;

import java.util.Collection;

public interface EmployeeControllerInterface {
    /**
     *Function creates and receives employee
     *@param employee employee
     *@param employeeSkills skills of employee
     *@return Employee
     *@throws TaskManagerException if creating employee exception occurred
     */
    Employee createEmployee(Employee employee, Collection<EmployeeSkill> employeeSkills) throws TaskManagerException;
    /**
     *Function updates and receives employee
     *@param employee employee
     *@return Employee
     * @throws TaskManagerException if updating employee exception occurred
     */
    Employee updateEmployee(Employee employee) throws TaskManagerException;
    /**
     *Function updates and receives employee
     *@param employee employee
     *@param employeeSkills skills of employee
     *@return Employee
     *@throws TaskManagerException if updating employee exception occurred
     */
    Employee updateEmployee(Employee employee, Collection<EmployeeSkill> employeeSkills) throws TaskManagerException;
    /**
     *Procedure deletes employee by identifier
     *@param employeeId identifier of employee
     *@throws TaskManagerException if deleting employee exception occurred
     */
    void deleteEmployee(Long employeeId) throws TaskManagerException;
    /**
     *Procedure deletes employee
     *@param employee employee
     *@throws TaskManagerException if deleting employee exception occurred
     */
    void deleteEmployee(Employee employee) throws TaskManagerException;
    /**
     *Function receives employee by identifier
     *@param employeeId identifier of employee
     *@return Employee
     *@throws TaskManagerException if getting employee exception occurred
     */
    Employee getEmployeeByEmployeeId(Long employeeId) throws TaskManagerException;
    /**
     *Function receives employee by username
     *@param username username of employee
     *@return Employee
     *@throws TaskManagerException if getting employee exception occurred
     */
    Employee getEmployeeByUsername(String username) throws TaskManagerException;
    /**
     *Function receives collection of employees
     *@return Collection<Employee>
     *@throws TaskManagerException if getting employees exception occurred
     */
    Collection<Employee> getAllEmployees() throws TaskManagerException;
    /**
     *Function receives collection of employee's skills by employee's identifier
     *@param employeeId identifier of employee
     *@return Collection<EmployeeSkill>
     *@throws TaskManagerException if getting employee's skills exception occurred
     */
    Collection<EmployeeSkill> getEmployeeSkillsByEmployeeId(Long employeeId) throws TaskManagerException;

    Collection<EmployeeSkill> getAllEmployeeSkills() throws TaskManagerException;

    Long getAssigneeEmployeeId(Task task) throws TaskManagerException;
}
