package CloudDisk.domain;

public class Upload {
	int uploadID;//�ϴ����
	String uploadDate;//�ϴ�ʱ��
	String uploadUser;//�ϴ��û�
	String uploadFile;//�ϴ��ļ���
	public int getUploadID() {
		return uploadID;
	}
	public void setUploadID(int uploadID) {
		this.uploadID = uploadID;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "Upload [uploadID=" + uploadID + ", uploadDate=" + uploadDate
				+ ", uploadUser=" + uploadUser + "]";
	}
	public Upload(int uploadID, String uploadDate, String uploadUser,
			String uploadFile) {
		super();
		this.uploadID = uploadID;
		this.uploadDate = uploadDate;
		this.uploadUser = uploadUser;
		this.uploadFile = uploadFile;
	}
	
}
