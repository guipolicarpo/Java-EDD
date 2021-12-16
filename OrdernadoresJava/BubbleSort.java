/*
Guilherme Policarpo de Carvalho
*/

import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;
public class BubbleSort {

    static int contador = 0;

    public static void main (String[] args) {
        int t = 2000;

        int[] p = new int [ t ];

        for ( int i = 0 ; i < p.length ; i++ ) {

            p[i] = (int)(Math.random() * t) + 1;
        }


        imprime ( p );
        Instant inicio = Instant.now();

        ordena ( p, 0, p.length );
        Instant termino = Instant.now();
        Duration tempo = Duration.between (  inicio, termino );

        imprime ( p );
        System.out.println("Tempo de execução: " + tempo );

        System.out.println("\nContador: " + contador);

    }


    //                                       0            5
    static void ordena ( int[] vetor, int inicio, int termino ) {

        for ( int atual = inicio ; atual < termino - 1 ; atual++ ) {

            //LOG
            System.out.println("Atual: " + atual );

            //                                                 |||||||
            for ( int posicao = inicio ; posicao < termino - 1 - atual ; posicao++ ) {
                //                                             |||||||

                contador++;

                //LOG
                System.out.println("Teste >> [" + posicao + "]: " + vetor[posicao] +
                        " > [" + (posicao + 1) + "]: " + vetor[posicao + 1]);

                if ( vetor [ posicao ] > vetor [ posicao + 1 ] ) {

                    troca ( vetor, posicao, posicao + 1 );
                }
            }
            System.out.println("------\n");
        }
    }


    //
    static void troca ( int[] vetor, int de, int para ) {

        int  posicaoDe  = vetor [  de  ];
        int posicaoPara = vetor [ para ];

        vetor [  de  ] = posicaoPara;
        vetor [ para ] =  posicaoDe;

        System.out.print("\n>");
        imprime ( vetor );
    }


    //
    static void imprime ( int[] vetor ) {

        System.out.println ( Arrays.toString ( vetor ) );
    }
}