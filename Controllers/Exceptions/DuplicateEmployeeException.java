package Controllers.Exceptions;

public class DuplicateEmployeeException extends RuntimeException{

    public DuplicateEmployeeException(Integer id){
        super("Ya existe un empleado con el ID: " + id);
    }

}
