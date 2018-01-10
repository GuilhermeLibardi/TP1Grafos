package src.graphtheoryjava.algoritmos;

import src.graphtheoryjava.util.Grafo;

public class Info {

    public Grafo grafo;

    public Info(Grafo grafo) { // Construtor
        this.grafo = grafo;
    }

    public int ordem() { // Item 2
        return this.grafo.vertices.size();
    }

    public void sucessores(int v) { // Item 4
        System.out.print("Vértices adjacentes (sucessores) de " + v + " -> ");
        for (int i = 0; i < this.grafo.adjList.get(v).size(); i++) {
            System.out.print(this.grafo.adjList.get(v).get(i).destino + " ");
        }
        System.out.println();
    }

    public void grauEntrada(int v) { // Item 8
        int n = 0;
        for (int i = 0; i < this.grafo.adjList.size(); i++) {
            for (int j = 0; j < this.grafo.adjList.get(i).size(); j++) {
                if(this.grafo.adjList.get(i).get(j).origem == v){
                    n++;
                }
            }
        }
        System.out.println("Grau de entrada do vértice " + v + ": " + n);
    }

    public void grauSaida(int v) { //Item 9
        System.out.println("Grau de entrada do vértice " + v + ": " + this.grafo.adjList.get(v).size());
    }

    public void listaAdj() { // Não tem item pra isso aqui não haueaeh
        for (int i = 0; i < this.grafo.adjList.size(); i++) {
            System.out.print(i + "->");
            for (int j = 0; j < this.grafo.adjList.get(i).size(); j++) {
                System.out.print(this.grafo.adjList.get(i).get(j).destino + " ");
            }
            System.out.println();
        }
    }

}
