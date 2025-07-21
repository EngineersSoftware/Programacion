package Controllers;

import java.util.ArrayList;
import java.util.List;

import Model.Employee;

public class EmployeController {

    private List<Employee> employees;

    public EmployeController() {
        employees = new ArrayList<>();
    }

    public List<Employee> addEmployee(Employee employee) {
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
        return null; // o puedes lanzar una excepción
    }

    public Employee deleteEmployeeById(Integer id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getWorkerId().equals(id)) {
                return employees.remove(i);
            }
        }
        return null; // o puedes lanzar una excepción
    }
}
