/*
Guilherme Policarpo de Carvalho
*/

import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;

public class Select {

    public static void main (String[] args) {

        int t = 3000;

        int[] professores = new int [ t ];

        for ( int i = 0 ; i < professores.length ; i++ ) {

            professores[i] = (int)(Math.random() * t) + 1;
        }


        imprime ( professores );

        Instant inicio = Instant.now();

        ordena ( professores, 0, professores.length );

        Instant termino = Instant.now();

        Duration tempo = Duration.between (  inicio, termino );

        imprime ( professores );

        System.out.println("Tempo de execução: " + tempo );
    }

    //
    static void ordena ( int[] vetor, int inicio, int termino ) {

        for ( int atual = inicio ; atual < termino - 1 ; atual++ ) {

            int menor = buscaMenor ( vetor, atual , termino );

            troca ( vetor, menor, atual );

            //System.out.print(".");
        }
        //System.out.println();
    }

    //
    static void troca ( int[] vetor, int de, int para ) {

        int  posicaoDe  =  vetor[de];
        int posicaoPara = vetor[para];

        vetor[de]  = posicaoPara;
        vetor[para] =  posicaoDe;

        //System.out.print(">");
        //imprime ( vetor );

    }

    //
    static int buscaMenor ( int[] vetor, int inicio , int termino ) {

        int menor = inicio;

        for ( int posicao = inicio + 1 ; posicao < termino ; posicao++ ) {

            if ( vetor[posicao] < vetor[menor] ) {

                menor = posicao;
            }
        }

        return menor;
    }

    //
    static void imprime ( int[] vetor ) {

        if ( vetor.length > 20 ) {
            for ( int i = 0 ; i < 10 ; i ++) {
                System.out.print( vetor[i] + " " );
            }
            System.out.println("\n...");
            for ( int i = vetor.length - 10 ; i < vetor.length ; i ++) {
                System.out.print( vetor[i] + " " );
            }
            System.out.println();

        } else {
            System.out.println( Arrays.toString ( vetor )  );
        }
    }
}
