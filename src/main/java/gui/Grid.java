package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import gui.bloques.Bloque;
import source.Table;


public class Grid extends JPanel{
    
	private int widthCuadrado;
	private int fila;
	private int columna;
	private List<Bloque> bloques;
	int posx = -1;
	int posy = -1;
	int mouseMode = Bloque.VACIO;
	
	public boolean showing = false;
	public boolean fueraPanel = false;
	
	public int PANEL_WIDTH;
	private List<Bloque> tableroInicial;
	public Grid() {
		PANEL_WIDTH = this.getWidth();
		bloques = new ArrayList<>();
		tableroInicial = new ArrayList<>();
		
		setBounds(10,10,601,601);
		
		setVisible(true);
		fila = 10;
		columna = 17;
		findWidthCuadrado();
		anadirBloques();
		
		
		
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				fueraPanel = false;	 
					
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				fueraPanel = true;
				for(Bloque b: bloques) {
					  b.setHover(false);
					  b.setHoverMode(Bloque.VACIO);
					  repaint();
					  continue;
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			  if(!showing) {
				for(Bloque b: bloques) {
					  if(arg0.getX() > b.getX() && arg0.getX()< b.getX()+widthCuadrado) {
						  if(arg0.getY() > b.getY() && arg0.getY()< b.getY()+widthCuadrado) {
							  
							  b.setActualMode(mouseMode);
							  if(b.getActualMode()!=Bloque.VACIO) {
							  b.setDato(true);
							  }else {
								  b.setDato(false);	  
							  }
							  repaint();
							  continue;
						  } 
					  }
				} 
			 }
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
		});
		
		this.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
			}	
			

			@Override
			public void mouseMoved(MouseEvent arg0) {
			if(!fueraPanel) { 
			 if(!showing) {	
				for(Bloque b: bloques) {
				 
				  if(arg0.getX() > b.getX() && arg0.getX()< b.getX()+widthCuadrado) {
					  if(arg0.getY() > b.getY() && arg0.getY()< b.getY()+widthCuadrado) {
						  b.setHover(true);
						  b.setHoverMode(mouseMode);
						  repaint();
						  continue;
					  } 
				  }
				 b.setHover(false);
				 repaint();
				 
				
			    }
			  }
			}	  
			  
			}
		});	
		
		
		
	}
	public void setBloqueActualMode(int bloque, int mode) {
		bloques.get(bloque).setActualMode(mode);
	}
	public List<Bloque> getBloques(){return bloques;}
	public void showResults(Table tablero) {
		  
	 
	   
	  
    volverNormal();
		   
    if(tablero != null) {   
		for(Bloque b: bloques) {
		  if(b.getActualMode() == -2 && !b.isDato()) {
			 b.setActualMode(tablero.getValueAtPoint(b.getPosY(), b.getPosX())); 
			 b.setResuelto(true);
			  
		  }   
		}   
      }	  
		 repaint();  
	    
	   
	}
	public void finalizarEdicion() {
		tableroInicial.clear();
		   for(Bloque b: bloques) {
			  Bloque bloque = new Bloque(b.getPosX(),b.getPosY(),this.widthCuadrado);
			  bloque.setActualMode(b.getActualMode());
			  bloque.setDato(b.isDato());
			  tableroInicial.add(bloque);
		   }   
		   
	}
	public void volverNormal() {
		bloques.clear();
		for(Bloque b: tableroInicial) {
	      Bloque bloque = new Bloque(b.getPosX(),b.getPosY(),widthCuadrado);
		  
		  bloque.setActualMode(b.getActualMode());
		  bloque.setDato(b.isDato());
		  bloques.add(bloque);
		}
		
		repaint();
	}
	public int[][] getTableValues() {
		int[][] values = new int[fila][columna];
		
		for(Bloque b: bloques) {
		  values[b.getPosY()][b.getPosX()]	= b.getActualMode();
		}
		
		
		return values;
	}
	
	public void anadirBloques() {
		for(int i = 0; i < fila; i++) {
			   for(int j = 0; j < columna; j++) {
				   
				 Bloque bloque = new Bloque(j,i,widthCuadrado);
				 bloques.add(bloque);
				  
	       }
		}
	}
	
	public int getFilas() {return fila;}
	public int getColumnas() {return columna;}
	
	public int getWidthCuadrado() {return widthCuadrado;}
	
	public void setFila(int fila) {
		this.fila = fila;
		findWidthCuadrado();
		bloques.clear();
		anadirBloques();
		repaint();
	}
	public void setColumna(int columna) {
		this.columna = columna;
		findWidthCuadrado();
		bloques.clear();
		anadirBloques();
		repaint();
	}
	
	public void paintGrid(Graphics g) {
		
	  for(Bloque b: bloques) {
		  b.paint(g);
	  }
		
		
		
	}
	
	public void findWidthCuadrado() {
		
		if(fila==columna) {
	     this.widthCuadrado = Math.max(600/fila, 600/columna);
		}else if(fila > columna) {
		 this.widthCuadrado = 600/fila;	
		}else {
		 this.widthCuadrado = 600/columna;
		}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGrid(g);
		
	}
}
