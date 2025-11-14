package BlackList;

import java.util.ArrayList;

public class BlackList {
    static Terminal t = new Terminal();

    private ArrayList<String> pessoas = new ArrayList<>();

    public void adicionar() {
        this.adicionar(t.inputString("Informe o nome da pessoa "));
    }

    private void adicionar(String nome) {
        pessoas.add(nome);
        t.prt(nome+" adicionado");
        t.menu();
    }

    public void listar() {
        for (String pessoa : this.pessoas) {
            t.prt("Nome: " + pessoa);
        }
        t.menu();
    }

    public void remover() {
       this.remover( t.inputInt("Informe a posição da pessoa"));
    }

    private void remover(Integer index) {
        String user = this.pessoas.get(index);
        t.prt(user+ " foi removido");
        this.pessoas.remove(index-1);
        t.menu();
    }

    public void alterar() {
        Integer id = t.inputInt("Informe a posição da pessoa que deseja alterar");
        String novo = t.inputString("Informe o novo nome");
        alterar(id, novo);
    }

    private void alterar(Integer index, String pessoa){
        this.pessoas.set(index, pessoa);
        t.menu();
    }
}
