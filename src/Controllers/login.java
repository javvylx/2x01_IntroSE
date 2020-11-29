package Controllers;
import entities.Lecturer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entities.Component;

public class login{
	String user;
	
	public String getUser() {
		return user;
	}

	public login() {
		super();
		// TODO Auto-generated constructor stub
	}



	@FXML
	private AnchorPane mainStage;

    @FXML
    private Pane loginPane;

    @FXML
    private TextField txtfieldUsername;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    private Button btnLogin;

    Lecturer lecturer = new Lecturer();

	public void loginMethod(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnLogin) {
			Boolean exist = false;
			String username = txtfieldUsername.getText();
			Lecturer l = new Lecturer();
			ResultSet rs = null;
			PreparedStatement pstmt;
			MySQLConnection db = new MySQLConnection();
			String dbQuery;
			// Step 1 - connect to database
			db.getConnection();
			// step 2 - declare the SQL statement
			dbQuery = "SELECT * FROM 2x01_db.lecturer WHERE lect_id= '"+username+ "';";
			// step 3 - using DBControlle readRequest method
			pstmt = db.getPreparedStatement(dbQuery);
			try {
				rs = pstmt.executeQuery();
				if (rs.next()) {
					Lecturer lm = new Lecturer();
					l = lm.convertToLecturer(rs);
					exist = true;
				}
			} catch (Exception e) {
			}
			// step 4 - close connection
			db.terminate();
			if (exist == true) {
				Parent dashboard;
				try {
					dashboard = FXMLLoader.load(getClass().getResource("/Templates/dashboard.fxml"));
					//dashboard = FXMLLoader.load(getClass().getResource("/Templates/dashboard_student.fxml"));
					this.user = l.getLect_fname()+ " " + l.getLect_lname();
					Scene dashboardScene = new Scene(dashboard);
					Stage dashboardStage = (Stage) ((Node) actionEvent.getSource()).getScene()
							.getWindow();
					dashboardStage.setScene(dashboardScene);
					dashboardStage.show();
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				Stage newStage = new Stage();
				VBox comp = new VBox();
				Text error = new Text("Incorrect information!");
				comp.getChildren().add(error);

				Scene stageScene = new Scene(comp, 300, 300);
				newStage.setScene(stageScene);
				newStage.show();
			}
		}
	}
}
