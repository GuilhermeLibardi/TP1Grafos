package src.graphtheoryjava.algoritmos;

import src.graphtheoryjava.util.Grafo;

public class Info {
	
	public Grafo grafo;
	
	public Info(Grafo grafo){
		this.grafo = grafo;
	}
	
	public int ordem(){
		return grafo.vertices.size();
	}
	
	public void adjacente(int i){
		System.out.println("Arestas adjacentes a " + i);
        for(int j = 0; j< grafo.adjList.get(i).size(); j++){
        	System.out.print(i + "" + grafo.adjList.get(i).get(j).destino+" ");
        }
        System.out.println();
	}

	public void listaAdj(Grafo grafo){
		for(int i = 0; i< grafo.adjList.size(); i++){
			System.out.print(i+"->");
			for(int j = 0; j< grafo.adjList.get(i).size(); j++){
				System.out.print(grafo.adjList.get(i).get(j).destino+" ");
			}
			System.out.println();
		}
	}
	
	
	
	
}
