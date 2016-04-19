package principal;

import java.sql.SQLException;

import gui.InterfaceFrame;
import banco.ManipulaBanco;
public class Main {
	static ManipulaBanco manipula = new ManipulaBanco();
	
	public static void main(String[] args) {
		manipula.conectaBanco("jdbc:postgresql://localhost:5432/BD3","postgres","Seventeam4670");
		try {
			manipula.createProcedureShowCompetidor();
			manipula.createProcedureShowTop3();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InterfaceFrame f = new InterfaceFrame("Tela de Cadastro");
		f.setVisible(true);

	}

}
