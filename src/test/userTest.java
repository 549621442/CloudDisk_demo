package test;
import java.util.List;

import CloudDisk.dao.*;
import CloudDisk.domain.*;
public class userTest {
	public void userTset1(){
		UserDao ud = new UserDao();
		 List<User> list = ud.queryAllUser();
		
		for(User user:list){
			System.out.println(user.getUserID());
			System.out.println(user.getUserName());
		}
	}
	

}
