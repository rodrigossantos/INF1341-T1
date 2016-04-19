package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.ManipulaBanco;

public class ListaInfoCompetidoresDialog extends JDialog {
	
	private JTextField insereCompetidor;
	private JLabel	   competidor;
	private JButton btListarTop3;
	private JButton btListaCompetidor;
	private ResultSetMetaData rsmd;
	private ResultSetMetaData rsmdcompetidor;
	private ResultSet resComp;
	private ResultSet resTop3;
	static ManipulaBanco manipula = new ManipulaBanco();
	boolean consulta = true;
	public ListaInfoCompetidoresDialog() {
		
		setLayout(null);
		
		insereCompetidor = new JTextField();
		insereCompetidor.setBounds(390, 100, 170, 30);
		this.add(insereCompetidor);
		
		competidor = new JLabel("Competidor ");
		competidor.setBounds(320, 100, 70, 30);
		this.add(competidor);
		
		btListarTop3 = new JButton("Listar Top 3");
		btListarTop3.addActionListener(btTop3Listener);
		btListarTop3.setBounds(400, 150, 145, 30);
		this.add(btListarTop3);
		
		btListaCompetidor = new JButton("Procurar");
		btListaCompetidor.addActionListener(btLIstaCompetidorListener);
		btListaCompetidor.setBounds(590, 100, 145, 30);
		this.add(btListaCompetidor);
		
		this.setTitle("Busca Competidores");
		this.setModal(true);
		this.setPreferredSize(new Dimension(800, 600));
		this.setResizable(false);	
		this.pack();
	}
	/*
    private ActionListener btLIstaCompetidorListener = new ActionListener(){
    	
		@Override
		public void actionPerformed(ActionEvent e){
			
			manipula.conectaBanco("jdbc:postgresql://localhost:5432/BD3","postgres","Seventeam4670");
			String comp = String.valueOf(insereCompetidor);
			//resComp = manipula.consultaCompetidor(comp);	
			resComp = manipula.listaParticipante(comp);
			
			try {
				rsmd = resComp.getMetaData();
				int numberOfColumns = rsmd.getColumnCount();
				int rowCount = 1;
				while (resComp.next()) {
					System.out.println("Row " + rowCount + ":  ");
					for (int i = 1; i <= numberOfColumns; i++) {
						System.out.print("   Column " + i + ":  ");
						System.out.println(resComp.getString(i));
					}
					System.out.println("");
					rowCount++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
						
	};
	
	*/
	private ActionListener btLIstaCompetidorListener = new ActionListener(){
    	//TODO exibir os dados(console?, tabela?)
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Foi Ka!");
			manipula.conectaBanco("jdbc:postgresql://localhost:5432/BD3","postgres","Seventeam4670");
			int comp = Integer.parseInt(insereCompetidor.getText());
			//resComp = manipula.consultaCompetidor(comp);	
			resComp = manipula.listaParticipante2(comp);
			
			try {
				rsmd = resComp.getMetaData();
				int numberOfColumns = rsmd.getColumnCount();
				int rowCount = 1;
				while (resComp.next()) {
					System.out.println("Row " + rowCount + ":  ");
					for (int i = 1; i <= numberOfColumns; i++) {
						System.out.print("   Column " + i + ":  ");
						System.out.println(resComp.getString(i));
					}
					System.out.println("");
					rowCount++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
						
	};
	
	 private ActionListener btTop3Listener = new ActionListener(){
			//TODO exibir os dados(console?, tabela?)
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Foi Ka!");
				manipula.conectaBanco("jdbc:postgresql://localhost:5432/BD3","postgres","Seventeam4670");
				try {
					resTop3 = manipula.listarTop3();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					rsmdcompetidor = resTop3.getMetaData();
					int numberOfColumns = rsmdcompetidor.getColumnCount();
					int rowCount = 1;
					while (resTop3.next()) {
						consulta = false;
						System.out.println("Row " + rowCount + ":  ");
						for (int i = 1; i <= numberOfColumns; i++) {
							System.out.print("   Column " + i + ":  ");
							System.out.println(resTop3.getString(i));
						}
						System.out.println("");
						rowCount++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   
			}
							
		};

}
