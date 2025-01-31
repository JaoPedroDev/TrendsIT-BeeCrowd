import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String getResultado(String operacao) {
        String[] split = operacao.split(" ");

        // Index: 0 1 2 3 4 5 6
        // Opera: 1 / 2 + 3 / 4
        int n1 = Integer.parseInt(split[0]);
        int d1 = Integer.parseInt(split[2]);
        String sinal = split[3];
        int n2 = Integer.parseInt(split[4]);
        int d2 = Integer.parseInt(split[6]);

        int numerador;
        int denominator;
        switch (sinal) {
            case "+":
                numerador = n1 * d2 + n2 * d1;
                denominator = d1 * d2;
                break;
            case "-":
                numerador = n1 * d2 - n2 * d1;
                denominator = d1 * d2;
                break;
            case "*":
                numerador = n1 * n2;
                denominator = d1 * d2;
                break;
            case "/":
                numerador = n1 * d2;
                denominator = n2 * d1;
                break;
            default:
                numerador = 0;
                denominator = 0;
                break;
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append(numerador + "/" + denominator);

        int mdc = getMDC(numerador, denominator);

        int numeradorSimp = numerador / mdc;
        int denominadorSimp = denominator / mdc;

        resultado.append(" = ");
        resultado.append(numeradorSimp + "/" + denominadorSimp);

        return resultado.toString();
    }

    public static int getMDC(int a, int b) {
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }

        return Math.abs(a);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int qtdCasos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < qtdCasos; i++) {
            saida.append(getResultado(scanner.nextLine()) + "\n");
        }

        System.out.print(saida);

        scanner.close();
    }

}
