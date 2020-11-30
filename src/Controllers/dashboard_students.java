package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entities.Component;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class dashboard_students implements Initializable {

    @FXML
    private AnchorPane mainStage;

    @FXML
    private Pane dashboardPane;

    @FXML
    private Pane lViewStudentsPane;

    @FXML
    private Pane lManageCPane;

    @FXML
    private Button btnAssWeightage;

    @FXML
    private VBox componentVB;

    @FXML
    private Pane lHomePagePane;

    @FXML
    private Button welcomeTxt;

    @FXML
    private Button btnViewGrades;

    @FXML
    private Button btnSignOut;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String studentName = "Student A"; //change this to get dynamically
		welcomeTxt.setText(welcomeTxt.getText()+ studentName);
	}

    @FXML
    void navBar(ActionEvent actionEvent) {
    	if (actionEvent.getSource() == btnViewGrades) {
			Parent dashboard;
			try {
				dashboard = FXMLLoader.load(getClass().getResource("/Templates/studentViewComp.fxml"));
				Scene dashboardScene = new Scene(dashboard);
				Stage dashboardStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
				dashboardStage.setScene(dashboardScene);
				dashboardStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

    }

    @FXML
    void weightageMethod(ActionEvent event) {

    }

}
