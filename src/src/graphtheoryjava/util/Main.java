package src.graphtheoryjava.util;

import src.graphtheoryjava.util.Leitura;
import src.graphtheoryjava.util.Grafo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import src.graphtheoryjava.algoritmos.Info;
import src.graphtheoryjava.algoritmos.Search;
import src.graphtheoryjava.caminhominimo.CaminhoMinimo;

public class Main {

    public static void main(String[] args) {
        try {

            Leitura leitura = new Leitura();
            Grafo grafo = leitura.lerArquivo("toy.txt");

            Info info = new Info(grafo);
            Search search = new Search(grafo);
            CaminhoMinimo cm = new CaminhoMinimo(grafo);
            
            ArrayList<Integer> caminho = cm.Dijkstra(0, 4);
            
            for(int i: caminho){
                System.out.println(i + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
