package Parcial14_06.EjercicioGreedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Procesador {
    private Set<Tarea> solucion;
    private int puntajeTotal;

    public Set<Tarea> getSolucion(ArrayList<Tarea> tareas) {
        Collections.sort(tareas,Collections.reverseOrder());
        int maxTiempo = 0;

        for (Tarea tarea : tareas) {
            if (tarea.getCaducidad() > maxTiempo) {
                maxTiempo = tarea.getCaducidad();
            }

        }

        Tarea [] ejecuciones = new Tarea[maxTiempo]; // voy a tener un arreglo del tamaño de tarea con mayor caducidad

        for (Tarea tarea : tareas) {
            for (int i = tarea.getCaducidad()-1; i >=0 ; i--) { //ejemplo con T2{C=1] -----  int i = 1-1 => 0
                if(ejecuciones[i] == null){ // pongo la tarea en la primer posicion si no esta ocupada, ya que tiene prioridad por caducidad
                    ejecuciones[i] = tarea;
                    break;
                }

            }
        }

        for (int i = 0; i < maxTiempo; i++) {
            if (ejecuciones[i] != null) {
                solucion.add(ejecuciones[i]);
            }
        }

        return solucion;

    }

    public int getPuntajeTotal() {
        for (Tarea tarea : solucion) {
            puntajeTotal += tarea.getPuntaje();
        }
        return puntajeTotal;
    }
}
