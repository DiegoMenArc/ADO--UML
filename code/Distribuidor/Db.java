package Distribuidor;

import java.util.ArrayList;
import java.text.SimpleDateFormat;;

public class Db {
    Terminal t = new Terminal();
    Concorrente c = new Concorrente();
    Sala s = new Sala();
    Escala e = new Escala();

    private ArrayList<Escala> escalas;
    private ArrayList<Sala> salas;
    private ArrayList<Concorrente> concorrentes;
    private String[] horarios = {
        "12:00", "15:00", "18:00", "21:00"
    };

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

    public void addOjeto(){

    }

    public void deleteObjeto(){

    }

    public void editarObjeto(){
        Integer e = t.tipoObjeto();
        switch (e) {
            case 1:  editarConcorrente(); break;
            case 2:  editarSala()       ; break;
            case 3:  ; break;
            default: e = t.tipoObjeto();break;
        }   
    }

    //Sala functions

    private void editarSala(){
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

    // Concorrente functions



    private void editarConcorrente(){
        Integer cc = t.inputInt("Informe o id do concorrente que quer editar");
        for(Concorrente conc : this.concorrentes){
            if(cc == conc.id){
                conc.nome = t.inputString("Informe o novo nome");
                conc.sobrenome = t.inputString("Informe o novo sobrenome");
                conc.tipoProva = t.inputString("Informe o tipo de prova");
                
                this.editarConcorrente(conc);
            }
        }
    }

    private void editarConcorrente(Concorrente conc){
        this.concorrentes.set(conc.id, conc);
        t.menu();
    }

    private void cadastrarConc(){
        this.c.nome = t.inputString("Informe o nome do Concorrente");
        this.c.sobrenome = t.inputString("Informe o sobrenome de "+this.c.nome);
        
        this.cadastrarConc(this.c);
    }

    private void cadastrarConc(Concorrente cc){
        this.concorrentes.add(cc);
        t.menu();
    }

}

class Sala{
    Integer id;
    private Integer maxCap;
    Integer numeroSala;
    String[] tipoProvas;
    SimpleDateFormat horarios = new SimpleDateFormat("HH:mm");
    Boolean disponibilidade;
    Integer alocados;

    void definirLimite(Integer l){
        this.maxCap = l;
        disponibilidade = true;
    }

    void varificarCap(){
        if(this.alocados == this.maxCap){
            disponibilidade = false;
        }
    }
}

class Escala{
    Integer id;
    Sala sala;
    Concorrente[] concorrentes;
}

class Concorrente{
    Integer id;
    String nome;
    String sobrenome; 
    String horaProva;
    String tipoProva;
}