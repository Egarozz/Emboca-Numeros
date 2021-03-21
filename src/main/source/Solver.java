package main.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.SwingWorker;

import main.gui.Grid;

public class Solver {

	private Table tablero;
	private Node actualVertex;
	private List<Node> nodes;
	
	private Stack<Node> stack;
	public Solver(Table tablero, List<Integer> numeros) {
		this.nodes = new ArrayList<>();
		this.tablero = tablero;
		
		
		stack = new Stack<>();
	}
	
	public Node DFS(List<Node> startNodes) {
		for(Node node: startNodes) {
			if(!node.isVisited()) {
				node.setVisited(true);
				Node resolucion = solveDFS(node);
				if(resolucion != null) {
					return resolucion;
				}
			}
		}
		return null;
	}
	public Node getActualVertex() {return this.actualVertex;}
	
	
	
	public Node solveDFS(Node vertex) {
		
		stack.add(vertex);
		vertex.setVisited(true);
        
        Node actualVertex = null;
        
		while(!stack.isEmpty()) {
			actualVertex = stack.pop();
			this.actualVertex = actualVertex;
			
			System.out.println(actualVertex.getTableroNuevo().getNumerosDisponibles().size());
			
			if(actualVertex.getTableroNuevo().isSolved()) {
				
				return actualVertex;
				
			}
			
			for(Node node: actualVertex.getNuevoNextNodes()) {
				
				if(!node.isVisited()) {
					stack.push(node);
					
				}
			}
			
			actualVertex = null;
		}	
		
		return null;
		
	}
	
	
	public Table solve() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.addAll(tablero.getFirstNodes());
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			System.out.println(node.getTableroNuevo().getNumerosDisponibles().size() + " " + node.getPuntaje() + " " + queue.size());
			if(node.getTableroNuevo().isSolved()) {
				return node.getTableroNuevo();
			}
			
			
			List<Node> nuevosNodes = node.getNuevoNextNodes();
			
			queue.addAll(nuevosNodes);
			
		}
	 return null;	
		
	}
	
	
}
