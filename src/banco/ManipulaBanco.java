package banco;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.swing.JLabel;

public class ManipulaBanco {

	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	private String insereDados;
	private Statement searchParticipante;
	//private PreparedStatement searchParticipante;
	private PreparedStatement insertParticipante;
	private PreparedStatement insertProvaParticipante;
	private PreparedStatement insertSerie;
	private PreparedStatement searchTop3;
	private String     nome;
	private int     anoNascimento;
	private String     patrocinio;
	private String     sexo;
	private String     modalidade;
	private int     distancia;
	private ResultSet rs;
	private ResultSet rsTop3;
	
	String createProcedureExibeComp = "create procedure SHOW_COMPETIDOR " +
			"as " +
			"select SERIE_PARTICIPANTE.NOME_PART, SERIE_PARTICIPANTE.DATA_HORA, SERIE.TIPO" +
			"from SERIE_PARTICIPANTE , SERIE " +
			"where SERIE_PARTICIPANTE.DATA_HORA = SERIE.DATA_HORA ";
	
	String createProcedureTop3 = "create procedure SHOW_TOP3" +
	        "as "+
			"select SERIE_PARTICIPANTE.NOME_PART, SERIE_PARTICIPANTE.DATA_HORA, SERIE_PARTICIPANTE.TEMPO " +
	        "from SERIE_PARTICIPANTE " +
			"where SERIE_PARTICIPANTE.DATA_HORA = SERIE.DATA_HORA AND SERIE_PARTICIPANTE.NOME_PART = PARTICIPANTE_PROVA.NOME_PART AND PARTICIPANTE_PROVA.ID_PROVA = PROVA.ID_PROVA " +
	        "order_by TEMPO";
	
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
	
	/*
	public void encerraConexão() throws SQLException{
		stmt.close();
		con.close();
	}
	*/
	
	//Acionado ao clicar no botao adicionar na tela de cadastro
	/*
	public void insereCompetidor(String nome, int anoNasc, String patrocinio, String sexo,String modalidade, int distancia){
		System.out.println("Fue!");
		
	}
	*/
	
	//Acionado ao clicar no botao adicionar na tela de cadastro
	public void insereCompetidor(String nome, int anoNasc, String patrocinio, String sexo){
			System.out.println("Fue!");
			try{
					
				insertParticipante = con.prepareStatement("INSERT INTO PARTICIPANTE VALUES(?,?,?,?)");
				insertParticipante.setString(1, nome);
				insertParticipante.setInt(2, anoNasc);
				insertParticipante.setString(3, sexo);
				insertParticipante.setString(4, patrocinio);
							 
				insertParticipante.close();
				con.close();
				
				/*	
				insertParticipante = con.createStatement();	
				insertParticipante.executeUpdate("INSERT INTO PARTICIPANTE VALUES(1031,'Chevrolet','Chevette','92',7200.00,'EUA')");
				insertParticipante.executeUpdate("INSERT INTO PARTICIPANTE VALUES(1031,'Citroen','Ax','95',25000.00,'Franca')");
				insertParticipante.executeUpdate("INSERT INTO PARTICIPANTE VALUES(1022, 'Ford', 'Del Rey', '85', 4800.00, 'EUA')");
				insertParticipante.executeUpdate("INSERT INTO PARTICIPANTE VALUES(1050, 'Chevrolet', 'Chevette', '93', 7900.00,'EUA')");
				*/
				
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
			
			
	}
	
	public void cadastraProva(String nome, int id){
		System.out.println("Fue!");
		
		try{
			
			insertProvaParticipante = con.prepareStatement("INSERT INTO PARTICIPANTE_PROVA VALUES(?,?)");
			insertProvaParticipante.setString(1, nome);
			insertParticipante.setInt(2, id);
						 
			insertParticipante.close();
			con.close();
			
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
	
	public void cadastraSerie(String tipo, Timestamp dataHora, int totalPartic, int totalParticEfet, int idProva) {
		System.out.println("Fue!");
		
		try {
		insertSerie = con.prepareStatement("INSERT INTO SERIE VALUES(?,?,?,?,?)");
		insertSerie.setString(1, tipo);	
		insertSerie.setTimestamp(2, dataHora);
		insertSerie.setInt(3, totalPartic);
		insertSerie.setInt(4, totalParticEfet);
		insertSerie.setInt(5,idProva);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void computaSerie(){
		System.out.println("Fue!");
	}
	
	public ResultSet consultaCompetidor(String nomePart){
		System.out.println("Fue!");
						
				try {
					// Uso de Stored Procedure
					String searchParticipante = "{call SHOW_PARTICIPANTE(?)}";
					CallableStatement cs = con.prepareCall(searchParticipante);
					cs.setString(1, nomePart);
					rs = cs.executeQuery();
					//searchParticipante = con.createStatement();
					//searchParticipante.executeUpdate(createProcedure);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
	}
	
	public ResultSet consultaTop3(){
		System.out.println("Fue!");
		
		try {
			CallableStatement top3 = con.prepareCall("{call SHOW_TOP3}");
			rsTop3 = top3.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsTop3;
				
		
	}

}
