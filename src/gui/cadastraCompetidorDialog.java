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

public class cadastraCompetidorDialog extends JDialog{
	
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
	
	
	
	static ManipulaBanco manipula = new ManipulaBanco();

	public cadastraCompetidorDialog() {
		
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
		
		btCadastrar = new JButton("Cadastar");
		btCadastrar.setBounds(40, 460, 90, 30);
		btCadastrar.addActionListener(btCadastrarListener);
		this.add(btCadastrar);
				
		
		btCadastrados = new JButton("Listar cadastrados");
		//btCadastrados.addActionListener(btCadastradosListener);
		btCadastrados.setBounds(150, 460, 145, 30);
		this.add(btCadastrados);
		

		//super();
		this.setTitle("Inserir Competidores");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
	}
	
	private ActionListener btCadastrarListener = new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Foi Ka!");
			//TODO ao clicar no botao inserir os dados do competidor no banco
			manipula.insereCompetidor();
		}
						
	};

}
