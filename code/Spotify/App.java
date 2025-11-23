package Spotify;

import javax.swing.JOptionPane;

import Terminal.Terminal;

public class App {
    static Terminal t = new Terminal();
    static ListaReprod l = new ListaReprod();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Integer e;
        e = Integer.parseInt(JOptionPane.showInputDialog("""
                    MENU:
                    1. Adicionar música à fila;
                    2. Listar músicas na fila
                    3. Tocar próxima

                    0. Sair
                """));
        switch (e) {
            case 1:
                Musica m = new Musica();
                m.setNome( t.inputString("Informe o nome da música"));
                m.setArtista(t.inputString("Informe o artista da música"));
                l.adicionar(m);
                break;
            case 2: l.listar(); break;
            case 3: l.tocarProx(); break;
            case 0: System.exit(0); break;
            default: menu(); break;
        }
    }
}
