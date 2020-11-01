package entities;

public class Subcomponent_marks {
	String scm_id;
	String scm_subcomp_id;
	String scm_stu_id;
	String scm_marks;
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
	public String getScm_marks() {
		return scm_marks;
	}
	public void setScm_marks(String scm_marks) {
		this.scm_marks = scm_marks;
	}
	public Subcomponent_marks(String scm_id, String scm_subcomp_id, String scm_stu_id, String scm_marks) {
		super();
		this.scm_id = scm_id;
		this.scm_subcomp_id = scm_subcomp_id;
		this.scm_stu_id = scm_stu_id;
		this.scm_marks = scm_marks;
	}
	public Subcomponent_marks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
