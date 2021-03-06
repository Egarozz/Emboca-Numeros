package source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Table {
	private int columnas;
	private int filas;
	private int[][] tablero;
	
	public static final int ALINEACION_VERTICAL = 0;
	public static final int ALINEACION_HORIZONTAL = 1;
	
	private List<String> numerosOriginales;
	private List<String> numerosDisponibles;
	
	private List<int[]> coordenadasEncerradas;
	
	public Table(int filas, int columnas, int[] tablero, List<String> numerosOriginales) {
		this.filas = filas;
		this.columnas = columnas;
		
		this.tablero = parseTablero(tablero);
		this.numerosOriginales = numerosOriginales;
		numerosDisponibles = cloneList(numerosOriginales);
		
		this.coordenadasEncerradas = getCoordenadasEncerrados();
		List<String> as = getNumerosEnTablero();
		this.numerosOriginales.addAll(getNumerosEnTablero());
		//numerosOriginales.add(80784);
		//numerosOriginales.add(239);
		//numerosOriginales.add(17);
	}
	public Table(int filas, int columnas, int[][] tablero, List<String> numerosOriginales) {
		this.filas = filas;
		this.columnas = columnas;
		
		this.tablero = tablero;
		this.numerosOriginales = numerosOriginales;
		numerosDisponibles = cloneList(numerosOriginales);
		
		this.coordenadasEncerradas = getCoordenadasEncerrados();
		
		this.numerosOriginales.addAll(getNumerosEnTablero());
	}
	public List<String> getNumerosEnTablero(){
		List<String> numerosVisitados = new ArrayList<>();
		
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
				
				if(tablero[fila][columna]==-1 || tablero[fila][columna]==-2) {
					continue;
				}
				
				String value = getValueAt(fila,columna,Table.ALINEACION_HORIZONTAL);
				if(value != null) {
					if(!numerosVisitados.contains(value)) {
						
						columna+=String.valueOf(value).length();
						numerosVisitados.add(value);
						continue;
					}
				}	
			}
	     }		
		for(int columna = 0; columna < columnas; columna++) {
			for(int fila = 0; fila < filas; fila++) {
				
				if(tablero[fila][columna]==-1 || tablero[fila][columna]==-2) {
					continue;
				}
				
				String value = getValueAt(fila,columna,Table.ALINEACION_VERTICAL);
				if(value != null) {
					if(!numerosVisitados.contains(value)) {
						
						fila+=String.valueOf(value).length();
						numerosVisitados.add(value);
						continue;
					}
				}	
			}
	     }			
			return numerosVisitados;		
				
		
	}
	public int getValueAtPoint(int fila, int columna) {
		return this.tablero[fila][columna];
	}
	public Table(int filas, int columnas, int[][] tablero, List<String>numerosOriginales, List<String>numerosDisponibles) {
		this.filas = filas;
		this.columnas = columnas;
		
		this.tablero = tablero;
		this.numerosOriginales = numerosOriginales;
		this.coordenadasEncerradas = getCoordenadasEncerrados();
	    this.numerosDisponibles = numerosDisponibles;
	    
	}
	public List<int[]> getCoordenadasEncerrados(){
		List<int[]> coordenadas = new ArrayList<>();
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
				if(isEncerrado(fila,columna)) {
					 
					List<String> valueHorizontal = getCifrasAt(fila,columna,Table.ALINEACION_HORIZONTAL);
					  if(valueHorizontal.size()==2) {
						  int[] coordenada = {fila,columna};
						  coordenadas.add(coordenada);
					  }
					
					  List<String> valueVertical = getCifrasAt(fila,columna,Table.ALINEACION_VERTICAL);
					   if(valueVertical.size() == 2) {
						   int[] coordenada = {fila,columna};
							coordenadas.add(coordenada);
					   }  
					   
				}
			}
		}
		return coordenadas;
	}			  
					  
					  
					  
					   
					   
						
						
					  
					
			
	private int[][] parseTablero(int[] tablero){
		int[][] parsedTablero = new int[filas][columnas];
		
		int columna = 0;	
		int fila = 0;
		
		for(int i = 0; i < tablero.length; i++) {
		  	if(columna < columnas) {
				parsedTablero[fila][columna] = tablero[i];
				columna++;
				continue;
			}
			
			columna=0;
			fila++;
			i--;
		}
		
		return parsedTablero;
	}	
	
	public boolean isSolved() {
		if(getErroresEnTablero() > 0) {
			return false;
		}
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
		        if(tablero[fila][columna] == -2) {
		        	return false;
		        }
			}
		}
		
		return true;
	}
	public int getErroresEnTablero() {
		List<String> numerosVisitados = new ArrayList<>();
		int errores = 0;
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
				
				if(tablero[fila][columna]==-1 || tablero[fila][columna]==-2) {
					continue;
				}
				
				String value = getValueAt(fila,columna,Table.ALINEACION_HORIZONTAL);
				if(value != null) {
					if(!numerosOriginales.contains(value)) {
						errores++;
						columna+=String.valueOf(value).length();
						continue;
					}
					if(!numerosVisitados.contains(value) && numerosOriginales.contains(value)) {
						numerosVisitados.add(value);
						columna+=String.valueOf(value).length();
						continue;
					}
					if(numerosVisitados.contains(value)) {
						errores++;
						columna+=String.valueOf(value).length();
						continue;
					}
					
					
				}
			}
		}
		
		for(int columna = 0; columna < columnas; columna++) {
			for(int fila = 0; fila < filas; fila++) {
				
				if(tablero[fila][columna]==-1 || tablero[fila][columna]==-2) {
					continue;
				}
				
				String value = getValueAt(fila,columna,Table.ALINEACION_VERTICAL);
				if(value != null) {
					if(!numerosOriginales.contains(value)) {
						errores++;
						fila+=String.valueOf(value).length();
						continue;
					}
					if(!numerosVisitados.contains(value) && numerosOriginales.contains(value)) {
						numerosVisitados.add(value);
						fila+=String.valueOf(value).length();
						continue;
					}
					if(numerosVisitados.contains(value) || !numerosOriginales.contains(value)) {
						fila+=String.valueOf(value).length();
						errores++;
					}
				}
			}
		}
		return errores;
	}
	public int[] getNextPositionFree(){
	  
	  List<Espacio> coordenadas = new ArrayList<>();
	  
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
		    if(tablero[fila][columna] == -2) {
			  List<String> posibleHorizontal = getPosiblesValues(fila,columna,Table.ALINEACION_HORIZONTAL);
			  List<String> posibleVertical = getPosiblesValues(fila,columna,Table.ALINEACION_VERTICAL);
			  int sizeHorizontal = posibleHorizontal.size();
			  int sizeVertical = posibleVertical.size();
			  int sizeTotal = sizeHorizontal + sizeVertical;
			 
				  if(sizeHorizontal == 1 && (sizeVertical > 1 || sizeHorizontal == -1)) {
					  
					  int[] coordenada = new int[2];
					  coordenada[0] = fila;
					  coordenada[1] = columna;
					  return coordenada;
				  }  
				  
				  if(sizeVertical == 1 && (sizeHorizontal > 1 || sizeHorizontal == -1)) {
					  
					  int[] coordenada = new int[2];
					  coordenada[0] = fila;
					  coordenada[1] = columna;
					  return coordenada;
				  }
				   Espacio espacio = new Espacio(fila,columna,sizeTotal);
				   coordenadas.add(espacio);
				  
				  
			  }
			}
		}
	  Collections.sort(coordenadas);
	  int[] coordenada = new int[2];
	  if(!coordenadas.isEmpty()) {
		  coordenada[0] = coordenadas.get(0).getFila();
		  coordenada[1] = coordenadas.get(0).getColumna();
	  }
	  return coordenada;
	}
	
	public int[] getPositionFirstNeighbor(int fila, int columna) {
	   int[] coordenada = {-3,-3}; 
		if(fila > 0) {
		   coordenada[0] = fila -1;
		   coordenada[1] = columna;
		   if(tablero[coordenada[0]][coordenada[1]] == -2) {
			   return coordenada;
		   }
	   }
		if(fila < filas-1) {
			coordenada[0]= fila+1;
			coordenada[1] = columna;
			if(tablero[coordenada[0]][coordenada[1]] == -2) {
				   return coordenada;
			   }
		}
		if(columna > 0) {
			coordenada[0] = fila;
			coordenada[1] = columna-1;
			if(tablero[coordenada[0]][coordenada[1]] == -2) {
				   return coordenada;
			   }
		}
		if(columna < columnas -1) {
			coordenada[0] = fila;
			coordenada[1] = columna +1;
			if(tablero[coordenada[0]][coordenada[1]] == -2) {
				   return coordenada;
			  }
		}
		coordenada[0]=-3;
		coordenada[1]=-3;
		
		return coordenada;
		
	}
	
	public int[][] cloneTableValues() {
		int[][] valuesTablero = new int[filas][columnas];
		
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
				valuesTablero[fila][columna] = tablero[fila][columna];
			}
		}
		
		return valuesTablero;
		
	}
	public void shiftPlaceAt(String numeroAPoner, int fila, int columna, int alineacion, String numeroACambiar, int[]coordenadaCambio) {
		setValuesAt(numeroAPoner,fila,columna,alineacion);
		
		//shiftPlace
		int sizeFila= getSize(coordenadaCambio[0],coordenadaCambio[1],Table.ALINEACION_HORIZONTAL);
		int sizeColumna = getSize(coordenadaCambio[0],coordenadaCambio[1],Table.ALINEACION_VERTICAL);
		
		if(sizeFila == 1) {
			setValuesAt(numeroACambiar,coordenadaCambio[0],coordenadaCambio[1],Table.ALINEACION_HORIZONTAL);
		}
		if(sizeColumna == 1) {
			setValuesAt(numeroACambiar,coordenadaCambio[0],coordenadaCambio[1],Table.ALINEACION_VERTICAL);
		}
	}
	public void setValuesAt(String numero, int fila, int columna, int alineacion) {
	  
		if(alineacion == Table.ALINEACION_HORIZONTAL) {
			int comienzo = getComienzo(fila,columna,alineacion);
			String[] cifrasNumero = String.valueOf(numero).split("(?!^)");
			int count = 0;
			while(comienzo < this.columnas) {
				if(tablero[fila][comienzo] == -1) {
					break;
				}
				tablero[fila][comienzo] = Integer.parseInt(cifrasNumero[count]);
				count++;
				comienzo++;
			}
		}
		
		if(alineacion == Table.ALINEACION_VERTICAL) {
			int comienzo = getComienzo(fila,columna,alineacion);
			String[] cifrasNumero = String.valueOf(numero).split("(?!^)");
			int count = 0;
			while(comienzo < filas) {
				if(tablero[comienzo][columna] == -1) {
					break;
				}
				tablero[comienzo][columna] = Integer.parseInt(cifrasNumero[count]);
				count++;
				comienzo++;
			}
		}
		
	}
	
	public List<Node> getFirstNodes(){
		return getNextNodes(null);
	}
	
	public List<Node> getNextNodes(Node nodeAnterior){
		List<Node> nextNodes = new ArrayList<>();
		
		int[] coordenadas = this.getNextPositionFree();
		int fila = coordenadas[0];
		int columna = coordenadas[1];
		
		
		
         List<String> posiblesValuesHorizontal = getPosiblesValues(fila,columna, Table.ALINEACION_HORIZONTAL);
         List<String> posiblesValuesVertical = getPosiblesValues(fila,columna, Table.ALINEACION_VERTICAL);	
		  
         if(posiblesValuesHorizontal.size()==1) {
        	 Table nextTableHorizontal = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posiblesValuesHorizontal.get(0)));
			 nextTableHorizontal.setValuesAt(posiblesValuesHorizontal.get(0), fila, columna, Table.ALINEACION_HORIZONTAL);
			 if(nextTableHorizontal.getErroresEnTablero()==0) {
					List<String> nextNumerosDisponibles = nextTableHorizontal.removeCloneList(posiblesValuesHorizontal.get(0));
					nextNodes.add(new Node(posiblesValuesHorizontal.get(0), nodeAnterior, nextTableHorizontal, nextNumerosDisponibles,posiblesValuesHorizontal.size() ));
			        return nextNodes;
			 }else{
					List<String> numerosIntercambiables = getPosiblesNumerosIntercambiables(posiblesValuesHorizontal.get(0));
				    for(String numeroIntercambiable: numerosIntercambiables) {
				    	Table tableCambiado = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posiblesValuesHorizontal.get(0)));
				        tableCambiado.shiftPlaceAt(numeroIntercambiable, fila, columna, Table.ALINEACION_HORIZONTAL, posiblesValuesHorizontal.get(0), getCoordenadaNumero(numeroIntercambiable));
				        if(tableCambiado.getErroresEnTablero()==0) {
				        	List<String> nextNumerosDisponibles = tableCambiado.removeCloneList(posiblesValuesHorizontal.get(0));
				        	nextNodes.add(new Node(numeroIntercambiable, nodeAnterior, tableCambiado, nextNumerosDisponibles,posiblesValuesHorizontal.size()));
				            return nextNodes;
				        }
				    }
				}
          }
         
         if(posiblesValuesVertical.size()==1) {
        	 Table nextTableVertical = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posiblesValuesVertical.get(0)));
			 nextTableVertical.setValuesAt(posiblesValuesVertical.get(0), fila, columna, Table.ALINEACION_VERTICAL);
			 if(nextTableVertical.getErroresEnTablero()==0) {
					List<String> nextNumerosDisponibles = nextTableVertical.removeCloneList(posiblesValuesVertical.get(0));
					nextNodes.add(new Node(posiblesValuesVertical.get(0), nodeAnterior, nextTableVertical, nextNumerosDisponibles,posiblesValuesVertical.size() ));
			        return nextNodes;
			 }else {
					List<String> numerosIntercambiables = getPosiblesNumerosIntercambiables(posiblesValuesVertical.get(0));
				    for(String numeroIntercambiable: numerosIntercambiables) {
				    	Table tableCambiado = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posiblesValuesVertical.get(0)));
				        tableCambiado.shiftPlaceAt(numeroIntercambiable, fila, columna, Table.ALINEACION_VERTICAL, posiblesValuesVertical.get(0), getCoordenadaNumero(numeroIntercambiable));
				        if(tableCambiado.getErroresEnTablero()==0) {
				        	List<String> nextNumerosDisponibles = tableCambiado.removeCloneList(posiblesValuesVertical.get(0));
				        	nextNodes.add(new Node(numeroIntercambiable, nodeAnterior, tableCambiado, nextNumerosDisponibles,posiblesValuesVertical.size() ));
				            return nextNodes;
				        }
				    }
				}
          }
			  
           for(String posibleNumero: posiblesValuesHorizontal) {
        	    int size = posiblesValuesHorizontal.size();
				Table nextTableHorizontal = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posibleNumero));
				nextTableHorizontal.setValuesAt(posibleNumero, fila, columna, Table.ALINEACION_HORIZONTAL);
				
				if(nextTableHorizontal.getErroresEnTablero()==0) {
					List<String> nextNumerosDisponibles = nextTableHorizontal.removeCloneList(posibleNumero);
					nextNodes.add(new Node(posibleNumero, nodeAnterior, nextTableHorizontal, nextNumerosDisponibles,size ));
				}else {
					List<String> numerosIntercambiables = getPosiblesNumerosIntercambiables(posibleNumero);
				    for(String numeroIntercambiable: numerosIntercambiables) {
				    	Table tableCambiado = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posibleNumero));
				        tableCambiado.shiftPlaceAt(numeroIntercambiable, fila, columna, Table.ALINEACION_HORIZONTAL, posibleNumero, getCoordenadaNumero(numeroIntercambiable));
				        if(tableCambiado.getErroresEnTablero()==0) {
				        	List<String> nextNumerosDisponibles = tableCambiado.removeCloneList(posibleNumero);
				        	nextNodes.add(new Node(numeroIntercambiable, nodeAnterior, tableCambiado, nextNumerosDisponibles,size ));
				        }
				    }
				}
			 }
		   
		   
			   
			for(String posibleNumero: posiblesValuesVertical) {
				int size = posiblesValuesVertical.size();
				Table nextTableVertical = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posibleNumero));
				nextTableVertical.setValuesAt(posibleNumero, fila, columna, Table.ALINEACION_VERTICAL);
				
				if(nextTableVertical.getErroresEnTablero()==0) {
					List<String> nextNumerosDisponibles = nextTableVertical.removeCloneList(posibleNumero);
					nextNodes.add(new Node(posibleNumero, nodeAnterior, nextTableVertical, nextNumerosDisponibles,size ));
				}else {
					List<String> numerosIntercambiables = getPosiblesNumerosIntercambiables(posibleNumero);
				    for(String numeroIntercambiable: numerosIntercambiables) {
				    	Table tableCambiado = new Table(filas,columnas,cloneTableValues(),numerosOriginales,removeCloneList(posibleNumero));
				        tableCambiado.shiftPlaceAt(numeroIntercambiable, fila, columna, Table.ALINEACION_VERTICAL, posibleNumero, getCoordenadaNumero(numeroIntercambiable));
				        if(tableCambiado.getErroresEnTablero()==0) {
				        	List<String> nextNumerosDisponibles = tableCambiado.removeCloneList(posibleNumero);
				        	nextNodes.add(new Node(numeroIntercambiable, nodeAnterior, tableCambiado, nextNumerosDisponibles,size ));
				        }
				    }
				}
			}
		  
			
			
			
		
		
		
	return nextNodes;	
		
	}
	
	public List<String> getPosiblesValues(int fila, int columna, int alineacion){
		List<String> posiblesValues = new ArrayList<>();
		
		
		if(alineacion == Table.ALINEACION_HORIZONTAL) {
		    String[] valoresFila = listToArray(getCifrasAt(fila,columna,alineacion));	
		    
			for(String posibleNumero: getPosiblesValuesBySize(getSize(fila,columna,alineacion))) {
				if(isPosibleValueCorrect(valoresFila,posibleNumero)) {
				  if(isEntra(valoresFila,posibleNumero)) {
					posiblesValues.add(posibleNumero);
				  }
				}
			}
			
			
		}
		
		if(alineacion == Table.ALINEACION_VERTICAL) {
		    String[] valoresFila = listToArray(getCifrasAt(fila,columna,alineacion));
		    
			for(String posibleNumero: getPosiblesValuesBySize(getSize(fila,columna,alineacion))) {
				if(isPosibleValueCorrect(valoresFila,posibleNumero) ) {
				  if(isEntra(valoresFila,posibleNumero)) {	
					posiblesValues.add(posibleNumero);
				  }
				}
			}
				
			
		}
		
		return posiblesValues;
	}	
	public List<String> getPosiblesNumerosIntercambiables(String posibleNumero){
		List<String> posiblesNumeros = new ArrayList<>();
		 for(int[] coordenada: coordenadasEncerradas){
			 int fila = coordenada[0];
			 int columna = coordenada[1];
			 
			
				 String numeroHorizontal = getValueAt(fila,columna,Table.ALINEACION_HORIZONTAL);
				 
				 if(numeroHorizontal!=null) {
					 String[] numeroString = String.valueOf(numeroHorizontal).split("(?!^)");
					 String[] numeroPosible = String.valueOf(posibleNumero).split("(?!^)");
					 if(numeroString[1].equals(numeroPosible[1])&& numeroPosible.length == 2) {
					 posiblesNumeros.add(numeroHorizontal);
					 }
				 }
			 
			 
			 
				 String numeroVertical = getValueAt(fila,columna,ALINEACION_VERTICAL);
				 String[] numeroString = String.valueOf(numeroVertical).split("(?!^)");
				 String[] numeroPosible = String.valueOf(posibleNumero).split("(?!^)");
				 
				 if(numeroString[1].equals(numeroPosible[1]) && numeroPosible.length == 2) {
				   posiblesNumeros.add(numeroVertical);
				  }
		 }
			    
			 
	       	  
		 return posiblesNumeros;
	}		  
				  
	public int[] getCoordenadaNumero(String numero) {
		for(int[] coordenada: coordenadasEncerradas){
			 int fila = coordenada[0];
			 int columna = coordenada[1];
			 
			 String numeroHorizontal = getValueAt(fila,columna,Table.ALINEACION_HORIZONTAL);
			 if(numeroHorizontal != null) {
				 if(numeroHorizontal.equals(numero)) {
					 return coordenada;
				 }
			 }
			 
			 String numeroVertical = getValueAt(fila,columna,Table.ALINEACION_VERTICAL);
			 if(numeroVertical != null) {
				 if(numeroVertical.equals(numero)) {
					 return coordenada;
				 }
			 }
			 
		}
		int[] coordenada = {-3,-3};
		return coordenada;
	}
				  
			
	       
			
		
	  
	public boolean isIntercambiableApto(String[] numeroIntercambiable, Integer posibleNumero) {
		
		String[] posibleString = String.valueOf(posibleNumero).split("(?!^)");
		if(numeroIntercambiable[1].equals(posibleString[1])) {
			return true;
		}
		return false;
	}
	public boolean isEncerrado(int fila, int columna) {
	    int bloques = 0;	  
	    
	    if(tablero[fila][columna] == -1) {
	    	return false;
	    }
	    
		if(fila>0) {
		  if(tablero[fila-1][columna]==-1) {
			  bloques++;
		  }
	    }
		if(fila < filas-1) {
			if(tablero[fila+1][columna]==-1) {
				bloques++;
			}
		}
		if(columna > 0) {
			if(tablero[fila][columna-1] == -1) {
				bloques++;
			}
		}
		if(columna < columnas-1) {
			if(tablero[fila][columna+1]==-1) {
				bloques++;
			}
		}
		if(columna==0) {
			bloques++;
		}
		if(fila==0) {
			bloques++;
		}
		if(bloques==3) {
			if(Math.max(getSize(fila,columna,Table.ALINEACION_HORIZONTAL),getSize(fila,columna,Table.ALINEACION_VERTICAL)) == 2) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEntra(String[] valoresFila, String posibleNumero) {
		String[] posibleNumeroString = String.valueOf(posibleNumero).split("(?!^)");
		for(int i = 0; i < posibleNumeroString.length;i++) {
			if(!valoresFila[i].equals(String.valueOf(-2)) && !valoresFila[i].equals(posibleNumeroString[i])) {
				return false;
			}
		}
		return true;
	}
	public boolean isPosibleValueCorrect(String[] valoresFila, String posibleNumero) {
		String[] posibleNumeroString = String.valueOf(posibleNumero).split("(?!^)");
		
		if(posibleNumeroString.length != valoresFila.length) {
			return false;
		}
		
		return true;
	}
	
	public List<String> getPosiblesValuesBySize(int size) {
		List<String> numerosDisponibles = new ArrayList<>();
		for(String numero: this.numerosDisponibles) {
		    if(size == getSizeNumber(numero)) {
		    	numerosDisponibles.add(numero);
		    }
		}
		return numerosDisponibles;
		
	}
	
	
	
	public int getSizeNumber(String numero) {
		String[] numeroString = String.valueOf(numero).split("(?!^)");
		return numeroString.length;
	}
	public String getValueAt(int fila, int columna, int alineacion) {
		String numeroString = "";
		for(String cifra: getCifrasAt(fila,columna,alineacion)) {
			if(cifra.equals("-2")) {
				return null;
			}
			
			numeroString+= cifra;
		}
		
		if(numeroString.length()<=1) {
			return null;
		}
		
		 return numeroString;
		
	}
	
 
	public List<String> getCifrasAt(int fila, int columna, int alineacion) {
		List<String> cifrasString = new ArrayList<>();
		
		if(alineacion == Table.ALINEACION_HORIZONTAL) {
			int comienzo = getComienzo(fila,columna,alineacion);
			
			while(comienzo < columnas) {
			if(tablero[fila][comienzo] == -1) break; 
				cifrasString.add(String.valueOf(tablero[fila][comienzo]));
				comienzo++;
			}
		}	
		
		if(alineacion == Table.ALINEACION_VERTICAL) {
            int comienzo = getComienzo(fila,columna,alineacion);
			
			while(comienzo < filas) {
			   if(tablero[comienzo][columna] == -1) break; 
			   cifrasString.add(String.valueOf(tablero[comienzo][columna]));
				comienzo++;
			}
		}	
		return cifrasString;
		
	}	
		
	
	
	
	public boolean removeNumeroDisponible(String numero) {
		if(numerosDisponibles.contains(numero)) {
			numerosDisponibles.remove(numero);
			return true;
		}
		return false;
	}
	
	public List<String> removeCloneList(String numero){
	   List<String> clonedList = cloneList(numerosDisponibles);
	   clonedList.remove(numero);
	   return clonedList;
	}
	
	public List<String> cloneList(List<String> lista){
		List<String> listaClonada = new ArrayList<>();
		for(String numero: lista) {
			listaClonada.add(numero);
		}
		return listaClonada;
	}
	public int getComienzo(int fila, int columna, int alineacion) {
		if(fila<0 && alineacion == Table.ALINEACION_VERTICAL) return fila +1 ;
		if(columna<0 && alineacion == Table.ALINEACION_HORIZONTAL) return columna +1;
		if(tablero[fila][columna]==-1   &&   alineacion == Table.ALINEACION_VERTICAL) return fila+1;
		if(tablero[fila][columna] == -1 && alineacion == Table.ALINEACION_HORIZONTAL) return columna+1;
		if(alineacion == Table.ALINEACION_VERTICAL) return getComienzo(fila-1,columna,Table.ALINEACION_VERTICAL);
		if(alineacion == Table.ALINEACION_HORIZONTAL) return getComienzo(fila,columna-1,Table.ALINEACION_HORIZONTAL);
		
		return 0;	
	}
	public String[] listToArray(List<String> lista) {
		String[] arrayList = new String[lista.size()];
		
		for(int i = 0; i< lista.size();i++) {
			arrayList[i] = lista.get(i);
		}
		
		return arrayList;
	}
	public int getSize(int fila, int columna, int alineacion) {
	   int suma = 0;
		if(alineacion == Table.ALINEACION_HORIZONTAL) {	
	     int comienzo = getComienzo(fila,columna,alineacion);
			
		  while(comienzo < columnas) {
			  if(tablero[fila][comienzo] == -1) break; 
			   comienzo++;
			   suma++;
	    }
	  }	
	  
	  if(alineacion == Table.ALINEACION_VERTICAL) {	
		int comienzo = getComienzo(fila,columna,alineacion);
		
		while(comienzo < filas) {
		   if(tablero[comienzo][columna] == -1) break; 
		    comienzo++;
		    suma++;
		}
	  }
		return suma;
	}
	
	public void printTablero() {
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
		       System.out.print(tablero[fila][columna] + " ");		
			}
			System.out.println("");
		}
		System.out.println("");
	}
	public List<String> getNumerosDisponibles(){return numerosDisponibles;}
	public List<String> getNumerosOriginales(){return numerosOriginales;}
	public int[][] getTablero(){return tablero;}
	public int getFilas() {return filas;}
	public int getColumnas() {return columnas;}
	
	
	
	
	
		
	
	
}
