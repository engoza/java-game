/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author engoza
 */
class Nivel {

    int EMPTY;
    int BSIZE; //board size.
    int HEXSIZE;	//hex size in pixels
    int BORDERS;
    int SCRSIZE; //screen size (vertical dimension).

    Casilla[][] board;
    Unidad[] unidades;
    private File archivo;
    private FileReader fr;
    private BufferedReader br;
    protected int num_unidades;
    protected int seleccionada_x;
    protected int seleccionada_y;
    

    public Nivel(int i) {

        try {
         // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(new File("").getAbsolutePath() + "/src/javagame/niveles/" + 1 + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            int contador = 0;

            this.EMPTY = Integer.parseInt(br.readLine());
            this.BSIZE = Integer.parseInt(br.readLine());
            this.HEXSIZE = Integer.parseInt(br.readLine());
            this.BORDERS = Integer.parseInt(br.readLine());
            this.board = new Casilla[this.BSIZE][this.BSIZE];
            //carga terreno
            for (int j = 0; j < BSIZE; j++) {
                String[] partes = br.readLine().split(",");
                for (int k = 0; k < BSIZE; k++) {
                    board[j][k] = new Casilla(new Integer(partes[k]).intValue());
                }
            }

            //carga unidades
            this.num_unidades = Integer.parseInt(br.readLine());
            unidades=new Unidad[num_unidades];
            for (int j = 0; j < num_unidades; j++) {
                String[] partes = br.readLine().split(",");
                this.unidades[j] = new Unidad(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
            }

        } catch (IOException ex) {
            Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("Nivel leido correctamente");
        this.SCRSIZE = this.HEXSIZE * (this.BSIZE + 1) + this.BORDERS * 3;
    }
}
