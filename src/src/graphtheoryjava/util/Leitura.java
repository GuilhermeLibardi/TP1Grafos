package src.graphtheoryjava.util;

import java.io.*;
import java.util.*;

public class Leitura {

    public File arquivo;
    public src.graphtheoryjava.util.Grafo grafo;

    public Leitura() {

    }

    public src.graphtheoryjava.util.Grafo lerArquivo(String nomeArquivo) throws IOException {

        //abre o arquivo
        this.arquivo = new File(nomeArquivo);
        FileReader leitura = new FileReader(arquivo);
        BufferedReader armazenar = new BufferedReader(leitura);

        //Le o cabecalho do arquivo
        String[] linha;
        linha = armazenar.readLine().split(" ");
        int numVertice = Integer.parseInt(linha[0]);
        int numArcos = Integer.parseInt(linha[1]);

        //Inicializa as estruturas de dados
        ArrayList<Integer> vertices = new ArrayList<>();
        ArrayList<ArrayList<Arco>> adjList = new ArrayList<>();
        ArrayList<Arco> arcos = new ArrayList<>();
        int[][] adjMatrix = new int[numVertice][numVertice];

        //cria a lista de adj e a matrix adj
        for (int i = 0; i < numVertice; i++) {
            for (int j = 0; j < numVertice; j++) {
                adjMatrix[i][j] = 0;
            }
        }

        for (int i = 0; i < numVertice; ++i) {
            adjList.add(new ArrayList<>());
        }

        //preenche as estruturas lidas no arquivo
        for (int i = 0; i < numVertice; ++i) {
            vertices.add(i);
        }

        for (int i = 0; i < numArcos; ++i) {
            String[] infoArco = armazenar.readLine().split(" ");
            int origem = Integer.parseInt(infoArco[0]);
            int destino = Integer.parseInt(infoArco[1]);
            int peso = Integer.parseInt(infoArco[2]);

            src.graphtheoryjava.util.Arco e = new src.graphtheoryjava.util.Arco(origem, destino, peso);

            arcos.add(e);
            adjList.get(origem).add(e);
            adjMatrix[origem][destino] = peso;
        }

        grafo = new src.graphtheoryjava.util.Grafo(vertices, arcos, adjList, adjMatrix);

        //fecha o arquivo
        armazenar.close();
        leitura.close();
        return grafo;

    }
}
