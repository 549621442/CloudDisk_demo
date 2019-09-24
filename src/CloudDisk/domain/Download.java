package CloudDisk.domain;

public class Download {
	int downloadID;//下载编号
	String downloadFile;//下载文件名
	String downloadUser;//下载用户
	int downloadNum;//下载次数
	String downloadDate;//下载日期
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
