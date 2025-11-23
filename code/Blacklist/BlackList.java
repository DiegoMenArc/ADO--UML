package Blacklist;

import java.util.ArrayList;

public class BlackList {

    private ArrayList<String> pessoas = new ArrayList<>();

    public void adicionar() {
        String p;
        p = App.t.inputString("Informe o nome da pessoa ");
        this.adicionar( p );
    }

    private void adicionar(String nome) {
        this.pessoas.add(nome);
        App.t.msg(this.pessoas.get(this.pessoas.size()-1)+" adicionado");
        App.menu();
    }

    public void listar() {
        for (int i = 0; i < this.pessoas.size(); i++) {
            App.t.msg((i+1)+"º Nome: " + this.pessoas.get(i));
        }
        App.menu();
    }

    public void remover() {
        Integer pos;
        pos = App.t.inputInt("Informe a posição da pessoa na lista");
        this.remover( pos);
    }

    private void remover(Integer index) {
        String user;
        user = this.pessoas.get(index);
        App.t.msg(user+ " foi removido");
        this.pessoas.remove(index-1);
        App.menu();
    }

    public void alterar() {
        Integer id;
        id = App.t.inputInt("Informe a posição da pessoa que deseja alterar");
        String novo;
        novo = App.t.inputString("Informe o novo nome");
        alterar(id, novo);
    }

    private void alterar(Integer index, String pessoa){
        this.pessoas.set(index-1, pessoa);
        App.menu();
    }
}
