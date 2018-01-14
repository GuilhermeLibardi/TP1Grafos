package src.graphtheoryjava.algoritmos;

import src.graphtheoryjava.caminhominimo.Fila;
import src.graphtheoryjava.util.Grafo;
import src.graphtheoryjava.algoritmos.estruturasdedados.Pilha;
import java.util.ArrayList;

public class Search {

    public Grafo grafo;
    public ArrayList<Integer> ordem;
    public int[] visitado;

    public Search(Grafo grafo) {
        this.grafo = grafo;
        this.visitado = new int[grafo.vertices.size()];
    }

    public ArrayList<Integer> BuscaLargura(int s) { // Item 11
        Fila fila = new Fila();
        Info info = new Info(this.grafo);
        ArrayList<Integer> retorno = new ArrayList<>();
        int u;
        
        this.reset();
        this.visitado[s] = 1;
        retorno.add(s);
        
        fila.Enfilera(s);
        while(!fila.isEmpty()){
            u = (int) fila.Desenfilera();
            for(int v: info.sucessores(u)){
                if(this.visitado[v] == 0){
                    visitado[v] = 1;
                    fila.Enfilera(v);
                    retorno.add(v);
                }
            }
        }
        return retorno;
    }

    public ArrayList<Integer> BuscaProfundidade(int s) { // Item 12
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

    public ArrayList<Integer> BuscaProfRecursiva() { // Item 13
        this.reset();
        ArrayList<Integer> retorno = new ArrayList<>();
        for (int i : this.grafo.vertices) {
            if (this.visitado[i] == 0) {
                PROF(i, retorno);
            }
        }
        return retorno;
    }

    public int ComponentesConexas() { // Item 14
        this.reset();
        int componente = 0;

        for (int i : this.grafo.vertices) {
            if (visitado[i] == 0) {
                componente++;
                this.PROF_CON(i, componente);
            }
        }

        return componente;
    }

    public ArrayList<Integer> OrdenacaoTopologica() { // Item 15
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

    private void PROF(int u, ArrayList<Integer> retorno) {
        Info info = new Info(this.grafo);

        this.visitado[u] = 1;
        retorno.add(u);
        for (int v : info.sucessores(u)) {
            if (visitado[v] == 0) {
                PROF(v, retorno);
            }
        }
    }
    
    private void reset() {
        ordem = new ArrayList<Integer>();
        for (int i = 0; i < grafo.vertices.size(); i++) {
            this.visitado[i] = 0;
        }
    }
}
