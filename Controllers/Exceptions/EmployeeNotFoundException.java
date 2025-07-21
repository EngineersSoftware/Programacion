package Controllers.Exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    
    public EmployeeNotFoundException(Integer id) {
        super("No se encontró un empleado con el ID:  "+ id);
    }

}
