package XDesafio.Distribuidor;

import javax.swing.JOptionPane;

public class Terminal {
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
        Integer e = Integer.parseInt(JOptionPane.showInputDialog(null, """
                1. Cadastrar concorrente
                2. Lista de concorrentes
                3. Lista de salas
                4. Lista de escalas
                
                0. Sair
                """, "MENU", 0));
        while(e != 0 && e < 5) {
            e = Integer.parseInt(JOptionPane.showInputDialog(null, """
                1. Cadastrar concorrente
                2. Lista de concorrentes
                3. Lista de salas
                4. Lista de escalas
                
                0. Sair
                """, "MENU", 0));
        }   
        Op(1);
    }

    private void Op(int e) {
        switch (e) {
            case 0: System.exit(0); break;
            case 1: ;break;
            case 2: ;break;
            case 3: ;break;
            case 4: ;break;

            default: menu(); break;
        }
    }

    public Integer tipoObjeto() {
        return Integer.parseInt(JOptionPane.showInputDialog("""
                Informe o tipo digitando o número correspondente
                1. Concorrente;
                2. Sala;
                3. Escala
                """));
    }
}
