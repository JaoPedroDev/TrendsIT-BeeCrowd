import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static String getResultado(int num) {
        ArrayDeque<Integer> pilha = new ArrayDeque<>();
        IntStream.rangeClosed(1, num).forEach(pilha::add);

        StringBuilder saida = new StringBuilder();
        saida.append("Discarded cards:");
        while (pilha.size() > 1) {
            saida.append(" " + pilha.pop() + (pilha.size() == 1 ? "" : ","));
            pilha.add(pilha.pop());
        }
        saida.append("\nRemaining card: " + pilha.getFirst());

        return saida.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int caso;
        StringBuilder saida = new StringBuilder();
        while (true) {
            caso = scanner.nextInt();
            if (caso == 0) {
                break;
            }
            saida.append(getResultado(caso));
            saida.append("\n");
        }

        System.out.print(saida);

        scanner.close();

    }
}
