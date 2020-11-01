package entities;

public class Component_Grades {
	String cg_id;
	String cg_comp_id;
	String cg_stu_id;
	String cg_grades;
	double total_marks;
	String feedback;
	public String getCg_id() {
		return cg_id;
	}
	public void setCg_id(String cg_id) {
		this.cg_id = cg_id;
	}
	public String getCg_comp_id() {
		return cg_comp_id;
	}
	public void setCg_comp_id(String cg_comp_id) {
		this.cg_comp_id = cg_comp_id;
	}
	public String getCg_stu_id() {
		return cg_stu_id;
	}
	public void setCg_stu_id(String cg_stu_id) {
		this.cg_stu_id = cg_stu_id;
	}
	public String getCg_grades() {
		return cg_grades;
	}
	public void setCg_grades(String cg_grades) {
		this.cg_grades = cg_grades;
	}
	public double getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(double total_marks) {
		this.total_marks = total_marks;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Component_Grades(String cg_id, String cg_comp_id, String cg_stu_id, String cg_grades, double total_marks,
			String feedback) {
		super();
		this.cg_id = cg_id;
		this.cg_comp_id = cg_comp_id;
		this.cg_stu_id = cg_stu_id;
		this.cg_grades = cg_grades;
		this.total_marks = total_marks;
		this.feedback = feedback;
	}
	public Component_Grades() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
