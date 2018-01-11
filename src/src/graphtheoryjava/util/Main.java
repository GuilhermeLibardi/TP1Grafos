package src.graphtheoryjava.util;

import src.graphtheoryjava.util.Leitura;
import src.graphtheoryjava.util.Grafo;
import java.io.IOException;
import java.util.ArrayList;
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
            ArrayList<Integer> busca = search.buscaProfundidade(0);
            System.out.println("Ordem: ");
            for(int a : busca){
                System.out.print(a + " ");
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
