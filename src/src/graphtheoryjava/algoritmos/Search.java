/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.graphtheoryjava.algoritmos;

import src.graphtheoryjava.util.Grafo;
import java.util.ArrayList;

/**
 *
 * @author nobreck
 */
public class Search {
    
    public Grafo grafo;
    public ArrayList<Integer> ordem;
    public int [] visitado;
    
    public Search(Grafo grafo)
    {
        this.grafo = grafo;
        this.visitado = new int[grafo.vertices.size()];
    }
    
    public void reset () {
        ordem = new ArrayList<Integer>();
        for (int i = 0; i < grafo.vertices.size(); i++) {
            this.visitado[i] = 0;
        }
    }
    
    public ArrayList<Integer> buscaLargura(int s)
    {
        ArrayList<Integer> fila = new ArrayList<Integer>();
       this.reset();
        
        this.visitado[s] = 1;
        
        fila.add(s);
        this.ordem.add(s);
        
        while (!fila.isEmpty()) {
            int u = fila.remove(0);
            for (int i = 0; i < grafo.adjList.get(u).size(); i++) {
                int v = grafo.adjList.get(u).get(i).sink;
                if (this.visitado[v] == 0) {
                    this.visitado[v] = 1;
                    this.ordem.add(v);
                    fila.add(v);
                }
            }
        }
        return this.ordem;
    }
    
    public ArrayList<Integer> buscaProfundidade(int s)
    {
        this.visitado[s] = 1;
        this.ordem.add(s);
        
        for (int i = 0; i < grafo.adjList.get(s).size(); i++) {
            int v = grafo.adjList.get(s).get(i).sink;
            if (this.visitado[v] == 0) {
                this.buscaProfundidade(v);
            }
        }
        return this.ordem;
    }
    
//    public ArrayList<Integer> buscaProfundidadeRec(int u);;
//    {
//        this.visitado[u] = 1;
//        this.ordem.add(u);
//        
//        for (int i = 0; i < grafo.adjList.get(i).size(); i++) {
//            
//            int v = grafo.adjList.get(u).get(i).sink;
//            
//            if (this.visitado[u] ==0) {
//                this.buscaProfundidadeRec(v);
//            }
//        }
//        
//        return ordem;
//    }
}
    