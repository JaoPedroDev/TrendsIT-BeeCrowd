import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] palavras = new String[3];
        for (int i = 0; i < 3; i++) {
            palavras[i] = scanner.nextLine();
        }

        HashMap<String, String[]> animais = new HashMap<>();
        animais.put("aguia", new String[] { "vertebrado", "ave", "carnivoro" });
        animais.put("pomba", new String[] { "vertebrado", "ave", "onivoro" });
        animais.put("homem", new String[] { "vertebrado", "mamifero", "onivoro" });
        animais.put("vaca", new String[] { "vertebrado", "mamifero", "herbivoro" });
        animais.put("pulga", new String[] { "invertebrado", "inseto", "hematofago" });
        animais.put("lagarta", new String[] { "invertebrado", "inseto", "herbivoro" });
        animais.put("sanguessuga", new String[] { "invertebrado", "anelideo", "hematofago" });
        animais.put("minhoca", new String[] { "invertebrado", "anelideo", "onivoro" });

        for (String chave : animais.keySet()) {
            if (Arrays.equals(animais.get(chave), palavras)) {
                System.out.println(chave);
                break;
            }
        }

        scanner.close();
    }

}
