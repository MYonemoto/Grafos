/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Geovani
 */
public class Principal {

    public static void main(String[] args) {

            String arquivo = "GROUP 1/MDGraph20_20.txt";
        ArrayList<Grafo> grafos = Read.CarregaGrafosLista(Read.CarregaGrafosMatriz(arquivo));
        MVCA mvca = new MVCA();
        float mediaTempo = 0;
        Double mediaRotulos = 0.0;
        Integer i = 0;
        for (Grafo g : grafos) {
            long tempoInicial = 0;
            i++;
            System.out.println("\n\n#####     Arquivo  :  " + arquivo);
            System.out.println("#####    Grafo  :" + i);
            
            //Buscas.IniciaBuscaProfundidade(g);
            if (Grafo.isConexo(g)) {
                 tempoInicial = new GregorianCalendar().getTimeInMillis();
                mvca.Rotulos(g);
                mediaRotulos = mediaRotulos + g.rotulos;
            } else {
                System.out.println(" grafo nao conexooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
                
            }

            long tempoFinal = new GregorianCalendar().getTimeInMillis() - tempoInicial;
            mediaTempo  = mediaTempo+ tempoFinal;
            System.out.println("\n Tempo gasto  : " + tempoFinal + "ms");
        }
        DecimalFormat d =  new DecimalFormat("#.##");
        float p = mediaTempo/10;
        System.out.println("Media rotulos " + d.format(mediaRotulos/10));
        System.out.println("Media tempo :  " + mediaTempo/10);
    }
}
