/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Geovani
 */
public class Read {

    public static ArrayList<Grafo> CarregaGrafosMatriz(String arquivo) {
        ArrayList<Grafo> grafos = new ArrayList<Grafo>();

        ArrayList<String> texto = abrirArquivo(arquivo);

        String[] linha = texto.get(0).split(" ");
        Integer tamanho = Integer.parseInt(linha[0]);
        Integer peso = Integer.parseInt(linha[1]);
        int inicio = 1, fim = inicio + tamanho;

        while (fim <= texto.size()) {

            List<String> text = texto.subList(inicio, fim);
            Collections.reverse(text);

            Grafo matriz = new Grafo(tamanho);

            for (Integer i = 0; i < tamanho; i++) {
                linha = text.get(i).split(" ");

                for (Integer k = 0; k < linha.length; k++) {
                    Integer n;
                    String s = linha[k];
                    if (s.equals("") || s.equals(peso.toString())) {
                        n = -1;
                    } else {
                        n = Integer.parseInt(linha[k]);
                    }

                    matriz.matriz[i][k] = n;
                    matriz.matriz[k][i] = n;

                }
                matriz.matriz[i][i] = -1;
            }
            grafos.add(matriz);
            inicio = fim;
            fim = inicio + tamanho;

        }

        return grafos;
    }

    public static ArrayList<Grafo> CarregaGrafosLista(ArrayList<Grafo> matriz) {
        ArrayList<Grafo> grafos = new ArrayList<Grafo>();
        for (Grafo grafo : matriz) {

            Grafo g = new Grafo();
            for (Integer i = 0; i < grafo.matriz.length; i++) {
                g.insereVertice(g, new Vertice(i.toString()));

            }
            for (Integer i = 0; i < grafo.matriz.length; i++) {
                Vertice origem = Grafo.getKey(g, i.toString());
                for (Integer j = 0; j < matriz.get(0).matriz.length; j++) {
                    Integer n = grafo.matriz[i][j];
                    if (!n.equals(-1)) {
                        Vertice destino = Grafo.getKey(g, j.toString());
                        if (!g.existeAdjascencia(g, origem, destino)) {
                            g.InsereArestaNaoDiretiva(g, origem, new Aresta(destino, n));

                        }
                    }
                }
            }
            grafos.add(g);
        }

        return grafos;
    }

    public static ArrayList<String> abrirArquivo(String caminho) {
        ArrayList<String> texto = new ArrayList<>();
        File arq = new File(caminho);
        if (arq.exists()) {
            try {
                //OpenFile
                FileReader arquivo = new FileReader(caminho);
                BufferedReader conteudoDoArquivo = new BufferedReader(arquivo);
                String linha = conteudoDoArquivo.readLine();
                while (linha != null) {
                    texto.add(linha);
                    linha = conteudoDoArquivo.readLine();
                }
                conteudoDoArquivo.close();
            } catch (Exception e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            texto.add("");
        }
        return texto;
    }
}
