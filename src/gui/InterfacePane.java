package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.shape.Line;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.sun.javafx.geom.Line2D;



public class InterfacePane extends JPanel {
	
	private JButton    btCompetidor;//mostra tabela com cadastrados.pode editar(?)
	private JButton    btEspectador;
	private JLabel     areaCompetidorEspectador;
	private cadastraCompetidorDialog cadastraInfoDialog = new cadastraCompetidorDialog();
	private ListaInfoCompetidoresDialog listaInfoDialog = new ListaInfoCompetidoresDialog();
	
	
	/*
	private JTextField insereNome;
	private JTextField insereAnoNascimento;
	private JTextField inserePatrocinio;
	private JTextField insereSexo;
	private JTextField insereModalidade;
	private JTextField insereDistancia;
	private JTextField insereCompetidor;
	private JLabel     nome;
	private JLabel     anoNascimento;
	private JLabel     patrocinio;
	private JLabel     sexo;
	private JLabel     modalidade;
	private JLabel     distancia;
	private JLabel	   competidor;
	private JButton    btCadastrar;
	private JButton    btCadastrados;//mostra tabela com cadastrados.pode editar(?)
	private JButton    btListarTop3;
	
	private cadastraCompetidorDialog cadastraInfoDialog = new cadastraCompetidorDialog();
	private ListaInfoCompetidoresDialog listaInfoDialog = new ListaInfoCompetidoresDialog();
	
    */
	public InterfacePane() {
		
		setLayout(null);
		

		btCompetidor = new JButton("Sou Competidor");
		btCompetidor.setBounds(200, 350, 145, 30);
		btCompetidor.addActionListener(btCompetidorListener);
		this.add(btCompetidor);
		
		btEspectador = new JButton("Sou Espectador");
		btEspectador.addActionListener(btEspectadorListener);
		btEspectador.setBounds(200, 410, 145, 30);
		this.add(btEspectador);
		
		areaCompetidorEspectador = new JLabel("Area de Competidores/Espectadores");
		areaCompetidorEspectador.setBounds(80, 100, 250, 30);
		this.add(areaCompetidorEspectador);
		
		
		/*
		insereNome = new JTextField();
		insereNome.setBounds(120, 100, 170, 30);
		this.add(insereNome);
		
		nome = new JLabel("Nome ");
		nome.setBounds(80, 100, 50, 30);
		this.add(nome);
		
		insereAnoNascimento = new JTextField();
		insereAnoNascimento.setBounds(120, 160, 170, 30);
		this.add(insereAnoNascimento);
		
		anoNascimento = new JLabel("Ano de Nascimento");
		anoNascimento.setBounds(0, 160, 120, 30);
		this.add(anoNascimento);
		
		inserePatrocinio = new JTextField();
		inserePatrocinio.setBounds(120, 220, 170, 30);
		this.add(inserePatrocinio);
		
		patrocinio = new JLabel("Patrocinador");
		patrocinio.setBounds(35, 220, 120, 30);
		this.add(patrocinio);
		
		insereSexo = new JTextField();
		insereSexo.setBounds(120, 280, 170, 30);
		this.add(insereSexo);
		
		sexo = new JLabel("Sexo");
		sexo.setBounds(40, 280, 120, 30);
		this.add(sexo);
		
		insereModalidade = new JTextField();
		insereModalidade.setBounds(120, 340, 170, 30);
		this.add(insereModalidade);
		
		modalidade = new JLabel("Modalidade");
		modalidade.setBounds(40, 340, 120, 30);
		this.add(modalidade);
		
		insereDistancia = new JTextField();
		insereDistancia.setBounds(120, 400, 170, 30);
		this.add(insereDistancia);
		
		distancia = new JLabel("Distancia");
		distancia.setBounds(40, 400, 120, 30);
		this.add(distancia);
		
		insereCompetidor = new JTextField();
		insereCompetidor.setBounds(450, 100, 170, 30);
		this.add(insereCompetidor);
		
		competidor = new JLabel("Competidor ");
		competidor.setBounds(380, 100, 70, 30);
		this.add(competidor);
		
		btCadastrar = new JButton("Cadastar");
		btCadastrar.setBounds(40, 460, 90, 30);
		btCadastrar.addActionListener(btCadastrarListener);
		this.add(btCadastrar);
		
		
		btListarTop3 = new JButton("Listar Top 3");
		btListarTop3.addActionListener(btTop3Listener);
		btListarTop3.setBounds(400, 150, 145, 30);
		this.add(btListarTop3);
		
		btCadastrados = new JButton("Listar cadastrados");
		btCadastrados.addActionListener(btCadastradosListener);
		btCadastrados.setBounds(150, 460, 145, 30);
		this.add(btCadastrados);
		*/
		
		
		
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        //Line2D lin = new Line2D(20, 40, 850, 40);
        g2.drawLine(700, 0, 700, 800);//x1,y1,x2,y2
    }
	
	
	private ActionListener btCompetidorListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Foi Ka!");
			//CadastroPane cp = new CadastroPane();
			//cp.setVisible(true);
			if(cadastraInfoDialog == null)
			{
				cadastraInfoDialog = new cadastraCompetidorDialog();
			}
			
			cadastraInfoDialog.setLocationRelativeTo(InterfacePane.this);
			cadastraInfoDialog.setVisible(true);
			
		}
						
	};
	

	private ActionListener btEspectadorListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			 //System.out.println("Foi tbm Ka!");
			if(listaInfoDialog == null)
			{
				listaInfoDialog = new ListaInfoCompetidoresDialog();
			}
			
			listaInfoDialog.setLocationRelativeTo(InterfacePane.this);
			listaInfoDialog.setVisible(true);
		}
	};

/*	
private ActionListener btTop3Listener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			//System.out.println("Foi Ka!");
		}
						
	};
*/

	
}
