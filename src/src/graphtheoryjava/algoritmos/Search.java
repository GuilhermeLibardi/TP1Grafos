/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.graphtheoryjava.algoritmos;

import src.graphtheoryjava.util.Grafo;
import src.graphtheoryjava.algoritmos.Pilha;
import java.util.ArrayList;

public class Search {

    public Grafo grafo;
    public ArrayList<Integer> ordem;
    public int[] visitado;

    public Search(Grafo grafo) {
        this.grafo = grafo;
        this.visitado = new int[grafo.vertices.size()];
    }

    public void reset() {
        ordem = new ArrayList<Integer>();
        for (int i = 0; i < grafo.vertices.size(); i++) {
            this.visitado[i] = 0;
        }
    }

    public ArrayList<Integer> BuscaLargura(int s) {
        ArrayList<Integer> fila = new ArrayList<Integer>();
        this.reset();

        this.visitado[s] = 1;

        fila.add(s);
        this.ordem.add(s);

        while (!fila.isEmpty()) {
            int u = fila.remove(0);
            for (int i = 0; i < grafo.adjList.get(u).size(); i++) {
                int v = grafo.adjList.get(u).get(i).peso;
                if (this.visitado[v] == 0) {
                    this.visitado[v] = 1;
                    this.ordem.add(v);
                    fila.add(v);
                }
            }
        }
        return this.ordem;
    }

    public ArrayList<Integer> BuscaProfundidade(int s) {
        Pilha pilha = new Pilha();
        Info info = new Info(this.grafo);
        int u, i = 0;
        this.reset();

        this.visitado[s] = 1;
        this.ordem.add(s);
        pilha.Empilha(s);

        while (!pilha.isEmpty()) {
            u = (int) pilha.lookFirst();
            ArrayList<Integer> adjacentes = info.sucessores(u);
            if (!adjacentes.isEmpty()) {
                for (int v : adjacentes) {
                    if (this.visitado[v] == 0) {
                        this.visitado[v] = 1;
                        pilha.Empilha(v);
                        this.ordem.add(v);
                        break;
                    } else if (adjacentes.size() - 1 == i) {
                        pilha.Desempilha();
                    }
                    i++;
                }
            } else {
                pilha.Desempilha();
            }
            i = 0;
        }
        return this.ordem;
    }

    public ArrayList<Integer> BuscaProfRecursiva(int s) {
        this.reset();
        ArrayList<Integer> retorno = new ArrayList<>(0);
        for (int i : this.grafo.vertices) {
            if (this.visitado[i] == 0) {
                PROF(i);
                retorno.add(i);
            }
        }
        return retorno;
    }

    public int ComponentesConexas() {
        this.reset();
        int componente = 0;

        for (int i : this.visitado) {
            if (visitado[i] == 0) {
                componente++;
                this.PROF_CON(i, componente);
            }
        }

        return componente;
    }

    public ArrayList<Integer> OrdenacaoTopologica() {
        ArrayList<Integer> retorno = new ArrayList<>(0);
        this.reset();

        for (int i : this.grafo.vertices) {
            if (visitado[i] == 0) {
                PROF_ORD(i, retorno);
            }
        }
        return retorno;
    }

    private void PROF_ORD(int u, ArrayList<Integer> retorno) {
        Info info = new Info(this.grafo);
        visitado[u] = 1;
        for (int v : info.sucessores(u)) {
            if (visitado[v] == 0) {
                PROF_ORD(v, retorno);
            }
        }
        retorno.add(0, u);
    }

    private void PROF_CON(int u, int marca) {
        Info info = new Info(this.grafo);
        this.visitado[u] = marca;
        for (int v : info.sucessores(u)) {
            if (this.visitado[v] == 0) {
                this.PROF_CON(v, marca);
            }
        }
    }

    private void PROF(int u) {
        Info info = new Info(this.grafo);

        this.visitado[u] = 1;
        for (int v : info.sucessores(u)) {
            if (visitado[v] == 0) {
                PROF(v);
            }
        }
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
