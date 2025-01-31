import java.io.IOException;

import java.util.Scanner;

/**
 * IMPORTANT:
 * O nome da classe deve ser "Main" para que a sua solução execute
 * Class name must be "Main" for your solution to execute
 * El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int horaInicial = scanner.nextInt();

        int minutoInicial = scanner.nextInt();

        int horaFinal = scanner.nextInt();

        int minutoFinal = scanner.nextInt();

        int tempoInicialEmMinutos = horaInicial * 60 + minutoInicial;
        int tempoFinalEmMinutos = horaFinal * 60 + minutoFinal;

        if (tempoFinalEmMinutos < tempoInicialEmMinutos) {
            tempoFinalEmMinutos += 1440;
        }

        int tempoDeJogoEmMinutos = tempoFinalEmMinutos - tempoInicialEmMinutos;

        int horasDeJogo = 24;
        int minutosDeJogo = 0;

        if (tempoDeJogoEmMinutos != 0) {
            horasDeJogo = tempoDeJogoEmMinutos / 60;
            minutosDeJogo = tempoDeJogoEmMinutos % 60;
        }

        System.out.println("Tempo Inicial em Minutos: " + tempoInicialEmMinutos);
        System.out.println("Tempo Final em Minutos: " + tempoFinalEmMinutos);
        System.out.println("Tempo de Jogo em Minutos: " + tempoDeJogoEmMinutos);
        System.out.println("O JOGO DUROU " + horasDeJogo + " HORA(S) E " + minutosDeJogo + " MINUTO(S)");

        scanner.close();

    }

}
