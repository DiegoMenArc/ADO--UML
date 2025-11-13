package App3.Distribuidor;


import java.util.ArrayList;
import java.text.SimpleDateFormat;;

public class Db {
    Terminal t = new Terminal();

    ConcorrenteService c = new ConcorrenteService();
    SalaService s = new SalaService();
    EscalaService e = new EscalaService();

    ArrayList<Escala> escalas;
    ArrayList<Sala> salas;
    ArrayList<Concorrente> concorrentes;
    
    // Geral

    public void consultarObjeto(Integer id){
        Integer e = t.tipoObjeto();
        switch (e) {
            case 1: this.concorrentes.get(id) ;break;
            case 2: this.salas.get(id) ;break;
            case 3: this.escalas.get(id) ;break;
            default: e = t.tipoObjeto();break;
        }   
    }

    public void addOjeto(Integer id){
        Integer e = t.tipoObjeto();
        switch (e) {
            case 1: this.c.cadastrarConc(); ;break;
            case 2: this.s.cadastrarSala(); ;break;
            case 3: this.e.fazerEscala(); ;break;
            default: e = t.tipoObjeto();break;
        }
    }

    public void deleteObjeto(){
        Integer e = t.tipoObjeto();
        switch (e) {
            case 1: this.c.deleteConcorrente(); break;
            case 2: this.s.deleteSala();; break;
            case 3: this.e.deleteEscala(); break;
            default: e = t.tipoObjeto();break;
        }   
    }

    public void editarObjeto(){
        Integer e = t.tipoObjeto();
        switch (e) {
            case 1:  this.c.editarConcorrente(); break;
            case 2:  this.s.editarSala(); break;
            case 3:  this.e.editarEscala() ; break;
            default: e = t.tipoObjeto() ;break;
        }   
    }

}

class Sala{
    Terminal t = new Terminal();

    Integer id;
    Integer maxCap;
    Integer numeroSala;
    String[] tipoProvas;
    ArrayList<SimpleDateFormat> horarios = new ArrayList < SimpleDateFormat > ();
    Boolean disponibilidade;
    ArrayList<Concorrente> concorrentes;  
}

class SalaService {
    Terminal t = new Terminal();
    Db db = new Db();

    private ArrayList<Sala> salas;

    //Cadastro

    public void cadastrarSala(){
        Sala s = new Sala();
        s.numeroSala = t.inputInt("Informe o número da sala");
        s.maxCap = t.inputInt("Informe a capacidade máxima da sala");
        s.disponibilidade = true;   

        Integer h = t.inputInt("Quantos horários quer cadastrar?");
        for(int i = 0; i<h; i++){
            String horarioInput = t.inputString("Informe o horário "+(i+1)+" no formato HH:mm");
            try {
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
                hora.parse(horarioInput);
                s.horarios.add(hora);
            } catch (Exception e) {
                t.prt("Formato de horário inválido! Tente novamente.");
                i--;
            }
        }
        
        this.cadastrarSala(s);
    }

    private void cadastrarSala(Sala sala) {
        this.salas.add(sala);
        t.menu();
    }

    //Exluir

    public void deleteSala(){
        Integer id = t.inputInt("Informe o id da sala que quer deletar");
        deleteSala(id);
    }

    private void deleteSala(Integer id) {
        for (Sala sala : this.salas) {
            if (sala.id.equals(id)) {
                this.salas.remove(sala);
                t.menu();
                break;
            }
        }
    }

    public void editarSala(){
        Integer sl = t.inputInt("Informe o id da sala que quer editar");
        for(Sala sala : this.salas){
            if(sl == sala.id){
                this.editarSala(sala);
            }
        }
    }

    private void editarSala(Sala sala){
        this.salas.set(sala.id, sala);
        t.menu();
    }

    public void definirTipoProvas(){
        Integer id = t.inputInt("Informe o id da sala que quer definir os tipos de provas");
        String tiposInput = t.inputString("Informe os tipos de provas separados por vírgula");
        String[] tipos = tiposInput.split(",");
        this.definirTipoProvas(id, tipos); 
        t.menu();     
    }

    private void definirTipoProvas(Integer id, String[] tipos){
        Sala url = this.db.salas.get(id);
        if(url != null){
            url.tipoProvas = tipos;
            t.prt("Tipos de provas definidos com sucesso!");
            t.menu();
        } else {
            t.prt("Sala não encontrada!");
            t.menu();
        }
                
    }

    public void definirLimite(){
        Integer id = t.inputInt("Informe o id da sala que quer definir o limite");
        Integer limite = t.inputInt("Informe o limite de concorrentes nessa sala");
        this.definirLimite(id, limite);      
    }

