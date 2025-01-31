import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int counter = -1;

    public static int fibonnaci(int result) {
        counter++;
        if (result == 0) {
            return 0;
        }
        if (result == 1) {
            return 1;
        }

        return fibonnaci(result - 1) + fibonnaci(result - 2);
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int qtdCasos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder saida = new StringBuilder();
        while (qtdCasos-- > 0) {
            int num = scanner.nextInt();
            int fibResult = fibonnaci(num);
            saida.append(String.format("fib(%d) = %d calls = %d\n", num, counter, fibResult));
            counter = -1;
        }

        System.out.print(saida);

        scanner.close();

    }

}
