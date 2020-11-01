package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lecturer {
	String lect_id;
	String lect_fname;
	String lect_lname;
	String lect_mobile;
	String lect_email;
	public String getLect_id() {
		return lect_id;
	}
	public void setLect_id(String lect_id) {
		this.lect_id = lect_id;
	}
	public String getLect_fname() {
		return lect_fname;
	}
	public void setLect_fname(String lect_fname) {
		this.lect_fname = lect_fname;
	}
	public String getLect_lname() {
		return lect_lname;
	}
	public void setLect_lname(String lect_lname) {
		this.lect_lname = lect_lname;
	}
	public String getLect_mobile() {
		return lect_mobile;
	}
	public void setLect_mobile(String lect_mobile) {
		this.lect_mobile = lect_mobile;
	}
	public String getLect_email() {
		return lect_email;
	}
	public void setLect_email(String lect_email) {
		this.lect_email = lect_email;
	}
	public Lecturer(String lect_id, String lect_fname, String lect_lname, String lect_mobile, String lect_email) {
		super();
		this.lect_id = lect_id;
		this.lect_fname = lect_fname;
		this.lect_lname = lect_lname;
		this.lect_mobile = lect_mobile;
		this.lect_email = lect_email;
	}
	public Lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lecturer convertToLecturer(ResultSet rs) throws SQLException {
		Lecturer lr;
		String lect_id = rs.getString("lect_id");
		String lect_fname = rs.getString("lect_fname");
		String lect_lname = rs.getString("lect_lname");
		String lect_mobile = rs.getString("lect_mobile");
		String lect_email = rs.getString("lect_email");
		lr = new Lecturer(lect_id, lect_fname, lect_lname, lect_mobile, lect_email);
		return lr;
	}
	
}
