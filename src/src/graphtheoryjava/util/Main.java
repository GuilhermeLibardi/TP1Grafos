package src.graphtheoryjava.util;

import src.graphtheoryjava.util.Leitura;
import src.graphtheoryjava.util.Grafo;
import java.io.IOException;
import java.util.Scanner;
import src.graphtheoryjava.algoritmos.Info;
import src.graphtheoryjava.algoritmos.Search;

public class Main {

    public static void main(String[] args) {
        try {

            System.out.println("Graph File:");
            Leitura leitura = new Leitura();

            Grafo grafo = leitura.lerArquivo("graph.txt");
            
            Search search = new Search(grafo);
            search.buscaProfundidade(0);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
