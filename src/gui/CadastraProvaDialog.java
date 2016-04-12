package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.ManipulaBanco;

public class CadastraProvaDialog extends JDialog {
	
	private JTextField insereModalidade;
	private JTextField insereDistancia;
	private JLabel     modalidade;
	private JLabel     distancia;
	private JButton    btCadastraProva;
	private JButton    btcadastraOutra;
	private CadastraOutraDialog cadastraOutraDialog = new CadastraOutraDialog();
	static ManipulaBanco manipula = new ManipulaBanco();

	public CadastraProvaDialog() {
		
		setLayout(null);
		
		insereModalidade = new JTextField();
		insereModalidade.setBounds(120, 200, 170, 30);
		this.add(insereModalidade);
		
		modalidade = new JLabel("Modalidade");
		modalidade.setBounds(40, 200, 120, 30);
		this.add(modalidade);
		
		insereDistancia = new JTextField();
		insereDistancia.setBounds(120, 260, 170, 30);
		this.add(insereDistancia);
		
		distancia = new JLabel("Distancia");
		distancia.setBounds(40, 260, 120, 30);
		this.add(distancia);
		
		btCadastraProva = new JButton("Cadastar");
		btCadastraProva.setBounds(40, 460, 90, 30);
		btCadastraProva.addActionListener(btCadastraProvaListener);
		this.add(btCadastraProva);
		
		btcadastraOutra = new JButton("Cadastar outra prova");
		btcadastraOutra.setBounds(150, 460, 160, 30);
		btcadastraOutra.addActionListener(btCadastraOutraListener);
		this.add(btcadastraOutra);
		
		this.setTitle("Tela de cadastro de provas");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
		
	}
	
    private ActionListener btCadastraProvaListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Foi Ka!");
			//TODO ao clicar no botao inserir os dados do competidor no banco
			manipula.cadastraProva();
		}
						
	};
	
    private ActionListener btCadastraOutraListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Foi Ka!");
			
			if(cadastraOutraDialog == null)
			{
				cadastraOutraDialog = new CadastraOutraDialog();
			}
			

			cadastraOutraDialog.setLocationRelativeTo(CadastraProvaDialog.this);
			cadastraOutraDialog.setVisible(true);
		}
			//manipula.insereCompetidor();
		
						
	};

}
