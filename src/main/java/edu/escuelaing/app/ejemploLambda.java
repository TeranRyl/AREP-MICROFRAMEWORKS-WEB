package edu.escuelaing.app;


import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ejemploLambda {
    static Map <String, ServicioParam> servicios = new HashMap<String, ServicioParam>();
    //static Map <Integer, ServicioParam> servicios = new HashMap<Integer, ServicioParam>();

    public static void main(String[] args){
        System.out.println("Inicio");
        //registrar("/hello", str -> "Hello " + str); //'str -> "Hello " + str' Funcion Lambda
        //System.out.println(buscar("/hello").handle("Daniel")); // Esto sirve para implementar funciones, en este caso de 1 parametro.
        registrar("/cuadrado", str -> "El cuadrado de " + str + " es: " + Integer.parseInt(str) * Integer.parseInt(str));
        System.out.println(buscar("/cuadrado").handle("5"));

        registrar("/cos", new ServicioParam(){
            @Override
            public String handle(String str) {
                return "" + Math.cos(Double.parseDouble(str));
            }
        });

        System.out.println("El  cos de 0.77 rad es: " + buscar("/cos").handle("0.77"));

        registrar("/sin", str -> {
            Double val = Double.parseDouble(str.split("val=")[1]);
            return "" + Math.sin(val);
        });

        System.out.println("El sin 0.55 es: " + buscar("/sin").handle("/sin?val=0.55")); //SERVICIO WEB
    }



    public static void registrar(String url, ServicioParam endpoint){
        servicios.put(url, endpoint);
    }

    public static ServicioParam buscar(String url){
        return servicios.get(url);
    }
}