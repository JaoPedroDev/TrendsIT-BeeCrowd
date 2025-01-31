import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static int getMaxLucro(int custoPorDia, int[] dias) {
        int lucroMaximo = 0;
        int lucroAtual = 0;

        for (int dia : dias) {
            int lucroDiario = dia - custoPorDia;
            lucroAtual = Math.max(0, lucroAtual + lucroDiario);
            lucroMaximo = Math.max(lucroMaximo, lucroAtual);
        }

        return lucroMaximo;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        StringBuilder saida = new StringBuilder();
        while (scanner.hasNext()) {
            int numDias = scanner.nextInt();
            scanner.nextLine();
            int custoPorDia = scanner.nextInt();
            scanner.nextLine();

            int[] dias = IntStream.range(0, numDias)
                    .map(i -> scanner.nextInt())
                    .toArray();

            saida.append(getMaxLucro(custoPorDia, dias))
                    .append("\n");
        }

        System.out.print(saida);

        scanner.close();

    }

}
