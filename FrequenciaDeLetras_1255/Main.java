import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static String getFrequenciaLetras(String texto) {
        TreeMap<Character, Integer> contador = new TreeMap<>();

        for (char letra : texto.toLowerCase().replaceAll("[^a-z]", "").toCharArray()) {
            contador.put(letra, contador.getOrDefault(letra, 0) + 1);
        }

        int frequenciaMaxima = Collections.max(contador.values());

        StringBuilder letras = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : contador.entrySet()) {
            if (entry.getValue() == frequenciaMaxima) {
                letras.append(entry.getKey());
            }
        }

        return letras.toString();
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int qtdTextos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < qtdTextos; i++) {
            saida.append(getFrequenciaLetras(scanner.nextLine()));
            saida.append("\n");
        }

        System.out.print(saida);
        scanner.close();
    }

}
