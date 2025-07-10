package Parcial14_06.EjercicioGreedy;

import java.util.ArrayList;
import java.util.Collections;

public class Procesador2 {
    private Tarea [] solucion;
    private int puntajeTotal;


    public Tarea [] getSolucion(ArrayList<Tarea> tareas) {
        Collections.sort(tareas, Collections.reverseOrder());
        solucion = new Tarea [tareas.size()];
        boolean [] ocupados = new boolean[tareas.size()];


        for (Tarea tarea : tareas) {
            int caducidad = tarea.getCaducidad()-1;
            for (int i = caducidad; i <=0 ; i--) {
                if (!ocupados[caducidad]) {
                    ocupados[caducidad]=true;
                    solucion[caducidad] = tarea;
                    break;
                }
            }
        }
        return solucion;
    }

    public int getPuntajeTotal() {
        for (Tarea tarea : solucion) {
            puntajeTotal = puntajeTotal + tarea.getPuntaje();
        }
        return puntajeTotal;
    }
}
