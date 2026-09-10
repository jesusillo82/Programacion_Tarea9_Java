/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.cuerpoceleste.clase;

import ejercicio2.cuerpoceleste.fichero.OperacionesConFichero;
import ejercicio2.cuerpoceleste.interfaz.InterfazGui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author jesus Bernabe Imedio Perea
 * @date 02/04/2023
 * @description Clase Lanzador de la practica 6 que nos permite realizar
 * operaciones con la clase CuerpoCeleste.
 * Tema 9 Ejericio 2 Interfaces
 */
public class Lanzador {

    //creo arrayList, la hago publica para que pueda usarla la Interfaz GuiTabla
    public static List<CuerpoCeleste> cuerpos = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            // accedo a InterfazGUI que e smi ventana principal
            InterfazGui inter = new InterfazGui();
            inter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            inter.setVisible(true);

       
        } catch (Exception e) {
            System.err.println("EXCEPTION: Error de entrada de datos: " + e.getMessage());
        }

    }

    /**
     * metodo que crea cuerpo celeste y lo añade al fichero
     *
     * @throws java.lang.Exception //modifico el metodo para recibir los datos
     * de la INTERFAZ (por parametros) y realizar la operativa desde LANZADOR
     */
    public static void aniadirCuerpo(short cod, String nom, String tip, int diame) {

        //variables
        short codigo = cod;
        String nombre = nom;
        String tipo = tip;
        int diametro = diame;

        //abrir si existe y sino crear fichero
        OperacionesConFichero.abrir();

        try {

            
            for (int i = 0; i < cuerpos.size(); i++) {

                if (cuerpos.get(i).getCodigoCuerpo() == codigo) {
                    throw new Exception("El cuerpo celeste ya existe en el array");
                }

            }

            //si array no existe la creo
            if (cuerpos.isEmpty()) {
                cuerpos = new ArrayList<CuerpoCeleste>();
            }

            //añado al arrayList el cuerpoCeleste
            cuerpos.add(new CuerpoCeleste(codigo, nombre, tipo, diametro));

            //método escribirArchivo se guarda el el Array con todos los cuerpos celestes serializados en el fichero.
            OperacionesConFichero.escribirArchivo();

            //muestro mensaje de creación correcto 
            JOptionPane.showMessageDialog(null, "El Cuerpo celeste número " + cuerpos.size() + " se ha añadido correctamente");

        } catch (ExcepcionCuerpoCeleste ex) {
            JOptionPane.showMessageDialog(null, ex);

        } catch (IOException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    
    
    
    
    /**
     * ***************
     * Función que nos permite buscar un registro concreto buscándolo por su
     * codigo
     *
     */
    public static CuerpoCeleste buscarCuerpoCodigo(short ni) {

        CuerpoCeleste cuerpo = null;
        try {
            boolean encontrado;
            OperacionesConFichero.abrir();//abrir() carga en el ArryList cuerpos, todos los cuerpos celestes del fichero

            //int i = 0;
            encontrado = false;
            for (CuerpoCeleste p : cuerpos) {
                if (p.getCodigoCuerpo() == (ni)) {
                    encontrado = true;
                    //System.out.println("Registro nº" + i + " - " + p.toString());

                    //prueba
                    cuerpo = p;

                }
                //i++;
            }
            if (!encontrado) {
                throw new Exception("REGISTRO NO ENCONTRADO");
            }

            
        } catch (Exception ex) {
            //System.err.println("EXCEPTION: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex);
        }
        return cuerpo;

    }

    /**
     * funcion que nos permite buscar un cuerpo celeste por su tipo
     * @param tipo
     * @return
     */
    public static String buscarCuerpoTipo(String tipo) {

        String concate = "";
        try {

            boolean encontrado;
            OperacionesConFichero.abrir();//abrir() carga en el ArryList cuerpos, todos los cuerpos celestes de fichero.

            int i = 0;//posicionamiento elementos de arrayList tipoCuerpoCel

            encontrado = false;

            for (int j = 0; j < cuerpos.size(); j++) {
                if (cuerpos.get(j).getTipoObjeto().equals(tipo)) {

                    //concateno los objetos
                    concate = concate + "\n" + cuerpos.get(j).toString() + "\n";

                    //tipoCuerpoCel.set(i, cuerpos.get(j));
                    encontrado = true;

                }
                i++;
            }
            if (!encontrado) {
                throw new Exception("REGISTRO NO ENCONTRADO");

            }

           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            //System.err.println("EXCEPTION: " + ex.getMessage());
        }

        return concate;

    }

    /**
     * **************
     * Función similar a la anterior pero que en lugar de limitarse a mostrarnos
     * el resultado de la búsqueda, nos permite decidir si deseamos eliminar el
     * registro encontrado
     */
    //MODIFICO EL METODO AÑADIENDOLE PARAMETRO
    
    
    public static void eliminarCuerpo(short codigoelim) {
        try {

          
            OperacionesConFichero.abrir();
            int i = 0;
            boolean encontrado = false;
            for (CuerpoCeleste p : cuerpos) {
                
                if (p.getCodigoCuerpo() == (codigoelim)) {
                    encontrado = true;

                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminarlo?", "¡Cuidado!", JOptionPane.YES_NO_OPTION);

                    //recojemos datos del dialigo y comparamos
                    if (respuesta == JOptionPane.NO_OPTION) {

                    } else {
                        cuerpos.remove(i);//se elimina del array y posteriormente se guarda en el fichero ya sin ese cliente.
                        OperacionesConFichero.escribirArchivo();

                        //registro eliminado
                        throw new Exception(" EL REGISTRO HA SIDO ELIMINADO");
                    }
                }
                i++;
            }
            if (!encontrado) {
                // System.err.println("REGISTRO NO ENCONTRADO");
                throw new Exception("REGISTRO NO ENCONTRADO");
            }
        } catch (Exception ex) {
            //System.err.println("EXCEPTION: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}//fin clase lanzador
