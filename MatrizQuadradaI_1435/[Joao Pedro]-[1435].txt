import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void gerarMatriz(int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                int num = Math.min(
                        Math.min(i, j),
                        Math.min(tamanho - i - 1, tamanho - j - 1)) + 1;

                System.out.print((j == 0 ? "" : " ") + String.format("%3d", num));
            }
            System.out.println();
        }
        System.out.println();
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
