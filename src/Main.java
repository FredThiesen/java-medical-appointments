import medicalAppointments.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu option = null;

        AppointmentSystem appointmentSystem = new AppointmentSystem();
        do {
            Utils.printMenu();
            option = Utils.getMenuOption(scanner);
            switch (option) {
                case Menu.INCLUIR_PACIENTE:
                    Utils.includePatient(scanner, appointmentSystem);
                    Utils.pause(scanner);
                    break;
                case Menu.ALTERAR_PACIENTE:
                    Utils.changePatient(scanner, appointmentSystem);
                    Utils.pause(scanner);
                    break;
                case Menu.REALIZAR_CONSULTA:
                    Utils.makeAppointment(scanner, appointmentSystem);
                    Utils.pause(scanner);
                    break;
                case Menu.LISTAR_PACIENTES:
                    Utils.listPatients(appointmentSystem);
                    Utils.pause(scanner);
                    break;
                case Menu.MOSTRAR_PACIENTE:
                    Utils.showPatient(scanner, appointmentSystem);
                    Utils.pause(scanner);
                    break;
                case Menu.APAGAR_PACIENTE:
                    Utils.deletePatient(scanner, appointmentSystem);
                    Utils.pause(scanner);
                    break;
            }

        } while (option != Menu.SAIR);
        System.out.println("Até mais!");
        scanner.close();
    }
}