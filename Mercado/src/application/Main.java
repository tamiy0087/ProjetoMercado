package application;
	
import java.sql.Connection;
import java.util.ArrayList;

import connectionFactory.ConnectionDatabase;
import dao.ClienteDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Cliente;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes = clienteDAO.read();
		
		for(int i = 0; i <clientes.size(); i++){
			cliente = clientes.get(i);
			
			System.out.print(cliente.getIdCliente() );
			System.out.print(" | | ");
			System.out.print(cliente.getNomeCliente());
			System.out.print(" | ");
			System.out.print(cliente.getCpfCliente());
			System.out.print(" | ");
			System.out.print(cliente.getDataNasc());
			System.out.print(" | ");
			System.out.print(cliente.getTelefone());
			System.out.print(" | ");
			System.out.print(cliente.getEmail());
			System.out.print(" | ");
			System.out.print(cliente.getEndereco());
			System.out.print(" ");
		}
		
		//cliente.setNomeCliente("Pedro Alvares");
		//cliente.setCpfCliente("77382392");
		//cliente.setDataNasc("1999-01-28");
		//cliente.setTelefone("63 84805632");
		//cliente.setEndereco("Rua Neblina, numero 9");
		//cliente.setEmail("pedro@gmail,com");
		
		//clienteDAO.create(cliente);
		
		launch(args);
	}
}
