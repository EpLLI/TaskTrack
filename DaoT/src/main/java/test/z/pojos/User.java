package test.z.pojos;

import javax.persistence.*;


@Entity
@Table(name = ("user"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
	private int id;
	@Column(name="username", unique=true , nullable=false)
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}
