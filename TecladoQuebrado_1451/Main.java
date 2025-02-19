import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            LinkedList<StringBuilder> segmentos = new LinkedList<>();
            segmentos.add(new StringBuilder());

            boolean atHome = false;

            for (char c : line.toCharArray()) {
                if (c == '[') {
                    segmentos.addFirst(new StringBuilder());
                    atHome = true;
                } else if (c == ']') {
                    segmentos.addLast(new StringBuilder());
                    atHome = false;
                } else {
                    if (atHome) {
                        segmentos.getFirst().append(c);
                    } else {
                        segmentos.getLast().append(c);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder segment : segmentos) {
                result.append(segment);
            }

            System.out.println(result);
        }

        scanner.close();
    }
}
