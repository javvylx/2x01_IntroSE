package Controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import entities.Component;
import entities.Component_feedback;
import entities.ExcelToTable;
import entities.Lecturer;
import entities.Student;
import entities.SubComponent;
import entities.Subcomponent_marks;
import entities.User;

public class viewStudentController implements Initializable {

	@FXML
	private Button welcomeBtn;

	@FXML
	private AnchorPane mainStage;
	@FXML
	private VBox componentVB;
	@FXML
	private Pane loginPane;
	@FXML
	private TextField txtfieldUsername;
	@FXML
	private TextField txtFieldPassword;
	@FXML
	private Button btnLogin;
	@FXML
	private Pane dashboardPane;
	@FXML
	private Pane lHomePagePane;
	@FXML
	private Button importStudentGradeBtn;
	@FXML
	private Pane lViewStudentsPane;
	@FXML
	private Pane lManageCPane;
	@FXML
	private Button btnAssWeightage;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnManageCom;
	@FXML
	private Button btnViewStudent;
	@FXML
	private Button btnSignOut;
	@FXML
	private Pane lsubComponentPane;
	@FXML
	private TableView<Student> studentListTable;
	@FXML
	private TableColumn<Student, String> adminNoCol;
	@FXML
	private TableColumn<Student, String> fNameCol;
	@FXML
	private TableColumn<Student, String> lNameCol;
	@FXML
	private TableColumn<Student, String> emailCol;
	@FXML
	private TableColumn<Student, String> mobileCol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CreateText ct = new CreateText();
		String isd = ct.getText();
		User ul = new Lecturer();
		String name = ul.getNameByID(isd);
		welcomeBtn.setText("Welcome, " + name);
		ObservableList<Student> obsv = FXCollections.observableArrayList();
		User user = new Student();
		obsv = user.retrieveAllStudentForTable();
		adminNoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStu_id()));
		fNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStu_fname()));
		lNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStu_lname()));
		emailCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStu_email()));
		mobileCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStu_mobile()));
