/*
Guilherme Policarpo de Carvalho
*/

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class QuickSort {

    static int contadorQS = 0;
    static int contadorP = 0;

    public static void main(String[] args) {

        int t = 3000;
        int[] v = new int[t];
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) (Math.random() * t) + 1;
        }

        imprime(v);
        Instant inicio = Instant.now();
        quickSort(v, 0, v.length);
        Instant termino = Instant.now();

        Duration tempo = Duration.between(inicio, termino);
        imprime(v);
        System.out.println("Tempo de execução: " + tempo);

        System.out.println("Quantas vezes o metodo quickSort() foi chamado: " + contadorQS);
        System.out.println("Quantas vezes o metodo particiona() foi chamado: " + contadorP);
    }

    //
    public static void quickSort(int[] valor, int inicio, int termino) {

        contadorQS++;

        //// CB

        //// CR
        if (termino - inicio > 1) {

            int posicaoPivo = particiona(valor, inicio, termino);

            // ordenar o lado da esquerda
            quickSort(valor, inicio, posicaoPivo);

            // ordenar o lado da direita
            quickSort(valor, posicaoPivo + 1, termino);
        }
    }

    //
    public static int particiona(int[] valor, int inicio, int termino) {

        contadorP++;

        int menoresEncontrados = inicio;
        int posicaoDoPivo = termino - 1;

        int pivo = valor[posicaoDoPivo];

        for (int atual = inicio; atual < posicaoDoPivo; atual++) {

            int nota = valor[atual];

            if (nota < pivo) {

                troca(valor, atual, menoresEncontrados);

                menoresEncontrados++;
            }
        }

        troca(valor, posicaoDoPivo, menoresEncontrados);

        return menoresEncontrados;
    }

    //
    public static void troca(int[] valor, int origem, int destino) {

        int notaOrigem = valor[origem];
        int notaDestino = valor[destino];

        valor[origem] = notaDestino;
        valor[destino] = notaOrigem;
    }

    //
    public static void imprime(int[] valor) {

        for (int fim : valor) {

            System.out.println(fim);
        }

        System.out.println();
    }
}