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
 * @author mateus
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
                    if (s.equals("") || s.equals("20")) {
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
    
    public static ArrayList<Grafo> CarregaGrafosLista(String arquivo) {
        ArrayList<Grafo> grafos = new ArrayList<Grafo>();
        
        ArrayList<String> texto = abrirArquivo(arquivo);
        
        String[] linha = texto.get(0).split(" ");
        Integer tamanho = Integer.parseInt(linha[0]);
        Integer peso = Integer.parseInt(linha[1]);
        int inicio = 1, fim = inicio + tamanho;

        //while (fim <= texto.size()) {
        List<String> text = texto.subList(inicio, fim);
        Collections.reverse(text);
        
        Grafo g = new Grafo();
        
        for (Integer j = 0; j < tamanho; j++) {
            linha = text.get(j).split(" ");
            Vertice v = new Vertice(j.toString());
            g.insereVertice(g, v);
            for (Integer k = 0; k < linha.length; k++) {
                
                String s = linha[k];
                if (s.equals("") || s.equals("20")) {
                    System.out.println("rola");
                    
                } else {
                    
                    Vertice destino = new Vertice(k.toString());
                    
                    System.out.println("origem: " + v.nome);
                    System.out.println("destino: " + destino.nome);
                    
                    g.InsereArestaDiretiva(g, v, new Aresta(destino, Integer.parseInt(s)));
                }
                
            }
        }
        //Espelha(g);
        grafos.add(g);
        inicio = fim;
        fim = inicio + tamanho;

        //}
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
