package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controllers.MySQLConnection;

public class ClassStudent {
	String cs_id;
	String cs_class_id;
	String cs_student_id;
	public String getCs_id() {
		return cs_id;
	}
	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}
	public String getCs_class_id() {
		return cs_class_id;
	}
	public void setCs_class_id(String cs_class_id) {
		this.cs_class_id = cs_class_id;
	}
	public String getCs_student_id() {
		return cs_student_id;
	}
	public void setCs_student_id(String cs_student_id) {
		this.cs_student_id = cs_student_id;
	}
	
	
	
	public ClassStudent() {
		super();
	}
	
	public ClassStudent(String cs_id, String cs_class_id, String cs_student_id) {
		super();
		this.cs_id = cs_id;
		this.cs_class_id = cs_class_id;
		this.cs_student_id = cs_student_id;
	}
	
	public ClassStudent convertToClassStudent(ResultSet rs) throws SQLException {
		ClassStudent cs;
		String id = rs.getString("cs_id");
		String classID = rs.getString("cs_class_id");
		String studentID = rs.getString("cs_student_id");
		cs = new ClassStudent(id, classID, studentID);
		return cs;
	}
	
	public ArrayList<String> retrieveStudentIdByClassId(String classID) {
		ArrayList<String> alStuID = new ArrayList<String>();
		ResultSet rs = null;
		MySQLConnection db = new MySQLConnection();
		String dbQuery;
		// Step 1 - connect to database
		db.getConnection();
		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM 2x01_db.class_student where cs_class_id = '" + classID + "';";
		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				ClassStudent cs = new ClassStudent();
				String student_id = cs.convertToClassStudent(rs).cs_student_id;
				alStuID.add(student_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// step 4 - close connection
		db.terminate();
		// end of retrieve
		return alStuID;
	}
	
	
}
