/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Geovani
 */
public class Principal {

    public static void main(String[] args) {

        
        
        String arquivo = "GROUP 1/HDGraph30_30.txt";
        ArrayList<Grafo> grafos = Read.CarregaGrafosLista(Read.CarregaGrafosMatriz(arquivo));

        Integer i = 0;
        for (Grafo g : grafos) {
            i++;
            System.out.println("\n\n#####     Arquivo  :  "+ arquivo);
            System.out.println("#####    Grafo  :"  + i);
            MVCA mvca = new MVCA();
            mvca.Rotulos(g);
        }
    }
//        
//        int[][] matriz = new int[8][8];
//
//        matriz[0][0] = -1;
//        matriz[0][1] = 5;
//        matriz[0][2] = 3;
//        matriz[0][3] = -1;
//        matriz[0][4] = -1;
//        matriz[0][5] = -1;
//        matriz[0][6] = -1;
//        matriz[0][7] = 10;
//
//        matriz[1][0] = 5;
//        matriz[1][1] = -1;
//        matriz[1][2] = 5;
//        matriz[1][3] = -1;
//        matriz[1][4] = -1;
//        matriz[1][5] = -1;
//        matriz[1][6] = -1;
//        matriz[1][7] = -1;
//
//        matriz[2][0] = 3;
//        matriz[2][1] = 5;
//        matriz[2][2] = -1;
//        matriz[2][3] = 8;
//        matriz[2][4] = 1;
//        matriz[2][5] = 5;
//        matriz[2][6] = 2;
//        matriz[2][7] = 8;
//
//        matriz[3][0] = -1;
//        matriz[3][1] = -1;
//        matriz[3][2] = 8;
//        matriz[3][3] = -1;
//        matriz[3][4] = 8;
//        matriz[3][5] = -1;
//        matriz[3][6] = -1;
//        matriz[3][7] = -1;
//
//        matriz[4][0] = -1;
//        matriz[4][1] = -1;
//        matriz[4][2] = 1;
//        matriz[4][3] = 8;
//        matriz[4][4] = -1;
//        matriz[4][5] = 3;
//        matriz[4][6] = -1;
//        matriz[4][7] = -1;
//
//        matriz[5][0] = -1;
//        matriz[5][1] = -1;
//        matriz[5][2] = 5;
//        matriz[5][3] = -1;
//        matriz[5][4] = 3;
//        matriz[5][5] = -1;
//        matriz[5][6] = 10;
//        matriz[5][7] = -1;
//
//        matriz[6][0] = -1;
//        matriz[6][1] = -1;
//        matriz[6][2] = 2;
//        matriz[6][3] = -1;
//        matriz[6][4] = -1;
//        matriz[6][5] = 10;
//        matriz[6][6] = -1;
//        matriz[6][7] = 3;
//
//        matriz[7][0] = 10;
//        matriz[7][1] = -1;
//        matriz[7][2] = 8;
//        matriz[7][3] = -1;
//        matriz[7][4] = -1;
//        matriz[7][5] = -1;
//        matriz[7][6] = 3;
//        matriz[7][7] = -1;
//
//        Grafo g1 = new Grafo(8);
//        g1.setMatriz(matriz);
//        ArrayList<Grafo> grafos = new ArrayList<>();
//        grafos.add(g1);
//        grafos = Read.CarregaGrafosLista(grafos);
}
