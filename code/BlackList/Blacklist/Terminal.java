package Blacklist;

import javax.swing.JOptionPane;

public class Terminal {
    BlackList b = new BlackList();

    public void prt(String msg) {
        System.out.println(msg);
    }

    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public Integer inputInt(String msg) {
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }

    public Double inputDouble(String msg) {
        return Double.parseDouble(JOptionPane.showInputDialog(msg));
    }

    public String inputString(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    public void menu() {
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
            case 1: this.b.adicionar(); break;
            case 2: this.b.listar(); break;
            case 3: this.b.alterar(); break;
            case 4: this.b.remover(); break;
            case 0: System.exit(0);
            default: menu(); break;
        }
    }
}
