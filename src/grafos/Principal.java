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

        Grafo grafo = new Grafo();

        Vertice camisa = new Vertice("Camisa");
        Vertice gravata = new Vertice("Gravata");
        Vertice paleto = new Vertice("Paleto");
        Vertice cinto = new Vertice("Cinto");
        Vertice relogio = new Vertice("Relogio");
        Vertice cueca = new Vertice("Cueca");
        Vertice calca = new Vertice("Calca");
        Vertice sapato = new Vertice("Sapato");
        Vertice meia = new Vertice("Meia");

        grafo.insereVertice(grafo, camisa);
        grafo.insereVertice(grafo, gravata);
        grafo.insereVertice(grafo, paleto);
        grafo.insereVertice(grafo, cinto);
        grafo.insereVertice(grafo, relogio);
        grafo.insereVertice(grafo, cueca);
        grafo.insereVertice(grafo, calca);
        grafo.insereVertice(grafo, sapato);
        grafo.insereVertice(grafo, meia);

        grafo.InsereArestaDiretiva(grafo, camisa, new Aresta(gravata));
        grafo.InsereArestaDiretiva(grafo, camisa, new Aresta(cinto));
        grafo.InsereArestaDiretiva(grafo, gravata, new Aresta(paleto));
        grafo.InsereArestaDiretiva(grafo, calca, new Aresta(cinto));
        grafo.InsereArestaDiretiva(grafo, cueca, new Aresta(calca));
        grafo.InsereArestaDiretiva(grafo, cueca, new Aresta(sapato));
        grafo.InsereArestaDiretiva(grafo, cinto, new Aresta(paleto));
        grafo.InsereArestaDiretiva(grafo, meia, new Aresta(sapato));
        grafo.InsereArestaNaoDiretiva(grafo, calca, new Aresta(sapato));
//        grafo.InsereArestaNaoDiretiva(grafo, d, new Aresta(f));
        //qgrafo.InsereArestaNaoDiretiva(grafo, d, new Aresta(a));
        //grafo.InsereArestaNaoDiretiva(grafo, f, new Aresta(a));

        grafo.printaGrafo(grafo);
        System.out.println();

        for(Vertice v: Buscas.OrdenacaoTopologica(grafo)){
            System.out.println("nome: " + v.nome +" tempo: " + v.tempoDescoberto + " / " + v.tempoFinalizado);
        }
//        Buscas.IniciaBuscaProfundidade(grafo);
        //Buscas.IniciaBuscaLargura(grafo, a);

        //Buscas.BuscaLargura(grafo);

    }
}
