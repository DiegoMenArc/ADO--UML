package GerenciadorTarefas;

import Terminal.Terminal;

public class App {
    static Terminal t = new Terminal();
    static Gerenc g = new Gerenc();

    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        Integer e = t.inputInt("""
                1. Nova Tarefa;
                2. Listar Tarefa;
                3. Editar Tarefa;
                4. Remover Tarefa;
                5. Marcar como Concluida;

                0. Sair
                """);
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
