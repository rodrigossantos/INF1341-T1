package banco;


import java.sql.*;

import javax.swing.JLabel;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class ManipulaBanco {

	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	private String insereDados;
	//private Statement searchParticipante;
	private PreparedStatement searchParticipante;
	private PreparedStatement insertParticipante;
	private PreparedStatement insertProvaParticipante;
	private PreparedStatement insertSerie;
	private PreparedStatement searchTop3;
	private String     name;
	private int ident;
	private int     anoNascimento;
	private String     patrocinio;
	private String     sexo;
	private String     modalidade;
	private int     distancia;
	private ResultSet rs;
	private ResultSet result;
	private ResultSet rsTop3;
	
	String createProcedureExibeComp = "create function SHOW_COMPETIDOR " +
			"as " +
			"select SERIE_PARTICIPANTE.NOME_PARTIC_SP, SERIE_PARTICIPANTE.DATA_HORA_SP, SERIE.TIPO " +
			"from SERIE_PARTICIPANTE, SERIE, participante_prova,PROVA " +
			"where where SERIE_PARTICIPANTE.DATA_HORA_SP = SERIE.DATA_HORA ";
	
	String createProcedureTop3 = "create function SHOW_TOP3" +
	        "as "+
			"select SERIE_PARTICIPANTE.NOME_PARTIC_SP, serie_participante.data_hora_sp, serie_participante.tempo " +
	        "SERIE_PARTICIPANTE, SERIE, participante_prova,PROVA " +
			"SERIE_PARTICIPANTE.DATA_HORA_SP = SERIE.DATA_HORA AND SERIE_PARTICIPANTE.NOME_PARTIC_SP = PARTICIPANTE_PROVA.NOME_PARTIC_PP AND PARTICIPANTE_PROVA.ID_PROVA_PP = PROVA.ID_PROVA " +	       
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
	
	public void createProcedureShowTop3() throws SQLException {

		con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/BD3", "postgres",
				"Seventeam4670");

		// String createProcedure = null;
		// String queryDrop = "DROP PROCEDURE IF EXISTS SHOW_TOP3";

		String createProcedureTop3 = "create procedure show_top3 "
				+ "as "
				+ "select SERIE_PARTICIPANTE.NOME_PARTIC_SP, serie_participante.data_hora_sp, serie_participante.tempo "
				+ "from SERIE_PARTICIPANTE, SERIE, participante_prova,PROVA "
				+ "where SERIE_PARTICIPANTE.DATA_HORA_SP = SERIE.DATA_HORA AND SERIE_PARTICIPANTE.NOME_PARTIC_SP = PARTICIPANTE_PROVA.NOME_PARTIC_PP AND PARTICIPANTE_PROVA.ID_PROVA_PP = PROVA.ID_PROVA "
				+ "order_by TEMPO";
		
		

		Statement stmt = null;
		// Statement stmtDrop = null;

		/*
		 * try { System.out.println("Calling DROP PROCEDURE"); stmtDrop =
		 * con.createStatement(); stmtDrop.execute(queryDrop); } catch
		 * (SQLException ex) { System.err.println("SQLException: " +
		 * ex.getMessage()); } finally { if (stmtDrop != null) {
		 * stmtDrop.close(); } }
		 */

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createProcedureTop3);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
				con.close();
			}
		}
	}
	
	public void createProcedureShowCompetidor() throws SQLException {

		con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/BD3", "postgres",
				"Seventeam4670");

		// String createProcedure = null;
		// String queryDrop = "DROP PROCEDURE IF EXISTS SHOW_TOP3";

		String createProcedureExibeComp = "create procedure SHOW_COMPETIDOR "
				+ "as "
				+ "select SERIE_PARTICIPANTE.NOME_PARTIC_SP, SERIE_PARTICIPANTE.DATA_HORA_SP, SERIE.TIPO "
				+ "from SERIE_PARTICIPANTE, SERIE, participante_prova,PROVA "
				+ "where SERIE_PARTICIPANTE.DATA_HORA_SP = SERIE.DATA_HORA AND PARTICIPANTE_PROVA.NOME_PARTIC_PP = ?";
				

		Statement stmt = null;
		// Statement stmtDrop = null;

		/*
		 * try { System.out.println("Calling DROP PROCEDURE"); stmtDrop =
		 * con.createStatement(); stmtDrop.execute(queryDrop); } catch
		 * (SQLException ex) { System.err.println("SQLException: " +
		 * ex.getMessage()); } finally { if (stmtDrop != null) {
		 * stmtDrop.close(); } }
		 */

		try {
			stmt = con.createStatement();
			stmt.executeUpdate(createProcedureExibeComp);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
				con.close();
			}
		}

	}
	
	
	// Acionado ao clicar no botao adicionar na tela de cadastro
	public void insereCompetidor(String nome, int anoNasc, String patrocinio,
			String sexo) {
		System.out.println("Fue!");
		try {

			insertParticipante = con
					.prepareStatement("INSERT INTO PARTICIPANTE VALUES (?,?,?,?)");
			insertParticipante.setString(1, nome);
			insertParticipante.setInt(2, anoNasc);
			insertParticipante.setString(3, sexo);
			insertParticipante.setString(4, patrocinio);

			insertParticipante.executeUpdate();

			insertParticipante.close();
			con.close();


		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}

	public void cadastraProva(String nome, int id) {
		System.out.println("Fue!");

		try {

			insertProvaParticipante = con
					.prepareStatement("INSERT INTO PARTICIPANTE_PROVA VALUES(?,?)");
			insertProvaParticipante.setString(1, nome);
			insertProvaParticipante.setInt(2, id);
			insertProvaParticipante.executeUpdate();

			insertProvaParticipante.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

	public ResultSet listaParticipante(String nome) {
		System.out.println("Fue!");
		// Statement st = null;

		String createProcedureExibeComp = "select SERIE_PARTICIPANTE.NOME_PARTIC_SP, SERIE_PARTICIPANTE.DATA_HORA_SP, SERIE.TIPO "
				+ "from SERIE_PARTICIPANTE , SERIE "
				+ "where SERIE_PARTICIPANTE.DATA_HORA_SP = SERIE.DATA_HORA ";

		String teste = "select PARTICIPANTE_PROVA.NOME_PARTIC_PP "
				+ "from PARTICIPANTE_PROVA "
				+ "where PARTICIPANTE_PROVA.NOME_PARTIC_PP = ? ";

		try {

			// st = con.createStatement();
			// searchParticipante =
			// con.prepareStatement("INSERT INTO PARTICIPANTE_PROVA VALUES(?,?)");
			searchParticipante = con.prepareStatement(teste);
			searchParticipante.setString(1, nome);
			// insertProvaParticipante.setInt(2, id);
			result = searchParticipante.executeQuery();
			searchParticipante = con.prepareStatement(teste);
			searchParticipante.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return result;
	}
	
	public ResultSet listarTop3() throws SQLException {

		String createListarTop3 = "select SERIE_PARTICIPANTE.NOME_PARTIC_SP, serie_participante.data_hora_sp, serie_participante.tempo "
				+ "from SERIE_PARTICIPANTE, SERIE, participante_prova,PROVA "
				+ "where  SERIE_PARTICIPANTE.DATA_HORA_SP = SERIE.DATA_HORA AND SERIE_PARTICIPANTE.NOME_PARTIC_SP = PARTICIPANTE_PROVA.NOME_PARTIC_PP AND PARTICIPANTE_PROVA.ID_PROVA_PP = PROVA.ID_PROVA "
				+ "order by tempo";

		Statement stmt = null;
		ResultSet res;
		stmt = con.createStatement();
		res = stmt.executeQuery(createListarTop3);
		return res;

	}

	public ResultSet listaParticipante2(int nome){
		System.out.println("Fue!");
		//Statement st = null;
		
		String createProcedureExibeComp = "select SERIE_PARTICIPANTE.NOME_PARTIC_SP, SERIE_PARTICIPANTE.DATA_HORA_SP, SERIE.TIPO " +
				"from SERIE_PARTICIPANTE , SERIE " +
				"where SERIE_PARTICIPANTE.DATA_HORA_SP = SERIE.DATA_HORA ";
		
		String teste = "select PARTICIPANTE_PROVA.NOME_PARTIC_PP " +
				"from PARTICIPANTE_PROVA " +
				"where PARTICIPANTE_PROVA.ID_PROVA_PP = ? ";
		
		
		
		try{
			
			//st = con.createStatement();
			//searchParticipante = con.prepareStatement("INSERT INTO PARTICIPANTE_PROVA VALUES(?,?)");
			searchParticipante = con.prepareStatement(teste);
			searchParticipante.setInt(1, nome);
			//insertProvaParticipante.setInt(2, id);
			result = searchParticipante.executeQuery();
			searchParticipante = con.prepareStatement(teste);	 
			searchParticipante.close();
			con.close();
			
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return result;
	}
	
	public void cadastraSerie(String tipo, Timestamp dataHora,int idProva) {
		System.out.println("Fue!");
		
		try {
		insertSerie = con.prepareStatement("INSERT INTO SERIE VALUES(?,?,?)");
		insertSerie.setString(1, tipo);
		//insertSerie.setString(2, dataHora);
		insertSerie.setTimestamp(2, dataHora);
		//insertSerie.setInt(3, totalPartic);
		//insertSerie.setInt(4, totalParticEfet);
		insertSerie.setInt(5,idProva);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cadastraSerie2(String tipo,int idProva) {
		System.out.println("Fue!");
		//insertParticipante = con.prepareStatement("INSERT INTO PARTICIPANTE VALUES (?,?,?)");
		
		try {
		insertSerie = con.prepareStatement("INSERT INTO SERIES VALUES(?,?)");
		insertSerie.setString(1, tipo);
		//insertSerie.setDate(2,new Date (data));
		insertSerie.setInt(2,idProva);
		
		insertSerie.executeUpdate();
		//insertSerie.set
		insertSerie.close();
		con.close();

		//insertSerie.setString(2, dataHora);
		//insertSerie.setInt(3, totalPartic);
		//insertSerie.setInt(4, totalParticEfet);
		
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
