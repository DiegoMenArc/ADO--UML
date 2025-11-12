package app2;

public class Uni {
    /*
     * +calcularMensalidade(opces: Opcoes Resultado ) :
     * -verificarNomeCurso( codCurso: String) : String
     * -verificarMensalidade ( codCurso: String) : double
     * -verificarProgramaBolsa ( codBolsa: String) : String
     * -verificarDesconto( codBolsa: String) : double
     */
    final String cursos[] = { "TADS", "TSI", "BCC", "BSI", "BSE" };
    final Double valores[] = { 915.00, 836.00, 1559.00, 1400.00, 1758.00 };
    Resultado r;

    Terminal t = new Terminal();

    public void coleta(){
        String c = t.inputString("Informe o nome do seu curso");
        this.r.curso = verifNomeCurso(c);
        Double m = t.inputDouble("Informe a mensalidade do seu curso sem descontos");
        this.r.mensalidade = verificarMensalidade(m);
    }

    private Resultado calcMensalidade() {
        return this.r;
    }

    private String verifNomeCurso(String curso) {

        String sigla = "";
        int limite = cursos.length;

        for (int i = 0; i < limite; i++) {
            if (!curso.matches(cursos[i])) {
                if (i == limite - 1 && !curso.matches(cursos[i])) {
                    coleta();
                } else {
                    continue;
                }
            } else {
                sigla = curso;
            }
        }
        return sigla;
    }

    private double verificarMensalidade(double m) {
        int limite = valores.length;
        double v = 0;

        for (int i = 0; i < limite; i++) {

            if (m != valores[i]) {
                if (i == limite && m != valores[i]) {
                    coleta();
                } else {
                    continue;
                }
            } else {

                if(!cursos[i].matches(this.r.curso)){
                    t.msg("O curso que você selecionou não corresponde à mensalidade");;
                    coleta();
                }else{
                    v = m;
                }
            }
        }
        return v;
    }
}
