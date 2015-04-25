package project.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="project")
public class Project {
	
	private int pid;
	private String pname;
	private String pdate;
	private int pspend;
	private int uid;
	
	@GeneratedValue
	@Id
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@NotEmpty(message="项目名称不能为空")
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	@NotEmpty(message="开始日期不能为空")
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getPspend() {
		return pspend;
	}
	public void setPspend(int pspend) {
		this.pspend = pspend;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	

}
