import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int qtdCasos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder saida = new StringBuilder();
        while (qtdCasos-- > 0) {
            String[] palavras = scanner.nextLine().split(" ");

            Arrays.sort(palavras, Comparator.comparingInt(String::length).reversed());

            saida.append(String.join(" ", palavras))
                    .append("\n");
        }

        System.out.print(saida);

        scanner.close();
    }

}
