/*
Guilherme Policarpo de Carvalho
*/

import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;

public class ArraySort {
    public static void main(String[] args) {
        int t = 3000;
        int[] v = new int[t];
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) (Math.random() * t) + 1;
        }
        Instant inicio = Instant.now();
        Arrays.sort(v);
        Instant termino = Instant.now();
        Duration tempo = Duration.between(inicio, termino);

        System.out.printf("Modified arr[] : %s",
                Arrays.toString(v));
        System.out.println("Tempo de execução: " + tempo);
    }
}