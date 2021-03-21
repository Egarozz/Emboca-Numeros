package main.source;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
   
  private String numero;
  private int tipoAlineamiento;
  private Node nodeAnterior;
  private Node nodeSiguiente;
    private Table tableroNuevo;
  private List<String> numeros;
  private int puntaje;
  
  private boolean visited = false;
  //ALINEAMIENTO VERTICAL = 0;
  //ALINEAMIENTO HORIZONTAL = 1;
  
  
  public Node(String numero, Node nodeAnterior, Table tablero, List<String> numeros, int puntaje) {
	  this.numero = numero;
	  this.nodeAnterior = nodeAnterior;
	  this.tableroNuevo = tablero;
	  this.nodeSiguiente = null;
	  this.numeros = numeros;
	  this.puntaje = this.getTableroNuevo().getErroresEnTablero();
  }
  
  public int getPuntaje() {return puntaje;}
  
  public Table getTableroNuevo() {return tableroNuevo;}
public String getNumero() {
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
  
  

public void setPuntaje(int j) {
	this.puntaje = j;
}

@Override
public int compareTo(Node arg0) {
	return this.getTableroNuevo().getErroresEnTablero() - arg0.getTableroNuevo().getErroresEnTablero();
	
}
  
  
}
