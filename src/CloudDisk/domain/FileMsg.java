package CloudDisk.domain;

public class FileMsg {
	String fileName;//文件名
	int fileID;//文件编号
	String fileURL;//文件路径
	float fileSize;//文件大小
	String fileType;//文件类型
	String upUser;//上传用户
	String upDate;//上传日期

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileID() {
		return fileID;
	}
	public int setFileID(int fileID) {
		return this.fileID = fileID;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	public float getFileSize() {
		return fileSize;
	}
	public void setFileSize(float fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getUpUser() {
		return upUser;
	}
	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	@Override
	public String toString() {
		return "File [fileName=" + fileName + ", fileID=" + fileID
				+ ", fileURL=" + fileURL + "]";
	}
	
	public FileMsg(String fileName, int fileID, String fileURL, float fileSize,
			String fileType, String upUser, String upDate) {
		super();
		this.fileName = fileName;
		this.fileID = fileID;
		this.fileURL = fileURL;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.upUser = upUser;
		this.upDate = upDate;
	}
	public FileMsg() {
		super();
	}
	
}
