package main.source;

public class Espacio implements Comparable<Espacio>{
  private int fila;
  private int columna;
  private int numerosDisponibles;
  
  
  public Espacio(int fila, int columna, int numerosDisponibles) {
	this.fila = fila;
	this.columna = columna;
	this.numerosDisponibles = numerosDisponibles;
  }
  
  public int getFila() {return fila;}
  public int getColumna() {return columna;}
  public int getNumerosDisponibles() {return numerosDisponibles;}

@Override
public int compareTo(Espacio o) {
	return this.getNumerosDisponibles()-o.getNumerosDisponibles();
}
  
  
  
  
}
