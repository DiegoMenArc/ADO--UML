package GerenciadorTarefas;

import java.util.ArrayList;

public class Gerenc {

    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void novaTarefa() {
        Tarefa t = new Tarefa();
        t.codigo = App.t.inputString("Informe um nome para sua tarefa");
        t.desc = App.t.inputString("Informe uma descrição para sua tarefa");
        t.conc = false;
        novaTarefa(t);
    }

    private void novaTarefa(Tarefa t) {
        this.tarefas.add(t);
        App.menu();
    }

    public void listarT() {
        System.out.println();
        for (Integer i = 0; i < tarefas.size(); i++) {
            Tarefa t = tarefas.get(i);
            String finalizada = (t.conc) ? "X" : "";
            System.out.printf("%dº | %s | %s | ( %s ) %n", (i + 1), t.codigo, t.desc, finalizada);
        }
        App.t.msg("Verfique a lista no terminal.");
        App.menu();
    }

    public void editar() {
        Integer pos = App.t.inputInt("Informe a posição da tarefa que deseja edita  r");
        String nome = App.t.inputString("Informe um novo nome, caso não queria, apenas digite o nome atual");
        String desc = App.t.inputString("Informe uma nova descrição, caso não queria, apenas digite a atual");

        this.editar(pos, nome, desc);
    }

    private void editar(Integer pos, String nome, String desc) {
        Tarefa t = this.tarefas.get(pos - 1);
        t.codigo = nome;
        t.desc = desc;
        App.menu();
    }

    public void deletar() {
        Integer pos = App.t.inputInt(
                "Informe a posição da tarefa que deseja remover. \nCaso não deseje deletar nenhuma tarefa, digite 0");
        if (pos == 0) {
            App.menu();
        } else {
            this.deleter(pos);
        }
    }

    private void deleter(Integer pos) {
        this.tarefas.remove(pos - 1);
        App.menu();
    }

    public void concluir() {
        Integer pos;
        pos = App.t.inputInt("Informe a posição da tarefa que deseja concluir");
        while (pos <= 0 || pos > this.tarefas.size()) {
            this.concluir();
        }
        this.concluir(pos);
    }

    private void concluir(Integer pos) {
        Tarefa tarefa = this.tarefas.get(pos - 1);
        tarefa.conc = true;
        App.menu();
    }
}

class Tarefa {
    public String codigo;
    public String desc;
    public Boolean conc;
}
