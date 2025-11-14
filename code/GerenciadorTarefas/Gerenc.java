package GerenciadorTarefas;

import java.util.ArrayList;

public class Gerenc {
    Terminal t = new Terminal();

    private ArrayList<Tarefa> tarefas = new ArrayList<>(); 

    public void novaTarefa(Tarefa t){
        this.tarefas.add(t);
        this.t.menu();
    }

    public void listarT(){
        for(Integer i = 0; i<tarefas.size(); i++){
            Tarefa t = tarefas.get(i);
            System.out.printf("%d º | $s | %s | ( %b )", (i+1), t.codigo, t.conc, ((t.conc) ? "X":"") );
        }
        t.menu();
    }

    public void editar(Integer pos, String nome, String desc){
        Tarefa t = this.tarefas.get(pos-1);
        t.codigo = nome;
        t.desc = desc;
        this.t.menu();
    }

    public void deleter(Integer pos){
        this.tarefas.get(0);
    }

    public void concluir(){}
}

class Tarefa{
    public String codigo;
    public String desc;
    public Boolean conc;
}
