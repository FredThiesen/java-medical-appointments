package medicalAppointments;

import java.util.ArrayList;

public class AppointmentSystem {

    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;

    public AppointmentSystem() {
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void scheduleAppointment(Patient patient, Appointment appointment) {
            appointments.add(appointment);
            patient.addAppointment(appointment);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
        appointments.removeAll(patient.getAppointments());
    }

    public Patient getPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.equalsName(name)) {
                return patient;
            }
        }
        return null;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}
