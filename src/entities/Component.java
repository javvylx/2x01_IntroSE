package entities;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Component {
	String comp_id;
	String comp_name;
	String comp_desc;
	double comp_weight;
	
	public double getComp_weight() {
		return comp_weight;
	}
	public void setComp_weight(double comp_weight) {
		this.comp_weight = comp_weight;
	}
	public String getComp_id() {
		return comp_id;
	}
	public void setComp_id(String comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getComp_desc() {
		return comp_desc;
	}
	public void setComp_desc(String comp_desc) {
		this.comp_desc = comp_desc;
	}
	
	public Component(String comp_id, String comp_name, String comp_desc, double comp_weight) {
		super();
		this.comp_id = comp_id;
		this.comp_name = comp_name;
		this.comp_desc = comp_desc;
		this.comp_weight = comp_weight;
	}
	public Component() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Component convertToComponent(ResultSet rs) throws SQLException {
		Component cp;
		String id = rs.getString("comp_id");
		String name = rs.getString("comp_name");
		String desc = rs.getString("comp_desc");
		double weight = rs.getDouble("comp_weight");
		cp = new Component(id, name, desc, weight);
		return cp;
	}
	
	
}
