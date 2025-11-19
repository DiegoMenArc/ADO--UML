package Blacklist;

import java.util.ArrayList;

public class BlackList {

    private ArrayList<String> pessoas = new ArrayList<>();

    public void adicionar() {
        this.adicionar( App.t.inputString("Informe o nome da pessoa "));
    }

    private void adicionar(String nome) {
        this.pessoas.add(nome);
        App.t.msg(this.pessoas.get(this.pessoas.size()-1)+" adicionado");
        App.t.menu();
    }

    public void listar() {
        for (int i = 0; i < this.pessoas.size(); i++) {
            App.t.prt("i = "+i);
            App.t.msg((i+1)+"º Nome: " + this.pessoas.get(i));
        }
        App.t.menu();
    }

    public void remover() {
       this.remover( App.t.inputInt("Informe a posição da pessoa"));
    }

    private void remover(Integer index) {
        String user = this.pessoas.get(index);
        App.t.prt(user+ " foi removido");
        this.pessoas.remove(index-1);
        App.t.menu();
    }

    public void alterar() {
        Integer id = App.t.inputInt("Informe a posição da pessoa que deseja alterar");
        String novo = App.t.inputString("Informe o novo nome");
        alterar(id, novo);
    }

    private void alterar(Integer index, String pessoa){
        this.pessoas.set(index-1, pessoa);
        App.t.menu();
    }
}
