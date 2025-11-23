package Blacklist;

import javax.swing.JOptionPane;
import Terminal.Terminal;

public class App {
    static BlackList b = new BlackList();
    static Terminal t = new Terminal();
    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        Integer e;
        e = Integer.parseInt(JOptionPane.showInputDialog(null, """
            Escolha uma ação
                1. Cadastrar nome
                2. Lista de nomes
                3. Alterar nome
                4. Excluir nome

                0. Sair
                """, "MENU", 1));
        switch (e) {
            case 1: b.adicionar(); break;
            case 2: b.listar(); break;
            case 3: b.alterar(); break;
            case 4: b.remover(); break;
            case 0: System.exit(0);
            default: menu(); break;
        }
    }
}
