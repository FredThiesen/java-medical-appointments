package medicalAppointments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static void printMenu() {
        Menu.listValues();
    }

    public static Menu getMenuOption(Scanner scanner) {
        System.out.println("Digite a opção desejada:");
        int option = scanner.nextInt();
        scanner.nextLine();
        return Menu.getOption(option);
    }

    public static void pause(Scanner scanner) {
        System.out.println("=====================================================");
        System.out.println("Aperte enter para continuar...");
        scanner.nextLine();
    }

    public static String getReadableDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public static LocalDate convertToLocalDate(String date) {
        DateTimeFormatter formatter;
        LocalDate localDate;
        try {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            localDate = LocalDate.parse(date, formatter);
            if (localDate.isAfter(LocalDate.now()) || localDate.isBefore(LocalDate.now().minusYears(150))) {
                System.out.println("Data inválida. Caso seja alguém do futuro ou tenha mais de 150 anos?");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return null;
        }
        return localDate;
    }

    //   ===========================  FUNÇÕES DO MENU ABAIXO

    public static void includePatient(Scanner scanner, AppointmentSystem appointmentSystem) {
        System.out.println("Digite o nome do paciente:");
        String name = scanner.nextLine();
        System.out.println("Digite a data de nascimento do paciente (dd/mm/aaaa):");
        String birthDate = scanner.nextLine();
        LocalDate convertedDate = convertToLocalDate(birthDate);
        if (convertedDate == null) {
            return;
        }
        Patient patient = new Patient(name, convertedDate);
        appointmentSystem.addPatient(patient);
        System.out.println("Paciente adicionado com sucesso.");
    }

    public static void changePatient(Scanner scanner, AppointmentSystem appointmentSystem) {
        System.out.println("Digite o nome do paciente:");
        String name = scanner.nextLine();
        Patient patient = appointmentSystem.getPatientByName(name);
        if (patient == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        System.out.println("Digite o novo nome do paciente:");
        String newName = scanner.nextLine();
        System.out.println("Digite a nova data de nascimento do paciente (dd/mm/aaaa):");
        String newBirthDate = scanner.nextLine();
        LocalDate convertedDate = convertToLocalDate(newBirthDate);
        if (convertedDate == null) {
            return;
        }
        patient.setName(newName);
        patient.setBirthDate(convertedDate);
        System.out.println("Paciente alterado com sucesso.");
    }

    public static void makeAppointment(Scanner scanner, AppointmentSystem appointmentSystem) {
        System.out.println("Digite o nome do paciente:");
        String name = scanner.nextLine();
        Patient patient = appointmentSystem.getPatientByName(name);
        if (patient == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        System.out.println("Digite a data da consulta (dd/mm/aaaa):");
        String appointmentDate = scanner.nextLine();
        LocalDate convertedDate = convertToLocalDate(appointmentDate);
        if (convertedDate == null) {
            return;
        }
        System.out.println("Digite a descrição da consulta:");
        String description = scanner.nextLine();
        Appointment appointment = new Appointment(convertedDate, description);
        appointmentSystem.scheduleAppointment(patient, appointment);
        System.out.println("Consulta agendada com sucesso.");
    }

    public static void listPatients(AppointmentSystem appointmentSystem) {
        ArrayList<Patient> patients = appointmentSystem.getPatients();
        if(patients.isEmpty()){
            System.out.println("Não há pacientes cadastrados.");
            return;
        }
        for (Patient patient : patients) {
            System.out.println("Nome: " + patient.getName() + " Idade: " + patient.getAge());
        }
    }

    public static void showPatient(Scanner scanner, AppointmentSystem appointmentSystem) {
        System.out.println("Digite o nome do paciente:");
        String name = scanner.nextLine();
        Patient patient = appointmentSystem.getPatientByName(name);
        if (patient == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        System.out.println("Nome: " + patient.getName() + " | Idade: " + patient.getAge() + " | Data de nascimento: " + getReadableDate(patient.getBirthDate()));

        ArrayList<Appointment> appointments = patient.getAppointments();
        if(appointments.isEmpty()){
            System.out.println("Não há consultas agendadas para  " + patient.getName()+ ".");
            return;
        }
        System.out.println("Consultas:");
        for (Appointment appointment : appointments) {
            System.out.println("Data: " + appointment.getDate() + " | Descrição: " + appointment.getDescription());
        }
    }

    public static void deletePatient(Scanner scanner, AppointmentSystem appointmentSystem) {
        System.out.println("Digite o nome do paciente:");
        String name = scanner.nextLine();
        Patient patient = appointmentSystem.getPatientByName(name);
        if (patient == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        appointmentSystem.removePatient(patient);
        System.out.println("Paciente removido com sucesso.");
    }
}
