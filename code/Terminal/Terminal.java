package Terminal;

import javax.swing.JOptionPane;

public class Terminal {

    public void prt(String msg) {
        System.out.println(msg);
    }

    public void msg(String msg) {
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

    
}
