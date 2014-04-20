/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.awt.*;
import javax.swing.ImageIcon;
/**
 *
 * @author whiteskull
 */
public class Sprite{
    private int x,y; //coordenadas
    private boolean visible; // si esta visible o no
    private String sprite; // el nombre de la imagen
 
    public Sprite() //Constructor
    {
       visible=true;
       x=y=0;
    }
 
    public boolean isVisble()
    {
        return visible;
    }
 
    public void setVisible(boolean estado)
    {
        visible=estado;
    }
 
    public int getX() // Obtenemos la coordenada horizontal actual del Sprite
    {
        return x;
    }
 
    public void setX(int valor) //Asignamos la coordenada horizontal actual del Sprite
    {
        x=valor;
    }
 
    public int getY() // Obtenemos la coordenada vertical actual del Sprite
    {
        return y;
    }
 
    public void setY(int valor) // Asignamos la coordenada vertical actual del Sprite
    {
        y=valor;
    }
 
    public int getWidth() // Ancho del Sprite
    {
        return new ImageIcon(getClass().getResource(sprite)).getImage().getWidth(null);
    }
 
    public int getHeight() // Alto del Sprite
    {
        return new ImageIcon(getClass().getResource(sprite)).getImage().getHeight(null);
    }
 
    public void setSprite(String nombre) // Asignamos el fichero imagen al Sprite
    {
        sprite=nombre;
    }
 
    public String getSprite() // Nos devuelve el fichero imagen del Sprite
    {
        return sprite;
    }
 
    public void putSprite(Graphics grafico,int coordenadaHorizontal,int coordenadaVertical) // Pegamos el Sprite en la pantalla
    {
        x=coordenadaHorizontal;
        y=coordenadaVertical;
        if (visible) grafico.drawImage(new ImageIcon(getClass().getResource(sprite)).getImage(), x, y, null);
    }
 
}

