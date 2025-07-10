package Parcial14_06.EjercicioBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ArmarPalabra {

    Diccionario diccionario = new Diccionario();
    List<String> palabras;

    public List<String> generarPalabra(Set<String> letras) {
        palabras = new LinkedList<>();
        String palabra = new String();
        backtracking(palabra, letras);
        return palabras;

    }

    private void backtracking(String palabra, Set<String> letras) {
        if (palabra.length() == 4){
            if(diccionario.esValida(palabra)){
                palabras.add(palabra);
            }
        }
        else{
            for (String letra : letras) {
                //Validamos restricciones
                //Si es la primera letra que no sea vocal
                if ((palabra.length() != 0) || ((palabra.length() == 0) && (!Diccionario.esVocal(letra)))) { //Si no es letra repetida
                    if (!palabra.contains(letra)) {
                        palabra += letra;
                        //if (!poda(palabra)) {
                        //Si no podamos, generamos el estado
                            backtracking(palabra, letras);
                        }
                       // palabra -= letra;
                    }
                }
            }
        }
    }




