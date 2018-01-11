package src.graphtheoryjava.caminhominimo;

import java.util.ArrayList;
import src.graphtheoryjava.algoritmos.Info;
import src.graphtheoryjava.util.Grafo;

public class CaminhoMinimo {
    
    private Grafo grafo;
    
    public CaminhoMinimo(Grafo grafo) {
        this.grafo = grafo;
    }
    
    public ArrayList<Integer> Dijkstra(int origem, int destino) {
        Info info = new Info(this.grafo);
        int[] dist = new int[this.grafo.vertices.size()];
        int[] pred = new int[this.grafo.vertices.size()];
        ArrayList<Integer> caminho = new ArrayList<>();
        int u;
        
        for (int i : this.grafo.vertices) {
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        
        dist[origem] = 0;
        ArrayList<Integer> Q = this.grafo.vertices;
        
        while (!Q.isEmpty()) {
            u = this.min(dist);
            this.remove(Q, u);
            for (int v : info.sucessores(u)) {
                if (dist[v] > dist[u] + this.w(u, v) && this.w(u, v) != -1) {
                    dist[v] = dist[u] + this.w(u, v);
                    pred[v] = u;
                    caminho.add(u);
                }
            }
        }
        return caminho;
    }
    
    private int min(int[] dist) {
        int min = dist[0];
        for (int i : dist) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
    
    private int w(int u, int v) {
        int w = 0;
        for (int i = 0; i < this.grafo.arestas.size(); i++) {
            if (this.grafo.arestas.get(i).origem == u && this.grafo.arestas.get(i).destino == v || this.grafo.arestas.get(i).origem == v && this.grafo.arestas.get(i).destino == u) {
                return this.grafo.arestas.get(i).peso;
            }
        }
        return -1;
    }
    
    private void remove(ArrayList<Integer> arr, int x){
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == x){
                arr.remove(i);
            }
        }
    }

//    public ArrayList<Integer> BellmanFord(int origem, int destino){
//        
//    }
}
