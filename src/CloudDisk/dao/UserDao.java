package CloudDisk.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import CloudDisk.domain.User;
import CloudDisk.util.DBUtil;



public class UserDao {
	DBUtil dbutil = new DBUtil();
public List<User> queryAllUser(){ //�鿴�����û���Ϣ
	
		String sql  = "select * from user";
		CachedRowSet crs   = dbutil.Query(sql);
		List<User> list  = new ArrayList<User>();
		try {
			while(crs.next()){
				String uid = crs.getString("userID");
				String uname  = crs.getString("userName");
				String upwd = crs.getString("userPWD");
				String UPM = crs.getString("userPM");
				String uPhone = crs.getString("userPhone");
				User user  = new User(uid, uname,UPM,upwd,uPhone);
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}

public User queryUserByID(String ID) throws SQLException{//��ID�����û�
	String sql = "select * from user where userID = ?";
	User user = null;
	CachedRowSet crs = dbutil.Query(sql, ID);
	if(crs.next()){
	String uid = crs.getString("userID");
	String uname  = crs.getString("userName");
	String upwd = crs.getString("userPWD");
	String UPM = crs.getString("userPM");
	String uphone = crs.getString("userPhone");
	
	 user  = new User(uid, uname,UPM,upwd,uphone);
	}
	return user;
}

public boolean registUser(User user){//�û�ע��
	String sql ="insert into user values(?,?,?,?,?)";
	int result=0;
	result = dbutil.Update(sql,user.getUserID(),user.getUserName(),"4",user.getUserPWD(),user.getUserPhone());
	return result>0;
}

//�û���¼
public Boolean checklogin(String username,String pwd){
	
	
	//��дsql select * from tbl_user where userName="����" and userPass ="123"
	String sql  ="select * from user where userID = ? and userPWD = ?";
	//���ý�����弯
	CachedRowSet crs  = null;		
	//����dbutil�в�ѯ����
	crs = dbutil.Query(sql, username,pwd);
	int n = 0;
	//���²�ѯ����Ƿ��м�¼
	try {
		
		if(crs.next()){
			n = crs.getInt("userID");//��ȡ�û��ı��
		}	
	} catch (Exception e) {
		// TODO: handle exception
	}
	return n>0;
	
}

}
