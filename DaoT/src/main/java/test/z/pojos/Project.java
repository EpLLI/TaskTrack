package test.z.pojos;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ("Project"))
public class Project {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="date")
	private String date;
	@Column(name="manager")
	private String manager;
	
	
	public Project() {
		super();
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", date=" + date + ", manager=" + manager + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
}
