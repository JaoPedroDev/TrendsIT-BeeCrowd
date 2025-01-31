import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int qtdNumeros = scanner.nextInt();
        scanner.nextLine();

        TreeMap<Integer, Integer> contadorNumeros = new TreeMap<>();
        for (int i = 0; i < qtdNumeros; i++) {
            Integer numero = scanner.nextInt();
            contadorNumeros.put(numero, contadorNumeros.getOrDefault(numero, 0) + 1);
        }

        StringBuilder saida = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : contadorNumeros.entrySet()) {
            saida.append(String.format("%d aparece %d vez(es)\n", entry.getKey(), entry.getValue()));
        }

        System.out.print(saida);

        scanner.close();
    }

}
