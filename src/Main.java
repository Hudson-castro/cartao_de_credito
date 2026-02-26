import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = sc.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descrição da compra: ");
            String descricao = sc.next();

            System.out.println("Digite o valor da compra: ");
            double valor = sc.nextDouble();

            Compras compras = new Compras(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compras);
            if (compraRealizada) {
                System.out.println("Compra realizada");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = sc.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }

        }
        System.out.println("------------------------");
        System.out.println("COMPRAS REALIZADAS");

        Collections.sort(cartao.getCompras());
        for (Compras c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor());

        }
        System.out.println("\n------------------------");
        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());

    }
}