/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.awt.Color;
import java.util.List;

/**
 *
 * @author a1602055
 */
public class Vertice {
    String nome;
    String cor;
    Double distancia;
    Vertice antecessor;
    Integer tempoDescoberto;
    Integer tempoFinalizado;

        

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Vertice getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(Vertice antecessor) {
        this.antecessor = antecessor;
    }

    public Integer getTempoDescoberto() {
        return tempoDescoberto;
    }

    public void setTempoDescoberto(Integer tempoDescoberto) {
        this.tempoDescoberto = tempoDescoberto;
    }

    public Integer getTempoFinalizado() {
        return tempoFinalizado;
    }

    public void setTempoFinalizado(Integer tempoFinalizado) {
        this.tempoFinalizado = tempoFinalizado;
    }
    
   
    
    
        
    
    
}
