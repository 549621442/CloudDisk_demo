package CloudDisk.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import CloudDisk.domain.Download;
import CloudDisk.util.DBUtil;

public class downloadDao {
	DBUtil dbutil = new DBUtil();
	//添加下载信息
	public boolean addfile(Download download){//将上传的文件信息添加到数据库
		  
		   String sql  = "insert into download VALUES(null,?,?,?,?)"; 
		   //初始化一个变量 result
		   int result = 0;
		   //调用dbutil中的更新方法
		   result  = dbutil.Update(sql,download.getDownloadFile(),download.getDownloadUser(),download.getDownloadNum(),download.getDownloadDate());
		  
		   return result>0;
	   
	   }
	//显示所有文件下载信息
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
	//统计文件下载次数
	public int queryDownloadNum(String filename) throws SQLException{
		String sql = "select count(downloadFile) from download where downloadFile = ?";
		CachedRowSet crs   = dbutil.Query(sql,filename);
		int num = crs.getInt(1);
		return num;
	}
}
