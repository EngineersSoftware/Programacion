package Model;

import java.util.Date;

import Service.interfaces.Reportable;

public class Administrator extends Employee implements Reportable {

    private String accessLevel;

    public Administrator( Integer workerId, String name, Double salary, Date schedule, String accessLevel) {
        super(workerId, name, salary, schedule);
        this.accessLevel = accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    @Override
    public void trabajar() {
        System.out.println(getName() + " , esta gestionando recursos !!");
    }

    @Override
    public void generateReport() {
        System.out.println(getName() + " , esta generando resporte de gestion de recursos ...");
    }

}
