package medicalAppointments;

public enum Menu {
    INCLUIR_PACIENTE(1, "Incluir paciente"),
    ALTERAR_PACIENTE(2, "Alterar paciente"),
    REALIZAR_CONSULTA(3, "Realizar consulta"),
    LISTAR_PACIENTES(4, "Listar os pacientes"),
    MOSTRAR_PACIENTE(5, "Mostrar paciente"),
    APAGAR_PACIENTE(6, "Apagar um paciente"),
    SAIR(7, "Sair");

    private int value;
    private String description;

    Menu(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static void listValues() {
        for (Menu menu : Menu.values()) {
            System.out.println(menu.getValue() + " - " + menu.getDescription());
        }
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

    public static Menu getOption(int value) {
        for (Menu menu : Menu.values()) {
            if (menu.getValue() == value) {
                return menu;
            }
        }
        return null;
    }
}

