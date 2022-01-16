package source;

import java.util.ArrayList;
import java.util.List;

public class Boot {
     
	public static void main(String[] args) {
         int[] tablero = {-1, -2, -2, -2, -2, -1, -2, -1, -1, -1, -2, -2, -2, -2, -2, -1, -1,  
        		          -2, -2, -2, -2, -1, -2, -2, 2, -1, -2, -2, -1, -2, -1, 1, 7, -1, 
        		          -2, -2, -2, -1, -2, -2, -2, 3, -1, -1, -2, -2, -1, -2, -2, -2, -2, 
        		          -2, -2, -2, -2, -2, -1, -2, 9, -2, -2, -2, -1, -1, -2, -1, -1, -2,
        		          -1, -1, -1, -2, -2, -2, -2, -1, -2, -2, -1, -2, -1, -2, -2, -2, -2,
        		          -2, -2, -2, -2, -1, -2, -1, -2, -2, -1, -2, -2, -2, -2, -1, -1, -1,
        		          -2, -1, -1, -2, -1, -1, -2, -2, -2, -2, -2, -1, -2, -2, -2, -2, -2,
        		          -2, -2, -2, -2, -1, -2, -2, -1, -1, -2, -2, -2, -2, -1, -2, -2, -2,
        		          -1, -2, -2, -1, -2, -1, -2, -2, -1, -2, -2, -2, -1, -2, -2, -2, -2,
        		          -1, -1, 8, 0, 7, 8, 4, -1, -1, -1, -2, -1 ,-2 ,-2, -2 ,-2, -1};
         
         int[] tableroReducido = {-1, 3, 2, 7, 5, -1, 1, -1, -1, -1, 9, 0, 4, 0, 5, -1, -1,  
		          9, 6, 3, 0, -1, 8, 6, 2, -1, 9, 6, -1, 8, -1, 1, 7, -1, 
		          9, 8, 4, -1, 2, 0, 0, 3, -1, -1, 7, 2, -1, 5, 6, 6, 3, 
		          7, 3, 6, 2, 4, -1, 3, 9, 8, 6, 9, -1, -1, 3, -1, -1, 2,
		          -1, -1, -1, 8,  6,  5, 4, -1, 1, 0, -1, 8, -1, 2, 7, 7, 0,
		          4, 2, 2, 2, -1, 6, -1, 9, 9, -1, 1, 3, 9, 6, -1, -1, -1,
		          4, -1, -1, 2, -1, -1, 1, 0, 7, 6, 3, -1, 6, 1, 6, 7, 3,
		          1, 6, 2, 8, -1, 5, 4, -1, -1, 9, 5, -2, 0, -1, 2, 3, 7,
		          -1, 9, 7, -1, -2, -1,  2, -2, -1, 4, 1, -2, -1, -2, 9, 5, -2,
		          -1, -1, 8, 0, 7, 8, 4, -1, -1, -1, 0, -1 ,-2 ,-2, 6 ,7, -1};

  
         
         
 int[] tableroP ={-1, -1, -2, -2, -2, -2, -2, -1, -1,  
		          -1, -2, -2, -1, -2, -1,  1,  7, -1, 
		          -1, -1, -2, -2, -1, -2, -2, -2, -2, 
		          -2, -2, -2, -1, -1, -2, -1, -1, -2,
		          -2, -2, -1, -2, -1, -2, -2, -2, -2,
		          -2, -1, -2, -2, -2, -2, -1, -1, -1,
		          -2, -2, -2, -1, -2, -2, -2, -2, -2,
		          -1, -2, -2, -2, -2, -1, -2, -2, -2,
		          -1, -2, -2, -2, -1, -2, -2, -2, -2,
		          -1, -1, -2, -1 ,-2 ,-2, -2 ,-2, -1};
         
                           
         
         //Tablero tablp = new Tablero(10,8, tableroP);
         
         //tabl.printTablero();
         List<String> numeros = new ArrayList<>();
         
        numeros.add("10");
 		numeros.add("15");
 		numeros.add("22");
 		numeros.add("37");
 		numeros.add("46");
 		numeros.add("48");
 		numeros.add("54");
 		numeros.add("56");
 		numeros.add("60");
 		numeros.add("69");
 		numeros.add("70");
 		numeros.add("72");
 		numeros.add("73");
 		numeros.add("80");
 		numeros.add("83");
 		numeros.add("90");
 		numeros.add("96");
 		numeros.add("97");
 		numeros.add("99");
 		
 		numeros.add("237");
 		numeros.add("246");
 		numeros.add("278");
 		numeros.add("320");
 		numeros.add("379");
 		numeros.add("416");
 		numeros.add("441");
 		numeros.add("516");
 		numeros.add("694");
 		numeros.add("862");
 		numeros.add("960");
 		numeros.add("984");
 		numeros.add("997");
 		
 		numeros.add("1396");
 		numeros.add("1424");
 		numeros.add("1628");
 		numeros.add("1959");
 		numeros.add("2003");
 		numeros.add("2346");
 		numeros.add("2770");
 		numeros.add("3275");
 		numeros.add("3683");
 		numeros.add("4222");
 		numeros.add("5633");
 		numeros.add("6296");
 		numeros.add("6567");
 		numeros.add("7357");
 		numeros.add("8197");
 		numeros.add("8654");
 		numeros.add("9590");
 		numeros.add("9630");
 		numeros.add("9679");
 		
 		numeros.add("10763");
 		numeros.add("13510");
 		numeros.add("16034");
 		numeros.add("28228");
 		numeros.add("39869");
 		numeros.add("53261");
 		numeros.add("61673");
 		numeros.add("73624");
 		numeros.add("90405");
         
 		
 		 
 		 
 		 Table table = new Table(10,17,tablero, numeros);
 		 
 		 
 		 
 		 
         Solver solver = new Solver(table, numeros);
         //solver.solve().printTablero();
        // Node nodo = solver.DFS(table.getFirstNodes());
         //if(nodo != null) {
        ///	 nodo.getTableroNuevo().printTablero();
        // }
         
	}
	
	
}