    private void definirLimite(Integer id, Integer limite){
        Sala url = this.db.salas.get(id);
        if(url != null){
            url.maxCap = limite;
            url.disponibilidade = true;
            t.prt("Limite definido com sucesso!");
        } else {
            t.prt("Sala não encontrada!");
        }   
    }

    private void varificarCap(Sala s){
        if(s.concorrentes.size() == s.maxCap){
            s.disponibilidade = false;
        }
    }

    void alocarConcorrente(Concorrente c, Sala s){
        if(s.disponibilidade == true){
            s.concorrentes.add(c);
            this.varificarCap(s);
        } else {
            t.prt("Sala sem disponibilidade!"); 
            t.menu();  
        }
   }

}


class Escala{
    Integer id;
    Sala sala;
    ArrayList<Concorrente> concorrentes;
    String horario;
}

class EscalaService {
    Terminal t = new Terminal();
    Db db = new Db();
    Sala s = new Sala();
    Escala e = new Escala();
    Concorrente c = new Concorrente();


    public void fazerEscala(){
        Integer id = t.inputInt("Informe o id da escala que quer fazer a escala");
        Sala sala = this.db.salas.get(id);    
        
        e.sala = sala;
        e.concorrentes = sala.concorrentes;

        this.addEscala(e);
    }

    private void addEscala(Escala escala) {
        this.db.escalas.add(escala);
        t.menu();
    }

    public void deleteEscala(){
        Integer id = t.inputInt("Informe o id da escala que quer deletar");
        deleteEscala(id);
    }

    private void deleteEscala(Integer id) {
        for (Escala escala : this.db.escalas) {
            if (escala.id.equals(id)) {
                this.db.escalas.remove(escala);
                t.menu();
                break;
            }
        }
    }

    public void editarEscala(){
        Integer es = t.inputInt("Informe o id da escala que quer editar");
        for(Escala escala : this.db.escalas){
            if(es == escala.id){
                this.editarEscala(escala);
            }
        }
    }

    private void editarEscala(Escala escala){
        this.db.escalas.set(escala.id, escala);
        t.menu();
    }
}

class Concorrente{
    Terminal t = new Terminal();
    Db db = new Db();

    Integer id;
    String nome;
    String sobrenome; 
    String horaProva;
    String tipoProva;

}

class ConcorrenteService {
    Terminal t = new Terminal();
    Db db = new Db();

    //Consultar

    public void consultarConcorrente(){
        Integer id = t.inputInt("Informe o id do concorrente que quer consultar");
        this.ConsultarConcorrente(id);
    }

    private void ConsultarConcorrente(Integer id){
        Concorrente conc = this.db.concorrentes.get(id);
        if(conc != null){
            t.msg("ID: " + conc.id + "\nNome: " + conc.nome + "\nSobrenome: " + conc.sobrenome + "\nTipo de Prova: " + conc.tipoProva + "\nHora da Prova: " + conc.horaProva);
            t.menu();
        } else {
            t.msg("Concorrente não encontrado!");
            t.menu();
        }
    }

    //Exluir

    public void deleteConcorrente(){
        Integer id = t.inputInt("Informe o id do concorrente que quer deletar");
        this.deleteConcorrente(id);
    }

    private void deleteConcorrente(Integer id) {
        for (Concorrente conc : this.db.concorrentes) {
            if (conc.id.equals(id)) {
                this.db.concorrentes.remove(conc);
                t.menu();
                break;
            }
        }
    }

    //Editar

    public void editarConcorrente(){
        Integer cc = t.inputInt("Informe o id do concorrente que quer editar");
        Concorrente conc = this.db.concorrentes.get(cc);
        if(conc != null){
            conc.nome = t.inputString("Informe o novo nome");
            conc.sobrenome = t.inputString("Informe o novo sobrenome");
            conc.tipoProva = t.inputString("Informe o tipo de prova");
                
            this.editarConcorrente(conc);
        } else {
            t.prt("Concorrente não encontrado!");
            t.menu();
        }
    }

    private void editarConcorrente(Concorrente conc){
        this.db.concorrentes.set(conc.id, conc);
        t.menu();
    }

    //Cadastro

    public void cadastrarConc(){
        Concorrente c = new Concorrente();
        c.nome = t.inputString("Informe o nome do Concorrente");
        c.sobrenome = t.inputString("Informe o sobrenome de "+c.nome);
        
        this.cadastrarConc(c);
    }

    private void cadastrarConc(Concorrente cc){
        this.db.concorrentes.add(cc);
        t.menu();
    }
    
}