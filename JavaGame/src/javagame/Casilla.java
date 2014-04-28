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
    
    protected int tipoCasilla;
    protected boolean seleccionada;
    protected Unidad unidad;
    
    public Casilla(){}
    
    public Casilla(int tipo){
        this.tipoCasilla=tipo;
        this.seleccionada=false;
    }
}
