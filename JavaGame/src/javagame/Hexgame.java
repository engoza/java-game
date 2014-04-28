package javagame;

import java.awt.*;
import java.awt.event.*; 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
 
/**********************************
  This is the main class of a Java program to play a game based on hexagonal tiles.
  The mechanism of handling hexes is in the file hexmech.java.
 
  Written by: M.H.
  Date: December 2012
 
 ***********************************/
 
public class Hexgame
{

  private Hexgame() {
		initGame();
		createAndShowGUI();
	}
 
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new Hexgame();
				}
				});
	}
 
	//constants and global variables
        final static String NOMBRE=" ENGO GAME";
	final static Color COLOURBACK =  Color.WHITE;
	final static Color COLOURCELL =  Color.YELLOW;	
	final static Color COLOURGRID =  Color.BLACK;	
        final static Color SELECTED =  Color.BLUE;
	final static Color COLOURONE = new Color(255,255,255,200);
	final static Color COLOURONETXT = Color.BLUE;
	final static Color COLOURTWO = new Color(0,0,0,200);
	final static Color COLOURTWOTXT = new Color(255,100,255);
        final static Color[] COLORES= {Color.YELLOW,Color.GREEN,Color.BLUE, new Color(139,69,19)};
        static TexturePaint[] texturas=new TexturePaint[4];
        //parametros
        Nivel nivel;
        
 
	void initGame(){
 
            
        
 
                nivel=cargarNivel(1);
                
        BufferedImage arena = null;
        BufferedImage hierba = null;
        BufferedImage agua = null;
        BufferedImage madera = null;   
                
      try {
          arena = ImageIO.read(new File(new File("").getAbsolutePath() + "/src/javagame/imagenes/arena.jpg"));
            hierba = ImageIO.read(new File(new File("").getAbsolutePath() + "/src/javagame/imagenes/hierba.jpg"));
            agua = ImageIO.read(new File(new File("").getAbsolutePath() + "/src/javagame/imagenes/agua.jpg"));
            madera = ImageIO.read(new File(new File("").getAbsolutePath() + "/src/javagame/imagenes/madera.jpg"));
      } catch (IOException ex) {
          Logger.getLogger(Hexgame.class.getName()).log(Level.SEVERE, null, ex);
      }
          
            Hexgame.texturas[0] = new TexturePaint(arena, new Rectangle(0, 0, 90, 60));
            Hexgame.texturas[1]= new TexturePaint(hierba, new Rectangle(0, 0, 90, 60));
            Hexgame.texturas[2]= new TexturePaint(agua, new Rectangle(0, 0, 90, 60));
            Hexgame.texturas[3] = new TexturePaint(madera, new Rectangle(0, 0, 90, 60));
            
		Hexmech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.
 
		Hexmech.setHeight(nivel.HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
		Hexmech.setBorders(nivel.BORDERS);
        
                
	}
 
	private void createAndShowGUI()
	{
		DrawingPanel panel = new DrawingPanel();
 
		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame(NOMBRE);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		content.add(panel);
		//this.add(panel);  -- cannot be done in a static context
		//for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
		frame.setSize( (int)(nivel.SCRSIZE/1.23), nivel.SCRSIZE);
		frame.setResizable(false);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
                
                
	}

    private Nivel cargarNivel(int i) {
      
      Nivel nivel=new Nivel(i);
      return nivel;           
    }
 
 
	class DrawingPanel extends JPanel
	{		
		//mouse variables here
		//Point mPt = new Point(0,0);
 
		public DrawingPanel()
		{	
			setBackground(COLOURBACK);
 
			MyMouseListener ml = new MyMouseListener();            
			addMouseListener(ml);
		}
 
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			super.paintComponent(g2);
			//draw grid
			/*for (int i=0;i<nivel.BSIZE;i++) {
				for (int j=0;j<nivel.BSIZE;j++) {
					Hexmech.drawHex(i,j,g2);
				}
			}*/
			//fill in hexes
			for (int i=0;i<nivel.BSIZE;i++) {
				for (int j=0;j<nivel.BSIZE;j++) {					
					//if (board[i][j] < 0) hexmech.fillHex(i,j,COLOURONE,-board[i][j],g2);
					//if (board[i][j] > 0) hexmech.fillHex(i,j,COLOURTWO, board[i][j],g2);
					Hexmech.fillHex(i,j,nivel.board[i][j].tipoCasilla,nivel.board[i][j].seleccionada,g2);
				}
			}
 
			//g.setColor(Color.RED);
			//g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
		}
 
		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel 
			public void mouseClicked(MouseEvent e) { 
				int x = e.getX(); 
				int y = e.getY(); 
				//mPt.x = x;
				//mPt.y = y;
				Point p = new Point( Hexmech.pxtoHex(e.getX(),e.getY()) );
				if (p.x < 0 || p.y < 0 || p.x >= nivel.BSIZE || p.y >= nivel.BSIZE) return;
 
				//DEBUG: colour in the hex which is supposedly the one clicked on
				//clear the whole screen first.
				/* for (int i=0;i<BSIZE;i++) {
					for (int j=0;j<BSIZE;j++) {
						board[i][j]=EMPTY;
					}
				} */
 
				//What do you want to do when a hexagon is clicked?
                                nivel.board[nivel.seleccionada_x][nivel.seleccionada_y].seleccionada=false;
                                nivel.seleccionada_x=p.x;
                                nivel.seleccionada_y=p.y;
				nivel.board[p.x][p.y].seleccionada=true;
				repaint();
			}		 
		} //end of MyMouseListener class 
	} // end of DrawingPanel class
}
