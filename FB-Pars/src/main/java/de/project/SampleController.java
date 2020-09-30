package de.project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class SampleController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
					
	}
	
	@FXML
	private Label db_conn_stat;
	
	@FXML
	private Button db_path_browseBtn;
	
	@FXML
	private Button db_connect_btn;
	
	@FXML
	private TextField db_path_textfield;
}
