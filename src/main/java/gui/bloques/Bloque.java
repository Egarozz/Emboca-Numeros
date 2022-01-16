package gui.bloques;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Bloque {
    
	public static final int CUADRADO = -1;
    public static final int VACIO = -2;
    public static final int NUMERO0 = 0;
    public static final int NUMERO1 = 1;
    public static final int NUMERO2 = 2;
    public static final int NUMERO3 = 3;
    public static final int NUMERO4 = 4;
    public static final int NUMERO5 = 5;
    public static final int NUMERO6 = 6;
    public static final int NUMERO7 = 7;
    public static final int NUMERO8 = 8;
    public static final int NUMERO9 = 9;
	
	protected int posx;
    protected int posy;
    private int width;
    
    
    private boolean hover = false;
    private boolean bloqueResuelto = false;
    private boolean dato = false;
    
    private int actualMode = -2;
    private int mode = -2;
    
    
    
    public Bloque(int posx, int posy, int width) {
    	this.posx = posx;
    	this.posy = posy;
    	this.width = width;
    }
    public void setDato(boolean dato) {
    	this.dato = dato;
    }
    public boolean isDato() {return dato;}
    public int getActualMode() {return actualMode;}
    
	public void setHover(boolean hover) {
		this.hover = hover;
	}
	
	public void setHoverMode(int mode) {
		this.mode = mode;
		
	}
	
	public void setResuelto(boolean resuelto) {
		this.bloqueResuelto = resuelto;
	}
	public void setActualMode(int mode) {
		this.actualMode = mode;
	}
	
	public void paint(Graphics g) {
		if(hover) {
		  switch(mode) {
		  
		  case CUADRADO: {
			  g.setColor(Color.blue);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  break;
		  }
		  case VACIO: {
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  break;
		  }
		  case NUMERO0: {
			  
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("0", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO1: {
			  
			  
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("1", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO2: {
			 
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("2", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO3: {
			 
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("3", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO4: {
			  
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("4", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO5: {
			 
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("5", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO6: {
			  
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("6", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO7: {
			  
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("7", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO8: {
			 
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("8", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  case NUMERO9: {
			  
			  g.setColor(Color.white);  
			  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
			  g.setColor(Color.blue);
			  g.setFont(new Font("Arial",Font.ITALIC,15));
			  g.drawString("9", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
			  break;
		  }
		  
		  
		  
		  
		  }
		  	
		}else {
			
			switch(actualMode) {
			  
			  case CUADRADO: {
				  g.setColor(Color.blue);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  break;
			  }
			  case VACIO: {
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  break;
			  }
			  case NUMERO0: {
				  
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
					 g.setColor(Color.blue); 
					 g.setFont(new Font("Arial",Font.ITALIC,15));
				  }else {
					  g.setColor(Color.black); 
					  g.setFont(new Font("Arial",Font.BOLD,15));
				  }
				  
				  
				  g.drawString("0", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO1: {
				  
				  
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue); 
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				 
				  g.drawString("1", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO2: {
				 
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue); 
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				  
				  g.drawString("2", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO3: {
				 
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue); 
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				  
				  g.drawString("3", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO4: {
				  
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue);  
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				  
				  g.drawString("4", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO5: {
				 
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue); 
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				  
				  g.drawString("5", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO6: {
				  
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue);  
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				 
				  g.drawString("6", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO7: {
				  
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue); 
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black);
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				  
				  g.drawString("7", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO8: {
				 
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue); 
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				  
				  g.drawString("8", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			  case NUMERO9: {
				  
				  g.setColor(Color.white);  
				  g.fillRect(posx*this.width, posy*this.width, this.width, this.width);
				  if(!bloqueResuelto) {
						 g.setColor(Color.blue); 
						 g.setFont(new Font("Arial",Font.ITALIC,15));
					  }else {
						  g.setColor(Color.black); 
						  g.setFont(new Font("Arial",Font.BOLD,15));
					  }
				  
				  g.drawString("9", posx*this.width + width/2 - 2, posy*this.width + width/2 + 5);
				  break;
			  }
			}  
		  }	  
			  
			  
			  
			
			
		
		
		
		g.setColor(Color.black);
		g.drawRect(posx*this.width, posy*this.width, this.width, this.width);
	}
	
	public int getX() {
		return posx*width;
	}
	public int getPosX() {return posx;}
	public int getPosY() {return posy;}
	public int getY() {
		return posy*width;
	}
}
