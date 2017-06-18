/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author geovani
 */
public class MVCA {

    public void CalculaVerticeAlcancaveis(ArrayList<Rotulo> rotulos, Grafo grafo) {

        for (Rotulo rotulo : rotulos) {
            rotulo.numAlcancaveis = 0;
            for (Aresta aresta : rotulo.arestas) {
                Vertice origem = Grafo.getKey(grafo, aresta.origem.nome);
                Vertice destino = Grafo.getKey(grafo, aresta.destino.nome);
                if (!origem.isVisit) {
                    rotulo.setNumAlcancaveis(rotulo.getNumAlcancaveis() + 1);
                }
                if (!destino.isVisit) {
                    rotulo.setNumAlcancaveis(rotulo.getNumAlcancaveis() + 1);
                }
//                if (!arvore.existeAdjascencia(arvore, origem, destino)) {
//                    arvore.InsereArestaNaoDiretiva(arvore, origem, new Aresta(destino, aresta.peso));
//
//                }

            }

        }
        rotulos.sort(new ComparadorRotulos());
    }

    public void InsereArvore(Rotulo rotulo, Grafo arvore) {
        for (Aresta aresta : rotulo.arestas) {
            Vertice origem = Grafo.getKey(arvore, aresta.origem.nome);
            origem.isVisit = true;
            Vertice destino = Grafo.getKey(arvore, aresta.destino.nome);
            destino.isVisit = true;
            if (!arvore.existeAdjascencia(arvore, origem, destino)) {
                arvore.InsereArestaNaoDiretiva(arvore, origem, new Aresta(destino, aresta.peso));

            }
        }

    }

    public void Rotulos( Grafo grafo) {
        ArrayList<Rotulo> rotulos = getRotulos(grafo);
        Integer numRotulos = 0;
        Grafo arvore = new Grafo();
        for (Integer i = 0; i < grafo.map.size(); i++) {
            Vertice v = new Vertice(i.toString());
            v.setIsVisit(false);
            arvore.insereVertice(arvore, v);

        }
        while (!Buscas.IniciaBuscaProfundidade(arvore)) {

//            for (Rotulo ro : rotulos) {
//                System.out.println("rotulo: " + ro.nome + "{" + ro.numAlcancaveis + "}");
//            }
//            System.out.println("");

            CalculaVerticeAlcancaveis(rotulos, arvore);
            InsereArvore(rotulos.remove(0), arvore);
            numRotulos++;
//            for (Rotulo ro : rotulos) {
//                System.out.println("rotulo: " + ro.nome + "{" + ro.numAlcancaveis + "}");
//            }
           
            

         
//        
        }
        System.out.println("numero de rotulos: "+ numRotulos);
        arvore.printaGrafo(arvore);

        System.out.println("Componentes arvore: " + arvore.ComponentesConexas);

    }

    public static boolean Exists(ArrayList<Rotulo> rotulos, Rotulo rotulo) {
        for (Rotulo r : rotulos) {
            if (r.nome.equals(rotulo.nome)) {

                for (Aresta a : rotulo.arestas) {
                    if (!ContemAresta(r, a)) {
                        r.arestas.add(a);
                        r.quantidade += rotulo.quantidade;
                    }
                }
                return true;
            }
        }

        return false;
    }

    public static boolean ContemAresta(Rotulo rotulo, Aresta aresta) {
        for (Aresta a : rotulo.getArestas()) {
            if (a.origem.nome.equals(aresta.origem.nome) && a.destino.nome.equals(aresta.destino.nome)) {
                return true;
            } else if (a.destino.nome.equals(aresta.origem.nome) && a.origem.nome.equals(aresta.destino.nome)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Rotulo> getRotulos(Grafo grafo) {
        ArrayList<Rotulo> rotulos = new ArrayList<>();
        for (Vertice v : grafo.getMap().keySet()) {
            for (Aresta a : grafo.getMap().get(v)) {
                Rotulo r = new Rotulo(a.peso);
                Aresta aresta = new Aresta(a.destino, a.peso);
                aresta.setOrigem(v);
                r.arestas.add(aresta);
                r.quantidade++;
                if (!Exists(rotulos, r)) {

                    rotulos.add(r);
                }

            }

        }

        return rotulos;
    }

    class ComparadorRotulos implements Comparator<Rotulo> {

        @Override
        public int compare(Rotulo r1, Rotulo r2) {
            if (r1.numAlcancaveis > r2.numAlcancaveis) {
                return -1;
            } else if (r1.numAlcancaveis < r2.numAlcancaveis) {
                return +1;
            } else {
                return 0;
            }
        }
    }
}
