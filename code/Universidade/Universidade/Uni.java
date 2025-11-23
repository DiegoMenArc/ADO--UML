package Universidade;

public class Uni {
    private String[] cursos = { "TSI", "TADS", "BCC", "BSI", "BEC" };
    private String[] nomeCursos = {"Sistemas para Internet", " Análise e Desenv. Sistemas", "Ciência da Computação", "Sistemas de Informação", "Engenharia da Computação"};

    static App a= new App();

    public void calcMensalidade(){

        Opcoes o = new Opcoes();
        o.codCurso = App.t.inputString("Informe o código do curso");
        o.codBolsa = App.t.inputString("Informe o código da bolsa se houver");
        Resultado r = this.calcMensalidade(o);
        a.mostrarResultado(r);
    } 

    private Resultado calcMensalidade(Opcoes opcoes) {

        Double mens = 0.0;

        String nome = verifNomeCurso(opcoes.codCurso);
        Double mensBase = verificarMensalidade(opcoes.codCurso);
        Double desc = verificarDesconto(opcoes.codBolsa);
        if(desc > 1) {
            mens = mensBase - desc;
        }else {
            mens = mensBase - mensBase*desc;
        }
        
        String bolsa = verificarBolsa(opcoes.codBolsa);
        
        return new Resultado(mens, desc, nome, bolsa);
    }

    private String verifNomeCurso(String codCurso) {
        String curso = "";

        for (int i = 0; i < cursos.length; i++) {
            if (codCurso.matches(cursos[i])) {
                curso = this.nomeCursos[i];
                return curso;
            } else {
                codCurso = "Curso não disponível";
                if (i == cursos.length - 1) {
                    App.menu();
                }
            }
        }
        return curso;
    }

    private double verificarMensalidade(String codC) {
        
        double m = 0;

        switch (codC.toUpperCase()) {
            case "TSI":  m =  915.00; break;
            case "TADS": m =  836.00; break;
            case "BCC":  m = 1559.00; break;
            case "BSI":  m = 1400.00; break;
            case "BEC":  m = 1758.00; break;
            default: App.menu(); break;
        }
        return m;
    }

    private String verificarBolsa(String codBolsa) {
        String b = "";
        switch (codBolsa) {
            case "MON": b = "Monitoria"; break;
            case "EMP": b = "Ensino Médio Público"; break;
            case "ISE": b = "Isenção"; break;
            case "EXT": b = "Projeto de Extensão"; break;
            case "PES": b = "Pesquisa Científica"; break;
            default: b = "Nenhuma"; break;
        }
        return b;
    }

    private double verificarDesconto(String codB) {
        double desc = 0;
        switch (codB) {
            case "MON": desc = 0.25; break;
            case "EMP": desc = 0.5; break;
            case "ISE": desc = 1; break;
            case "EXT": desc = 1000.00; break;
            case "PES": desc = 1500.00; break;
            default: desc = 0; break;
        }
        return desc;
    }
}

class Opcoes{
    String codCurso;
    String codBolsa;
}
