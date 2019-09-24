package CloudDisk.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import CloudDisk.domain.Upload;
import CloudDisk.util.DBUtil;

public class UploadDao {
	DBUtil dbutil = new DBUtil();
	public List<Upload> queryAllUpload(){ //�鿴�����ϴ��ļ���Ϣ
		
		String sql  = "select * from upload";
		CachedRowSet crs   = dbutil.Query(sql);
		List<Upload> list  = new ArrayList<Upload>();
		try {
			while(crs.next()){
				int upid = crs.getInt("uploadID");
				String update  = crs.getString("uploadDate");
				String upUser = crs.getString("uploadUser");
				String upFile = crs.getString("uploadFile");
				Upload upload = new Upload(upid,update,upUser,upFile);
				list.add(upload);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	 //���û���ѯ�ϴ���Ϣ
public List<Upload> queryAllUploadById(String uid){
		
		String sql  = "select * from upload where uploadUser = ?";
		CachedRowSet crs   = dbutil.Query(sql,uid);
		List<Upload> list  = new ArrayList<Upload>();
		try {
			while(crs.next()){
				int upid = crs.getInt("uploadID");
				String update  = crs.getString("uploadDate");
				String upUser = crs.getString("uploadUser");
				String upFile = crs.getString("uploadFile");
				Upload upload = new Upload(upid,update,upUser,upFile);
				list.add(upload);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	public boolean addUpload(Upload upload){//�û�ע��
		String sql ="insert into upload values(null,?,?,?)";
		int result=0;
		result = dbutil.Update(sql,upload.getUploadDate(),upload.getUploadUser(),upload.getUploadFile());
		return result>0;
	}
	
	public Upload querryUploadByName(String Name) throws SQLException{//��Name�����ϴ���Ϣ
		String sql = "select * from upload where uoloadFile = ?";
		Upload upload = null;
		CachedRowSet crs = dbutil.Query(sql, Name);
		if(crs.next()){
		int upid = crs.getInt("uploadID");
		String upDate  = crs.getString("uploadDate");
		String upUser = crs.getString("uploadUser");
		String upFile = crs.getString("uploadFile");
		
		upload  = new Upload(upid,upDate,upUser,upFile);
		
	}
		return upload;
	}
	}
