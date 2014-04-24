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

    int EMPTY ;
    int BSIZE ; //board size.
    int HEXSIZE ;	//hex size in pixels
    int BORDERS ;
    int SCRSIZE ; //screen size (vertical dimension).

    int[][] board;
    Unidad[] unidades;
    private File archivo;
    private FileReader fr;
    private BufferedReader br;

    public Nivel(int i){
        
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
        archivo = new File (new File ("").getAbsolutePath ()+"/src/javagame/niveles/"+1+".txt");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         int contador=0;
         while((linea=br.readLine())!=null){
                System.out.println(linea);
         contador++;
         if (contador==1){this.EMPTY = Integer.parseInt(linea);}
         if (contador==2){this.BSIZE =  Integer.parseInt(linea);}
         if (contador==3){this.HEXSIZE =  Integer.parseInt(linea);}
         if (contador==4){this.BORDERS =  Integer.parseInt(linea);}
         if (contador==5){
             this.board=new int[this.BSIZE][this.BSIZE];
         for (int j=0;j<BSIZE;j++){
             String[] partes=linea.split(",");
              for (int k=0;k<BSIZE;k++){
            board[j][k]= new Integer(partes[k]).intValue();
                    }
              linea=br.readLine();
              
         }
      
         }
         }
            System.out.println("Nivel leido correctamente");
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    this.SCRSIZE = this.HEXSIZE * (this.BSIZE + 1) + this.BORDERS*3;
    }
}
