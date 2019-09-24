package CloudDisk.domain;

public class Upload {
	int uploadID;//上传编号
	String uploadDate;//上传时间
	String uploadUser;//上传用户
	String uploadFile;//上传文件名
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
