package entities;

import java.sql.PreparedStatement;

import Controllers.MySQLConnection;

public class Component_feedback {
	private int id;
	private String cf_stu_id;
	private String cf_comp_id;
	private String feedback;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCf_stu_id() {
		return cf_stu_id;
	}
	public void setCf_stu_id(String cf_stu_id) {
		this.cf_stu_id = cf_stu_id;
	}
	public String getCf_comp_id() {
		return cf_comp_id;
	}
	public void setCf_comp_id(String cf_comp_id) {
		this.cf_comp_id = cf_comp_id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Component_feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Component_feedback(int id, String cf_stu_id, String cf_comp_id, String feedback) {
		super();
		this.id = id;
		this.cf_stu_id = cf_stu_id;
		this.cf_comp_id = cf_comp_id;
		this.feedback = feedback;
	}
	
	public boolean createStudentFeedback(String cf_stu_id, String cf_comp_id, String feedback) {
		// declare local variables
		boolean success = false;
		MySQLConnection db = new MySQLConnection();
		String dbQuery;
		PreparedStatement pstmt;
		// step 1 - establish connection to database
		db.getConnection();
		// step 2 - declare the SQL statement
		dbQuery = "INSERT INTO 2x01_db.component_feedback(cf_stu_id, cf_comp_id, feedback) VALUES(?, ?, ?)";
		pstmt = db.getPreparedStatement(dbQuery);
		// step 3 - to insert record using executeUpdate method
		try {
			pstmt.setString(1, cf_stu_id);
			pstmt.setString(2, cf_comp_id);
			pstmt.setString(3, feedback);
			if (pstmt.executeUpdate() == 1)
				success = true;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
}
