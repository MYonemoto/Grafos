/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author geovani
 */
public class Rotulo {
    Integer nome;
    Integer quantidade;
    ArrayList<Aresta> arestas;
    Integer numAlcancaveis;

    public Rotulo(Integer nome) {
        this.nome = nome;
        this.quantidade = 0;
        this.numAlcancaveis = 0;
        this.arestas = new ArrayList<>();
    }

    public Integer getNome() {
        return nome;
    }

    public void setNome(Integer nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public Integer getNumAlcancaveis() {
        return numAlcancaveis;
    }

    public void setNumAlcancaveis(Integer numAlcancaveis) {
        this.numAlcancaveis = numAlcancaveis;
    }
    
    
    
}
