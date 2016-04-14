package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import banco.ManipulaBanco;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastraCompetidorProvaDialog extends JDialog{
	
	private JButton    btDadosPessoais;
	private JButton    btProvas;
	private CadastraCompetidorDialog cadastraInfoDialog = new CadastraCompetidorDialog();
	private CadastraProvaDialog cadastraProvaDialog = new CadastraProvaDialog();
		
	static ManipulaBanco manipula = new ManipulaBanco();

	public CadastraCompetidorProvaDialog() {
		
		setLayout(null);	
		
		btDadosPessoais = new JButton("Cadastar dados pessoais");
		btDadosPessoais.setBounds(40, 160, 180, 30);
		btDadosPessoais.addActionListener(btCadastraInfoListener);
		this.add(btDadosPessoais);
				
		
		btProvas = new JButton("Cadastrar Provas");
		btProvas.addActionListener(btCadastraProvasListener);
		btProvas.setBounds(40, 200, 180, 30);
		this.add(btProvas);
		
		this.setTitle("Tela de Cadastro");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
	}
	
	//Listener que abre a janela de cadastrar competidor ao clicar 
    private ActionListener btCadastraInfoListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			//System.out.println("Foi Ka!");
			if(cadastraInfoDialog == null)
			{
				cadastraInfoDialog = new CadastraCompetidorDialog();
			}
			
			cadastraInfoDialog.setLocationRelativeTo(CadastraCompetidorProvaDialog.this);
			cadastraInfoDialog.setVisible(true);
		}
						
	};
	
	//Listener que abre a janela de cadastrar prova ao clicar
	private ActionListener btCadastraProvasListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			//System.out.println("Foi Ka!");
			if(cadastraProvaDialog == null)
			{
				cadastraProvaDialog = new CadastraProvaDialog();
			}
			
			cadastraProvaDialog.setLocationRelativeTo(CadastraCompetidorProvaDialog.this);
			cadastraProvaDialog.setVisible(true);
		}
						
	};
	

}
