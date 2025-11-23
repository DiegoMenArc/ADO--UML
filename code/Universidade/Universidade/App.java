package Universidade;

import javax.swing.JOptionPane;

import Terminal.Terminal;

public class App {
    static Terminal t = new Terminal();
    static Uni u = new Uni();
    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        Integer e = Integer.parseInt(JOptionPane.showInputDialog(null, """
                  1. Calcular Mensalidade
                  2. Ver cursos disponíveis
                  3. Ver programa de bolsas

                  0. Sair
                """, "MENU", 1));
        switch (e) {
            case 1:
                u.calcMensalidade();
                break;
            case 2:
                cursos();
                menu();
                break;
            case 3:
                bolsas();
                menu();
                break;
            case 0:
                System.exit(0);
            default:
                menu();
                break;
        }
    }

    public static void cursos() {
        t.msg("""
                Cursos:
                MON - Monitoria - Desconto: % 25
                EMP Ensino Médio Público - Desconto: % 50
                ISE Isenção - Desconto: % 100
                EXT Projeto de Extensão - Desconto: R$ 1000,00
                PES Pesquisa Científica - Desconto: R$ 1500,00
                                """);
    }

    public static void bolsas() {
        t.msg("""
                Cursos:

                TSI Sistemas para Internet - Mensalidade: R$ 915,00
                TADS Análise e Desenv. Sistemas - Mensalidade: R$ 836,00
                BCC Ciência da Computação - Mensalidade: R$ 1.559,00
                BSI Sistemas de Informação - Mensalidade: R$ 1.400,00
                BEC Engenharia da Computação - Mensalidade: R$ 1.758,00
                """);
    }

    public void mostrarResultado(Resultado r){
        String curso = "Curso: "+r.lerCurso();
        String mensalidade = "Mensalidade: "+r.lerMensalidade();
        String bolsa = "Bolsa: "+r.lerBolsa();
        String desconto = "Desconto: "+r.lerDesc()+"%";

        System.out.printf("""
                %s
                %s
                %s
                %s
                """, curso, mensalidade, bolsa, desconto);
        menu();
    }
}
