package XDesafio.Distribuidor;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;;

public class Db {

    ConcorrenteService c = new ConcorrenteService();
    SalaService s = new SalaService();
    EscalaService e = new EscalaService();

    ArrayList<Escala> escalas;
    ArrayList<Sala> salas;
    ArrayList<Concorrente> concorrentes;

    // Geral

    public Integer tipoObjeto() {
        return Integer.parseInt(JOptionPane.showInputDialog("""
                Informe o tipo digitando o número correspondente
                1. Concorrente;
                2. Sala;
                3. Escala
                """));
    }

    public void consultarObjeto() {
        Integer id, e;
        e = this.tipoObjeto();
        id = App.t.inputInt("Informe a posição do item");
        switch (e) {
            case 1: this.concorrentes.get(id); break;
            case 2: this.salas.get(id); break;
            case 3: this.escalas.get(id); break;
            default: e = this.tipoObjeto(); break;
        }
    }

    public void addOjeto() {
        Integer e = this.tipoObjeto();
        switch (e) {
            case 1: this.c.cadastrarConc(); break;
            case 2: this.s.cadastrarSala();  break;
            case 3: this.e.fazerEscala(); break;
            default: e = this.tipoObjeto(); break;
        }
    }

    public void deleteObjeto() {
        Integer e = this.tipoObjeto();
        switch (e) {
            case 1: this.c.deleteConcorrente(); break;
            case 2: this.s.deleteSala(); break;
            case 3: this.e.deleteEscala(); break;
            default: e = this.tipoObjeto(); break;
        }
    }

    public void editarObjeto() {
        Integer e = this.tipoObjeto();
        switch (e) {
            case 1: this.c.editarConcorrente(); break;
            case 2: this.s.editarSala(); break;
            case 3: this.e.editarEscala(); break;
            default: e = this.tipoObjeto(); break;
        }
    }

}

class Sala {

    Integer id;
    Integer maxCap;
    Integer numeroSala;
    String[] tipoProvas = {""};
    ArrayList<SimpleDateFormat> horarios = new ArrayList<SimpleDateFormat>();
    Boolean disponibilidade;
    ArrayList<Concorrente> concorrentes;
}

class SalaService {
    Db db = new Db();

    private ArrayList<Sala> salas;

    // Cadastro

    public void cadastrarSala() {
        Sala s = new Sala();
        s.numeroSala = App.t.inputInt("Informe o número da sala");
        s.maxCap = App.t.inputInt("Informe a capacidade máxima da sala");
        s.disponibilidade = true;

        Integer h = App.t.inputInt("Quantos horários quer cadastrar?");
        for (int i = 0; i < h; i++) {
            String horarioInput = App.t.inputString("Informe o horário " + (i + 1) + " no formato HH:mm");
            try {
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
                hora.parse(horarioInput);
                s.horarios.add(hora);
            } catch (Exception e) {
                App.t.prt("Formato de horário inválido! Tente novamente.");
                i--;
            }
        }

        this.cadastrarSala(s);
    }

    private void cadastrarSala(Sala sala) {
        this.salas.add(sala);
        App.menu();
    }

    // Exluir

    public void deleteSala() {
        Integer id = App.t.inputInt("Informe o id da sala que quer deletar");
        deleteSala(id);
    }

    private void deleteSala(Integer id) {
        for (Sala sala : this.salas) {
            if (sala.id.equals(id)) {
                this.salas.remove(sala);
                App.menu();
                break;
            }
        }
    }

    //editar

    public void editarSala() {
        Integer sl = App.t.inputInt("Informe o id da sala que quer editar");
        for (Sala sala : this.salas) {
            if (sl == sala.id) {
                this.editarSala(sala);
            }
        }
    }

    private void editarSala(Sala sala) {
        this.salas.set(sala.id, sala);
        App.menu();
    }

    public void definirTipoProvas() {
        Integer id = App.t.inputInt("Informe o id da sala que quer definir os tipos de provas");
        String tiposInput = App.t.inputString("Informe os tipos de provas separados por vírgula");
        String[] tipos = tiposInput.split(",");
        this.definirTipoProvas(id, tipos);
        App.menu();
    }

    private void definirTipoProvas(Integer id, String[] tipos) {
        Sala url = this.db.salas.get(id);
        if (url != null) {
            url.tipoProvas = tipos;
            App.t.prt("Tipos de provas definidos com sucesso!");
            App.menu();
        } else {
            App.t.prt("Sala não encontrada!");
            App.menu();
        }

    }

