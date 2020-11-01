package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubComponent {
	String subcomp_id;
	String comp_id;
	String subcomp_name;
	double subcomp_weight;
	String subcomp_desc;
	public String getSubcomp_id() {
		return subcomp_id;
	}
	public void setSubcomp_id(String subcomp_id) {
		this.subcomp_id = subcomp_id;
	}
	public String getComp_id() {
		return comp_id;
	}
	public void setComp_id(String comp_id) {
		this.comp_id = comp_id;
	}
	public String getSubcomp_name() {
		return subcomp_name;
	}
	public void setSubcomp_name(String subcomp_name) {
		this.subcomp_name = subcomp_name;
	}
	public double getSubcomp_weight() {
		return subcomp_weight;
	}
	public void setSubcomp_weight(double subcomp_weight) {
		this.subcomp_weight = subcomp_weight;
	}
	public String getSubcomp_desc() {
		return subcomp_desc;
	}
	public void setSubcomp_desc(String subcomp_desc) {
		this.subcomp_desc = subcomp_desc;
	}
	public SubComponent(String subcomp_id, String comp_id, String subcomp_name, double subcomp_weight,
			String subcomp_desc) {
		super();
		this.subcomp_id = subcomp_id;
		this.comp_id = comp_id;
		this.subcomp_name = subcomp_name;
		this.subcomp_weight = subcomp_weight;
		this.subcomp_desc = subcomp_desc;
	}
	public SubComponent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubComponent convertToSubComponent(ResultSet rs) throws SQLException {
		SubComponent sc;
		String subcomp_id = rs.getString("subcomp_id");
		String comp_id = rs.getString("comp_id");
		String subcomp_name = rs.getString("subcomp_name");
		double subcomp_weight = rs.getDouble("subcomp_weight");
		String subcomp_desc = rs.getString("subcomp_desc");
		sc = new SubComponent(subcomp_id, comp_id, subcomp_name, subcomp_weight,subcomp_desc);
		return sc;
	}
}
