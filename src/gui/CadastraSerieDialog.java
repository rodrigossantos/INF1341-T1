package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.ManipulaBanco;

public class CadastraSerieDialog extends JDialog{
	
	//TODO descobrir como converter JLabel para TimeStamp
	private JButton    btCadastraSerie;
	private JTextField insereTipo;
	private JTextField insereDia;
	private JTextField insereMes;
	private JTextField insereAno;
	
	private JTextField insereIdProva;
	private JLabel     tipo;
	private JLabel	   dataHora;
	private JLabel	   totPart;
	private JLabel	   partEfet;
	private JLabel	   idProva;
	Timestamp c = null;
	
	static ManipulaBanco manipula = new ManipulaBanco();
	

	public CadastraSerieDialog() {
		
		setLayout(null);
		
		insereTipo = new JTextField();
		insereTipo.setBounds(120, 100, 170, 30);
		this.add(insereTipo);
		
		tipo = new JLabel("Tipo");
		tipo.setBounds(80, 100, 50, 30);
		this.add(tipo);
		
		insereDia = new JTextField();
		insereDia.setBounds(120, 160, 170, 30);
		this.add(insereDia);
		
		dataHora = new JLabel("Data");
		dataHora.setBounds(40, 160, 120, 30);
		this.add(dataHora);
		
		/*
		insereMes = new JTextField();
		insereMes.setBounds(120, 220, 170, 30);
		this.add(insereMes);
		
		totPart = new JLabel("Mes");
		totPart.setBounds(35, 220, 120, 30);
		this.add(totPart);
		
		
		insereAno = new JTextField();
		insereAno.setBounds(120, 280, 170, 30);
		this.add(insereAno);
		
		partEfet = new JLabel("Ano");
		partEfet.setBounds(40, 280, 120, 30);
		this.add(partEfet);
		*/
		
		insereIdProva = new JTextField();
		insereIdProva.setBounds(120, 340, 170, 30);
		this.add(insereIdProva);
		
		idProva = new JLabel("Id Prova");
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
				//Date data = null;
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				//SimpleDateFormat sf = new SimpleDateFormat();
				
				String type = insereTipo.getText();
				String date = insereDia.getText();
				java.sql.Date data = null;
				try {
					data = new java.sql.Date(df.parse(date).getTime());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//String mes = insereMes.getText();
				//Timestamp datehour = null;
				//data = df.parse(date);
				
				//int dia = Integer.parseInt(insereDia.getText());
				//int mes = Integer.parseInt(insereMes.getText());
				//int ano = Integer.parseInt(insereAno.getText());
				int id = Integer.parseInt(insereIdProva.getText());
				//int tot = Integer.parseInt(totPart.getText());
				//int efet = Integer.parseInt(partEfet.getText());
				//c.set(ano, mes, dia, 16, 00);
				
				manipula.cadastraSerie2(type,id);
			}
							
		};
	
   
}
