/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

/**
 *
 * @author engoza
 */
class Casilla {
    
    protected int coordenadaX;
    protected int coordenadaY;
    protected int tipoCasilla;
    protected Unidad unidad;
    
    public Casilla(){}
    
    public Casilla(int x, int y, int tipo){
        this.coordenadaX=x;
        this.coordenadaY=y;
        this.tipoCasilla=tipo;
    }
}
