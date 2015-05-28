package dao;

/**
 * Maillist entity. @author MyEclipse Persistence Tools
 */

public class Maillist implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String number;
	private String email;

	// Constructors

	/** default constructor */
	public Maillist() {
	}

	/** full constructor */
	public Maillist(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}