package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.EmployeeControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Employee;
import com.netcracker.taskmanager.model.EmployeeSkill;
import com.netcracker.taskmanager.util.ModelFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.netcracker.taskmanager.Constants.FIELDS_OF_EMPLOYEE_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_EMPLOYEE;

public class EmployeeController implements EmployeeControllerInterface {

    @Autowired
    private ModelFacade modelFacade;

    @Override
    public Employee createEmployee(Employee employee, Collection<EmployeeSkill> employeeSkills) throws TaskManagerException {
        if (ModelFacade.getInstance().getModel().getEmployees().stream().anyMatch(employee1 -> employee1.getEmail().equals(employee.getEmail()))
                || ModelFacade.getInstance().getModel().getEmployees().stream().anyMatch(employee1 -> employee1.getUsername().equals(employee.getUsername())))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_EMPLOYEE_INCORRECT);
        employee.setEmployeeId(ModelFacade.getInstance().getModel().getMatchMap().get(Employee.class).generate());
        employeeSkills.stream()
                .peek(employeeSkill -> employeeSkill.setEmployeeId(employee.getEmployeeId()));
        ModelFacade.getInstance().getModel().getEmployees().add(employee);
        ModelFacade.getInstance().getModel().getEmployeeSkills().addAll(employeeSkills);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) throws TaskManagerException {
        if (ModelFacade.getInstance().getModel().getEmployees().stream().anyMatch(employee1 -> employee1.getEmail().equals(employee.getEmail()))
                || ModelFacade.getInstance().getModel().getEmployees().stream().anyMatch(employee1 -> employee1.getUsername().equals(employee.getUsername())))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_EMPLOYEE_INCORRECT);
        return ModelFacade.getInstance().getModel().getEmployees().stream()
                .filter(employee1 -> employee1.getEmployeeId() == employee.getEmployeeId())
                .peek(employee1 -> employee1 = employee)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_EMPLOYEE));
    }

    @Override
    public Employee updateEmployee(Employee employee, Collection<EmployeeSkill> employeeSkills) throws TaskManagerException {
        if (ModelFacade.getInstance().getModel().getEmployees().stream().anyMatch(employee1 -> employee1.getEmail().equals(employee.getEmail()))
                || ModelFacade.getInstance().getModel().getEmployees().stream().anyMatch(employee1 -> employee1.getUsername().equals(employee.getUsername())))
            throw new TaskManagerException(new Throwable(""), FIELDS_OF_EMPLOYEE_INCORRECT);
        ModelFacade.getInstance().getModel().getEmployeeSkills().removeAll(ModelFacade.getInstance().getModel().getEmployeeSkills().stream()
                        .filter(employeeSkill -> employeeSkill.getEmployeeId()==employee.getEmployeeId())
                        .collect(Collectors.toList())) ;
        ModelFacade.getInstance().getModel().getEmployeeSkills().addAll(employeeSkills);
        return ModelFacade.getInstance().getModel().getEmployees().stream()
                .filter(employee1 -> employee1.getEmployeeId() == employee.getEmployeeId())
                .peek(employee1 -> employee1 = employee)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_EMPLOYEE));
    }

    @Override
    public void deleteEmployee(Long employeeId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getEmployees().removeIf(employee -> employee.getEmployeeId() == employeeId);
    }

    @Override
    public void deleteEmployee(Employee employee) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getEmployees().remove(employee);
    }

    @Override
    public Employee getEmployeeByEmployeeId(Long employeeId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getEmployees().stream()
                .filter(employee -> employee.getEmployeeId() == employeeId)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_EMPLOYEE));

    }

    @Override
    public Employee getEmployeeByUsername(String username) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getEmployees().stream()
                .filter(employee -> employee.getUsername().equals(username))
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_EMPLOYEE));

    }

    @Override
    public Collection<Employee> getAllEmployees() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getEmployees();

    }

    @Override
    public Collection<EmployeeSkill> getEmployeeSkillsByEmployeeId(Long employeeId) throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getEmployeeSkills().stream()
                .filter(employeeSkill -> employeeSkill.getEmployeeId() == employeeId)
                .collect(Collectors.toList());

    }

}