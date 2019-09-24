package CloudDisk.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import CloudDisk.domain.Download;
import CloudDisk.util.DBUtil;

public class downloadDao {
	DBUtil dbutil = new DBUtil();
	//���������Ϣ
	public boolean addfile(Download download){//���ϴ����ļ���Ϣ��ӵ����ݿ�
		  
		   String sql  = "insert into download VALUES(null,?,?,?,?)"; 
		   //��ʼ��һ������ result
		   int result = 0;
		   //����dbutil�еĸ��·���
		   result  = dbutil.Update(sql,download.getDownloadFile(),download.getDownloadUser(),download.getDownloadNum(),download.getDownloadDate());
		  
		   return result>0;
	   
	   }
	//��ʾ�����ļ�������Ϣ
	public List<Download> queryAllUser(){
		
		String sql  = "select * from download";
		CachedRowSet crs   = dbutil.Query(sql);
		List<Download> list  = new ArrayList<Download>();
		try {
			while(crs.next()){
				int did = crs.getInt("downloadID");
				String dfile  = crs.getString("downloadFile");
				String duser = crs.getString("downloadUser");
				int dNum = crs.getInt("downloadNum");
				String dDate = crs.getString("downloadDate");
				Download download  = new Download(did, dfile,duser,dNum,dDate);
				list.add(download);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	//ͳ���ļ����ش���
	public int queryDownloadNum(String filename) throws SQLException{
		String sql = "select count(downloadFile) from download where downloadFile = ?";
		CachedRowSet crs   = dbutil.Query(sql,filename);
		int num = crs.getInt(1);
		return num;
	}
}
