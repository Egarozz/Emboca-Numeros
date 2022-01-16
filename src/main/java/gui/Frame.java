package gui;

import javax.swing.JFrame;

public class Frame extends JFrame{
   
    
	public Frame() {
		
		Grid grid = new Grid();
		Opciones opciones = new Opciones(grid);
		setSize(850,645);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Emboca Numeros");
		getContentPane().setLayout(null);
		getContentPane().add(grid);
		getContentPane().add(opciones);
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Frame();
        
	}

}
