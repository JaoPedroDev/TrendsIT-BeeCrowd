import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int maxTime;
    static Pedido[] pedidos;
    static int n, maxPizzas;

    static class Pedido {
        int mins;
        int qtd;

        public Pedido(int mins, int qtd) {
            this.mins = mins;
            this.qtd = qtd;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            n = scanner.nextInt();
            if (n == 0)
                break;

            maxPizzas = scanner.nextInt();
            pedidos = new Pedido[n];

            for (int i = 0; i < n; i++) {
                int mins = scanner.nextInt();
                int qtd = scanner.nextInt();
                pedidos[i] = new Pedido(mins, qtd);
            }

            maxTime = 0;

            backtrack(0, 0, 0);

            System.out.println(maxTime + " min.");
        }

        scanner.close();
    }

    public static void backtrack(int index, int pizzas, int time) {
        if (pizzas > maxPizzas)
            return;
        if (index == n) {
            maxTime = Math.max(maxTime, time);
            return;
        }

        backtrack(index + 1, pizzas + pedidos[index].qtd, time + pedidos[index].mins);

        backtrack(index + 1, pizzas, time);
    }
}
