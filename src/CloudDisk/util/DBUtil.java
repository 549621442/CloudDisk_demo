package CloudDisk.util;

import java.sql.*;

import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.*;
/*
 * 数据库连接的工具类
 */

public class DBUtil {
	
	//1.加载并注册驱动程序
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/disk_date?characterEncoding=utf-8"; //数据库的编码格式utf-8
	//用户和密码
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	//2.创建Connection 对象
	
	//创建一个数据连接方法 getCon()，返回一个连接对象 Connection
	public Connection getCon(){
		
		//创建Connection 对象
		Connection con  = null;
		try {
			Class.forName(DRIVER);
			//alt+/
			con  = DriverManager.getConnection(URL, USER, PASSWORD);
			//打印连接成功
			System.out.println("数据连接成功");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
		
	}
	
	/*
	 * sql 语句
	 * param  可变参数
	 * 
	 */
	//查询功能
	public CachedRowSet Query(String sql,Object ...param){	
		//连接数据库
		//创建Connection 对象
	    Connection con  =getCon();
	    //创建PreparedStatement对象
	    PreparedStatement ps = null;
	    //创建ResultSet对象
	    ResultSet  rs = null;
	    // 缓冲结果集  要求JDK>1.7
	    CachedRowSet crs  =  null;
	    
	    try {
			ps  = con.prepareStatement(sql);
			//for循环遍历sql的参数
			for(int i =0 ;i<param.length;i++){
				//补全sql的参数
				ps.setObject(i+1, param[i]);
			}	
			rs = ps.executeQuery();//调用查询方法，将返回值赋值给rs.
			//实例化CachedRowSet 对象
			crs = new CachedRowSetImpl();
			//将crs 与 rs 相关联
			crs.populate(rs);		
		} catch (Exception e) {
			// TODO: handle exception
		}	  
		return crs;	
	}


	
	//更新操作  修改 删除 添加
	public int Update(String sql,Object ...param){
		
		//连接数据库
		//创建Connection 对象
		Connection con  =getCon();
		//创建PreparedStatement对象
		PreparedStatement ps = null;
		
		//更新的结果result
		int result = 0;
		
		try {
			ps  = con.prepareStatement(sql);
			//for循环遍历sql的参数
			for(int i =0 ;i<param.length;i++){
				//补全sql的参数
				ps.setObject(i+1, param[i]);
			}	
			
			//执行更新操作
			result  = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
		
	}
	
	

}
