package GerenciadorTarefas;

import javax.swing.JOptionPane;

public class Terminal {
    Gerenc g = new Gerenc();

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
        Integer e = Integer.parseInt(JOptionPane.showInputDialog("""
                1. Nova Tarefa;
                2. Listar Tarefa;
                3. Editar Tarefa;
                4. Remover Tarefa;
                5. Marcar como Concluida;

                0. Sair
                """));
        while (e < 0 || e > 5) {
            menu();
        }
        switch (e) {
            case 1: g.novaTarefa();break;
            case 2: g.listarT();break;
            case 3: g.editar();;break;
            case 4: g.deletar();break;
            case 5: g.concluir();break;
            case 0: System.exit(0); break;
            default: break;
        }
    }
}
