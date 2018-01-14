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
            Scanner s = new Scanner(System.in);
            String graphName = s.nextLine().toString();
            Grafo grafo = leitura.lerArquivo(graphName);
            Info info = new Info(grafo);
            Search search = new Search(grafo);
            CaminhoMinimo cm = new CaminhoMinimo(grafo);

            System.out.println("Digite a origem");
            int origem = s.nextInt();
            System.out.println("Digite o destino");
            int destino = s.nextInt();

            cm.Dijkstra(origem, destino);
            System.out.println("Custo: " + cm.getCusto());
            System.out.print("Menor caminho de " + origem + " até " + destino + " => ");

            //Comparando os 2 algoritmos Origem: 0, Destino: 1000
            //Bellman-Ford: 0 21 164 161 166 163 170 189 190 335 337 342 343 339 346 347 334 514 406 523 574 573 572 571 570 600 604 507 506 508 511 510 958 962 963 970 971 969 1013 1015 1014 989 988 986 987 985 1000 
            //Dijkstra:     0 21 164 161 166 163 170 189 190 335 337 342 343 339 346 347 334 514 406 523 574 573 572 571 570 600 604 507 506 508 511 510 958 962 963 970 971 969 1013 1015 1014 989 988 986 987 985 1000 
            
            for (int i : cm.getCaminho()) {
                System.out.print(i + " ");
            }

            System.out.println("");
            System.out.println("Tempo de execução: " + cm.getTempo() + "s");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
