package empPackage1;

public class EmployeeBean
{

	String username;
	String password;
	String type;
	int userid;
	


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
//
	
	
	@Override
	public String toString() {
		return "EmpManageBean [username=" + username + ", password=" + password + ", type=" + type + ", userid="
				+ userid + "]";
	}
	
	
	//
	
	
	
}
