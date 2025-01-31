import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void gerarMatriz(int tamanho) {
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                int num = 1 + Math.abs(i - j);
                if (j > 0) {
                    saida.append(" ");
                }

                saida.append(String.format("%3d", num));
            }
            saida.append("\n");
        }
        System.out.println(saida);
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> tamanhos = new ArrayList<>();

        int num;
        while ((num = scanner.nextInt()) != 0) {
            tamanhos.add(num);
        }

        for (int tamanho : tamanhos) {
            gerarMatriz(tamanho);
        }

        scanner.close();
    }

}
