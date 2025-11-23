package Spotify;

import java.util.Stack;

public class ListaReprod {

    private Stack<Musica> musicas = new Stack<>();

    public void adicionar(Musica musica){
        this.musicas.push(musica);
        App.menu();
    }

    public void listar(){
        if (this.musicas.isEmpty()) {
        System.out.println("Nenhuma música na playlist.");
        App.menu();
    }
    System.out.println();
    for (int i = this.musicas.size() - 1, pos = 1; i >= 0; i--, pos++) {
        Musica m = this.musicas.get(i);
        System.out.printf("%d. %s ( %s ) %n", pos, m.getNome(), m.getArtista());
    }
        App.menu();
    }

    public void tocarProx(){
        this.musicas.pop();
        Musica m = this.musicas.peek(); 
        App.t.msg(m.getNome()+" ("+m.getArtista()+") Está tocando agora");
        App.menu();
    }
}

class Musica{
    private String nome; 
    private String artista;
    private String codYT;

    public void setNome(String nome){
        this.nome = nome;
        this.codYT = "Runtime.getRuntime().exec(\"cmd.exe /C start microsoft-edge:https://www.youtube.com/results?search_query="+nome;
    }

    public void setArtista(String artista){
        this.artista = artista;
    }

    public String getNome(){
        return this.nome;
    }

    public String getArtista(){
        return this.artista;
    }

    public String getCodYT(){
        return this.codYT;
    }
}
