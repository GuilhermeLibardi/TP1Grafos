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

    public ArrayList<Arco> adjacente(Arco a) { // Item 3
        ArrayList<Arco> retorno = new ArrayList<>(0);
        ArrayList<Arco> aux1 = new ArrayList<>(0);
        ArrayList<Arco> aux2 = new ArrayList<>(0);

        aux1 = incidentes_vertice(a.origem);
        aux2 = incidentes_vertice(a.destino);

        for (int i = 0; i < aux1.size(); i++) {
            if ((a.destino != aux1.get(i).destino)) {
                retorno.add(aux1.get(i));
            }
        }

        for (int i = 0; i < aux2.size(); i++) {
            if ((a.origem != aux2.get(i).origem)) {
                if ((a.origem != aux2.get(i).destino)) {
                    retorno.add(aux2.get(i));
                }
            }
        }

        return retorno;
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

    public ArrayList<Arco> incidentes_vertice(int i) { // Item 6
        ArrayList<Arco> retorno = new ArrayList(0);

        for (int j = 0; j < grafo.adjList.get(i).size(); j++) {
            retorno.add(grafo.adjList.get(i).get(j));
        }

        for (int j = 0; j < grafo.vertices.size(); j++) {
            for (int k = 0; k < grafo.adjList.get(j).size(); k++) {
                if (grafo.adjList.get(j).get(k).destino == i) {
                    retorno.add(grafo.adjList.get(j).get(k));
                }
            }
        }
        return retorno;
    }

    public ArrayList<Integer> incidentes_aresta(Arco a) { //Item 7
        ArrayList<Integer> retorno = new ArrayList<>(0);
        retorno.add(a.origem);
        retorno.add(a.destino);
        return retorno;
    }

    public int grauEntrada(int v) { // Item 8
        int n = 0;
        for (int i = 0; i < this.grafo.adjList.size(); i++) {
            for (int j = 0; j < this.grafo.adjList.get(i).size(); j++) {
                if (this.grafo.adjList.get(i).get(j).destino == v) {
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
