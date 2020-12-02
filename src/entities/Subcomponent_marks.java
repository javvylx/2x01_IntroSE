package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controllers.MySQLConnection;

public class Subcomponent_marks {
	String scm_id;
	String scm_subcomp_id;
	String scm_stu_id;
	double scm_marks;
	double scm_max_marks;
	public String getScm_id() {
		return scm_id;
	}
	public void setScm_id(String scm_id) {
		this.scm_id = scm_id;
	}
	public String getScm_subcomp_id() {
		return scm_subcomp_id;
	}
	public void setScm_subcomp_id(String scm_subcomp_id) {
		this.scm_subcomp_id = scm_subcomp_id;
	}
	public String getScm_stu_id() {
		return scm_stu_id;
	}
	public void setScm_stu_id(String scm_stu_id) {
		this.scm_stu_id = scm_stu_id;
	}
	public double getScm_marks() {
		return scm_marks;
	}
	public void setScm_marks(double scm_marks) {
		this.scm_marks = scm_marks;
	}
	public double getScm_max_marks() {
		return scm_max_marks;
	}
	public void setScm_max_marks(double scm_max_marks) {
		this.scm_max_marks = scm_max_marks;
	}
	public Subcomponent_marks(String scm_id, String scm_subcomp_id, String scm_stu_id, double scm_marks) {
		super();
		this.scm_id = scm_id;
		this.scm_subcomp_id = scm_subcomp_id;
		this.scm_stu_id = scm_stu_id;
		this.scm_marks = scm_marks;
	}
	//newly added
	public Subcomponent_marks(String scm_id, String scm_subcomp_id, String scm_stu_id, double scm_marks,
			double scm_max_marks) {
		super();
		this.scm_id = scm_id;
		this.scm_subcomp_id = scm_subcomp_id;
		this.scm_stu_id = scm_stu_id;
		this.scm_marks = scm_marks;
		this.scm_max_marks = scm_max_marks;
	}
	
	public Subcomponent_marks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Subcomponent_marks retrieveSubComponentMarkBySubComponentID(String subComp_id, String stuID){
		Subcomponent_marks subcomp_marks = new Subcomponent_marks();
		ResultSet rs = null;
		MySQLConnection db = new MySQLConnection();
		String dbQuery;
		// Step 1 - connect to database
		db.getConnection();
		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM 2x01_db.subcomponent_mark Where scm_subcomp_id = " +subComp_id+ " and scm_stu_id = " +stuID + ";";
		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				Subcomponent_marks sc = new Subcomponent_marks();
				subcomp_marks = sc.convertToSubcomponent_marks(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// step 4 - close connection
		db.terminate();
		// end of retrieve
		return subcomp_marks;
	}
	
	public Subcomponent_marks convertToSubcomponent_marks(ResultSet rs) throws SQLException {
		Subcomponent_marks scm;
		String scm_id = rs.getString("scm_id");
		String scm_subcomp_id = rs.getString("scm_subcomp_id");
		String scm_stu_id = rs.getString("scm_stu_id");
//		double subcomp_weight = rs.getDouble("subcomp_weight");
		double scm_marks = rs.getDouble("scm_mark");
		double scm_max_marks = rs.getDouble("scm_max_mark");
		scm = new Subcomponent_marks(scm_id, scm_subcomp_id, scm_stu_id, scm_marks,scm_max_marks);
		return scm;
	}
	
	
}
