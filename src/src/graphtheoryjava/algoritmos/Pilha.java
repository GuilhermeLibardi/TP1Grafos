package src.graphtheoryjava.algoritmos;

import java.util.LinkedList;
import java.util.List;

public class Pilha {
    private List<Object> objs = new LinkedList<>();
    
    public void Empilha(Object objeto){
        this.objs.add(objeto);
    }
    
    public Object Desempilha(Object objeto){
        return this.objs.remove(this.objs.size() - 1);
    }
    
    public boolean isEmpty(){
        return this.objs.isEmpty();
    }
}
