package gui;

import javax.swing.JFrame;

public class InterfaceFrame extends JFrame {
	
	InterfacePane p = new InterfacePane();
	
	public InterfaceFrame(String s) {
		// TODO Auto-generated constructor stub
		this.setTitle("Tela de Cadastro de Participantes");
		getContentPane().add(p);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
