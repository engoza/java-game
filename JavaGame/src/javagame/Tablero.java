/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.util.ArrayList;

/**
 *
 * @author engoza
 */
public class Tablero {
    
    protected int anchuraCasilla;
    protected int ancho;
    protected int alto;
    public ArrayList<Casilla> tablero;
    protected boolean debug=false;
    
    public Tablero(int ancho, int alto){
    this.ancho=ancho;
    this.alto=alto;
    tablero= new ArrayList();
    int i;
    for (i=1;i<=alto*ancho;i++){
        int x=i%ancho; if (x==0) x=ancho;
        int y=1+i/ancho; if (i%ancho==0) y=y-1;
    Casilla casilla=new Casilla(x,y,1);
    if (debug) {System.out.println("index "+ i +" x=" + x + " y=" + y );}
    tablero.add(i-1, casilla);
    }
    }

       public int getAnchuraCasilla() {
        return anchuraCasilla;
    }

    public void setAnchuraCasilla(int anchuraCasilla) {
        this.anchuraCasilla = anchuraCasilla;
    }
    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public ArrayList<Casilla> getTablero() {
        return tablero;
    }

    public void dibujarTablero(){
    }
    
}
