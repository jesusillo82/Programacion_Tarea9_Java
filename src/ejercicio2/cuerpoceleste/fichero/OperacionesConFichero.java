/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.cuerpoceleste.fichero;

import ejercicio2.cuerpoceleste.clase.CuerpoCeleste;
import static ejercicio2.cuerpoceleste.clase.Lanzador.cuerpos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus Bernabe Imedio Perea
 * @date 10/04/2023
 * @description Clase que tiene distintos métodos para realizar operaciones con
 * ficheros Tema 9 Ejercicio 2 Interfaz gráfica
 */
public class OperacionesConFichero {

    //creo fichero
    private static File f = new File("sistemasolar.dat");

    /**
     * **********************
     * Función que nos escribe el ArrayList en el fichero de disco. Es la manera
     * de guardar los datos serializados ya que la clase Cuerpo Celeste lo está
     */
    public static void escribirArchivo() {
        try {
            if (!f.exists()) {//si el fichero no existe lo crea
                f = new File("sistemasolar.dat");
            }
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cuerpos);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex, "Exception: Escribir archivo", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * *********************
     * Función que nos crea el fichero (válido para cuando se comprueba que no
     * existe)
     */
    public static void crearArchivo() {
        try {
            f.createNewFile();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex, "Exception: Crear archivo", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * ***************
     * Función que nos abre el fichero de datos para cagar su contenido en el
     * array 'cuerpos'. Podrías trabajar directamente con el fichero pero así es
     * más cómodo. Previamente comprueba si el fichero existe, y si es así carga
     * su contenido en el ArrayList y cierra el fichero. Si por cualquier motivo
     * no se puede leer del disco (está creado pero no contiene datos) nos avisa
     * que el fichero está vacío.
     */
    public static void abrir() {
        try {
            if (!f.exists()) {//si el fichero no existe lo creo
                crearArchivo();
            } else {
                if (f.canRead()) {//si se puede leer
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    cuerpos = (ArrayList<CuerpoCeleste>) ois.readObject();
                    ois.close();
                    fis.close();
                } else {

                    throw new Exception("El fichero no contiene datos, añadalos");
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Exception: Abrir archivo:", JOptionPane.WARNING_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * ****************
     * Función que nos elimina el fichero de datos del disco
     */
    public static void eliminarFichero() {

        boolean borrado;
        try {
            borrado = f.delete();// devuelve true si el archivo se elimino, false si no lo hizo o no existe
            if (borrado) {

                cuerpos.clear();//elimino cuerpos matriz
                throw new Exception("Fichero de datos eliminado");

            } else {
                throw new Exception("No existe el fichero, añada un cuerpo celeste y será creado");
                //System.err.println("No ha sido posible eliminar el fichero");
            }

        } catch (FileNotFoundException fnf) {

            JOptionPane.showMessageDialog(null, "El fichero no existe", "Exception", JOptionPane.WARNING_MESSAGE);
            //System.err.println("FNF EXCEPTION: Fichero inexistente: " + fnf.getMessage());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fichero no ha podido ser eliminado", "Exception", JOptionPane.WARNING_MESSAGE);
            //System.err.println("IO EXCEPTION: eliminar fichero: " + e.getMessage());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Exception", JOptionPane.WARNING_MESSAGE);
            //System.err.println("EXCEPTION: eliminar fichero: " + ex.getMessage());
        }
    }

    /**
     * ***************
     * Metodo que he modificado completamente y usare para determinar si existe
     * el fichero y en caso afirmativo abrirlo puesto que me es necesario que la
     * GuiTable abra antes el fichero y cargue el array para poder mostrarmelo
     */
    public static void listarCuerpo() {

        //lo llamamos desde la GuiTabla para que comprueba si existe el fichero y cargue el array
        try {

            if (!f.exists()) {
                //System.err.println("NO EXISTEN DATOS");
                throw new Exception("El fichero no existe. Añada un cuerpo celeste para crearlo");

            } else {
                abrir();//carga en el ArryList cuerpos, todos los cuerpos celestes del fichero.
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, e);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }

    }

}//fin clase
