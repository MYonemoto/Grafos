/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mateus
 */
public class Principal {

    public static void main(String[] args) {

//        Grafo grafo = new Grafo();
//        grafo.insereVertice(grafo, new Vertice("1"));
//        grafo.insereVertice(grafo, new Vertice("2"));
//        grafo.insereVertice(grafo, new Vertice("3"));
//
//        Vertice v = Grafo.getKey(grafo, "1");
//        Vertice v2 = Grafo.getKey(grafo, "2");
//        Vertice v3 = Grafo.getKey(grafo, "3");
//
//        grafo.InsereArestaNaoDiretiva(grafo, v, new Aresta(v2));
//        grafo.InsereArestaNaoDiretiva(grafo, v, new Aresta(v3));
//        grafo.printaGrafo(grafo);
//        

        String arquivo = "HDGraph20_20.txt";
        ArrayList<Grafo> grafos = Read.CarregaGrafosLista(Read.CarregaGrafosMatriz(arquivo));
        System.out.println("grafos: " + grafos.size());
        
        
        
        for(Grafo g: grafos){
            g.printaGrafo(g);
            System.out.println();
        }
        //Buscas busca = new Buscas();
//        Grafo grafo = new Grafo(6);
//        
//        grafo.insereArestaDiretivaMatriz(grafo, 0, 1);
//        grafo.insereArestaDiretivaMatriz(grafo, 1, 2);
//        grafo.insereArestaDiretivaMatriz(grafo, 2, 3);
//        grafo.insereArestaDiretivaMatriz(grafo, 3, 1);
//        grafo.insereArestaDiretivaMatriz(grafo, 1, 4);
//        
//
//        Vertice camisa = new Vertice("Camisa");
//        Vertice gravata = new Vertice("Gravata");
//        Vertice paleto = new Vertice("Paleto");
//        Vertice cinto = new Vertice("Cinto");
//        Vertice relogio = new Vertice("Relogio");
//        Vertice cueca = new Vertice("Cueca");
//        Vertice calca = new Vertice("Calca");
//        Vertice sapato = new Vertice("Sapato");
//        Vertice meia = new Vertice("Meia");
//
//        grafo.insereVertice(grafo, camisa);
//        grafo.insereVertice(grafo, gravata);
//        grafo.insereVertice(grafo, paleto);
//        grafo.insereVertice(grafo, cinto);
//        grafo.insereVertice(grafo, relogio);
//        grafo.insereVertice(grafo, cueca);
//        grafo.insereVertice(grafo, calca);
//        grafo.insereVertice(grafo, sapato);
//        grafo.insereVertice(grafo, meia);
//        grafo.insereVertice(grafo, camisa);
//        grafo.insereVertice(grafo, gravata);
//        grafo.insereVertice(grafo, paleto);
//        grafo.insereVertice(grafo, cinto);
//        grafo.insereVertice(grafo, relogio);
//        grafo.insereVertice(grafo, cueca);
//        grafo.insereVertice(grafo, calca);
//        grafo.insereVertice(grafo, sapato);
//        grafo.insereVertice(grafo, meia);
//        grafo.InsereArestaDiretiva(grafo, camisa, new Aresta(gravata));
//        grafo.InsereArestaDiretiva(grafo, camisa, new Aresta(cinto));
//        grafo.InsereArestaDiretiva(grafo, cinto, new Aresta(camisa));
//        grafo.InsereArestaDiretiva(grafo, gravata, new Aresta(paleto));
//        grafo.InsereArestaDiretiva(grafo, calca, new Aresta(cinto));
//        grafo.InsereArestaDiretiva(grafo, cueca, new Aresta(calca));
//        grafo.InsereArestaDiretiva(grafo, cueca, new Aresta(sapato));
//        grafo.InsereArestaDiretiva(grafo, cinto, new Aresta(paleto));
//        grafo.InsereArestaDiretiva(grafo, meia, new Aresta(sapato));
//        grafo.InsereArestaDiretiva(grafo, calca, new Aresta(sapato));
//        grafo.InsereArestaDiretiva(grafo, paleto, new Aresta(camisa));
////        grafo.InsereArestaNaoDiretiva(grafo, d, new Aresta(f));
//        //qgrafo.InsereArestaNaoDiretiva(grafo, d, new Aresta(a));
//        //grafo.InsereArestaNaoDiretiva(grafo, f, new Aresta(a));
////        grafo.RemoveVertice(grafo, camisa);
////        grafo.RemoveVertice(grafo, gravata);
////        grafo.RemoveVertice(grafo, paleto);
////        grafo.RemoveVertice(grafo, cinto);
////        grafo.RemoveVertice(grafo, relogio);
////        grafo.RemoveVertice(grafo, cueca);
////        grafo.RemoveVertice(grafo, calca);
////        grafo.RemoveVertice(grafo, sapato);
////        grafo.RemoveVertice(grafo, meia);
//        
////        Vertice a = new Vertice("A");
////        Vertice b = new Vertice("B");
////        Vertice c = new Vertice("C");
////        Vertice d = new Vertice("D");
////        Vertice e = new Vertice("E");
////        Vertice f = new Vertice("F");
////        
////        grafo.insereVertice(grafo, a);
////        grafo.insereVertice(grafo, b);
////        grafo.insereVertice(grafo, c);
////        grafo.insereVertice(grafo, d);
////        grafo.insereVertice(grafo, e);
////        grafo.insereVertice(grafo, f);
////        
////        grafo.InsereArestaDiretiva(grafo, a, new Aresta (b));
////        grafo.InsereArestaDiretiva(grafo, b, new Aresta (c));
////        grafo.InsereArestaDiretiva(grafo, c, new Aresta (d));
////        grafo.InsereArestaDiretiva(grafo, d, new Aresta (b));
////        grafo.InsereArestaDiretiva(grafo, a, new Aresta (d));
////        grafo.InsereArestaDiretiva(grafo, e, new Aresta (f));
////        grafo.InsereArestaDiretiva(grafo, e, new Aresta (c));
////        grafo.InsereArestaDiretiva(grafo, f, new Aresta (f));
////        
//        grafo.printaGrafo(grafo);
////        System.out.println();
////
//    List<Vertice> lista = busca.OrdenacaoTopologica(grafo);
//    if(lista != null){
//    for (Vertice v : lista) {
//            System.out.println("\nNome: " + v.nome + " Tempo: " + v.tempoDescoberto + " / " + v.tempoFinalizado);
//        }
//    }
//        Buscas.IniciaBuscaProfundidade(grafo);
//        Buscas.IniciaBuscaLargura(grafo, camisa);
//        Buscas.BuscaLargura(grafo);
    }
}
