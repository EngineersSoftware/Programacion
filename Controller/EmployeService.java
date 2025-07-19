package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Employee;

public class EmployeService {

    private List<Employee> employee;

    // CRUD: CREATE(CREAR, AGREGAR), READ(LEER), UPDATE(ACTUALIZAR),
    // DELETE(ELIMINAR)

    public EmployeService() {
        employee = new ArrayList<>();
    }

    public List<Employee> addEmployee(Employee employe) {
        employee.add(employe);
        return employee;
    }

    public List<Employee> readEmployee (Employee employe) {
        return employee;
    }

    public Employee updateEmployeId (Employee employe, Integer id){
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getWorkerId() == id) {
                employee.set(i, employe);
                return employee.get(i);
            }
        }
        return updateEmployeId(employe, id);
    }

    public Employee deleteEmployeId (Integer id){
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getWorkerId() == id) {
                employee.remove(i);
                return employee.get(i);
            }
        }
        return deleteEmployeId(id);
    }

}
