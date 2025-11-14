package BlackList;

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

    public Integer menu() {
        Integer e;
        e = Integer.parseInt(JOptionPane.showInputDialog(null, """
                1. Cadastrar nome
                2. Lista de nomes
                3. Alterar nome
                4. Excluir nome

                0. Sair
                """, "MENU", 1));
        while (e < 0 || e > 4 ) {
            e = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Cadastrar nome
                    2. Lista de nomes
                    3. Alterar nome
                    4. Excluir nome

                    0. Sair
                    """, "MENU", 1));
        }
        prt(e+"");
        return e;
    }
}
