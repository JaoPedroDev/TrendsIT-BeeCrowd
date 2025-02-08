import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int qtdCasos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder saida = new StringBuilder();
        while (qtdCasos-- > 0) {
            int qtdProdutosFeira = scanner.nextInt();
            scanner.nextLine();

            HashMap<String, Long> produtosFeira = new HashMap<>();
            while (qtdProdutosFeira-- > 0) {
                String[] produto = scanner.nextLine().split(" ");

                produtosFeira.put(
                        produto[0],
                        Long.parseLong(produto[1].replace(".", "")));
            }

            int qtdProdutosComprados = scanner.nextInt();
            scanner.nextLine();

            long sum = 0;
            while (qtdProdutosComprados-- > 0) {
                String[] produtoComprado = scanner.nextLine().split(" ");

                sum += (produtosFeira.get(produtoComprado[0]) *
                        Long.parseLong(produtoComprado[1]));
            }

            saida.append(String.format("R$ %.2f\n", sum / 100.0));

        }

        System.out.print(saida);

        scanner.close();
    }

}
