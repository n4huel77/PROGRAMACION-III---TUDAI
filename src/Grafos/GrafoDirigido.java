package Grafos;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, HashMap<Integer,Arco<T>>> vertices = new HashMap<>();

    public void agregarVertice(int verticeId) {
        if(!vertices.containsKey(verticeId))
            vertices.put(verticeId,new HashMap<>());
    }
    /*
    @Override
    (solo verifica si tiene arcos salientes, es decir, si desde él no se dirige a nadie)
    public void borrarVertice(int verticeId) {
        if(vertices.get(verticeId).values().isEmpty()){ // vertices.get(verticeId)-> { si el vertice no existe
            vertices.remove(verticeId);                                                apuntara a un null }
        }
    }
    */
    @Override
    public void borrarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId)) return; // evita nullpointer

        // Verifica que no tenga arcos entrantes
        for (HashMap<Integer, Arco<T>> adyacentes : vertices.values()) {
            if (adyacentes.containsKey(verticeId)) {
                return; // tiene arco entrante, no se borra
            }
        }

        // Verifica que no tenga arcos salientes
        if (vertices.get(verticeId).isEmpty()) {
            vertices.remove(verticeId);
        }
    }


    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
            Arco<T> arco = new Arco<>(verticeId1,verticeId2,etiqueta);
            vertices.get(verticeId1).put(verticeId2,arco);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return vertices.containsKey(verticeId1) && vertices.get(verticeId1).containsKey(verticeId2);
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        //Si no existe el vértice origen, directamente retorna null.
        if (vertices.containsKey(verticeId1)) {
            return vertices.get(verticeId1).get(verticeId2);
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
      return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int cantidad = 0;
        for (HashMap<Integer, Arco<T>> adyacentes : vertices.values()) {
            cantidad += adyacentes.size();
        }
        return cantidad;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(vertices.containsKey(verticeId)){
            for (Arco<T> arco : vertices.get(verticeId).values())
                arr.add(arco.getVerticeDestino());
        }
        return arr.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
            Iterator<Integer> it = this.obtenerVertices();
            ArrayList<Arco<T>>  arcos = new ArrayList<>();
            while (it.hasNext()){
                int vertice = it.next();
                arcos.addAll(vertices.get(vertice).values());
            }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (vertices.containsKey(verticeId)) {
            return vertices.get(verticeId).values().iterator();
        }
        return new ArrayList<Arco<T>>().iterator();
    }



}