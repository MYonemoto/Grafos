/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

//import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.Color;
import java.util.ArrayList;
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
        grafo.fila = new ArrayList<>();
        grafo.fila.add(inicial);

    }

    public static void BuscaLargura(Grafo grafo) {
        while (!grafo.fila.isEmpty()) {
            Vertice u = grafo.fila.remove(0);
            System.out.println("Pai: " + u.nome);
            for (Aresta ar : grafo.map.get(u)) {
                Vertice v = ar.destino;
                System.out.println("adjascente: " + v.nome + "  cor antes: " + v.cor);
                if (v.cor.equals("Branco")) {
                    v.setCor("Cinza");

                    System.out.println("cor depois: " + v.cor);

                    v.distancia = u.distancia + 1;
                    v.antecessor = u;
                    grafo.fila.add(v);
                }
            }
            u.setCor("Preto");
            System.out.println("pai  " + u.nome + "  cor: " + u.cor);
        }
    }

    public static void IniciaBuscaProfundidade(Grafo grafo) {
        for (Vertice u : grafo.map.keySet()) {
            u.setCor("Branco");
            u.antecessor = null;
           grafo.setTempo(0); 
        }
    }

    public static void BuscaProfundidade(Grafo grafo, Vertice vertice) {
        grafo.tempo +=1;
        vertice.setDistancia((double)grafo.tempo);
        vertice.setCor("Cinza");
        for (Aresta ar : grafo.map.get(vertice)) {
                Vertice v = ar.destino;
                if(vertice.cor.equals("Branco")){
                    v.antecessor = vertice;
                    BuscaProfundidade(grafo, v);
                }
                
        }
        vertice.setCor("Preto");
        grafo.setTempo(grafo.tempo + 1);
        
        
    }

}
