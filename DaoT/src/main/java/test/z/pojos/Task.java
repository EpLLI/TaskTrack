package test.z.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ("Task"))
public class Task {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
	private int id;
	@Column(name="project")
	private String project;
	@Column(name="name")
	private String name;
	@Column(name="date")
	private String date;
	@Column(name="manager")
	private String manager;
	@Column(name="Developer")
	private String developer;
	@Column(name="Importance")
	private String importance;
	public Task() {
		super();
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", project=" + project + ", name=" + name + ", date=" + date + ", manager=" + manager
				+ ", developer=" + developer + ", importance=" + importance + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
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
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="Status")
	private String status;
}
