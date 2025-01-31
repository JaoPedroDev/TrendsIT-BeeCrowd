import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int getResultado(String str) {
        int diamonds = 0;
        String currentStr = str;
        String replacedStr = str;
        while (true) {
            // System.out.println(currentStr);
            // System.out.println(replacedStr);
            currentStr = replacedStr;
            replacedStr = currentStr.replaceFirst("<>", "");
            if (currentStr.equals(replacedStr)) {
                break;
            }
            diamonds++;
        }

        return diamonds;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int qtdCasos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder saida = new StringBuilder();
        while (qtdCasos-- > 0) {
            saida.append(getResultado(scanner.nextLine().replace(".", "")));
            saida.append("\n");
        }

        System.out.print(saida);

        scanner.close();
    }

}
