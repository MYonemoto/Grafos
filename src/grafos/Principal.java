/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class Principal {

    public static void main(String[] args) {
        Buscas busca;
        
        Grafo grafo = new Grafo();
        
        Vertice a = new Vertice("A");
        Vertice b = new Vertice("B");
        Vertice c = new Vertice("C");
        Vertice d = new Vertice("D");
        Vertice e = new Vertice("E");
        Vertice f = new Vertice("F");
        Vertice h = new Vertice("H");

        grafo.insereVertice(grafo, a);
        grafo.insereVertice(grafo, b);
        grafo.insereVertice(grafo, c);
        grafo.insereVertice(grafo, d);
        //grafo.insereVertice(grafo, e);
        //grafo.insereVertice(grafo, f);
        //grafo.insereVertice(grafo, h);

        grafo.InsereArestaDiretiva(grafo, a, new Aresta(b));
        grafo.InsereArestaDiretiva(grafo, a, new Aresta(c));
        grafo.InsereArestaDiretiva(grafo, b, new Aresta(d));
        grafo.InsereArestaDiretiva(grafo, c, new Aresta(b));
        grafo.InsereArestaDiretiva(grafo, d, new Aresta(c));
        //grafo.InsereArestaDiretiva(grafo, a, new Aresta(e));
        //grafo.InsereArestaDiretiva(grafo, e, new Aresta(d));
        //grafo.InsereArestaDiretiva(grafo, b, new Aresta(a));
        //grafo.InsereArestaNaoDiretiva(grafo, c, new Aresta(e));
        //grafo.InsereArestaNaoDiretiva(grafo, d, new Aresta(f));
        //qgrafo.InsereArestaNaoDiretiva(grafo, d, new Aresta(a));
        //grafo.InsereArestaNaoDiretiva(grafo, f, new Aresta(a));
        
        grafo.printaGrafo(grafo);
        System.out.println();
        
        Buscas.IniciaBuscaProfundidade(grafo);
        
        //IniciaBuscaLargura(grafo, a);
        
        
       // grafo.RemoveVertice(grafo, a);
        //grafo.RemoveTodasArestas(grafo, a);
        //Buscas.BuscaLargura(grafo);
        
        
        
        
        

        //grafo.map.put("A", ares);

        /* for (Vertice v : grafo.vertices) {
            System.out.println("vertice : " + v.nome);
        }
        Aresta ar = new Aresta(b);
        exemplo.get("A").add(ar);
        ar = new Aresta(c);
        exemplo.get("A").add(ar);

        
        }*/
    }
}
