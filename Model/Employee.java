package Model;

import java.util.Date;

public abstract class Employee {

    private Integer workerId;
    private String name; 
    private Double salary; 
    private Date schedule;

    public Employee (Integer workerId, String name, Double salary, Date schedule){
        this.workerId = workerId;
        this.name = name;
        this.salary = salary;
        this.schedule = schedule;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "ID: " + workerId + "| Nombre: "+ name + " | Salario: " + salary + " | Horaio: " + schedule;
    }

    abstract void trabajar(); // Metodo abstracto

}