    public void definirLimite() {
        Integer id = App.t.inputInt("Informe o id da sala que quer definir o limite");
        Integer limite = App.t.inputInt("Informe o limite de concorrentes nessa sala");
        this.definirLimite(id, limite);
    }

    private void definirLimite(Integer id, Integer limite) {
        Sala url = this.db.salas.get(id);
        if (url != null) {
            url.maxCap = limite;
            url.disponibilidade = true;
            App.t.prt("Limite definido com sucesso!");
        } else {
            App.t.prt("Sala não encontrada!");
        }
    }

    private void varificarCap(Sala s) {
        if (s.concorrentes.size() == s.maxCap) {
            s.disponibilidade = false;
        }
    }

    void alocarConcorrente(Concorrente c, Sala s) {
        if (s.disponibilidade == true) {
            s.concorrentes.add(c);
            this.varificarCap(s);
        } else {
            App.t.prt("Sala sem disponibilidade!");
            App.menu();
        }
    }

}

class Escala {
    Integer id;
    Sala sala;
    ArrayList<Concorrente> concorrentes;
    String horario;
}

class EscalaService {
    Db db = new Db();
    Sala s = new Sala();
    Escala e = new Escala();
    Concorrente c = new Concorrente();

    public void fazerEscala() {
        Integer id = App.t.inputInt("Informe o id da escala que quer fazer a escala");
        Sala sala = this.db.salas.get(id);

        e.sala = sala;
        e.concorrentes = sala.concorrentes;

        this.addEscala(e);
    }

    private void addEscala(Escala escala) {
        this.db.escalas.add(escala);
        App.menu();
    }

    public void deleteEscala() {
        Integer id = App.t.inputInt("Informe o id da escala que quer deletar");
        deleteEscala(id);
    }

    private void deleteEscala(Integer id) {
        for (Escala escala : this.db.escalas) {
            if (escala.id.equals(id)) {
                this.db.escalas.remove(escala);
                App.menu();
                break;
            }
        }
    }

    public void editarEscala() {
        Integer es = App.t.inputInt("Informe o id da escala que quer editar");
        for (Escala escala : this.db.escalas) {
            if (es == escala.id) {
                this.editarEscala(escala);
            }
        }
    }

    private void editarEscala(Escala escala) {
        this.db.escalas.set(escala.id, escala);
        App.menu();
    }
}

class Concorrente {
    Integer id;
    String nome;
    String sobrenome;
    String horaProva;
    String tipoProva;

}

class ConcorrenteService {
    Db db = new Db();

    public void consultarConcorrente() {
        Integer id = App.t.inputInt("Informe o id do concorrente que quer consultar");
        this.ConsultarConcorrente(id);
    }

    private void ConsultarConcorrente(Integer id) {
        Concorrente conc = this.db.concorrentes.get(id);
        if (conc != null) {
            App.t.msg("ID: " + conc.id + "\nNome: " + conc.nome + "\nSobrenome: " + conc.sobrenome + "\nTipo de Prova: "
                    + conc.tipoProva + "\nHora da Prova: " + conc.horaProva);
            App.menu();
        } else {
            App.t.msg("Concorrente não encontrado!");
            App.menu();
        }
    }

    // Exluir

    public void deleteConcorrente() {
        Integer id = App.t.inputInt("Informe o id do concorrente que quer deletar");
        this.deleteConcorrente(id);
    }

    private void deleteConcorrente(Integer id) {
        for (Concorrente conc : this.db.concorrentes) {
            if (conc.id.equals(id)) {
                this.db.concorrentes.remove(conc);
                App.menu();
                break;
            }
        }
    }

    // Editar

    public void editarConcorrente() {
        Integer cc = App.t.inputInt("Informe o id do concorrente que quer editar");
        Concorrente conc = this.db.concorrentes.get(cc);
        if (conc != null) {
            conc.nome = App.t.inputString("Informe o novo nome");
            conc.sobrenome = App.t.inputString("Informe o novo sobrenome");
            conc.tipoProva = App.t.inputString("Informe o tipo de prova");

            this.editarConcorrente(conc);
        } else {
            App.t.prt("Concorrente não encontrado!");
            App.menu();
        }
    }

    private void editarConcorrente(Concorrente conc) {
        this.db.concorrentes.set(conc.id, conc);
        App.menu();
    }

    // Cadastro

    public void cadastrarConc() {
        Concorrente c = new Concorrente();
        c.nome = App.t.inputString("Informe o nome do Concorrente");
        c.sobrenome = App.t.inputString("Informe o sobrenome de " + c.nome);

        this.cadastrarConc(c);
    }

    private void cadastrarConc(Concorrente cc) {
        this.db.concorrentes.add(cc);
        App.menu();
    }

}