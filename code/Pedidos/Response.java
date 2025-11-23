package Pedidos;

public class Response {

    private Double valorFinal;
    private Double valorParcela;
    private Integer parcelas;
    private Double valorCupom;

    public Response(Double valorFinal, double valorParcelas, Integer parcelas, Double valorCupom) {
        this.valorFinal = valorFinal;
        this.valorParcela = valorParcelas;
        this.parcelas = parcelas;
        this.valorCupom = valorCupom;
    }

    public double lerTotal() {
        return this.valorFinal;
    }

    public double lerValorParcela() {
        return this.valorParcela;
    }

    public int lerParcelas() {
        return this.parcelas;
    }

    public double lerValorCupom() {
        return this.valorCupom;
    }
}