package de.project;

import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.sun.media.jfxmedia.events.MetadataListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MainWindowController implements Initializable{

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		Connection DataBase = DataBase_Connector.getConnDB();
		
		 try {
			if( DataBase.isValid(0) == true) {
				 connStat.setText("DB Connection Status: Connected");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
	@FXML
	private Label connStat;
	
	@FXML
	private Button testBtn;

	@FXML
	private TextArea testTextArea;
	
	public void testBtnClick(ActionEvent event) {
		
		testTextArea.setText("Du hast geklickt");
	}
	
	
}
