package CloudDisk.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import CloudDisk.domain.User;
import CloudDisk.util.DBUtil;



public class UserDao {
	DBUtil dbutil = new DBUtil();
public List<User> queryAllUser(){ //查看所有用户信息
	
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

public User queryUserByID(String ID) throws SQLException{//按ID查找用户
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

public boolean registUser(User user){//用户注册
	String sql ="insert into user values(?,?,?,?,?)";
	int result=0;
	result = dbutil.Update(sql,user.getUserID(),user.getUserName(),"4",user.getUserPWD(),user.getUserPhone());
	return result>0;
}

//用户登录
public Boolean checklogin(String username,String pwd){
	
	
	//编写sql select * from tbl_user where userName="张三" and userPass ="123"
	String sql  ="select * from user where userID = ? and userPWD = ?";
	//设置结果缓冲集
	CachedRowSet crs  = null;		
	//调用dbutil中查询方法
	crs = dbutil.Query(sql, username,pwd);
	int n = 0;
	//查下查询结果是否有记录
	try {
		
		if(crs.next()){
			n = crs.getInt("userID");//获取用户的编号
		}	
	} catch (Exception e) {
		// TODO: handle exception
	}
	return n>0;
	
}

}
