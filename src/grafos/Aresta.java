/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author a1602055
 */
public class Aresta {
    Vertice destino;
    Integer peso;
    

    public Aresta(Vertice destino) {
        this.destino = destino;
    }

    public Aresta(Vertice destino, Integer peso) {
        this.destino = destino;
        this.peso = peso;
    }
    
    
    
}
