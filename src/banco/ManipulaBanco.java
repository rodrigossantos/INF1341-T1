package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class ManipulaBanco {

	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	private String createString;
	private Statement stmt;
	private String     nome;
	private int     anoNascimento;
	private String     patrocinio;
	private String     sexo;
	private String     modalidade;
	private int     distancia;
	
	public ManipulaBanco() {
		
	}
	
	public void conectaBanco(String url, String usr, String senha){
		
		this.url = url;
		this.usuario = usr;
		this.senha = senha;
		
		try {
			//TODO mudar para sql
			Class.forName("org.postgresql.Driver");

		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão realizada com sucesso.");

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
	}
	
	//Acionado ao clicar no botao adicionar na tela de cadastro
	/*
	public void insereCompetidor(String nome, int anoNasc, String patrocinio, String sexo,String modalidade, int distancia){
		System.out.println("Fue!");
		
	}
	*/
	
	//Acionado ao clicar no botao adicionar na tela de cadastro
		public void insereCompetidor(){
			System.out.println("Fue!");
			
		}
	
	public void cadastraSerie(){
		
	}
	
	public void computaSerie(){
		
	}
	
	//TODO não é void
	public void consutaCompetidor(){
		
	}
	
	//TODO não é void
	public void consultaTop3(){
		
	}

}
