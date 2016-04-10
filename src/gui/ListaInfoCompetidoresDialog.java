package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListaInfoCompetidoresDialog extends JDialog {
	
	private JTextField insereCompetidor;
	private JLabel	   competidor;
	private JButton btListarTop3;

	public ListaInfoCompetidoresDialog() {
		
		setLayout(null);
		
		insereCompetidor = new JTextField();
		insereCompetidor.setBounds(450, 100, 170, 30);
		this.add(insereCompetidor);
		
		competidor = new JLabel("Competidor ");
		competidor.setBounds(380, 100, 70, 30);
		this.add(competidor);
		
		btListarTop3 = new JButton("Listar Top 3");
		//btListarTop3.addActionListener(btTop3Listener);
		btListarTop3.setBounds(400, 150, 145, 30);
		this.add(btListarTop3);
		
		this.setTitle("Busca Competidores");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
	}

}
