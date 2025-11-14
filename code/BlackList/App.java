package BlackList;

public class App {
    static Terminal t = new Terminal();
    static BlackList b = new BlackList();
    public static void main(String[] args){
        Integer e = t.menu();
        switch (e) {
            case 1: b.adicionar()   ;break;
            case 2: b.listar()      ;break;
            case 3: b.alterar()     ;break;
            case 4: b.remover()     ;break;
            default: t.menu()       ;break;
        }
    }
}
