import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static int getAlunos(int qtdAlunos, String notas) {
        Integer[] alunos = Arrays.stream(notas.trim().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] alunosSorted = Arrays.stream(alunos)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        int qtdAlunosMesmoLugar = 0;
        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].equals(alunosSorted[i])) {
                qtdAlunosMesmoLugar++;
            }
        }

        return qtdAlunosMesmoLugar;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int qtdCasos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder saida = new StringBuilder();
        while (qtdCasos-- > 0) {
            int qtdAlunos = scanner.nextInt();
            scanner.nextLine();
            String notas = scanner.nextLine();
            saida.append(getAlunos(qtdAlunos, notas))
                    .append("\n");
        }

        System.out.print(saida);

        scanner.close();

    }

}
