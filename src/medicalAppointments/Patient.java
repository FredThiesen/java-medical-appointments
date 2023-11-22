package medicalAppointments;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient {
    private String name;
    private LocalDate birthDate;
    private ArrayList<Appointment> appointments;

    public Patient(String nome, LocalDate birthDate) {
        this.name = nome;
        this.birthDate = birthDate;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }


    public boolean equalsName(String name) {
        return this.name.equals(name);
    }
}
