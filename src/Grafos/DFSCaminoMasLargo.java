package Grafos;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSCaminoMasLargo<T> {
    private LinkedList<Integer> caminoMasLargo;

    private void obtenerCaminoMasLargo(GrafoDirigido<T> grafo, int vertice1, int vertice2, LinkedList<Integer> recorridoAct){
        if(vertice1==vertice2) {
            if(caminoMasLargo.size()<recorridoAct.size()){
                caminoMasLargo.clear();
                caminoMasLargo.addAll(recorridoAct);
            }
        }else {
            Iterator<Integer> itAdy = grafo.obtenerAdyacentes(vertice1);
            while (itAdy.hasNext()) {
                int adyacente = itAdy.next();
                recorridoAct.add(adyacente);
                obtenerCaminoMasLargo(grafo,adyacente,vertice2,recorridoAct);
                recorridoAct.remove(adyacente);
            }
        }

    }

    public LinkedList<Integer> obtenerCaminoMasLargo(GrafoDirigido<T> grafo, int vertice1, int vertice2){
        caminoMasLargo.clear();
        LinkedList<Integer> recorrido = new LinkedList<>();
        recorrido.add(vertice1);
        obtenerCaminoMasLargo(grafo,vertice1,vertice2,recorrido);
        return caminoMasLargo;
    }
}
