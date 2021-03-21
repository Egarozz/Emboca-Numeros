package main.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.gui.bloques.Bloque;
import main.source.Node;
import main.source.Solver;
import main.source.SolverPrueba;
import main.source.Table;



public class Opciones extends JPanel{
    private Grid grid;
    private ActionListener listenerBotones;
    private DefaultListModel modelo;
    private SolverPrueba solver;
	public Opciones(Grid grid) {
		this.grid = grid;
		setBounds(630,10,200,600);
		//setBackground(Color.yellow);
		setBorder(new LineBorder(Color.black));
		setLayout(null);
		//elementos
		JLabel opcionesGrid = new JLabel("Grid");
		opcionesGrid.setBounds(90,10,30,10);
		
		JSpinner spFila = new JSpinner();
		spFila.setBounds(45, 30, 40, 25);
		spFila.setValue(8);
		
		JLabel labelFila = new JLabel("Filas:");
		labelFila.setBounds(10,37,30,10);
		
		JSpinner spColumna = new JSpinner();
		spColumna.setBounds(153,30,40,25);
		spColumna.setValue(8);
		
		JLabel labelColumna = new JLabel("Columnas:");
		labelColumna.setBounds(90,37,60,10);
		
		JLabel botones = new JLabel("Colocar");
		botones.setBounds(80,82,60,10);
		
		
		JButton botonNegro = new JButton("C");
		botonNegro.setBounds(20, 110, 50, 30);
		JButton botonUno = new JButton("1");
		botonUno.setBounds(70, 110, 50, 30);
		JButton botonDos = new JButton("2");
		botonDos.setBounds(120, 110, 50, 30);
		
		JButton botonTres = new JButton("3");
		botonTres.setBounds(20, 140, 50, 30);
		JButton botonCuatro = new JButton("4");
		botonCuatro.setBounds(70, 140, 50, 30);
		JButton botonCinco = new JButton("5");
		botonCinco.setBounds(120, 140, 50, 30);
		
		JButton botonSeis = new JButton("6");
		botonSeis.setBounds(20, 170, 50, 30);
		JButton botonSiete = new JButton("7");
		botonSiete.setBounds(70, 170, 50, 30);
		JButton botonOcho = new JButton("8");
		botonOcho.setBounds(120, 170, 50, 30);
		
		JButton botonNueve = new JButton("9");
		botonNueve.setBounds(20, 200, 50, 30);
		JButton botonCero = new JButton("0");
		botonCero.setBounds(70, 200, 50, 30);
		JButton botonBorrar = new JButton("B");
		botonBorrar.setBounds(120, 200, 50, 30);
		
		
		modelo = new DefaultListModel();
		JScrollPane listScroller = new JScrollPane();
		
		JList listaNumeros = new JList(modelo);
		
		modelo.addElement(10);
		modelo.addElement(15);
		modelo.addElement(22);
		modelo.addElement(37);
		modelo.addElement(46);
		modelo.addElement(48);
		modelo.addElement(54);
		modelo.addElement(56);
		modelo.addElement(60);
		modelo.addElement(69);
		modelo.addElement(70);
		modelo.addElement(72);
		modelo.addElement(73);
		modelo.addElement(80);
		modelo.addElement(83);
		modelo.addElement(90);
		modelo.addElement(96);
		modelo.addElement(97);
		modelo.addElement(99);
		
		modelo.addElement(237);
		modelo.addElement(246);
		modelo.addElement(278);
		modelo.addElement(320);
		modelo.addElement(379);
		modelo.addElement(416);
		modelo.addElement(441);
		modelo.addElement(516);
		modelo.addElement(694);
		modelo.addElement(862);
		modelo.addElement(960);
		modelo.addElement(984);
		modelo.addElement(997);
		
		modelo.addElement(1396);
		modelo.addElement(1424);
		modelo.addElement(1628);
		modelo.addElement(1959);
		modelo.addElement(2003);
		modelo.addElement(2346);
		modelo.addElement(2770);
		modelo.addElement(3275);
		modelo.addElement(3683);
		modelo.addElement(4222);
		modelo.addElement(5633);
		modelo.addElement(6296);
		modelo.addElement(6567);
		modelo.addElement(7357);
		modelo.addElement(8197);
		modelo.addElement(8654);
		modelo.addElement(9590);
		modelo.addElement(9630);
		modelo.addElement(9679);
		
		modelo.addElement(10763);
		modelo.addElement(13510);
		modelo.addElement(16034);
		modelo.addElement(28228);
		modelo.addElement(39869);
		modelo.addElement(53261);
		modelo.addElement(61673);
		modelo.addElement(73624);
		modelo.addElement(90405);
		
		
	 
		
		
		
		
		
		listScroller.setViewportView(listaNumeros);
		listScroller.setBounds(20,250,150,170);
		listaNumeros.setLayoutOrientation(JList.VERTICAL);
		
		listaNumeros.setBounds(20,250,150,170);
		
		JTextField listaTextField = new JTextField();
		listaTextField.setBounds(20,460,80,20);
		
		JButton anadirLista = new JButton("Añadir");
		anadirLista.setBounds(105,459,80,20);
		
		
		JButton botonListaBorrar = new JButton("Borrar");
		botonListaBorrar.setBounds(55, 430, 80, 20);
		
		JButton botonResolver = new JButton("Resolver");
		botonResolver.setBounds(50, 530, 100, 20);
		
		spFila.getModel().addChangeListener( new ChangeListener() {
         public void stateChanged(ChangeEvent arg0) {
				if((int)spFila.getValue() < 0) {
					spFila.getModel().setValue(0);
				}
				if((int)spFila.getValue() > 25) {
					spFila.getModel().setValue(25);
				}
				grid.setFila((int) spFila.getValue());
				
			}
		  });
		
		 spColumna.getModel().addChangeListener( new ChangeListener() {
	         public void stateChanged(ChangeEvent arg0) {
					if((int)spColumna.getValue() < 0) {
						spColumna.getModel().setValue(0);
					}
					if((int)spFila.getValue() > 25) {
						spColumna.getModel().setValue(25);
					}
					 
					grid.setColumna((int) spColumna.getValue());
				}
			  });
		
		listenerBotones = new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				
				if(arg0.getSource().equals(botonNegro)) {
					grid.mouseMode = Bloque.CUADRADO;
				}
				if(arg0.getSource().equals(botonUno)) {
					grid.mouseMode = Bloque.NUMERO1;
				}
				if(arg0.getSource().equals(botonDos)) {
					grid.mouseMode = Bloque.NUMERO2;
				}
				if(arg0.getSource().equals(botonTres)) {
					grid.mouseMode = Bloque.NUMERO3;
				}
				if(arg0.getSource().equals(botonCuatro)) {
					grid.mouseMode = Bloque.NUMERO4;
				}
				if(arg0.getSource().equals(botonCinco)) {
					grid.mouseMode = Bloque.NUMERO5;
				}
				if(arg0.getSource().equals(botonSeis)) {
					grid.mouseMode = Bloque.NUMERO6;
				}
				if(arg0.getSource().equals(botonSiete)) {
					grid.mouseMode = Bloque.NUMERO7;
				}
				if(arg0.getSource().equals(botonOcho)) {
					grid.mouseMode = Bloque.NUMERO8;
				}
				if(arg0.getSource().equals(botonNueve)) {
					grid.mouseMode = Bloque.NUMERO9;
				}
				if(arg0.getSource().equals(botonCero)) {
					grid.mouseMode = Bloque.NUMERO0;
				}
				if(arg0.getSource().equals(botonBorrar)) {
					grid.mouseMode = Bloque.VACIO;
				}
				
				if(arg0.getSource().equals(anadirLista)) {
					Integer numero = null;
					 try {
						 numero = Integer.parseInt(listaTextField.getText());
					 }catch(Exception e) {
						 numero = null;
					 }
					
					if(numero != null) {
						modelo.addElement(listaTextField.getText());
						listaTextField.setText("");
						listaTextField.requestFocus();
					}
				}
				if(arg0.getSource().equals(botonListaBorrar)) {
					modelo.removeElement(listaNumeros.getSelectedValue());
				}
					
				if(arg0.getSource().equals(botonResolver)) {
					
					if(botonResolver.getText().equals("Resolver")) {
						spFila.setEnabled(false);
						spColumna.setEnabled(false);
						
						botonNegro.setEnabled(false);
						botonUno.setEnabled(false);
						botonDos.setEnabled(false);
						botonTres.setEnabled(false);
						botonCuatro.setEnabled(false);
						botonCinco.setEnabled(false);
						botonSeis.setEnabled(false);
						botonSiete.setEnabled(false);
						botonOcho.setEnabled(false);
						botonNueve.setEnabled(false);
						botonCero.setEnabled(false);
						botonBorrar.setEnabled(false);
						
						anadirLista.setEnabled(false);
						botonListaBorrar.setEnabled(false);
						listaTextField.setEnabled(false);
						listaNumeros.setEnabled(false);
						
						List<String> numeros = new ArrayList<>();
						for(int i = 0; i < modelo.getSize(); i++) {
							numeros.add(String.valueOf(modelo.getElementAt(i)));
						}
						
						Table table = new Table(grid.getFilas(), grid.getColumnas(), grid.getTableValues(),numeros);
						
						Node nodo = null;
				        grid.finalizarEdicion();
						solver = new SolverPrueba(table, numeros, grid);
						
						//Solver solver = new Solver(table, numeros);
						//nodo = solver.DFS(table.getFirstNodes());
						//nodo = solver.DFS(table.getFirstNodes(),grid);
						nodo = solver.solve();
					
						if(nodo != null) {
							grid.showResults(nodo.getTableroNuevo());
							
						}
						grid.showing = true;
				
										
						botonResolver.setText("Volver");
					}else {
						if(solver.getTimer().isRunning()) {
							solver.getTimer().stop();
						}
						botonResolver.setText("Resolver");
						
						spFila.setEnabled(true);
						spColumna.setEnabled(true);
						
						botonNegro.setEnabled(true);
						botonUno.setEnabled(true);
						botonDos.setEnabled(true);
						botonTres.setEnabled(true);
						botonCuatro.setEnabled(true);
						botonCinco.setEnabled(true);
						botonSeis.setEnabled(true);
						botonSiete.setEnabled(true);
						botonOcho.setEnabled(true);
						botonNueve.setEnabled(true);
						botonCero.setEnabled(true);
						botonBorrar.setEnabled(true);
						
						anadirLista.setEnabled(true);
						botonListaBorrar.setEnabled(true);
						listaTextField.setEnabled(true);
						listaNumeros.setEnabled(true);
						
						grid.volverNormal();
						grid.showing = false;
					}
				}
				
			}
			
		};
			
	 
		 
		botonNegro.addActionListener(listenerBotones);
		botonUno.addActionListener(listenerBotones);
		botonDos.addActionListener(listenerBotones);
		botonTres.addActionListener(listenerBotones);
		botonCuatro.addActionListener(listenerBotones);
		botonCinco.addActionListener(listenerBotones);
		botonSeis.addActionListener(listenerBotones);
		botonSiete.addActionListener(listenerBotones);
		botonOcho.addActionListener(listenerBotones);
		botonNueve.addActionListener(listenerBotones);
		botonCero.addActionListener(listenerBotones);
		botonBorrar.addActionListener(listenerBotones);
		
		anadirLista.addActionListener(listenerBotones);
		botonListaBorrar.addActionListener(listenerBotones);
		
		botonResolver.addActionListener(listenerBotones);
		
		add(opcionesGrid);
		add(labelFila);
		add(spFila);
		add(spColumna);
		add(labelColumna);
		
		add(botones);
		add(botonNegro);
		add(botonUno);
		add(botonDos);
		add(botonTres);
		add(botonCuatro);
		add(botonCinco);
		add(botonSeis);
		add(botonSiete);
		add(botonOcho);
		add(botonNueve);
		add(botonCero);
		add(botonBorrar);
		
		add(listScroller);
		add(botonListaBorrar);
		add(listaTextField);
		add(anadirLista);
		add(botonResolver);
		setVisible(true);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.drawRect(6, 6, 188, 60);
	}
	
	
}
