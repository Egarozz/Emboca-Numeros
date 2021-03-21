package main.source;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
   
	private int columnas;
	private int filas;
	private int[][] tablero;
	
	private int fitness;
	
	public Tablero(int columnas, int filas, int[] tablero) {
		this.filas = filas;
		this.columnas = columnas;
		
		this.tablero = parseTablero(tablero);
	}
	
	
	public Tablero(int columnas, int filas, int[][] tablero) {
		this.filas = filas;
		this.columnas = columnas;
		
		this.tablero = tablero;
	}
	
	public Tablero(Tablero tablero) {
		this.filas = tablero.getFilas();
		this.columnas = tablero.getColumnas();
		
		this.tablero = new int[filas][columnas];
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				this.tablero[i][j] = tablero.getTablero()[i][j];
			}
		}
		
	}
	
	public void printTablero() {
		for(int fila = 0; fila < filas; fila++) {
			for(int columna = 0; columna < columnas; columna++) {
				System.out.print(tablero[fila][columna] + " ");
			}
			System.out.println();
		}
	}
	public int getValueTablero(int fila, int columna) {return tablero[fila][columna];}
	
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
	public int[][] getTablero(){return tablero;}
	public int getFilas() {return filas;}
	public int getColumnas() {return columnas;}
	public List<Node> getNodeAt(Node nodeAnterior, int fila, int columna, List<Integer> numeros){
		/*
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
			  if(newTablero.getTablero()[i][j]==-2) {	
				if(getNumerosPosiblesAt(i,j,tempNumeros).isEmpty()) {
					return nodes;
				}
		*/
		
		List<Node> nodes = new ArrayList<>();
		
		int sizeColumna = checkSizeColumnaAt(fila, columna);
		int sizeFila = checkSizeFilaAt(fila, columna);
		
		List<Integer> posiblesNumeros = getNumerosPosiblesAt(fila,columna,numeros);
		
		for(Integer numero: posiblesNumeros) {
			
			
			
			if(sizeColumna == getLengthNumber(numero)) {
				List<Integer> tempNumeros = cloneNumeros(numeros);
				tempNumeros.remove(numero);
				
				Tablero newTablero = new Tablero(this);
				newTablero.setNumeroAt(fila, columna, 0, numero);
				
								
				if(newTablero.getErrores(numeros)==0) {
				Node node = new Node(numero,0, nodeAnterior,newTablero,tempNumeros,(tempNumeros.size()));
				nodes.add(node);
				}
			}
			if(sizeFila == getLengthNumber(numero)) {
				List<Integer> tempNumeros = cloneNumeros(numeros);
				tempNumeros.remove(numero);
				
				Tablero newTablero = new Tablero(this);
				newTablero.setNumeroAt(fila, columna, 1, numero);
				if(newTablero.getErrores(numeros)==0) {
				Node node = new Node(numero,1, nodeAnterior,newTablero,tempNumeros,(tempNumeros.size()));
				nodes.add(node);
				}
			}
			
		}
		
		
		return nodes;
		
	}
	
	public List<Integer> cloneNumeros(List<Integer> numeros){
	  List<Integer> nuevosNumeros = new ArrayList<>();
	  
	  for(Integer numero: numeros) {
		  nuevosNumeros.add(numero);
	  }
	  
	  return nuevosNumeros;
	}
	
	
	public int getLengthNumber(Integer numero) {
		String[] values = String.valueOf(numero).split("(?!^)");
		return values.length;
		
	}
	public List<Node> getFirstNodes(List<Integer> numeros){
		for(int i = 0; i < getFilas(); i++) {
			for(int j = 0; j < getColumnas(); j++) {
				
				if(tablero[i][j]==-2) {
					return this.getNodeAt(null, i, j, numeros);
				}
			}
		}
		return new ArrayList<Node>();
	}
	public int getPuntaje() {
		int puntaje = 0;
		
		for(int i = 0; i < getFilas(); i++) {
			for(int j = 0; j < getColumnas(); j++) {
				
				if(tablero[i][j] != -2 && tablero[i][j] != -1) {
					puntaje++;
				}
			}
		}
		return puntaje;
	}
	public List<Integer> getNumerosPosiblesAt(int fila, int columna, List<Integer> numeros){
		List<Integer> numerosPosibles = new ArrayList<>();
		
		for(Integer numero: numeros) {
			String[] values = String.valueOf(numero).split("(?!^)");
		    
			
			int sizeFila = checkSizeFilaAt(fila,columna);
			int sizeColumna = checkSizeColumnaAt(fila,columna);
			
			int count = 0;
				
			
			String[] valuesTableroFila = getValuesTablero(fila,columna,1);
			String[] valuesTableroColumna = getValuesTablero(fila,columna,0);
			
		 if(sizeColumna != sizeFila){	
			//checker si tiene el mismo size de fila
		    if(values.length==sizeFila) {
		    //checkear si tiene numeros en la fila	
		      if(hasNumeros(valuesTableroFila)) {
		    	//chekear si coinciden los numeros con la fila
		    	  //derecho
		    	  if(isPossibleValue(values,valuesTableroFila)) {
		    		  numerosPosibles.add(numero);
		    	  }  
		    	  //al reves
		    	  //if(isPossibleValue(getInvertedArray(values),valuesTablero)) {
		    		//  numerosPosibles.add(getIntegerFromString(getInvertedArray(values)));
		    	  //}
		    	  
		      }else {
		    	  numerosPosibles.add(numero); 
		      }
		    }//end if	
		    	
		    //columna
		    
		    
		    
			
			//checker si tiene el mismo size de columna
		    if(values.length==sizeColumna) {
		    //checkear si tiene numeros en la fila	
		      if(hasNumeros(valuesTableroColumna)) {
		    	//chekear si coinciden los numeros con la fila
		    	  if(isPossibleValue(values,valuesTableroColumna)) {
		    		  numerosPosibles.add(numero);
		    		  
		    	  }
		    	   //al reves
		    	  //if(isPossibleValue(getInvertedArray(values),valuesTablero)) {
		    		//  numerosPosibles.add(getIntegerFromString(getInvertedArray(values)));
		    	  //}
		       }else {
		    	  numerosPosibles.add(numero);
		       }
		    }//end if
		 }else{//end sizefila = size columna
			//checker si tiene el mismo size de columna
			    if(values.length==sizeColumna) {
			    //checkear si tiene numeros en la fila	
			      if(hasNumeros(valuesTableroColumna)) {
			    	//chekear si coinciden los numeros con la fila
			    	  if(isPossibleValue(values,valuesTableroColumna)) {
			    		  numerosPosibles.add(numero);
			    		  
			    	  }
			    	   //al reves
			    	  //if(isPossibleValue(getInvertedArray(values),valuesTablero)) {
			    		//  numerosPosibles.add(getIntegerFromString(getInvertedArray(values)));
			    	  //}
			       }else {
			    	  numerosPosibles.add(numero);
			       }
			    } 
			 
		 }
		 
		}//end for numeros
		
		return numerosPosibles;
		
	}
	
	
	public int getComienzo(int fila, int columna, int alineamiento) {
		if(alineamiento == 1) {
			
			
			for(int i = columna; i >=0; i--) {
				if(tablero[fila][i] == -1) {
					return i+1;
					
				}
			}
			return 0;
		}
		if(alineamiento == 0) {
			
			
			for(int i = fila; i >=0; i--) {
				if(tablero[i][columna] == -1) {
					return i+1;
					
				}
			}
			return 0;
		}
		return 0;
	}
	
	
	
	public String[] getValuesTablero(int fila, int columna, int alineamiento) {
		
		if(alineamiento == 1) {
			//fila
			//checkear si hay numeros en la fila
			int sizeFila = checkSizeFilaAt(fila,columna);
			String[] valuesTablero = new String[sizeFila];
			int count = 0;
			int comienzo = 0;
			//regresar hasta un punto de comienzo
			for(int i = columna; i >=0; i--) {
				if(tablero[fila][i] == -1) {
					comienzo = i+1;
					break;
				}
			}
			
			comienzo = getComienzo(fila,columna,1);
			//recoger datos de la fila
			for(int i = 0; i <= sizeFila-1; i++) {
				   valuesTablero[count] = String.valueOf(tablero[fila][comienzo+i]); 
				   count++;
			} 
			return valuesTablero;
		}
		
		if(alineamiento == 0) {
			//fila
			//checkear si hay numeros en la fila
			int sizeColumna = checkSizeColumnaAt(fila,columna);
			String[] valuesTablero = new String[sizeColumna];
			int count = 0;
			int comienzo = 0;
			//regresar hasta un punto de comienzo
			for(int i = fila; i >=0; i--) {
				if(tablero[i][columna] == -1) {
					comienzo = i+1;
					break;
				}
			}
			comienzo = getComienzo(fila,columna,0);
			//recoger datos de la fila
			for(int i = 0; i <= sizeColumna-1; i++) {
				   valuesTablero[count] = String.valueOf(tablero[comienzo+i][columna]); 
				   count++;
			} 
			return valuesTablero;
		}
		return null;
	}
	
	
	
	public String[] getInvertedArray(String[] values) {
		String[] arreglo = new String[values.length];
		int count = 0;
		for(int i = values.length-1; i >= 0; i--) {
			arreglo[count] = values[i];
			count++;
		}
		return arreglo;
		
	}
	public Integer getIntegerFromString(String[] values) {
		String tempNum = "";
		
		for(String string: values) {
			tempNum += string;
		}
		
		return Integer.parseInt(tempNum);
		
		
	}
	public boolean isPossibleValue(String[] numero, String[] value){
		String tempNum = "";
		String tempValue = "";
		for(int i = 0; i < numero.length; i++) {
			
			if(!value[i].equals("-2") && !value[i].equals("-1")) {
				if(!numero[i].equals(value[i])) {
					return false;
				}
			}
			tempNum+=numero[i];
			tempValue+=value[i];
		}	
		
		if(tempNum.equals(tempValue)) {
			return false; //ya esta puesto;
		}
		
		
		return true;	
		
		
		
	}
	
	
	public boolean hasNumeros(String[] values) {
		
		for(String string: values) {
			
			if(!string.equals("-1") && !string.equals("-1")) {
				return true;
			}
			
		}
		
		return false;
	}
	public int checkSizeFilaAt(int fila, int columna) {
	  //buscar bloque cerrado hacia atras
		int count = -1; //comienza en -1 porque al comienzo se suma a si mismo
		for(int i = columna; i >= 0; i--) {
		   if(tablero[fila][i]==-1) break;
			   
		    count++;
		}  
		
		for(int i = columna; i < columnas; i++) {
			   if(tablero[fila][i]==-1) break;
				   
			  count++;
	    } 
		
		return count;
		
	}
	public int checkSizeColumnaAt(int fila, int columna) {
		  //buscar bloque cerrado hacia atras
			int count = -1; //comienza en -1 porque al comienzo se suma a si mismo
			for(int i = fila; i >= 0; i--) {
			   if(tablero[i][columna]==-1) break;
				   
			    count++;
			}  
			
			for(int i = fila; i < filas; i++) {
				   if(tablero[i][columna]==-1) break;
					   
				  count++;
		    } 
			
			return count;
			
		}
	public int getValueAt(int fila, int columna) {return tablero[fila][columna];}	
		
	public void setNumeroAt(int fila, int columna, int alineacion, Integer numero) {
		
		
		
		
		//vertical
		if(alineacion == 0) {
			int columnaSize = this.checkSizeColumnaAt(fila, columna);
			String[] values = String.valueOf(numero).split("(?!^)");
			int count = 0;
			//fila
			for(int i = getComienzo(fila,columna,0); count < columnaSize; i++) {
				tablero[i][columna] = Integer.parseInt(values[count]);
				fitness += areaOcupacion(fila,columna);
				count++;
			}
			
			
		}	
			
		//vertical
		 if(alineacion == 1) {
			 int filaSize = this.checkSizeFilaAt(fila, columna);
			 String[] values = String.valueOf(numero).split("(?!^)");
			 int count = 0;
			 
			 for(int i = getComienzo(fila,columna,1); count < filaSize; i++) {
				  tablero[fila][i] = Integer.parseInt(values[count]);
				  fitness += areaOcupacion(fila,columna);
				   count++;
				}
		 }	
		
		
		
	}
	
	public boolean isCeroComienzo(int fila, int columna) {
		
		
		int filaAtras = Math.max(0, fila-1);
		int filaAdelante = Math.min(filas-1, fila+1);
		
		int columnaAtras = Math.max(0, columna-1);
		int columnaAdelante = Math.min(columnas-1, columna+1);
		
		
		
		if(filaAtras != fila) {
			if(tablero[filaAtras][columna] == -1) {

                 if(filaAdelante != fila) {
                	 
                	 if(tablero[filaAdelante][columna] != -1) {
                		 return true;
                	 }
                 }else {
                	 return false;
                 }
			}	
		}else {		
			if(filaAdelante != fila) {
           	 
           	 if(tablero[filaAdelante][columna] != -1) {
           		 return true;
           	 }
            }else {
           	 return false;
            }
		}  
			
		
		
		if(columnaAtras != columna) {
			if(tablero[fila][columnaAtras] == -1) {
				
				if(columnaAdelante != columna) {
					if(tablero[fila][columnaAdelante] != -1) {
						
						return true;
					}
				}else {
					 return false;
				}
			}	
		}	
		return false;		
	}		
		
		
	  
	
	
	
	public int areaOcupacion(int fila, int columna) {
		
		int area = 0;
		
		int filaAtras = Math.max(0, fila-1);
		int filaAdelante = Math.min(filas-1, fila+1);
		
		int columnaAtras = Math.max(0, columna-1);
		int columnaAdelante = Math.min(columnas-1, columna+1);
		
		
		
		if(filaAtras != fila) {
			if(tablero[filaAtras][columna] != -2) {
				area++;
			}
		}else {
			area++;
		}
		
		if(filaAdelante != fila) {
			if(tablero[filaAdelante][columna] != -2) {
				area++;
			}
		}else {
			area++;
		}
		
		if(columnaAtras != columna) {
			if(tablero[fila][columnaAtras] != -2) {
				area++;
			}
		}else {
			area++;
		}
		if(columnaAdelante != columna) {
			if(tablero[fila][columnaAtras] != -2) {
				area++;
			}
		}else {
			area++;
		}
		
	  return area;
	}	
		
		
		
		
	
public int getErrores(List<Integer> numeros) {
	int error = 0;
	//ceros mal puestos
	for(int i = 0; i < filas; i++) {
		for(int j = 0; j < columnas; j++) {
			if(tablero[i][j]==0) {
				if(isCeroComienzo(i,j)) {
					error++;
				}
			}
		}
	}
	
	
	
	
	return error;
  }	

}
