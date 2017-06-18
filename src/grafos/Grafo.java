/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;
//import static javafx.scene.paint.Color.color;
//import static javafx.scene.paint.Color.color;

/**
 *
 * @author geovani
 */
public class Grafo {

    Map<Vertice, List<Aresta>> map;
    List<Vertice> filaBuscaLargura;
    int[][] matriz;
    boolean isCiclico;
    Integer ComponentesConexas;
    

    Integer tempo;

    public Grafo(int vertices) {
        matriz = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public Grafo() {

        this.map = new LinkedHashMap<>();
        

    }

    public void insereVertice(Grafo grafo, Vertice vertice) {
        List<Aresta> arestas = new ArrayList<>();

        grafo.map.put(vertice, arestas);

    }

    public void RemoveVertice(Grafo grafo, Vertice vertice) {
        grafo.map.remove(vertice);
        grafo.RemoveTodasArestas(grafo, vertice);
    }

    public void InsereArestaDiretiva(Grafo grafo, Vertice verticeOrigem, Aresta aresta) {
        grafo.map.get(verticeOrigem).add(aresta);
    }

    public void InsereArestaNaoDiretiva(Grafo grafo, Vertice verticeOrigem, Aresta aresta) {
        grafo.map.get(verticeOrigem).add(aresta);
        grafo.map.get(aresta.destino).add(new Aresta(verticeOrigem, aresta.peso));
    }

    public void insereArestaDiretivaMatriz(Grafo grafo, int origem, int destino) {
        grafo.matriz[origem][destino] = 1;
    }

    public void RemoveArestaDiretiva(Grafo grafo, Vertice vOrigem, Vertice vDestino) {
        for (Iterator<Aresta> it = grafo.map.get(vOrigem).iterator(); it.hasNext();) {
            Aresta a = it.next();
            if (a.destino.nome.equals(vDestino.nome)) {
                it.remove();

            }
        }
    }

    public void RemoveArestaNaoDiretiva(Grafo grafo, Vertice vOrigem, Vertice vDestino) {
        RemoveArestaDiretiva(grafo, vOrigem, vDestino);
        RemoveArestaDiretiva(grafo, vDestino, vOrigem);
    }

    public void RemoveTodasArestas(Grafo grafo, Vertice destino) {
        for (Vertice v : grafo.getMap().keySet()) {
            RemoveArestaDiretiva(grafo, v, destino);
        }
    }
    
   

    public void printaGrafo(Grafo grafo) {
        for (Vertice v : grafo.getMap().keySet()) {
            System.out.print("vertice : " + v.nome + "-->");
            for (Aresta ar : grafo.getMap().get(v)) {
                System.out.print(ar.destino.nome + "{" + ar.peso + "}  ");
            }
            System.out.println();
        }

    }

    public void printaMatriz(Grafo grafo) {
        for (int i = 0; i < grafo.matriz.length; i++) {
            System.out.print(i + " \t");
            for (int j = 0; j < grafo.matriz.length; j++) {
                System.out.print("\t{ " + grafo.matriz[i][j] + " }\t");
            }
            System.out.println();
        }
    }

    public void printaCorGrafo(Grafo grafo) {
        for (Vertice v : grafo.getMap().keySet()) {
            System.out.print("vertice : " + v.nome + "  ");
            System.out.println("cor: " + v.cor);

        }

    }

   public static Vertice getKey(Grafo g, String nome){
       Vertice vertice = null;
       for(Vertice v: g.getMap().keySet()){
            if(v.nome.equals(nome)){
                vertice = v;
            }
        }
       return vertice;
   }
   public boolean existeAdjascencia(Grafo grafo, Vertice origem, Vertice destino){
       
       if (grafo.getMap().containsKey(origem)) {
            for (Aresta a : grafo.getMap().get(origem)) {
                if (a.destino == destino) {
                    return true;
                }
            }
        }
        
       return false;
   }
    
    public Map<Vertice, List<Aresta>> getMap() {
        return map;
    }

    public void setMap(Map<Vertice, List<Aresta>> map) {
        this.map = map;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public boolean isIsCiclico() {
        return isCiclico;
    }

    public void setIsCiclico(boolean isCiclico) {
        this.isCiclico = isCiclico;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    

}
