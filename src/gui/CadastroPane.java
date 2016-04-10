package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroPane extends JPanel {
	
	private JTextField insereNome;
	private JTextField insereAnoNascimento;
	private JTextField inserePatrocinio;
	private JTextField insereSexo;
	private JTextField insereModalidade;
	private JTextField insereDistancia;
	private JLabel     nome;
	private JLabel     anoNascimento;
	private JLabel     patrocinio;
	private JLabel     sexo;
	private JLabel     modalidade;
	private JLabel     distancia;


	public CadastroPane() {
		
		setLayout(null);
		
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
	}

}
