package OutBack;

import java.util.LinkedList;
import java.util.Queue;

public class ControleReserva {
    private Queue<Reserva> reservas = new LinkedList<>(); 
        
    public void novaReserva(){
        String resp = OutBack.t.inputString("Informe o nome do responsável pela reserva");
        Integer lugs = OutBack.t.inputInt("Informe o número de lugares para essa reserva");
        this.novaReserva(resp, lugs);
    }

    private void novaReserva(String resp, Integer lug){
        Reserva r = new Reserva();
        r.responsavel = resp;
        r.lugares = lug;
        this.reservas.add(r);
        OutBack.menu();
    }

    public void listar(){
        Integer pos = 0;
        for(Reserva r : this.reservas){
            OutBack.t.msg((pos+1)+"º - responsável: "+r.responsavel+", reservou "+r.lugares+" lugares;");
            pos++;
        }
        OutBack.menu();
    }

    public void proximo(){
        this.reservas.poll();
        Reserva r = this.reservas.peek();
        OutBack.t.msg("O próximo da fila é: "+r.responsavel+" e precisa de "+r.lugares+" lugares");
        OutBack.menu();
    }
}

class Reserva{
    String responsavel;
    Integer lugares;
}
