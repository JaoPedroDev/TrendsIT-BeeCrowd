import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int qtdEstrelas = scanner.nextInt();
        scanner.nextLine();

        int[] estrelas = new int[qtdEstrelas];
        for (int i = 0; i < qtdEstrelas; i++) {
            estrelas[i] = scanner.nextInt();
        }

        boolean[] atacadas = new boolean[qtdEstrelas];

        int i = 0;
        while (i < qtdEstrelas && i >= 0) {
            atacadas[i] = true;
            int carneirosAnteriores = estrelas[i];
            if (carneirosAnteriores > 0) {
                estrelas[i]--;
            }

            i += (carneirosAnteriores % 2 == 0) ? -1 : 1;
        }

        int estrelasAtacadas = 0;
        long carneirosRestantes = 0;

        for (int j = 0; j < qtdEstrelas; j++) {
            if (atacadas[j]) {
                estrelasAtacadas++;
            }
            carneirosRestantes += estrelas[j];
        }

        System.out.printf("%d %d%n", estrelasAtacadas, carneirosRestantes);

        scanner.close();
    }

}
