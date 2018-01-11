package src.graphtheoryjava.algoritmos;

import java.util.ArrayList;
import src.graphtheoryjava.util.Arco;
import src.graphtheoryjava.util.Grafo;

public class Info {

    public Grafo grafo;

    public Info(Grafo grafo) { // Construtor
        this.grafo = grafo;
    }

    public int ordem() { // Item 2
        return this.grafo.vertices.size();
    }

    public void adjacente(Arco a) { // Item 3
        System.out.println("Arestas adjacentes a aresta " + a.origem + a.destino + ": ");
        for (int j = 0; j < grafo.adjList.get(a.origem).size(); j++) {
            if (a.destino != grafo.adjList.get(a.origem).get(j).destino) {
                System.out.print("" + a.origem + grafo.adjList.get(a.origem).get(j).destino + " ");
            }
        }
        for (int j = 0; j < grafo.vertices.size(); j++) {
            for (int k = 0; k < grafo.adjList.get(j).size(); k++) {
                if (grafo.adjList.get(j).get(k).destino == a.origem) {
                    System.out.print("" + grafo.adjList.get(j).get(k).origem + a.origem + " ");
                }
            }
        }
        for (int j = 0; j < grafo.adjList.get(a.destino).size(); j++) {
            if (a.origem != grafo.adjList.get(a.destino).get(j).destino) {
                System.out.print("" + a.destino + grafo.adjList.get(a.destino).get(j).destino + " ");
            }
        }
        for (int j = 0; j < grafo.vertices.size(); j++) {
            for (int k = 0; k < grafo.adjList.get(j).size(); k++) {
                if (grafo.adjList.get(j).get(k).destino == a.destino) {
                    if (grafo.adjList.get(j).get(k).origem != a.origem) {
                        System.out.print("" + grafo.adjList.get(j).get(k).origem + a.destino + " ");
                    }
                }
            }
        }
        System.out.println();
    }

    public ArrayList<Integer> sucessores(int v) { // Item 4
        ArrayList<Integer> retorno = new ArrayList<>(0);
        for (int i = 0; i < this.grafo.adjList.get(v).size(); i++) {
            retorno.add(this.grafo.adjList.get(v).get(i).destino);
        }
        return retorno;
    }

    public ArrayList<Integer> antecessores(int i) { // Item 5
        ArrayList<Integer> retorno = new ArrayList<>(0);
        for (int j = 0; j < grafo.vertices.size(); j++) {
            for (int k = 0; k < grafo.adjList.get(j).size(); k++) {
                if (grafo.adjList.get(j).get(k).destino == i) {
                    retorno.add(grafo.adjList.get(j).get(k).origem);
                }
            }
        }
        return retorno;
    }

    public void incidentes_vertice(int i) { // Item 6
        System.out.println("As arestas incidentes ao vertice " + i + " são: ");
        for (int j = 0; j < grafo.adjList.get(i).size(); j++) {
            System.out.print("" + i + grafo.adjList.get(i).get(j).destino + " ");
        }
        for (int j = 0; j < grafo.vertices.size(); j++) {
            for (int k = 0; k < grafo.adjList.get(j).size(); k++) {
                if (grafo.adjList.get(j).get(k).destino == i) {
                    System.out.print("" + grafo.adjList.get(j).get(k).origem + i + " ");
                }
            }
        }
        System.out.println();
    }

    public void incidentes_aresta(Arco a) { //Item 7
        System.out.println("Os vértices incidentes a aresta " + a.origem + a.destino + " são: " + a.origem + " " + a.destino);
    }

    public int grauEntrada(int v) { // Item 8
        int n = 0;
        for (int i = 0; i < this.grafo.adjList.size(); i++) {
            for (int j = 0; j < this.grafo.adjList.get(i).size(); j++) {
                if (this.grafo.adjList.get(i).get(j).origem == v) {
                    n++;
                }
            }
        }
        return n;
    }

    public int grauSaida(int v) { //Item 9
        return this.grafo.adjList.get(v).size();
    }

    public boolean adjacentes(int v1, int v2) { //Item 10
        boolean flag = false;
        for (int i = 0; i < this.grafo.adjList.get(v1).size(); i++) {
            if (this.grafo.adjList.get(v1).get(i).destino == v2) {
                flag = true;
            }

        }
        for (int i = 0; i < this.grafo.adjList.get(v2).size(); i++) {
            if (this.grafo.adjList.get(v2).get(i).destino == v1) {
                flag = true;
            }
        }
        return flag;
    }

    public void listaAdj() {
        for (int i = 0; i < this.grafo.adjList.size(); i++) {
            System.out.print(i + "->");
            for (int j = 0; j < this.grafo.adjList.get(i).size(); j++) {
                System.out.print(this.grafo.adjList.get(i).get(j).destino + " ");
            }
            System.out.println();
        }
    }

    public void matrizAdj() {
        for (int i = 0; i < this.grafo.vertices.size(); i++) {
            for (int j = 0; j < this.grafo.vertices.size(); j++) {
                System.out.print(this.grafo.adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println();
    }

}
