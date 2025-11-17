package XDesafio.Distribuidor;

public class App {
    Terminal t = new Terminal();
    Db db = new Db();

    public static void main(String[] args) {
        App a = new App();
        a.t.menu();
    }
}
