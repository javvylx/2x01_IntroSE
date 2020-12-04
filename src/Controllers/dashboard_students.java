package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Collections;
import java.util.HashMap;

import Controllers.DashboardController;
import entities.Component;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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

	@FXML
	private MediaView mv;
	private MediaPlayer mp;
	private Media me;

	@FXML
	private Button StartButton;

	@FXML
	private Button ReplayButton;

	@FXML
	private Label displayStuFeedbackField;

	public void LoopVideo() {
		String path = new File("src/video_clips/standby_loop.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
		DoubleProperty width = mv.fitHeightProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
	}

	public void zeropercentile() {
		String path = new File("src/video_clips/0percentile.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitHeightProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		ReplayButton.setVisible(true);
	}

	public void twentyfivepercentile() {
		String path = new File("src/video_clips/25percentile.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitHeightProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		ReplayButton.setVisible(true);
	}

	public void fiftypercentile() {
		String path = new File("src/video_clips/50percentile.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitHeightProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		ReplayButton.setVisible(true);
	}

	public void seventyfivepercentile() {
		String path = new File("src/video_clips/75percentile.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitHeightProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		ReplayButton.setVisible(true);
	}

	public void hundredpercentile() {
		String path = new File("src/video_clips/100percentile.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitHeightProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		ReplayButton.setVisible(true);
		System.out.println(me.getDuration().toSeconds());
	}
	
	public ArrayList<Double> getComGrades() {
		Double studentGrade = 0.0;
		ArrayList<String> classList = new ArrayList<String>();
		ArrayList<HashMap<String, Double>> gradeList = new ArrayList<HashMap<String, Double>>();
		ArrayList<Double> comGrades = new ArrayList<Double>();
		String dbQuery;
		double curHigh = 0;
		double curLow = 100;
		double alertfoundornot = -1;
		
		MySQLConnection db = new MySQLConnection();
		db.getConnection();
		dbQuery = "SELECT cs_class_id FROM 2x01_db.class_student";
		ResultSet rs = null;
		rs = db.readRequest(dbQuery);
		
		try {
			rs.next();
			classList.add(rs.getString("cs_class_id"));
			while(rs.next()){
				for(String i : classList) {
					if (rs.getString("cs_class_id").equals(i)) {
						continue;
					}
					else {
						classList.add(rs.getString("cs_class_id"));
					}
				}
				
			}
		} 	catch (SQLException e) {
			e.printStackTrace();
		}
		db.terminate();
		
		for (String i : classList) {
			HashMap<String, Double> grades = DashboardController.getStudentPerformance(i);
			gradeList.add(grades);
		}		
		
		CreateText ct = new CreateText();
		String id = ct.getText();
		
		for (HashMap <String, Double> i: gradeList) {
			if (i.get(id).equals(null)) {
				alertfoundornot = -2;
			}
			else {
				studentGrade = i.get(id);
			}
			for(Double v : i.values()) {
				if (v > curHigh) {
					curHigh = v;
				}
				if (v < curLow){
					curLow = v;
				}
			}
			
		} 
		comGrades.add(studentGrade);
		comGrades.add(curHigh);
		comGrades.add(curLow);
		comGrades.add(alertfoundornot);
		return comGrades;
	}

	public void startPressed() {
		
		
		/**Comment this below section to test**/
		
		/*
		ArrayList <Double> grades = getComGrades();
		double studentGrade = grades.get(0);
		double curHigh = grades.get(1);
		double curLow = grades.get(2);
		double alertfoundornot = grades.get(3);
		*/
		
		/**Comment the below section for actual code**/
		
		double studentGrade = 1.74;
		double curHigh = 1;
		double curLow = 0;
		double alertfoundornot = -1;
		
		
		double tf = (curHigh * 0.25)+curLow;
		double f = (curHigh * 0.5)+curLow;
		double sf = (curHigh * 0.75)+curLow;

		System.out.println("Last: " + curLow);
		System.out.println("Top: " + curHigh);
		System.out.println("TF: " + tf);
		System.out.println("F: " + f);
		System.out.println("SF: " + sf);
		
		if (alertfoundornot == -2) {
			Alert alert = new Alert(AlertType.INFORMATION, "No Grades Found for this particular student!");
			alert.showAndWait();
			System.out.println("Fail");

		} else {
			if (studentGrade == curHigh) {
				hundredpercentile();
				displayFeedback();
			} else if (studentGrade <= tf && studentGrade != 0) {
				twentyfivepercentile();
				displayFeedback();
			} else if (studentGrade > tf && studentGrade <= sf && studentGrade != 0) {
				fiftypercentile();
				displayFeedback();
			} else if (studentGrade > sf && studentGrade < curHigh && studentGrade != 0) {
				seventyfivepercentile();
				displayFeedback();
			} 
			
			if (StartButton.isVisible()) {
				StartButton.setVisible(false);
			}
		}

	}


	public void ReplayMe() {
		ShootSlingshot();
		ReplayButton.setVisible(false);
		StartButton.setVisible(true);

		displayStuFeedbackField.setVisible(false);
	}

	public void displayFeedback() {
		Timeline delayFeedback = new Timeline(
				new KeyFrame(Duration.seconds(0), event -> displayStuFeedbackField.setText(retrieveFeedback())),
				new KeyFrame(Duration.seconds(0), event -> displayStuFeedbackField.getAlignment()),
				new KeyFrame(Duration.seconds(6), event -> displayStuFeedbackField.setVisible(true)));
		delayFeedback.play();
	}

	private void ShootSlingshot() {
		LoopVideo();
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

	@FXML
	void weightageMethod(ActionEvent event) {

	}

	public String retrieveFeedback() {
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
		return feedback;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CreateText ct = new CreateText();
		String id = ct.getText();
		// Write a function to retrieve Student name by id
		welcomeTxt.setText(welcomeTxt.getText());
		ShootSlingshot();

	}

}
