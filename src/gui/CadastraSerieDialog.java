package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.ManipulaBanco;

public class CadastraSerieDialog extends JDialog{
	
	//TODO descobrir como converter JLabel para TimeStamp
	private JButton    btCadastraSerie;
	private JTextField insereTipo;
	private JTextField insereDataHora;
	private JTextField insereTotPart;
	private JTextField inserePartEfet;
	private JTextField insereIdProva;
	private JLabel     tipo;
	private JLabel	   dataHora;
	private JLabel	   totPart;
	private JLabel	   partEfet;
	private JLabel	   idProva;
	static ManipulaBanco manipula = new ManipulaBanco();
	

	public CadastraSerieDialog() {
		
		setLayout(null);
		
		insereTipo = new JTextField();
		insereTipo.setBounds(120, 100, 170, 30);
		this.add(insereTipo);
		
		tipo = new JLabel("Tipo");
		tipo.setBounds(80, 100, 50, 30);
		this.add(tipo);
		
		insereDataHora = new JTextField();
		insereDataHora.setBounds(120, 160, 170, 30);
		this.add(insereDataHora);
		
		dataHora = new JLabel("Data/Hora");
		dataHora.setBounds(40, 160, 120, 30);
		this.add(dataHora);
		
		insereTotPart = new JTextField();
		insereTotPart.setBounds(120, 220, 170, 30);
		this.add(insereTotPart);
		
		totPart = new JLabel("Patrocinador");
		totPart.setBounds(35, 220, 120, 30);
		this.add(totPart);
		
		inserePartEfet = new JTextField();
		inserePartEfet.setBounds(120, 280, 170, 30);
		this.add(inserePartEfet);
		
		partEfet = new JLabel("Sexo");
		partEfet.setBounds(40, 280, 120, 30);
		this.add(partEfet);
		
		insereIdProva = new JTextField();
		insereIdProva.setBounds(120, 340, 170, 30);
		this.add(insereIdProva);
		
		idProva = new JLabel("Modalidade");
		idProva.setBounds(40, 340, 120, 30);
		this.add(idProva);
		
		btCadastraSerie = new JButton("Cadastrar");
		btCadastraSerie.addActionListener(btCadastraSerieListener);
		btCadastraSerie.setBounds(120, 400, 170, 30);
		this.add(btCadastraSerie);
		
		this.setTitle("Tela de cadastro de series");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
		
	}
	
	//Listener que cadastra series ao clicar
	private ActionListener btCadastraSerieListener = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Foi Ka!");
				/*
				String type = String.valueOf(tipo);
				//Timestamp dh = Timestamp.valueOf(dateTime);
				String dh = String.valueOf(dataHora);
				int tot = Integer.parseInt(totPart.getText());
				int efet = Integer.parseInt(partEfet.getText());
				int id = Integer.parseInt(idProva.getText());
				*/
				
				//manipula.cadastraSerie(type,dh,tot,efet,id);
			}
							
		};
	
   
}
