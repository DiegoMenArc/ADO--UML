package Pedidos;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Response> pedidos = new ArrayList<>();
    
    public Double valor;
    public Integer parcelas;
    public String cupom;
    

    String[] cupons = new String[2] ;

    public Response calcTotal(){
        double valorCupom;
        double taxa = 0;

        this.valor = App.t.inputDouble("Informe o valor do pedido");
        
        this.parcelas = App.t.inputInt("Informe o número de parcelas");
        this.cupom = App.t.inputString("Informe o Cupom");
        valorCupom = verificaCupom(cupom); 

        
        if(parcelas > 0){
            taxa = 0.05;
        }
        Double valorTotal = valor + (valor*taxa);
        Double vP = valorTotal/parcelas;

        Response r = new Response(valorTotal, vP, parcelas, valorCupom);        
        this.pedidos.add(r);
        return r;
    }

    private Double verificaCupom(String cupom){
        double v = 0;
        if(cupom.equals("QUERO50")){
            v = 50.0;
            System.out.println("valor = "+v);
        }
        return v;
    }

    public void pedidosAnteriores(){
        Integer pos = 1;
        for(Response r : this.pedidos){
            App.t.msg(pos+"º \nValor da compra: "+r.lerTotal()+" \nValor do cupom usado "+r.lerValorCupom()+" \nParcelas "+r.lerParcelas()+" \nValor por parcela: "+r.lerValorParcela());
        }
        App.menu();
    } 
}
