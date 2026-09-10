/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2.cuerpoceleste.clase;

import java.io.Serializable;

/**
 *
 * @author jesus Bernabe Imedio Perea
 * @date 01/04/2023
 * @description Clase creacion de objetos cuerpos celestes. Es serializada
 * Control de excepciones para la creacion de los atributos 
 * Métodos set verifican la correcta introducción de los datos
 * 
 * Practica 6 Almacenando datos
 */
public class CuerpoCeleste implements Serializable {

    //atributos
    private short codigoCuerpo; //3 digitos
    private String nombre; //15 caracteres como maximo
    private String tipoObjeto;//tipos pueden ser "planeta" "planetaEnano" "luna" 
    private int diametro;//6 digitos km

    /**
     * Constructor sin parámetros. Inicializo por defecto
     */
    public CuerpoCeleste() {
        this.codigoCuerpo = 000;
        this.nombre = "";
        this.tipoObjeto = "";
        this.diametro = 000000;

    }

   
    /**
     * Constructor clase cuerpo celeste con parámetros
     *
     * @param codigoCuerpo
     * @param nombre
     * @param tipoObjeto
     * @param diametro
     * @throws ExcepcionCuerpoCeleste
     */
    public CuerpoCeleste(int codigoCuerpo, String nombre, String tipoObjeto, int diametro) throws ExcepcionCuerpoCeleste {
        this.setCodigoCuerpo(codigoCuerpo);
        this.setNombre(nombre);
        this.setTipoObjeto(tipoObjeto);
        this.setDiametro(diametro);
    }

    /**
     * Método que recibe el código del cuerpo celeste por parámetro y comprueba
     * que tenga 3 digitos. Para ello realiza division sucesivas entre 10 y
     * almacena en contador el numero de digitos.
     *
     * @param codigoCuerpo
     * @throws ExcepcionCuerpoCeleste es lanzada si el codigoCuerpo no tiene 3
     * digitos (se considera 3 cifras a partir de 100, los 0 a la izquierada no se contabilizan)
     * es decir el 099 seria el 99 por tanto tendria 2 cifras y saltaria excepción.
     */
    public void setCodigoCuerpo(int codigoCuerpo) throws ExcepcionCuerpoCeleste {

       
        int contador = 0;

        for (int i = Math.abs(codigoCuerpo); i > 0; i /= 10) {
            contador++;
        }

        if (contador == 3) {//tiene 3 cifras
            this.codigoCuerpo = (short) codigoCuerpo;
        } else {

            throw new ExcepcionCuerpoCeleste("CUERPO CELESTE EXCEPTION: codigoCuerpo no tiene 3 digitos");
        }
        

    }

    /**
     * Metodo que recibe el nombre y comprueba que el número de caracteres sea
     * correcto
     *
     * @param nombre
     * @throws ExcepcionCuerpoCeleste lanza si el nombre tiene mas de 15
     * caracteres
     */
    public void setNombre(String nombre) throws ExcepcionCuerpoCeleste {

        if (nombre.length() <= 15) {
            this.nombre = nombre;
        } else {

            throw new ExcepcionCuerpoCeleste("CUERPO CELESTE EXCEPTION: nombre no puede exceder de 15 caracteres");
        }

    }

    /**
     * Método que recibe el tipo de objeto del cuerpo celeste y comprueba que es
     * válido
     *
     * @param tipoObjeto
     * @throws ExcepcionCuerpoCeleste si tipoObjeto no es planetaEnano, luna o
     * planeta
     */
    public void setTipoObjeto(String tipoObjeto) throws ExcepcionCuerpoCeleste {

        if (tipoObjeto.equals("planeta") || tipoObjeto.equals("planetaEnano") || tipoObjeto.equals("luna")) {
            this.tipoObjeto = tipoObjeto;
        } else {
            throw new ExcepcionCuerpoCeleste("CUERPO CELESTE EXCEPTION: tipoObjeto tiene que ser: planeta,planetaEnano o luna");
        }

    }

    /**
     * Método que recibe el diametro del cuerpo celeste por parámetro y
     * comprueba que tenga 6 digitos. Para ello realiza division sucesivas entre
     * 10 y almacena en contador el numero de digitos.
     * No se coputan como cifras los 0 a la izquierda. es decir el 020202 será interpretado 
     * como el 20202 por tanto tendrá 5 cifras y lanzara una excepción.
     *
     * @param diametro
     * @throws ExcepcionCuerpoCeleste si diametro no tiene 6 digitos
     */
    public void setDiametro(int diametro) throws ExcepcionCuerpoCeleste {

        int contador = 0;

        for (int i = Math.abs(diametro); i > 0; i /= 10) {
            contador++;
        }

        if (contador == 6) {//tiene 6 cifras
            this.diametro = diametro;

        } else {

            throw new ExcepcionCuerpoCeleste("CUERPO CELESTE EXCEPTION: diametro no tiene los 6 digitos");
        }

    }

    //getter 
    public int getCodigoCuerpo() {
        return codigoCuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public int getDiametro() {
        return diametro;
    }

    
     
    //toString Sobreescrito
    @Override
    public String toString() {
        return "CuerpoCeleste{" + "codigoCuerpo=" + codigoCuerpo + ", nombre=" + nombre + ", tipoObjeto=" + tipoObjeto + ", diametro=" + diametro + '}';
    }

}//fin clase
