package Model;

import java.util.Date;

import Service.interfaces.Reportable;

public class Electrician extends Employee implements Reportable {

    private String electricalCertification;

    public Electrician(Integer workerId, String name, Double salary, Date schedule, String electricalCertification) {
        super(workerId, name, salary, schedule);
        this.electricalCertification = electricalCertification;
    }

    public String getElectricalCertification() {
        return electricalCertification;
    }

    @Override
    public void generateReport() {
        System.out.println(getName() + " , esta generando reporte de la certificacion electrica: " + electricalCertification +" !!");
    }

    @Override
    public void work() {
        System.out.println(getName() + " , esta trabajando con certificacion electrica: " + electricalCertification +" !!");
    }

}
