package main.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.gui.bloques.Bloque;
import main.source.Table;


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
		añadirBloques();
		
		
		bloques.get(0).setActualMode(-1);
		bloques.get(5).setActualMode(-1);
		bloques.get(7).setActualMode(-1);
		bloques.get(8).setActualMode(-1);
		bloques.get(9).setActualMode(-1);
		bloques.get(15).setActualMode(-1);
		bloques.get(16).setActualMode(-1);
		
		bloques.get(21).setActualMode(-1);
		bloques.get(24).setActualMode(2);
		bloques.get(25).setActualMode(-1);
		bloques.get(28).setActualMode(-1);
		bloques.get(30).setActualMode(-1);
		bloques.get(31).setActualMode(1);
		bloques.get(32).setActualMode(7);
		bloques.get(33).setActualMode(-1);

		bloques.get(37).setActualMode(-1);
		bloques.get(41).setActualMode(3);
		bloques.get(42).setActualMode(-1);
		bloques.get(43).setActualMode(-1);
		bloques.get(46).setActualMode(-1);
		
		bloques.get(56).setActualMode(-1);
		bloques.get(58).setActualMode(9);
		bloques.get(62).setActualMode(-1);
		bloques.get(63).setActualMode(-1);
		bloques.get(65).setActualMode(-1);
		bloques.get(66).setActualMode(-1);
		
		bloques.get(68).setActualMode(-1);
		bloques.get(69).setActualMode(-1);
		bloques.get(70).setActualMode(-1);
		bloques.get(75).setActualMode(-1);
		bloques.get(78).setActualMode(-1);
		bloques.get(80).setActualMode(-1);
		
		bloques.get(89).setActualMode(-1);
		bloques.get(91).setActualMode(-1);
		bloques.get(94).setActualMode(-1);
		bloques.get(99).setActualMode(-1);
		bloques.get(100).setActualMode(-1);
		bloques.get(101).setActualMode(-1);
		
		bloques.get(103).setActualMode(-1);
		bloques.get(104).setActualMode(-1);
		bloques.get(106).setActualMode(-1);
		bloques.get(107).setActualMode(-1);
		bloques.get(113).setActualMode(-1);
		
		bloques.get(123).setActualMode(-1);
		bloques.get(126).setActualMode(-1);
		bloques.get(127).setActualMode(-1);
		bloques.get(132).setActualMode(-1);
		
		bloques.get(136).setActualMode(-1);
		bloques.get(139).setActualMode(-1);
		bloques.get(141).setActualMode(-1);
		bloques.get(144).setActualMode(-1);
		bloques.get(148).setActualMode(-1);
		
		bloques.get(153).setActualMode(-1);
		bloques.get(154).setActualMode(-1);
		bloques.get(155).setActualMode(8);
		bloques.get(156).setActualMode(0);
		bloques.get(157).setActualMode(7);
		bloques.get(158).setActualMode(8);
		bloques.get(159).setActualMode(4);
		bloques.get(160).setActualMode(-1);
		bloques.get(161).setActualMode(-1);
		bloques.get(162).setActualMode(-1);
		bloques.get(164).setActualMode(-1);
		bloques.get(169).setActualMode(-1);
		
		
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
	
	public void añadirBloques() {
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
		añadirBloques();
		repaint();
	}
	public void setColumna(int columna) {
		this.columna = columna;
		findWidthCuadrado();
		bloques.clear();
		añadirBloques();
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
