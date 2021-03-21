package main.source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.Timer;

import main.gui.Grid;

public class SolverPrueba {
	private Table tablero;
	private Node actualVertex;
	private Grid grid;
	private List<Node> nodes;
	public static ArrayList<Table> nodosVisitados;
	Timer timer;
	
	private Stack<Node> stack;
	private Queue<Node> queue;
	public SolverPrueba(Table tablero, List<String> numeros, Grid grid) {
		this.nodosVisitados = new ArrayList<>();
		this.queue = new PriorityQueue<>();
		this.nodes = new ArrayList<>();
		this.tablero = tablero;
		this.grid = grid;
		stack = new Stack<>();
	
		timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			  /*if(!stack.isEmpty()) {	
				actualVertex = stack.pop();
				System.out.println(actualVertex.getTableroNuevo().getNumerosDisponibles().size());
				grid.showResults(actualVertex.getTableroNuevo());
				grid.showing = true;
				if(actualVertex.getTableroNuevo().isSolved()) {
					timer.stop();
				}	
                 for(Node node: actualVertex.getNuevoNextNodes()) {
					
					if(!node.isVisited() && !nodosVisitados.contains(node.getTableroNuevo())) {
						stack.push(node);
						nodosVisitados.add(node.getTableroNuevo());
					}
				}	
			  }else {
				  actualVertex = null;
				  timer.stop();
			  }
			 */	
			  if(!queue.isEmpty()) {
					actualVertex = queue.poll();
					
					System.out.println(actualVertex.getTableroNuevo().getNumerosDisponibles().size() + " " + actualVertex.getPuntaje() + " " + queue.size());
					grid.showResults(actualVertex.getTableroNuevo());
					grid.showing = true;
					if(actualVertex.getTableroNuevo().isSolved()) {
						timer.stop();
					}
					
					
					List<Node> nuevosNodes = actualVertex.getNuevoNextNodes();
					
					queue.addAll(nuevosNodes);
					
				}else {
					actualVertex = null;
					 timer.stop();
				}
			
				
				
			 
			}

		});	
		
		
	}
	public Timer getTimer() {return timer;}
	
	public Node DFS(List<Node> startNodes, Grid grid) {
		for(Node node: startNodes) {
			if(!node.isVisited()) {
				node.setVisited(true);
				Node resolucion = solveDFS(node, grid);
				if(resolucion != null) {
					return resolucion;
				}
			}
		}
		return null;
	}
	
	public Node solve() {
		//PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.addAll(tablero.getFirstNodes());
		timer.start();
		if(actualVertex != null) {
			return actualVertex;
		}else {
			return null;
		}
		
	}
	
	
public Node solveDFS(Node vertex, Grid grid) {
	    stack.add(vertex);
		timer.start();
		if(actualVertex != null) {
			return actualVertex;
		}
		return null;
	}
	
	
}
