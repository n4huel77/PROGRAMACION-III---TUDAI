package Parcial14_06.EjercicioGreedy;

public class Tarea implements Comparable<Tarea> {
    private String name;
    private int puntaje;
    private int caducidad;

    public Tarea(String name, int puntaje, int caducidad) {
        this.name = name;
        this.puntaje = puntaje;
        this.caducidad = caducidad;
    }

    public String getName() {
        return name;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getCaducidad() {
        return caducidad;
    }


    @Override
    public int compareTo(Tarea o) {
        return this.puntaje - o.puntaje;
    }
}
