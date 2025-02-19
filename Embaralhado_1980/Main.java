import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static long factorial(int num) {
        long resultado = 1;
        for (int i = 2; i <= num; i++) {
            resultado *= i;
        }

        return resultado;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        StringBuilder saida = new StringBuilder();
        while (true) {
            String letras = scanner.nextLine();
            if (letras.equals("0")) {
                break;
            }

            saida.append(factorial(letras.length()))
                    .append("\n");

        }

        System.out.print(saida);

        scanner.close();
    }

}
