package CloudDisk.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import CloudDisk.domain.FileMsg;
import CloudDisk.util.DBUtil;

public class FileDao {
	DBUtil dbutil = new DBUtil();
	public List<FileMsg> queryAllfilemsg(){ //查看所有文件信息
		
		String sql  = "select * from filemsg";
		CachedRowSet crs   = dbutil.Query(sql);
		List<FileMsg> list  = new ArrayList<FileMsg>();
		try {
			while(crs.next()){
				String fname = crs.getString("fileName");
				String furl  = crs.getString("fileURL");
				String ftype = crs.getString("fileType");
				String upuser = crs.getString("upUser");
				float fsize = crs.getFloat("fileSize");
				int fid = crs.getInt("fileID");
				String update = crs.getString("upDate");
				FileMsg filemsg  = new FileMsg(fname,fid,furl,fsize,ftype,upuser,update);
				list.add(filemsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public FileMsg querryFileByName(String Name) throws SQLException{//按Name查找文件
		String sql = "select * from filemsg where fileName = ?";
		FileMsg filemsg = null;
		CachedRowSet crs = dbutil.Query(sql, Name);
		if(crs.next()){
		int fid = crs.getInt("fileID");
		String fname  = crs.getString("fileName");
		String furl = crs.getString("fileURL");
		String ftype = crs.getString("fileType");
		String upuser = crs.getString("upUser");
		float fsize = crs.getFloat("fileSize");
		String update = crs.getString("upDate");
		filemsg  = new FileMsg(fname,fid,furl,fsize,ftype,upuser,update);
		}
		return filemsg;
	}
	
public List<FileMsg> queryUserAllfilemsg(String uid){ //查看单个用户所有文件信息
		
		String sql  = "select * from filemsg where upUser = ?";
		CachedRowSet crs   = dbutil.Query(sql,uid);
		List<FileMsg> list  = new ArrayList<FileMsg>();
		try {
			while(crs.next()){
				String fname = crs.getString("fileName");
				String furl  = crs.getString("fileURL");
				String ftype = crs.getString("fileType");
				String upuser = crs.getString("upUser");
				float fsize = crs.getFloat("fileSize");
				int fid = crs.getInt("fileID");
				String update = crs.getString("upDate");
				FileMsg filemsg  = new FileMsg(fname,fid,furl,fsize,ftype,upuser,update);
				list.add(filemsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}

	
	public FileMsg querryFileByType(String Type) throws SQLException{//按type查找文件
		String sql = "select * from filemsg where fileType = ?";
		FileMsg filemsg = null;
		CachedRowSet crs = dbutil.Query(sql, Type);
		if(crs.next()){
		int fid = crs.getInt("fileID");
		String fname  = crs.getString("fileName");
		String furl = crs.getString("fileURL");
		String ftype = crs.getString("fileType");
		String upuser = crs.getString("upUser");
		float fsize = crs.getFloat("fileSize");
		String update = crs.getString("upDate");
		filemsg  = new FileMsg(fname,fid,furl,fsize,ftype,upuser,update);
		}
		return filemsg;
	}
	
	public boolean addfile(FileMsg filemsg){//将上传的文件信息添加到数据库
		  
		   String sql  = "insert into filemsg VALUES(null,?,?,?,?,?,?)"; 
		   //初始化一个变量 result
		   int result = 0;
		   //调用dbutil中的更新方法
		   result  = dbutil.Update(sql,filemsg.getFileName(),filemsg.getFileURL(),filemsg.getFileType(),filemsg.getUpUser(),filemsg.getFileSize(),filemsg.getUpDate());
		  
		   return result>0;
	   
	   }
	
	public boolean deleteFile(int ID){//删除文件
		String sql = "delete from filemsg where fileID = ?";
		int result = 0;
		result = dbutil.Update(sql, ID);
		return result>0;
	}


}
