/*
Guilherme Policarpo de Carvalho
*/

import java.time.Duration;
import java.util.Arrays;
import java.time.Instant;
public class Insertion {

    public static void main (String[] args) {
        int t = 3000;

        int[] professores = new int [ t ];

        for ( int i = 0 ; i < professores.length ; i++ ) {

            professores[i] = (int)(Math.random() * t) + 1;
        }

        imprime ( professores );
        Instant inicio = Instant.now();
        ordena ( professores, 1, 4 );
        // { 16, 4, 40, 64, 30 }
        Instant termino = Instant.now();
        Duration tempo = Duration.between (  inicio, termino );

        imprime ( professores );
        System.out.println("Tempo de execução: " + tempo );

    }


    //
    static void ordena ( int[] vetor, int inicio, int termino ) {

        int posicao = 0;

        for ( int atual = inicio + 1 ; atual < termino ; atual++ ) {

            posicao = atual;
            // LOG
            System.out.println("\nPosicao atual: " + posicao);

            // LOG
            System.out.println("Testando: " + vetor[posicao] + " < " + vetor[posicao - 1]);
            while ( posicao > 0 && vetor[posicao] < vetor[posicao - 1] ) {
                // LOG
                System.out.println("Elemento na posicao: " + vetor[posicao]);
                System.out.println("Elemento na posicao anterior: " + vetor[posicao - 1]);

                troca ( vetor, posicao, posicao - 1 );

                posicao--;
                // LOG
                System.out.println("\nPosicao atual: " + posicao);
            }
        }
    }


    //
    static void troca ( int[] vetor, int de, int para ) {

        int  posicaoDe  = vetor [  de  ];
        int posicaoPara = vetor [ para ];

        // LOG
        System.out.println("Trocando: " + posicaoDe + " com " + posicaoPara );

        vetor [  de  ] = posicaoPara;
        vetor [ para ] =  posicaoDe;

        // LOG
        System.out.print(">");
        imprime ( vetor );
    }


    //
    static void imprime ( int[] vetor ) {

        System.out.println ( Arrays.toString ( vetor ) );
    }
}
