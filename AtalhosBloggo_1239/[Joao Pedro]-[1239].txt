import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        StringBuilder textoFinal = new StringBuilder();
        while (scanner.hasNext()) {
            String texto = scanner.nextLine();

            boolean italicoAberto = false;
            boolean negritoAberto = false;

            for (char c : texto.toCharArray()) {
                if (c == '_' && !italicoAberto) {
                    textoFinal.append("<i>");
                    italicoAberto = true;
                    continue;
                }

                if (c == '_' && italicoAberto) {
                    textoFinal.append("</i>");
                    italicoAberto = false;
                    continue;
                }

                if (c == '*' && !negritoAberto) {
                    textoFinal.append("<b>");
                    negritoAberto = true;
                    continue;
                }

                if (c == '*' && negritoAberto) {
                    textoFinal.append("</b>");
                    negritoAberto = false;
                    continue;
                }

                textoFinal.append(c);
            }
            textoFinal.append("\n");
        }

        System.out.print(textoFinal);

        scanner.close();
    }

}
