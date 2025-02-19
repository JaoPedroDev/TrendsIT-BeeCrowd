import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int instancias = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < instancias; t++) {
            String[] mn = scanner.nextLine().split(" ");
            int qtdPalavras = Integer.parseInt(mn[0]);
            int qtdLinhas = Integer.parseInt(mn[1]);

            HashMap<String, String> dicionario = new HashMap<>();

            for (int i = 0; i < qtdPalavras; i++) {
                String palavraJaponesa = scanner.nextLine();
                String traducaoPortugues = scanner.nextLine();
                dicionario.put(palavraJaponesa, traducaoPortugues);
            }

            StringBuilder saida = new StringBuilder();
            for (int i = 0; i < qtdLinhas; i++) {
                String linha = scanner.nextLine();
                if (!linha.isEmpty()) {
                    String[] palavras = linha.split(" ");
                    for (int j = 0; j < palavras.length; j++) {
                        String palavraTraduzida = dicionario.getOrDefault(palavras[j], palavras[j]);
                        saida.append(palavraTraduzida);
                        if (j < palavras.length - 1) {
                            saida.append(" ");
                        }
                    }
                }
                saida.append("\n");
            }

            System.out.println(saida);
        }

        scanner.close();
    }
}
