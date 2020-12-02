package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entities.Component;
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
    
    @FXML private MediaView mv;
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
			File filepath = new File("src/video_clips/100percentile.mp4");
			Media file = new Media(filepath.toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(file);
//			me = new Media(new File(path).toURI().toString());
			System.out.println(file.getDuration().toSeconds());
			mp = new MediaPlayer(me);
			mv.setMediaPlayer(mp);
			mp.setAutoPlay(true);
			DoubleProperty width = mv.fitHeightProperty();
			DoubleProperty height = mv.fitHeightProperty();
			width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
			ReplayButton.setVisible(true);
			
		}
		
	 public void startPressed() {
		 	hundredpercentile();
		 	displayStuFeedbackField.setText(retrieveFeedback());
		 	displayStuFeedbackField.setVisible(true);
		 	displayStuFeedbackField.getAlignment();
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
		//Write a function to retrieve Student name by id
		welcomeTxt.setText(welcomeTxt.getText());
		ShootSlingshot();
		
		
	}

	

}
