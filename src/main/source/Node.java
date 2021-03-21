package main.source;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
   
  private int numero;
  private int tipoAlineamiento;
  private Node nodeAnterior;
  private Node nodeSiguiente;
  private Tablero tablero;
  private Table tableroNuevo;
  private List<Integer> numeros;
  private int puntaje;
  
  private boolean visited = false;
  //ALINEAMIENTO VERTICAL = 0;
  //ALINEAMIENTO HORIZONTAL = 1;
  
  public Node(Integer numero, int tipoAlineamiento, Node nodeAnterior, Tablero tablero, List<Integer> numeros, int puntaje) {
	  this.numero = numero;
	  this.tipoAlineamiento = tipoAlineamiento;
	  this.nodeAnterior = nodeAnterior;
	  this.tablero = tablero;
	  this.nodeSiguiente = null;
	  this.numeros = numeros;
	  this.puntaje = puntaje;
  }
  public Node(Integer numero, Node nodeAnterior, Table tablero, List<Integer> numeros, int puntaje) {
	  this.numero = numero;
	  this.nodeAnterior = nodeAnterior;
	  this.tableroNuevo = tablero;
	  this.nodeSiguiente = null;
	  this.numeros = numeros;
	  this.puntaje = this.getTableroNuevo().getErroresEnTablero();
  }
  
  public int getPuntaje() {return puntaje;}
  public Tablero getTablero() {return tablero;}
  public Table getTableroNuevo() {return tableroNuevo;}
public int getNumero() {
	  return numero;
  }
public boolean isVisited() {return visited;}
public void setVisited(boolean visited) {this.visited = visited;}

  public int tipoAlineamiento() {
	  return tipoAlineamiento;
  }
  public Node getNodeAnterior() {
	  return nodeAnterior;
  }
  public boolean isSolucion() {
	  if(numeros.isEmpty()) return true;
	  
	  return false;
  }
  
  public List<Node> getNuevoNextNodes(){return this.tableroNuevo.getNextNodes(this);}
  
  public List<Node> getNextNodes(){
	List<Node> nextNodes = new ArrayList<>(); 
	int a = 0;
	  //encontrar espacios vacios
	  for(int i = 0; i < tablero.getFilas(); i++) {
		  for(int j = 0; j < tablero.getColumnas(); j++) {
			  
			  if(tablero.getTablero()[i][j]==-2) {
				  List<Node> tempNode = tablero.getNodeAt(this,i,j,numeros);
				  
				  if(tempNode.size()>0) {
					  a = 1;
				  }
				  return tempNode;
				  
			  }
			  
		  }
	  }
	  
	  return nextNodes;
  }

public void setPuntaje(int j) {
	this.puntaje = j;
}

@Override
public int compareTo(Node arg0) {
	return this.getTableroNuevo().getErroresEnTablero() - arg0.getTableroNuevo().getErroresEnTablero();
	
}
  
  
}
