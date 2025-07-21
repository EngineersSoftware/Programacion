package Controllers;

import java.util.ArrayList;
import java.util.List;

import Controllers.Exceptions.DuplicateEmployeeException;
import Controllers.Exceptions.EmployeeNotFoundException;
import Model.Employee;

public class EmployeController {

    private List<Employee> employees;

    public EmployeController() {
        employees = new ArrayList<>();
    }

    public List<Employee> addEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e.getWorkerId().equals(employee.getWorkerId())) {
                throw new DuplicateEmployeeException(employee.getWorkerId());
            }
        }
        employees.add(employee);
        return employees;
    }

    public List<Employee> readEmployees() {
        return employees;
    }

    public Employee updateEmployeeById(Employee updatedEmployee, Integer id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getWorkerId().equals(id)) {
                employees.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        throw new EmployeeNotFoundException(id);
    }

    public Employee deleteEmployeeById(Integer id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getWorkerId().equals(id)) {
                return employees.remove(i);
            }
        }
        throw new EmployeeNotFoundException(id);
    }

}
