import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final float TEMPO = 0.01f;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        StringBuilder valores = new StringBuilder();
        for (int i = 0; i < T; i++) {
            valores.append(String.format("%.2f\n", (scanner.next().length() * TEMPO)));
        }

        System.out.print(valores);
        scanner.close();
    }

}
