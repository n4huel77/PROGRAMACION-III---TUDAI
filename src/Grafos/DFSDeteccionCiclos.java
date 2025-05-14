package Grafos;

import java.util.HashMap;
import java.util.Iterator;

public class DFSDeteccionCiclos<T> {
    private enum Color{BLANCO,AMARILLO,NEGRO};
    private HashMap<Integer,Color> colores; // Mapeo de verticesID correspondientes a un COLOR
    private boolean hayCiclo;  //Booleano para identificar existencia de ciclo

    public boolean tieneCiclo(GrafoDirigido<T> grafo){
        //Inicializacion de variables
        colores = new HashMap<>();
        hayCiclo = false;

        //Inicializo todos los vertices en BLANCO
        Iterator<Integer> it = grafo.obtenerVertices(); //Me traigo los vertices
        while(it.hasNext()){
            colores.put(it.next(), Color.BLANCO);
        }
        //Por cada vertice, pregunto su color
        for (int vertice : colores.keySet()){
            if(colores.get(vertice)== Color.BLANCO){
                dfsVisit(grafo,vertice); //Se visita siempre que sea blanco
            }
        }
        return hayCiclo;
    }

    // u = vertice
    private void dfsVisit(GrafoDirigido<T> grafo, int u) {
        //Vertice entrante se pone en AMARILLO para identificar que fue visitado
        colores.put(u,Color.AMARILLO);

        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(u); //Me traigo los adyacentes
        while (itAdy.hasNext()){
            int verticeAdy = itAdy.next();

            if (colores.get(verticeAdy) == Color.BLANCO){ // Por cada adyacente pregunto si no fue visitado
                dfsVisit(grafo,verticeAdy); //En caso de no serlo, se visita (vuelve a linea 33)
            }else if (colores.get(verticeAdy) == Color.AMARILLO)//En caso de ya haber sido visitado, hay ciclo
                hayCiclo = true;

        }
        colores.put(u,Color.NEGRO); //Si no tengo adyacente por visitar, lo marco en NEGRO
    }

}
