
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.Resultset;

import de.project.Contact;
import de.project.DataBase_Connector;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class testController implements Initializable{
	
	
Connection DataBase = null;
ResultSet rs = null;

@FXML Button populate_Btn;
@FXML TableView<Contact> table1;
@FXML TableColumn<Contact, String> firstname; 
@FXML TableColumn<Contact, String> lastname; 
@FXML TableColumn<Contact, String> username; 
@FXML TableColumn<Contact, String> FbId;

	

	//Prüft initial verbindung zur Datenbank
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		firstname.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstname"));
		lastname.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastname"));
		username.setCellValueFactory(new PropertyValueFactory<Contact, String>("username"));
		FbId.setCellValueFactory(new PropertyValueFactory<Contact, String>("FbId"));
		
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DataBase = DriverManager.getConnection("jdbc:sqlite:G:\\Softwareprojekt\\Facebook\\001Testdaten_Grundlegendes\\ExtraktionGeorgSamsonG4\\Facebook Export\\threads_db2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
	}
		
	public ObservableList<Contact> getContacts() throws SQLException{
		
		ObservableList<Contact> contact = FXCollections.observableArrayList();
		
		// Itterate rows of Resultset
		while(rs.next()) {
			Contact person = new Contact(null, null, null, null);
				
			//Itterate Columns until ColumnCount reached
			for(int i=1; i<=rs.getMetaData().getColumnCount(); i+=4) {
								
				String fbid = rs.getString(i);
				String firstname = rs.getString(i+1);
				String lastname = rs.getString(i+2);
				String username = rs.getString(i+3);
				
				person.setFbId(fbid);
				person.setFirstname(firstname);
				person.setLastname(lastname);
				person.setUsername(username);
		
			}
			contact.add(person);
			System.out.println(contact.size());
		}
			
			

		return contact;
	
	}
	
public void populate_BtnClick(ActionEvent event) throws IOException, SQLException {
		
	//	DataBase = DataBase_Connector.getConnDB();
		
		Statement st = DataBase.createStatement();
		rs = st.executeQuery("SELECT user_key, first_name, last_name, username FROM thread_users" );

		table1.setItems(getContacts());

		
		ObservableList<Contact> contacts = table1.getItems();
		
		for( int i = 0; i<contacts.size();i++) {
			
			System.out.println(contacts.get(i).getFirstname() + " "+
								contacts.get(i).getLastname() + " "+
								contacts.get(i).getUsername() + " "+
								contacts.get(i).getFbId());
		
	
	}
	
}	
}
