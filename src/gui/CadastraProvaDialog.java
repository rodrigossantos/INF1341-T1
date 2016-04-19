package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.ManipulaBanco;

//TODO pensar em como inserir mais de uma prova por competidor
public class CadastraProvaDialog extends JDialog {
	
	private JTextField insereNome;
	private JTextField insereIdProva;
	private JLabel     nome;
	private JLabel     idProva;
	private JButton    btCadastraProva;
	private JButton    btcadastraOutra;
	private CadastraOutraDialog cadastraOutraDialog = new CadastraOutraDialog();
	private CadastraProvaDialog cadastraProvaDialog;
	static ManipulaBanco manipula = new ManipulaBanco();

	public CadastraProvaDialog() {
		
		setLayout(null);
		
		insereNome = new JTextField();
		insereNome.setBounds(120, 200, 170, 30);
		this.add(insereNome);
		
		nome = new JLabel("Nome");
		nome.setBounds(40, 200, 120, 30);
		this.add(nome);
		
		insereIdProva = new JTextField();
		insereIdProva.setBounds(120, 260, 170, 30);
		this.add(insereIdProva);
		
		idProva = new JLabel("Id da Prova");
		idProva.setBounds(40, 260, 120, 30);
		this.add(idProva);
		
		btCadastraProva = new JButton("Cadastar");
		btCadastraProva.setBounds(40, 460, 90, 30);
		btCadastraProva.addActionListener(btCadastraProvaListener);
		this.add(btCadastraProva);
		
		btcadastraOutra = new JButton("Cadastar outra prova");
		btcadastraOutra.setBounds(150, 460, 160, 30);
		//btcadastraOutra.addActionListener(btCadastraOutraListener);
		this.add(btcadastraOutra);
		
		this.setTitle("Tela de cadastro de provas");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
		
	}
	
	//Listener que cadastra provas do competidor ao clicar
    private ActionListener btCadastraProvaListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Foi Ka!");
			
			int id = Integer.parseInt(insereIdProva.getText());
			String name = insereNome.getText();
			manipula.conectaBanco("jdbc:postgresql://localhost:5432/BD3","postgres","Seventeam4670");
			manipula.cadastraProva(name,id);
	
		}
						
	};
	/*
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
			
		
						
	};
	*/

}
