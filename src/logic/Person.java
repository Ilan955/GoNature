package logic;

public class Person {
	private String firstName;
	private String lastName;
	private String email;

	public Person(String firstname, String lastname, String email) {
		firstName = firstname;
		lastName = lastname;
		this.email = email;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

}
