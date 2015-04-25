package project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="res")
public class Res {

	private int rid;
	private String rname;
	private int rmoney;
	private int uid;
	@GeneratedValue
	@Id
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@NotEmpty(message="资源名称不能为空")
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRmoney() {
		return rmoney;
	}
	public void setRmoney(int rmoney) {
		this.rmoney = rmoney;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
