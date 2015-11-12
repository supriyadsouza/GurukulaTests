package classes;

public class RegistrationData {
	private String login;
	private String email;
	private String password;
	private String expectedError;
	
	public RegistrationData(String login, String email,
			String password, String expectedError) {
		this.login = login;
		this.email = email;
		this.password = password;
		this.expectedError = expectedError;
	}
	
	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getExpectedError() {
		return expectedError;
	}
}
