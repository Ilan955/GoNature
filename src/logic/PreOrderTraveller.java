package logic;

public class PreOrderTraveller extends Person {
	private String id;
	private String phoneNumber;

	public PreOrderTraveller(String firstname, String lastname, String email, String id, String phonenumber) {
		super(firstname, lastname, email);
		this.id = id;
		phoneNumber = phonenumber;
	}

	public String getID() {
		return this.id;
	}

	public void setPhoneNum(String num) {
		this.phoneNumber = num;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setID(String id) {
		this.id=id;
	}
}
