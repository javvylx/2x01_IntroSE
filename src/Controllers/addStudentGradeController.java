package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entities.Component;
import entities.ExcelToTable;
import entities.Student;
import entities.SubComponent;
import entities.Subcomponent_marks;
import entities.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class addStudentGradeController implements Initializable{
    @FXML
    private AnchorPane modifyStage;

    @FXML
    private Text titlelbl;

    @FXML
    private Text fileSelectedtxt;

    @FXML
    private Button importCSVBtn;
    
    @FXML
    private Button saveToDbBtn;
    
    @FXML
    private TableView<ExcelToTable> excelTable;

    @FXML
    private TableColumn<ExcelToTable, String> colOne;

    @FXML
    private TableColumn<ExcelToTable, String> coltwo;

    @FXML
    private TableColumn<ExcelToTable, String> colthree;

    @FXML
    private TableColumn<ExcelToTable, String> colfour;

    @FXML
    private TableColumn<ExcelToTable, String> colfive;

    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ArrayList<String> all = new ArrayList<String>();
		ObservableList<ExcelToTable> ettOL = FXCollections.observableArrayList();
		importCSVBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				FileChooser chooser = new FileChooser();
			    chooser.setTitle("Open File");
			    chooser.getExtensionFilters().addAll(
			            new ExtensionFilter("XSLX Files", "*.xlsx"));
			    File file = chooser.showOpenDialog(new Stage());
			    if(file.canRead()==true) { 
			    	fileSelectedtxt.setText("File selected!");
			    	try {
					    FileInputStream fis = new FileInputStream(file);
			    		// Finds the workbook instance for XLSX file 
			    		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis); 
			    		// Return first sheet from the XLSX workbook 
			    		XSSFSheet mySheet = myWorkBook.getSheetAt(0); 
			    		// Get iterator to all the rows in current sheet 
			    		Iterator<Row> rowIterator = mySheet.iterator(); 
			    		// Traversing over each row of XLSX file 
			    		while (rowIterator.hasNext()) {
			    			Row row = rowIterator.next(); 
				    		// For each row, iterate through each columns 
				    		Iterator<Cell> cellIterator = row.cellIterator(); 
				    		while (cellIterator.hasNext()) { 
				    			Cell cell = cellIterator.next(); 
				    			if(cell.getCellTypeEnum() == CellType.STRING) {
				    				all.add(cell.getStringCellValue());
				    			}else if(cell.getCellTypeEnum() == CellType.NUMERIC) {
				    				all.add(Double.toString(cell.getNumericCellValue()));
				    			}
				    		} 
				    	}
			    		List<String> allList = all;
			    		for(int i = 0; i < all.size(); i+=5) {
			    			List<String> tempList;
			    			tempList = allList.subList(i, i+5);
			    			ExcelToTable ettData = new ExcelToTable(tempList.get(0).toString(), tempList.get(1).toString(), tempList.get(2).toString(), tempList.get(3).toString(), tempList.get(4).toString());
			    			ettOL.add(ettData);
			    		}
			    		colOne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getComp_name()));
			    		coltwo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSubcomp_name()));
			    		colthree.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStu_id()));
			    		colfour.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarks_obtained()));
			    		colfive.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMaximum_marks()));
			    		excelTable.setItems(ettOL);
			    		
			    	}catch(Exception e) {
						System.out.println(e);
						e.printStackTrace();  // This will give line number
			    	}
			    }
			}
			
		});
		saveToDbBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			Component c  = new Component();
			@Override
			public void handle(MouseEvent arg0) {
				boolean success = true;
				for(ExcelToTable ett : ettOL) {
					String comp_id = c.retrieveIDByName(ett.getComp_name());
					SubComponent sc = new SubComponent();
					String subcomp_id = sc.retrieveIDByName(ett.getSubcomp_name());
					String stu_id = ett.getStu_id();
					Subcomponent_marks scm = new Subcomponent_marks();
					System.out.println("Subcomp_id: " +subcomp_id);
					System.out.println("stu_id: " +stu_id);
					System.out.println("marks: " +ett.getMarks_obtained());
					System.out.println("max_marks: " +ett.getMaximum_marks());
					String scm_id = scm.retrieveHighestPKValue();
					success = scm.createStudentGrades(scm_id, subcomp_id, stu_id, Double.parseDouble(ett.getMarks_obtained()), Double.parseDouble(ett.getMaximum_marks()));
						
					}
				if(success == true) {
					Stage stage = (Stage) saveToDbBtn.getScene().getWindow();
				    stage.close();
				    Alert a = new Alert(AlertType.INFORMATION, "Successfully added students' grades!");
					a.showAndWait();
				}
			}
		});
	}
}
