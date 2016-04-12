package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.ManipulaBanco;

public class ListaInfoCompetidoresDialog extends JDialog {
	
	private JTextField insereCompetidor;
	private JLabel	   competidor;
	private JButton btListarTop3;
	private JButton btListaCompetidor;
	static ManipulaBanco manipula = new ManipulaBanco();
	
	public ListaInfoCompetidoresDialog() {
		
		setLayout(null);
		
		insereCompetidor = new JTextField();
		insereCompetidor.setBounds(390, 100, 170, 30);
		this.add(insereCompetidor);
		
		competidor = new JLabel("Competidor ");
		competidor.setBounds(320, 100, 70, 30);
		this.add(competidor);
		
		btListarTop3 = new JButton("Listar Top 3");
		btListarTop3.addActionListener(btTop3Listener);
		btListarTop3.setBounds(400, 150, 145, 30);
		this.add(btListarTop3);
		
		btListaCompetidor = new JButton("Procurar");
		btListaCompetidor.addActionListener(btLIstaCompetidorListener);
		btListaCompetidor.setBounds(590, 100, 145, 30);
		this.add(btListaCompetidor);
		
		this.setTitle("Busca Competidores");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
	}
	
    private ActionListener btLIstaCompetidorListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			//TODO buscar dados do participante(todas as séries em que participou)
			System.out.println("Foi Ka!");
			manipula.consutaCompetidor();
		}
						
	};
	
	 private ActionListener btTop3Listener = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				//TODO buscar os 3 melhores participantes
				System.out.println("Foi Ka!");
				manipula.consultaTop3();
			}
							
		};

}
