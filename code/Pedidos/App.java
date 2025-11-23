package Pedidos;

import Terminal.Terminal;

public class App{
    static Terminal t = new Terminal(); 
    static Pedido p = new Pedido();
    
    public static void main(String[] args){
        menu();
    }

    public static void menu() {
      Integer e = t.inputInt("""
            MENU
            1. Fazer pedido
            2. Ver pedidos anteriores

            0. Sair
            """);
      switch (e) {
         case 1:
            Response res;
            res = p.calcTotal();
            resultado(res);
            menu();
            break;

         case 2:
            p.pedidosAnteriores();
            break;
         case 0: System.exit(0);break;

         default:
            menu();
            break;
      }
   }

   public static void resultado(Response r) {
      System.out.printf("""
            Valor total da compra: %.2f
            Valor das parcelas: %.2f
            Número de Parcelas: %d
            Desconto adquirido pelo cupom usado: %.2f
            """, r.lerTotal(), r.lerValorParcela(), r.lerParcelas(), r.lerValorCupom()
      );

      menu();
   }
}