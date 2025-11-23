package OutBack;

import Terminal.Terminal;

public class OutBack {
    static Terminal t = new Terminal(); 
    static ControleReserva cr = new ControleReserva();
    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        Integer e;
        e = t.inputInt( """
            Escolha uma ação
                1. Nova Reserva
                2. Lista de Reservas
                3. Chamar Próximo

                0. Sair
                """);
        switch (e) {
            case 1: cr.novaReserva(); break;
            case 2: cr.listar(); break;
            case 3: cr.proximo(); break;
            case 0: System.exit(0);
            default: menu(); break;
        }
    }
}
