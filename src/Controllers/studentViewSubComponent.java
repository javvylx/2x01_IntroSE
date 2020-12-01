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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class studentViewSubComponent {
    
	@FXML
    private AnchorPane mainStage;

    @FXML
    private Pane dashboardPane;

    @FXML
    private Pane lsubComponentPane;

    @FXML
    private Text moduleLbl;

    @FXML
    private TextArea feedbackTxtArea;

    @FXML
    private Button welcomeTxt;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnComponents;

    @FXML
    private Button btnSignOut;
    
    @FXML
    void navBar(ActionEvent actionEvent) {
    	if (actionEvent.getSource() == btnHome) {
			Parent dashboard;
			try {
				dashboard = FXMLLoader.load(getClass().getResource("/Templates/dashboard_student.fxml"));
				Scene dashboardScene = new Scene(dashboard);
				Stage dashboardStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
				dashboardStage.setScene(dashboardScene);
				dashboardStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	if (actionEvent.getSource() == btnComponents) {
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
    	if (actionEvent.getSource() == btnSignOut) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Confirm logout? ", ButtonType.YES, ButtonType.CANCEL);
			alert.showAndWait();
			if (alert.getResult() == ButtonType.YES) {
				Parent login;
				try {
					login = FXMLLoader.load(getClass().getResource("/Templates/login.fxml"));
					Scene loginScene = new Scene(login);
					Stage loginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
					loginStage.setScene(loginScene);
					loginStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    
    


}
