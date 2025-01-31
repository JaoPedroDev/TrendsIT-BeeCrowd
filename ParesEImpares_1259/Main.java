import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int qtdCasos = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();
        while (qtdCasos-- > 0) {
            int numero = scanner.nextInt();
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }

        Collections.sort(pares);
        Collections.sort(impares);

        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < pares.size(); i++) {
            saida.append(pares.get(i) + "\n");
        }

        for (int i = impares.size() - 1; i >= 0; i--) {
            saida.append(impares.get(i) + "\n");
        }

        System.out.print(saida);

        scanner.close();

    }

}
