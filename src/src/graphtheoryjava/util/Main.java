package src.graphtheoryjava.util;

import src.graphtheoryjava.util.Leitura;
import src.graphtheoryjava.util.Grafo;
import java.io.IOException;
import java.util.Scanner;
import src.graphtheoryjava.algoritmos.Info;

public class Main {

    public static void main(String[] args) {
        try {

            System.out.println("Graph File:");
            Leitura leitura = new Leitura();

            Grafo grafo = leitura.lerArquivo("graph.txt");
            
            Info info = new Info(grafo);
            info.listaAdj();
            info.adjacentes(0, 1);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
