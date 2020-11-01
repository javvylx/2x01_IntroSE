package entities;

public class Grades {
	String grade_code;
	String grade_desc;
	public String getGrade_code() {
		return grade_code;
	}
	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
	}
	public String getGrade_desc() {
		return grade_desc;
	}
	public void setGrade_desc(String grade_desc) {
		this.grade_desc = grade_desc;
	}
	public Grades(String grade_code, String grade_desc) {
		super();
		this.grade_code = grade_code;
		this.grade_desc = grade_desc;
	}
	public Grades() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
