package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Collections;

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

	public void startPressed() {
		Double studentGrade = 0.0;

		Component comp2 = new Component();
		ArrayList<Component> compAL = comp2.retrieveAllComponents();

		// Step 1 - connect to database
		ArrayList<Double> gradesList = new ArrayList<Double>();
		MySQLConnection db = new MySQLConnection();
		db.getConnection();
		ResultSet rs = null;
		String dbQuery;
		dbQuery = "SELECT stu_id FROM 2x01_db.student";
		boolean alertfoundornot = false;
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				for (Component c : compAL) {
					// run subcomponent binding
//    	 			System.out.println("Testing for comp id: "+ c.getComp_id());
					c.populateSubComponentList();
//    	 			System.out.println("Populated... Querying Grades for 1902128");	
//    	 			System.out.println("Grade's HEREEEEEEEEEEE"+c.getGrade("1902128"));
					// if (rs.getString("stu_id") == same as student id);
					// studentGrade == c.getGrade(rs.getString("stu_id"))
					// gradesList.add(studentGrade)
					// continue

					double grades = c.getGrade(rs.getString("stu_id"));
					System.out.println(grades);
					if (Double.isNaN(grades) == false) {
						gradesList.add(grades);
						alertfoundornot = true;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 4 - close connection
		db.terminate();

		Collections.sort(gradesList);
		studentGrade = -1.0;
		double last = gradesList.get(0);
		double top = gradesList.get(gradesList.size() - 1);
		double tf = ((top - last) * 0.25) + last;
		double f = ((top - last) * 0.5) + last;
		double sf = ((top - last) * 0.75) + last;

		System.out.println("Last: " + last);
		System.out.println("Top: " + top);
		System.out.println("TF: " + tf);
		System.out.println("F: " + f);
		System.out.println("SF: " + sf);
		if (studentGrade == -1.0) {
			Alert alert = new Alert(AlertType.INFORMATION, "No Grades Found for this particular student!");
			alert.showAndWait();
			System.out.println("Fail");
			// error message

		} else if (studentGrade == last) {
			zeropercentile();
		} else if (studentGrade == top) {
			hundredpercentile();
			displayFeedback();
		} else if (studentGrade <= tf && studentGrade != 0) {
			twentyfivepercentile();
			displayFeedback();
		} else if (studentGrade > tf && studentGrade <= sf && studentGrade != 0) {
			fiftypercentile();
			displayFeedback();
		} else if (studentGrade > sf && studentGrade < top && studentGrade != 0) {
			seventyfivepercentile();
			displayFeedback();
		}
		if (StartButton.isVisible()) {
			StartButton.setVisible(false);
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
