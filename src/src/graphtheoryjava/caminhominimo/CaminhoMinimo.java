package src.graphtheoryjava.caminhominimo;

import java.util.ArrayList;
import src.graphtheoryjava.algoritmos.Info;
import src.graphtheoryjava.algoritmos.estruturasdedados.Pilha;
import src.graphtheoryjava.util.Arco;
import src.graphtheoryjava.util.Grafo;

public class CaminhoMinimo {

    private Grafo grafo;
    private ArrayList<Integer> caminho;
    private int custo;
    private double tempo;

    public CaminhoMinimo(Grafo grafo) {
        this.grafo = grafo;
        this.caminho = new ArrayList<>();
        this.custo = 0;
        this.tempo = 0;
    }

    public void Dijkstra(int origem, int destino) {
        long inicio = System.currentTimeMillis();
        Info info = new Info(this.grafo);
        int[] dist = new int[this.grafo.vertices.size()];
        int[] pred = new int[this.grafo.vertices.size()];
        ArrayList<Integer> caminho = new ArrayList<>();
        int u;

        for (int i : this.grafo.vertices) {
            dist[i] = 99999;
            pred[i] = -1;
        }

        dist[origem] = 0;
        ArrayList<Integer> Q = this.grafo.vertices;

        while (!Q.isEmpty()) {
            u = this.min(Q, dist);
            Q.remove(Q.indexOf(u));
            for (int v : info.sucessores(u)) {
                if (dist[v] > dist[u] + this.w(u, v)) {
                    dist[v] = dist[u] + this.w(u, v);
                    pred[v] = u;
                }
            }
        }
        this.Caminho(pred, origem, destino);
        this.tempo = (double) (System.currentTimeMillis() - inicio)/1000;
    }

    private void Caminho(int[] pred, int origem, int destino) {
        int aux = destino;
        this.caminho.add(0, destino);

        while (aux != origem) { //enquanto destino(sink)!= origem(source)
            aux = pred[aux];
            this.caminho.add(0, aux);
        }
        for (int i = 0; i < this.caminho.size() - 1; i++) {
            this.custo += w(i, i + 1);
        }
    }

    private int min(ArrayList<Integer> visitado, int[] distancia) {
        int u = visitado.get(0);

        int auxi = distancia[visitado.get(0)];
        for (int i = 0; i < visitado.size(); i++) {
            if (distancia[visitado.get(i)] < auxi) {
                auxi = distancia[visitado.get(i)];
                u = visitado.get(i);
            }
        }

        return u;
    }

    /*
    Calcula o peso de uma aresta que possui u e v como vértices incidentes
    @param u    Vértice 1
    @param v    Vértice 2
    @return     peso da aresta ou -1 caso não encontre uma aresta
    @author Guilherme Libardi
    @author Italo Trindade
     */
    private int w(int u, int v) {
        for (int i = 0; i < this.grafo.arestas.size(); i++) {
            if (this.grafo.arestas.get(i).origem == u && this.grafo.arestas.get(i).destino == v || this.grafo.arestas.get(i).origem == v && this.grafo.arestas.get(i).destino == u) {
                return this.grafo.arestas.get(i).peso;
            }
        }
        return -1;
    }

    private void remove(ArrayList<Integer> arr, int x) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == x) {
                arr.remove(i);
                break;
            }
        }
    }

    public boolean BellmanFord(int origem, int destino) {
        long inicio = System.currentTimeMillis();
        Info info = new Info(this.grafo);
        int[] dist = new int[this.grafo.vertices.size()];
        int[] pred = new int[this.grafo.vertices.size()];
        Pilha pilha = new Pilha();
        int aux, teste = 0;

        for (int i : this.grafo.vertices) {
            dist[i] = 10000000;
            pred[i] = -1;
        }
        dist[origem] = 0;

        for (int j : this.grafo.vertices) {
            for (Arco k : this.grafo.arestas) {
                if (dist[k.destino] > (dist[k.origem] + w(k.origem, k.destino))) {
                    dist[k.destino] = (dist[k.origem] + w(k.origem, k.destino));
                    pred[k.destino] = k.origem;
                    teste++;
                }
            }
            if (teste == 0) {
                break;
            }
            teste = 0;
        }

        for (Arco i : this.grafo.arestas) {
            if (dist[i.destino] > (dist[i.origem] + w(i.origem, i.destino))) {
                return false;
            }
        }
        this.Caminho(pred, origem, destino);
        this.tempo = (double) (System.currentTimeMillis() - inicio)/1000;
        return true;
    }

    public ArrayList<Integer> getCaminho() {
        return this.caminho;
    }

    public int getCusto() {
        return this.custo;
    }

    public double getTempo() {
        return this.tempo;
    }
}
