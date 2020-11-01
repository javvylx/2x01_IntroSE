package entities;

public class Class_student {
	int cs_id;
	String cs_class_id;
	String cs_student_id;
	public int getCs_id() {
		return cs_id;
	}
	public void setCs_id(int cs_id) {
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
	public Class_student(int cs_id, String cs_class_id, String cs_student_id) {
		super();
		this.cs_id = cs_id;
		this.cs_class_id = cs_class_id;
		this.cs_student_id = cs_student_id;
	}
	public Class_student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
