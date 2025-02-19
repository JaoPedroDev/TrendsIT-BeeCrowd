import java.io.IOException;
import java.util.Scanner;

public class Main {

    record Sequencia(String sequencia, int tamanho) {
    }

    public static Sequencia getSequencia(int num) {
        StringBuilder seq = new StringBuilder();
        int tamanhoSeq = 1;

        seq.append("0");

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                tamanhoSeq++;
                seq.append(" " + i);
            }
        }
        seq.append("\n");

        return new Sequencia(seq.toString(), tamanhoSeq);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        StringBuilder saida = new StringBuilder();

        int i = 1;
        while (scanner.hasNext()) {
            Sequencia seq = getSequencia(scanner.nextInt());

            saida.append(
                    String.format("Caso %d: %d %s\n",
                            i,
                            seq.tamanho(),
                            seq.tamanho() == 1 ? "numero" : "numeros"));
            saida.append(seq.sequencia());
            saida.append("\n");
            i++;
        }

        System.out.print(saida);

        scanner.close();
    }

}
