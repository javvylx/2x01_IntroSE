package entities;

public class ExcelToTable {
	public String comp_name;
	public String subcomp_name;
	public String stu_id;
	public String marks_obtained;
	public String maximum_marks;

	public ExcelToTable(String comp_name, String subcomp_name, String stu_id, String marks_obtained,
			String maximum_marks) {
		super();
		this.comp_name = comp_name;
		this.subcomp_name = subcomp_name;
		this.stu_id = stu_id;
		this.marks_obtained = marks_obtained;
		this.maximum_marks = maximum_marks;
	}
	
	
	public ExcelToTable() {

	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getSubcomp_name() {
		return subcomp_name;
	}

	public void setSubcomp_name(String subcomp_name) {
		this.subcomp_name = subcomp_name;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getMarks_obtained() {
		return marks_obtained;
	}

	public void setMarks_obtained(String marks_obtained) {
		this.marks_obtained = marks_obtained;
	}

	public String getMaximum_marks() {
		return maximum_marks;
	}

	public void setMaximum_marks(String maximum_marks) {
		this.maximum_marks = maximum_marks;
	}

}
