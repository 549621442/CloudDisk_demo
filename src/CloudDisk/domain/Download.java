package CloudDisk.domain;

public class Download {
	int downloadID;//���ر��
	String downloadFile;//�����ļ���
	String downloadUser;//�����û�
	int downloadNum;//���ش���
	String downloadDate;//��������
	public int getDownloadID() {
		return downloadID;
	}
	public void setDownloadID(int downloadID) {
		this.downloadID = downloadID;
	}
	public String getDownloadFile() {
		return downloadFile;
	}
	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}
	public String getDownloadUser() {
		return downloadUser;
	}
	public void setDownloadUser(String downloadUser) {
		this.downloadUser = downloadUser;
	}
	public int getDownloadNum() {
		return downloadNum;
	}
	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}
	public String getDownloadDate() {
		return downloadDate;
	}
	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}
	@Override
	public String toString() {
		return "Download [downloadID=" + downloadID + ", downloadFile="
				+ downloadFile + ", downloadUser=" + downloadUser
				+ ", downloadNum=" + downloadNum + ", downloadDate="
				+ downloadDate + "]";
	}
	public Download(int downloadID, String downloadFile,
			String downloadUser, int downloadNum, String downloadDate) {
		super();
		this.downloadID = downloadID;
		this.downloadFile = downloadFile;
		this.downloadUser = downloadUser;
		this.downloadNum = downloadNum;
		this.downloadDate = downloadDate;
	}
	
	
}
