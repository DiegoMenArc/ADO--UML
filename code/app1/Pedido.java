package app1;

public class Pedido {
    
    Terminal t = new Terminal();
    
    Double valor;
    Integer parcelas;
    String cupom;
    Double valorCupom;
    Double total;
    Response r;

    String[] cupons = new String[2] ;

    public Response calcTotal(){
        valor = t.inputDouble("Informe o valor do pedido");
        parcelas = t.inputInt("Informe o número de parcelas");
        cupom = t.inputString("Informe o Cupom");
        valorCupom = verificaCupom(cupom); 

        return this.r;        
    }

    private Double verificaCupom(String cupom){
        double v = 0;
        if(cupom.equals("QUERO50")){
            v = 50.0;
        }
        return v;
    }
    
}
