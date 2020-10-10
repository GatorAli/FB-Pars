package fxmlController;

import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.sun.javafx.binding.SelectBinding.AsString;
import com.sun.media.jfxmedia.events.MetadataListener;

import de.project.DataBase_Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class MainWindowController implements Initializable{
	
	@FXML Label connStat;
	@FXML private Button testBtn;
	@FXML private TextArea testTextArea;
	@FXML private Tab contact_tab;
	@FXML private ContactsController contactsController;
	
	
	Connection DataBase = null;
	
	//Prüft initial verbindung zur Datenbank
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	
		this.DataBase = DataBase_Connector.getConnDB();
		
		
		 try {
			if( DataBase.isValid(0) == true) {
				 connStat.setText("DB Connection Status: Connected - to " + DataBase_Connector.getDbPath());
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	

	
	public void testBtnClick(ActionEvent event) throws SQLException {
		
		Statement st = DataBase.createStatement();
		ResultSet rs = st.executeQuery("SELECT text FROM messages WHERE _id=5" );
		
		testTextArea.setText("Query: SELECT text FROM messages WHERE _id=5" + "\n" + 
								"Ergebnis:"+ "\n" + rs.getString(1));
		}
	
	
	
	
	
}

	
	
	

