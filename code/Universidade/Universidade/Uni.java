
package Universidade;

public class Uni {
    Terminal t = new Terminal();

    private String[] cursos = { "TSI", "TADS", "BCC", "BSI", "BEC" };
    private String[] bolsas = { "MON", "EMP", "ISE", "EXT", "PES" };

    public Resultado calcMensalidade() {
        return new Resultado(0, 0, null, null);
    }

    private String verifNomeCurso(String curso) {
        t.inputString("Informe o curso desejado: ");
        
        for (int i = 0; i < cursos.length; i++) {
            if (curso.matches(cursos[i])) {
                return curso;
            } else {
                curso = "Curso não disponível";
                if (i == cursos.length - 1) {
                    t.menu();
                }
            }
        }
        return curso;
    }

    private double verificarMensalidade(double m) {

        return m;
    }

    private String verificarBolsa(String b) {
        if (b == null) {
            return "Nenhuma";
        } else if (b.matches(bolsas[0]) || b.matches(bolsas[1]) || b.matches(bolsas[2]) || b.matches(bolsas[3])
                || b.matches(bolsas[4])) {
            return b;
        }
        return b;
    }

    private double verificarDesconto(double d) {
        if(d < 0){
            d = 0.0;
        }
        return d;
    }
}
