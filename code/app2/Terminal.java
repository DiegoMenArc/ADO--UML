package app2;

import javax.swing.JOptionPane;

public class Terminal {
    Uni u = new Uni();

    public void prt(String msg) {
        System.out.println(msg);
    }

    public void msg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public Integer inputInt(String msg) {
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }

    public Double inputDouble(String msg) {
        return Double.parseDouble(JOptionPane.showInputDialog(msg));
    }

    public String inputString(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

     public void menu() {
            // Integer e = Integer.parseInt(JOptionPane.showInputDialog(null, """
            //  1. Consultar
            //  2. Ver cursos disponíveis
            //  3. Sair
            //  """, "MENU", 0));
        // Op(e);
    }

    private void Op(int e) {
        switch (e) {
            case 1:
                u.coleta();
                break;
            case 2:
                
                break;
            case 3:
                System.exit(0);;
                break;
            default:
                menu();
                break;
        }
    }
}
