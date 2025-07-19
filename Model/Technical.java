package Model;

import java.util.Date;

import Service.interfaces.Reportable;

public class Technical extends Employee implements Reportable {

    private String specializedArea;

    public Technical(Integer workerId, String name, Double salary, Date schedule, String specializedArea) {
        super(workerId, name, salary, schedule);
        this.specializedArea = specializedArea;
    }
    public String getSpecializedArea() {
        return specializedArea;
    }

    @Override
    public void generateReport() {
         System.out.println(getName() + " , esta generando reporte tecnico en: "+ specializedArea + " !!");
    }

    @Override
    public void trabajar() {
         System.out.println(getName() + " , esta resolviendo problema en: "+ specializedArea + " !!");
    }

}
