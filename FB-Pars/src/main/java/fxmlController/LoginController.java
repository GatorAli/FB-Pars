package fxmlController;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import de.project.DataBase_Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;



public class LoginController implements Initializable {

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
					
	}
	
	@FXML
	private Label db_conn_stat;
	
	@FXML
	private Button db_path_browseBtn;
	
	@FXML
	public Button db_connect_btn;
	
	@FXML
	private TextField db_path_textfield;

	
	
	//auswahlmöglichkeit um Datenbank im Dateisystem zu wählen
	
	@FXML
	private void db_path_browseBtnClick(ActionEvent event) {
			FileChooser fc = new FileChooser();
			fc.setTitle("Select Database");
			Window primaryStage = null;
			File initPath = new File("G:\\Softwareprojekt\\Facebook\\001Testdaten_Grundlegendes\\ExtraktionGeorgSamsonG4\\Facebook Export");
			fc.setInitialDirectory(initPath);
			File file = fc.showOpenDialog(primaryStage);
			
			
			db_path_textfield.setText(file.getAbsolutePath());
			DataBase_Connector.setDbPath(file.getAbsolutePath());
			
	}
	
	
	@FXML
	private void db_connect_btnClick(ActionEvent event) {
		
		//Stellt Verbindung zur gewählten Datenbank her
		DataBase_Connector.connectDB();
		
		// Wechselt die Szene  von Login auf Main
		try {
		Parent MainWindow = FXMLLoader.load(getClass().getResource("/fxmlController/MainWindow.fxml"));
		Scene MainWindowScene = new Scene(MainWindow);
		Stage MainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		MainStage.setScene(MainWindowScene);
		MainStage.setTitle("MainWindow");
		MainStage.show();
		
		
		
		} catch (Exception e){
			System.out.println("Szene nicht anzeigbar");
			e.printStackTrace();
		}
	
	}
		
	
}
	