//		fNameCol.setCellValueFactory(new PropertyValueFactory<>("stu_fname"));
//		lNameCol.setCellValueFactory(new PropertyValueFactory<>("stu_lname"));
//		emailCol.setCellValueFactory(new PropertyValueFactory<>("stu_email"));
//		mobileCol.setCellValueFactory(new PropertyValueFactory<>("stu_mobile"));
		studentListTable.setItems(obsv);
		studentListTable.setRowFactory( tv -> {
		    TableRow<Student> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            Student rowData = row.getItem();
		            String studentID = rowData.getStu_id();
		            Node[] nodesCreate  = new Node[3];
					try {
			    		Component_feedback cfb = new Component_feedback();
			    		Subcomponent_marks scm = new Subcomponent_marks();
						nodesCreate[0] = FXMLLoader.load(getClass().getResource("/Templates/lecturerAddFeedback.fxml"));
						Text studenNametxt = (Text) nodesCreate[0].lookup("#studenNametxt");
						Text studentGradetxt = (Text) nodesCreate[0].lookup("#studentGradetxt");
						ComboBox<String> componentSelectcmb = (ComboBox) nodesCreate[0].lookup("#componentSelectcmb");
						studenNametxt.setText(rowData.getStu_fname()+" "+rowData.getStu_lname());
						Component c = new Component();
						ObservableList<String> locn = c.retrieveComponentName();
						componentSelectcmb.setItems(locn);
						componentSelectcmb.getSelectionModel().select(locn.get(0));
			    		String tempid = c.retrieveIDByName(locn.get(0));
						studentGradetxt.setText(c.gradeValueToGradeChar(c.getStudentGrade(studentID, locn.get(0))));
						Text titlelbl = (Text)nodesCreate[0].lookup("#titlelbl");
						TextArea feedbacktxtarea =(TextArea) nodesCreate[0].lookup("#feedbacktxtarea");
			    		feedbacktxtarea.setText(cfb.retrieveFeedbackViaID(tempid, rowData.getStu_id()));
						String feedback = cfb.retrieveFeedbackViaID(tempid, rowData.getStu_id());
						Button addFeedbackBtn = (Button) nodesCreate[0].lookup("#addFeedbackBtn");
						componentSelectcmb.valueProperty().addListener((obs, oldItem, newItem) -> {
							if(oldItem != newItem) {
								String checkFeedback = cfb.retrieveFeedbackViaID(c.retrieveIDByName(newItem), rowData.getStu_id());
					    		ArrayList<Component> compAL = c.retrieveAllComponents();
					    		studentGradetxt.setText(c.gradeValueToGradeChar(c.getStudentGrade(studentID, newItem)));
					    		String compid = c.retrieveIDByName(newItem);
					    		feedbacktxtarea.setText(checkFeedback);
								System.out.println(checkFeedback+"Check feedback");
					    		if(checkFeedback == "") {
						    		feedbacktxtarea.setText(cfb.retrieveFeedbackViaID(compid, rowData.getStu_id()));
						    		addFeedbackBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
										@Override
										public void handle(MouseEvent arg0) {
											// TODO Auto-generated method stub
											Alert alert = new Alert(AlertType.CONFIRMATION, "Confirm? ", ButtonType.YES, ButtonType.CANCEL);
											alert.showAndWait();
											if (alert.getResult() == ButtonType.YES) {
												String feedback = feedbacktxtarea.getText();
												String stu_id = rowData.getStu_id();
												String comp_name = componentSelectcmb.getSelectionModel().getSelectedItem();
												String comp_id = c.retrieveIDByName(comp_name);
												Component_feedback cfb = new Component_feedback();
												if(cfb.createStudentFeedback(stu_id, comp_id, feedback)) {
													Stage stage = (Stage) addFeedbackBtn.getScene().getWindow();
												    stage.close();
												    Alert a = new Alert(AlertType.INFORMATION, "Successfully made feedback!");
													a.showAndWait();
												}
											}
										}
									});
					    		}else {
					    			addFeedbackBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
										@Override
										public void handle(MouseEvent arg0) {
											// TODO Auto-generated method stub
											Alert alert = new Alert(AlertType.CONFIRMATION, "Confirm? ", ButtonType.YES, ButtonType.CANCEL);
											alert.showAndWait();
											if (alert.getResult() == ButtonType.YES) {
												String feedback = feedbacktxtarea.getText();
												String stu_id = rowData.getStu_id();
												String comp_name = componentSelectcmb.getSelectionModel().getSelectedItem();
												String comp_id = c.retrieveIDByName(comp_name);
												Component_feedback cfb = new Component_feedback();
												
												if(cfb.updateFeedback(comp_id,stu_id , feedback)) {
													Stage stage = (Stage) addFeedbackBtn.getScene().getWindow();
												    stage.close();
												    Alert a = new Alert(AlertType.INFORMATION, "Successfully made feedback!");
													a.showAndWait();
												}
											}
										}
									});
					    		}
							}
						});
						
						Stage stage = new Stage();
						stage.initModality(Modality.APPLICATION_MODAL);
						stage.initOwner(mainStage.getScene().getWindow());
						stage.setScene(new Scene((Parent) nodesCreate[0]));
						stage.show();
					}catch(Exception e) {

						System.out.println(e);
						e.printStackTrace();  // This will give line number
					}   
		        }
		    });
		    return row ;
		});
		importStudentGradeBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				Node[] nodesadd  = new Node[3];
				try {
					nodesadd[0] = FXMLLoader.load(getClass().getResource("/Templates/addStudentGrade.fxml"));
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(mainStage.getScene().getWindow());
					stage.setScene(new Scene((Parent) nodesadd[0]));
					stage.show();
				}catch(Exception e) {
					System.out.println(e);
					e.printStackTrace();  // This will give line number
				}
			}
		});
	}

	public void weightageMethod(ActionEvent actionEvent) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Templates/weightageComponent.fxml"));
			Parent root2 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(mainStage.getScene().getWindow());
			stage.setTitle("Assign Weightage");
			stage.setScene(new Scene(root2));
			stage.show();
		} catch (Exception e) {

		}
	}

	public void navBar(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnHome) {
			Parent dashboard;
			try {
				dashboard = FXMLLoader.load(getClass().getResource("/Templates/dashboard.fxml"));
				Scene dashboardScene = new Scene(dashboard);
				Stage dashboardStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
				dashboardStage.setScene(dashboardScene);
				dashboardStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (actionEvent.getSource() == btnManageCom) {
			Parent dashboard;
			try {
				dashboard = FXMLLoader.load(getClass().getResource("/Templates/manageComp.fxml"));
				Scene dashboardScene = new Scene(dashboard);
				Stage dashboardStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
				dashboardStage.setScene(dashboardScene);
				dashboardStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (actionEvent.getSource() == btnViewStudent) {
			Parent dashboard;
			try {
				dashboard = FXMLLoader.load(getClass().getResource("/Templates/viewStudent.fxml"));
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
