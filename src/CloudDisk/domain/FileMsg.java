package CloudDisk.domain;

public class FileMsg {
	String fileName;//�ļ���
	int fileID;//�ļ����
	String fileURL;//�ļ�·��
	float fileSize;//�ļ���С
	String fileType;//�ļ�����
	String upUser;//�ϴ��û�
	String upDate;//�ϴ�����

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
