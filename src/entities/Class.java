package entities;

public class Class {
	String class_id;
	String lect_id;
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getLect_id() {
		return lect_id;
	}
	public void setLect_id(String lect_id) {
		this.lect_id = lect_id;
	}
	public Class(String class_id, String lect_id) {
		super();
		this.class_id = class_id;
		this.lect_id = lect_id;
	}
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
