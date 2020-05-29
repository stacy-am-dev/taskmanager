package com.netcracker.taskmanager.controller.local;

import com.netcracker.taskmanager.controller.EmployeeControllerInterface;
import com.netcracker.taskmanager.exception.TaskManagerException;
import com.netcracker.taskmanager.model.Employee;
import com.netcracker.taskmanager.model.EmployeeSkill;
import com.netcracker.taskmanager.model.Task;
import com.netcracker.taskmanager.model.TaskSkill;
import com.netcracker.taskmanager.util.ModelFacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.netcracker.taskmanager.Constants.FIELDS_OF_EMPLOYEE_INCORRECT;
import static com.netcracker.taskmanager.Constants.NO_SUCH_EMPLOYEE;

public class EmployeeController implements EmployeeControllerInterface {
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
        ArrayList<EmployeeSkill> list = ModelFacade.getInstance().getModel().getEmployeeSkills().stream()
                .filter(employeeSkill -> employeeSkill.getEmployeeId() == employee.getEmployeeId())
                .collect(Collectors.toCollection(ArrayList::new));
        list = sortArrayList(list);
        ArrayList<EmployeeSkill> newList = sortArrayList((ArrayList<EmployeeSkill>) employeeSkills);
        int count = 0;
        int all = Math.max(list.size(), newList.size());
        while (count != all) {
            if (count < list.size() && !newList.contains(list.get(count))) {
                ModelFacade.getInstance().getModel().getEmployeeSkills().remove(list.get(count));
            }
            if (count < newList.size() && !list.contains(newList.get(count))) {
                ModelFacade.getInstance().getModel().getEmployeeSkills().add(newList.get(count));
            }
            count++;
        }
        return ModelFacade.getInstance().getModel().getEmployees().stream()
                .filter(employee1 -> employee1.getEmployeeId() == employee.getEmployeeId())
                .peek(employee1 -> employee1 = employee)
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), NO_SUCH_EMPLOYEE));
    }

    @Override
    public void deleteEmployee(Long employeeId) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getEmployeeSkills().removeIf(employeeSkill -> employeeSkill.getEmployeeId() == employeeId);
        ModelFacade.getInstance().getModel().getEmployees().removeIf(employee -> employee.getEmployeeId() == employeeId);
    }

    @Override
    public void deleteEmployee(Employee employee) throws TaskManagerException {
        ModelFacade.getInstance().getModel().getEmployeeSkills().removeIf(employeeSkill -> employeeSkill.getEmployeeId() == employee.getEmployeeId());
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

    @Override
    public Collection<EmployeeSkill> getAllEmployeeSkills() throws TaskManagerException {
        return ModelFacade.getInstance().getModel().getEmployeeSkills();
    }

    @Override
    public Long getAssigneeEmployeeId(Task task) throws TaskManagerException{
        TaskSkill taskSkill = ModelFacade.getInstance().getModel().getTaskSkills().stream()
                .filter(taskSkill1 -> taskSkill1.getTaskId() == task.getTaskId())
                .findAny()
                .orElseThrow(() -> new TaskManagerException(new Throwable(""), 234));
        for (EmployeeSkill employeeSkill: getAllEmployeeSkills()) {
            if (employeeSkill.getSkillLevel() >= taskSkill.getLevelSkill())
                return employeeSkill.getEmployeeId();
        }
        return null;
    }

    public ArrayList<EmployeeSkill> sortArrayList(ArrayList<EmployeeSkill> collection) { // сортировка Массива который передается в функцию
        if (collection == null) {
            return null;
        }

        if (collection.size() < 2) {
            return collection;
        }

        ArrayList<EmployeeSkill> collection1 = new ArrayList<>();
        collection1.ensureCapacity(collection.size() / 2);
        collection1 = collection.stream().limit(collection.size() / 2).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<EmployeeSkill> collection2 = new ArrayList<>();
        collection2.ensureCapacity(collection.size() - collection.size() / 2);
        collection2 = collection.stream().skip(collection.size() / 2).collect(Collectors.toCollection(ArrayList::new));

        collection1 = sortArrayList(collection1);
        collection2 = sortArrayList(collection2);

        return mergeArrayList(collection1, collection2);
    }

    public ArrayList<EmployeeSkill> mergeArrayList(ArrayList<EmployeeSkill> arrayListA, ArrayList<EmployeeSkill> arrayListB) {

        ArrayList<EmployeeSkill> arrayListC = new ArrayList<>();
        arrayListC.ensureCapacity(arrayListB.size() + arrayListA.size());
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayListC.size(); i++) {
            if (positionA == arrayListA.size()) {
                arrayListC.set(i, arrayListB.get(i - positionB));
                positionB++;
            } else if (positionB == arrayListB.size()) {
                arrayListC.set(i, arrayListA.get(i - positionA));
                positionA++;
            } else if (arrayListA.get(i - positionA).getSkillId() < arrayListB.get(i - positionB).getSkillId()) {
                arrayListC.set(i, arrayListA.get(i - positionA));
                positionB++;
            } else {
                arrayListC.set(i, arrayListB.get(i - positionB));
                positionA++;
            }
        }
        return arrayListC;
    }
}