package CloudDisk.domain;

public class User {

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPM() {
		return userPM;
	}
	public void setUserPM(String userPM) {
		this.userPM = userPM;
	}
	public String getUserPWD() {
		return userPWD;
	}
	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	String userID;//�û��˺�
	String userName;//�û�����
	String userPM;//�û�Ȩ�޼�
	String userPWD;//�û�����
	String userPhone;//�û��ֻ�����
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", userPM=" + userPM + ", userPWD=" + userPWD
				+ ", userPhone=" + userPhone + "]";
	}
	public User(String userID, String userName, String userPM, String userPWD,
			String userPhone) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPM = userPM;
		this.userPWD = userPWD;
		this.userPhone = userPhone;
	}
	
}
