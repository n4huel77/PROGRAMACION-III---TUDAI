package Grafos;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        super.agregarArco(verticeId1, verticeId2, etiqueta);
        super.agregarArco(verticeId2, verticeId1, etiqueta);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        super.borrarArco(verticeId1, verticeId2);
        super.borrarArco(verticeId2, verticeId1);
    }

    @Override
    public int cantidadArcos() {
        return super.cantidadArcos() / 2;
    }

    //EL ENUNCIADO TIENE UN GRAFO DE STRING PERO ESTE GRAFO ADMITE INTEGER, DEBERIA CAMBIAR LA SIGNATURA A UN T PARA PODER RECIBIR CUALQUIER TIPO
    public List<Integer> encontrarHamiltoniano(Grafo<Integer> grafo, int origen) {
        ArrayList<Integer> solucion = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<>();
        mayorPeso = -1;
        actual.add(origen);
        existeCicloRec(grafo, origen, origen, solucion, actual, 0);
        return solucion;
    }

    private void existeCicloRec(
            Grafo<?> grafo,
            int origen,
            int destino,
            ArrayList<Integer> solucion,
            ArrayList<Integer> actual,
            int pesoActual
    ) {
        if (actual.size() == grafo.cantidadVertices() && grafo.existeArco(origen, destino)) {
            Arco<Integer> arcoVuelta = (Arco<Integer>) grafo.obtenerArco(destino, origen);
            int pesoTotal = pesoActual + arcoVuelta.getEtiqueta();
            if (esMejor(mayorPeso, pesoTotal)) {
                solucion.clear();
                solucion.addAll(actual);
                solucion.add(origen);
                mayorPeso = pesoTotal;
            }
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()) {
                int ad = adyacentes.next();
                if (!actual.contains(ad)) {
                    Arco<Integer> arco = (Arco<Integer>) grafo.obtenerArco(origen, ad);
                    int pesoArco = arco.getEtiqueta();
                    actual.add(ad);
                    existeCicloRec(grafo, origen, destino, solucion, actual, pesoActual + pesoArco);
                    actual.removeLast();
                    pesoActual -= pesoArco;
                }
            }
        }
    }


    private boolean esMejor(Integer mejor, Integer actual) {
        // return mejor == null || actual < mejor; // Camino menos pesado
        return mejor == null || actual > mejor; // Camino mas pesado
    }
}