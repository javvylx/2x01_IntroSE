package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controllers.MySQLConnection;

public class Student {
	private String stu_id;
	private String stu_fname;
	private String stu_lname;
	private String stu_email;
	private String stu_mobile;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_fname() {
		return stu_fname;
	}
	public void setStu_fname(String stu_fname) {
		this.stu_fname = stu_fname;
	}
	public String getStu_lname() {
		return stu_lname;
	}
	public void setStu_lname(String stu_lname) {
		this.stu_lname = stu_lname;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getStu_mobile() {
		return stu_mobile;
	}
	public void setStu_mobile(String stu_mobile) {
		this.stu_mobile = stu_mobile;
	}
	public Student(String stu_id, String stu_fname, String stu_lname, String stu_email, String stu_mobile) {
		super();
		this.stu_id = stu_id;
		this.stu_fname = stu_fname;
		this.stu_lname = stu_lname;
		this.stu_email = stu_email;
		this.stu_mobile = stu_mobile;
	}
	
	public Student() {
		super();
	}
	
}
