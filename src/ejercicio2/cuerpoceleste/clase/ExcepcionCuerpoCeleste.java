/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.cuerpoceleste.clase;

/**
 * @author jesus Bernabe Imedio Perea
 * @date 01/04/2023
 * @description Clase excepcion creada por mi que hereda de Exception y es lanzada desde los métodos set de la 
 * clase CuerpoCeleste, cuando sus parámetros no cumplen con la especificación del problema.
 * Posee un constructor el cual llama mediante super a su padre, pasándole por parámetro el mensaje.
 * 
 * Practica 6 Almacenando datos
 */
public class ExcepcionCuerpoCeleste extends Exception{
    public ExcepcionCuerpoCeleste(String msg){
        super(msg);
    }
    
}
