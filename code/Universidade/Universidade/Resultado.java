package Universidade;

public class Resultado {
    Double mensalidade;
    String curso;
    String ProgramaBolsa;
    Double desconto;

    public Resultado(double mens, double desc, String curso, String bolsa) {
        this.mensalidade = mens;
        this.desconto = desc;
        this.curso = curso;
        this.ProgramaBolsa = bolsa;
    }

    public double lerMensalidade() {
        return this.mensalidade;
    }

    public String lerCurso() {
        return this.curso;
    }

    public String lerBolsa() {
        return this.ProgramaBolsa;
    }

    public double lerDesc() {
        return this.desconto;
    }
}
