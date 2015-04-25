package project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="task")
public class Task {
	private int tid;
	private String tname;
	private int tnumber;
	private int tyear;
	private int tmonth;
	private int tday;
	private int tspend;
	private int tafter;
	private String ttype;
	private int pid;
	
	@GeneratedValue
	@Id
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@NotEmpty(message="任务名称不能为空")
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTnumber() {
		return tnumber;
	}
	public void setTnumber(int tnumber) {
		this.tnumber = tnumber;
	}
	public int getTyear() {
		return tyear;
	}
	public void setTyear(int tyear) {
		this.tyear = tyear;
	}
	public int getTmonth() {
		return tmonth;
	}
	public void setTmonth(int tmonth) {
		this.tmonth = tmonth;
	}
	public int getTday() {
		return tday;
	}
	public void setTday(int tday) {
		this.tday = tday;
	}
	public int getTspend() {
		return tspend;
	}
	public void setTspend(int tspend) {
		this.tspend = tspend;
	}
	public int getTafter() {
		return tafter;
	}
	public void setTafter(int tafter) {
		this.tafter = tafter;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	

}
