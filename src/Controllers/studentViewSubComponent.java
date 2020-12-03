package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entities.Component;
import entities.Student;
import entities.SubComponent;
import entities.Subcomponent_marks;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class studentViewSubComponent implements Initializable{
    
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
	private TableView<SubComponent> subCompTable;
	
	@FXML
	private TableColumn<SubComponent, String> scNameCol;
	
	@FXML
	private TableColumn<SubComponent, String> weightageCol;
	
	@FXML
	private TableColumn<SubComponent, String> descCol;
	
	@FXML
	private TableView<Subcomponent_marks> subCompTableMarks;
	
	@FXML
	private TableColumn<Subcomponent_marks, String> marksCol;
	
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
    	
    	//go to home scene
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
    	
    	//go to components scene
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
    	
    	//signing out
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
    
    public void displayFeedback() {
		MySQLConnection db = new MySQLConnection();
		String feedback = "";
		ResultSet rs = null;
		String dbQuery;
		// Step 1 - connect to database
		db.getConnection();
		dbQuery = "SELECT feedback FROM 2x01_db.component_feedback WHERE cf_stu_id = 1902127";
		rs = db.readRequest(dbQuery);
		try {
			if (rs.next()) {
				feedback = rs.getString("feedback");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 4 - close connection
		db.terminate();
		feedbackTxtArea.setText(feedback);
	}
    
    public void displayComponentName() {
    	MySQLConnection db = new MySQLConnection();
		String compName = "";
		ResultSet rs = null;
		String dbQuery;
		// Step 1 - connect to database
		db.getConnection();
		dbQuery = "SELECT comp_name FROM 2x01_db.component WHERE comp_id='1'";
		rs = db.readRequest(dbQuery);
		try {
			if (rs.next()) {
				compName = rs.getString("comp_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 4 - close connection
		db.terminate();
		moduleLbl.setText(compName);
    }
    
    
    //things to do when init subcomp page
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	//display the feedback for the particular component
    	displayFeedback();
    	
    	//display the component name for the particular component
    	displayComponentName();
    	
		studentViewComp svc = new studentViewComp();
		
		
		//*****getting comp_id not working****** currently id is 1
		int id = svc.getComp_id() + 5;
		
		
		//for storing of SubComponent rows
		ObservableList<SubComponent> scOL = FXCollections.observableArrayList();
		
		//for storing of a subcomponent_mark rows
		ObservableList<Subcomponent_marks> scmOL = FXCollections.observableArrayList();
		
		ResultSet rs = null;
		
		MySQLConnection db = new MySQLConnection();
		String dbQuery;
		
		
		//*****getting of the subcomp DETAILS******
		// Step 1 - connect to database
		db.getConnection();
		
		// step 2 - declare the SQL statement
		System.out.println("this is the COMP ID" + id);
		
		dbQuery = "SELECT * FROM 2x01_db.subcomponent WHERE comp_id="+id+" ;";
		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				SubComponent sc = new SubComponent();
				SubComponent subComponent = sc.convertToSubComponent(rs);
				scOL.add(subComponent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// step 4 - close connection
		db.terminate();
		
		
		//*****getting of the subcomp MARKS******
		// Step 1 - connect to database
		db.getConnection();
		
		// step 2 - declare the SQL statement		
		dbQuery = "SELECT * FROM 2x01_db.subcomponent_mark WHERE scm_stu_id='1902127' GROUP BY scm_subcomp_id;";
		
		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				Subcomponent_marks scm = new Subcomponent_marks();
				Subcomponent_marks subComponentMark = scm.convertToSubcomponent_marks(rs);
				scmOL.add(subComponentMark);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// step 4 - close connection
		db.terminate();
		
		
		
		
		scNameCol.setCellValueFactory(new PropertyValueFactory<>("subcomp_name"));	
		
		weightageCol.setCellValueFactory(new PropertyValueFactory<>("subcomp_weight"));
		descCol.setCellValueFactory(new PropertyValueFactory<>("subcomp_desc"));
		subCompTable.setItems(scOL);
		
		
		//subcomp marks set in a different table
		marksCol.setCellValueFactory(new PropertyValueFactory<>("scm_marks"));
		subCompTableMarks.setItems(scmOL);
		
		
		subCompTable.setRowFactory( tv -> {
		    TableRow<SubComponent> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            SubComponent rowData = row.getItem();
		            System.out.println(rowData.getSubcomp_id());
		        }
		    });
		    return row ;
		});
	}
    
    


}
