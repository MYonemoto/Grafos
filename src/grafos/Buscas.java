/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

//import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.Color;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *
 * @author Mateus
 */
public class Buscas {

    public static void IniciaBuscaLargura(Grafo grafo, Vertice inicial) {
        for (Vertice u : grafo.map.keySet()) {
            if (!u.equals(inicial)) {
                u.setCor("Branco");
                u.setDistancia(Infinity);
                u.antecessor = null;
            }
        }
        inicial.setCor("Cinza");
        inicial.setDistancia(0.0);
        inicial.setAntecessor(null);
        grafo.filaBuscaLargura = new ArrayList<>();
        grafo.filaBuscaLargura.add(inicial);

    }

    public static void BuscaLargura(Grafo grafo) {
        while (!grafo.filaBuscaLargura.isEmpty()) {
            Vertice u = grafo.filaBuscaLargura.remove(0);
            System.out.println("Pai: " + u.nome);
            for (Aresta ar : grafo.map.get(u)) {
                Vertice v = ar.destino;
                System.out.println("adjascente: " + v.nome + "  cor antes: " + v.cor);
                if (v.cor.equals("Branco")) {
                    v.setCor("Cinza");

                    System.out.println("cor depois: " + v.cor);

                    v.distancia = u.distancia + 1;
                    v.antecessor = u;
                    grafo.filaBuscaLargura.add(v);
                }
            }
            u.setCor("Preto");
            System.out.println("pai  " + u.nome + "  cor: " + u.cor);
        }
    }
    
    public static void removeSozinho(Grafo grafo){
        Vertice x = null;
            for(Vertice v: grafo.map.keySet()){
                Integer n = 0;
                if(n.equals(grafo.getMap().get(v).size())){
                    x = v;
                }
                 
            }
          
            grafo.getMap().remove(x);
    }

    public static void IniciaBuscaProfundidade(Grafo grafo) {
        grafo.ComponentesConexas = 0;
        for (Vertice u : grafo.map.keySet()) {
            u.setCor("Branco");
            u.antecessor = null;
            grafo.setTempo(0);
        }
        for (Vertice u : grafo.map.keySet()) {
            if (u.cor.equals("Branco")) {
                BuscaProfundidade(grafo, u);
                grafo.ComponentesConexas++;
            }
        }
        
        
        
    }
    
    

    public static void BuscaProfundidade(Grafo grafo, Vertice vertice) {
        grafo.tempo += 1;
        vertice.setTempoDescoberto((Integer) grafo.tempo);
//        System.out.println("\ndescoberto vertice: "+ vertice.nome + "  cor:  "+ vertice.cor + " Tempo descoberto: " + vertice.getTempoDescoberto());
        vertice.setCor("Cinza");
//        System.out.println("\n sou vertice: "+ vertice.nome + " me pintei cor:  "+ vertice.cor);
        for (Aresta ar : grafo.map.get(vertice)) {
            Vertice v = ar.destino;
            if(v.cor.equals("Cinza")){
                grafo.setIsCiclico(true);
            }
            else if (v.cor.equals("Branco")) {
                v.antecessor = vertice;
                BuscaProfundidade(grafo, v);
            }
        }

        vertice.setCor("Preto");
        grafo.setTempo(grafo.tempo + 1);
        vertice.setTempoFinalizado(grafo.getTempo());
//        System.out.println("\n sou vertice: "+ vertice.nome + " finalizei :  "+ vertice.cor + " Tempo finalizado: "+ vertice.tempoFinalizado);
    }

    public  List<Vertice> OrdenacaoTopologica(Grafo grafo) {
        List<Vertice> lista = new ArrayList<>();
        IniciaBuscaProfundidade(grafo);
        if(grafo.isCiclico){
            System.out.println("\nGrafo Cíclico!\n");
            return null;
        }
        for (Vertice v : grafo.map.keySet()) {
                lista.add(v);
        }
            lista.sort(new ComparadorVertices());
            return lista;

    }

class ComparadorVertices implements Comparator<Vertice> {
    public int compare(Vertice v1, Vertice v2) {
        if (v1.tempoFinalizado > v2.tempoFinalizado) return -1;
        else if (v1.tempoFinalizado < v2.tempoFinalizado) return +1;
        else return 0;
    }
}
    
}
