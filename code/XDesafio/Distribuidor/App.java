package XDesafio.Distribuidor;

import javax.swing.JOptionPane;

import Terminal.Terminal;

public class App {
    static Terminal t = new Terminal();
    static Db db = new Db();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Integer e = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Escolha a operação: 
                1. Cadastro
                2. Edição
                3. Consulta
                4. Exclusão
                
                0. Sair
                """, "MENU", 0));
        while(e != 0 && e < 5) {
            menu();
        }   
        switch (e) {
            case 1: db.addOjeto(); break;
            case 2: db.editarObjeto(); break;
            case 3: db.consultarObjeto(); break;
            default: menu(); break;
        }
    }
}
