/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javagame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class Tablero extends Canvas{
            // TODO code application logic here
    private Frame ventana;
    private Sprite caracol, zombie;
    long tiempo=System.currentTimeMillis();
 
    public Tablero(){
        caracol=new Sprite();
        zombie=new Sprite();
 
        ventana=new Frame();
 
        ventana.setSize(550,500);
        ventana.add(this);
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
        });
 
        caracol.setSprite("/imagenes/caracol.png");
        zombie.setSprite("/imagenes/zombie.png");
        while(true)
        {         
            if (System.currentTimeMillis()-tiempo>25) { // actualizamos cada 25 milisegundos
 
                if (caracol.getX()>this.getWidth()) caracol.setX(0);
                else caracol.setX(caracol.getX()+1);
 
                dibuja(this.getGraphics());
                tiempo=System.currentTimeMillis();
            }
        }
    }
 
    public void dibuja(Graphics grafico)
    {
        // El Begin de OpenGL o DirectX
        BufferedImage pantalla=new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_RGB );
 
        caracol.putSprite(pantalla.getGraphics(), caracol.getX(), caracol.getY());
        zombie.putSprite(pantalla.getGraphics(), 110, 100);
 
        // El ENd
        grafico.drawImage(pantalla, 0, 0, this);
    }

}
