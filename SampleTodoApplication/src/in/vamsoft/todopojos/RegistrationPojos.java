package in.vamsoft.todopojos;

public class RegistrationPojos {

	private String name;
	private String email;
	private String encodedPassword;
	private String emailHashcode;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEncodedPassword() {
		return encodedPassword;
	}
	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}
	
	public String getEmailHashcode() {
		return emailHashcode;
	}
	public void setEmailHashcode(String emailHashcode) {
		this.emailHashcode = emailHashcode;
	}
	public RegistrationPojos(String email) {
		super();
		this.email = email;
	}
	
	public RegistrationPojos(String name, String email, String encodedPassword, String emailHashcode) {
		super();
		this.name = name;
		this.email = email;
		this.encodedPassword = encodedPassword;
		this.emailHashcode = emailHashcode;
	}
	
	
	public RegistrationPojos(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegistrationPojos [name=" + name + ", email=" + email + ", encodedPassword=" + encodedPassword + "]";
	}
	
	
}
