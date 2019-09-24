package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CloudDisk.dao.FileDao;

public class FileDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public FileDeleteServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   
		   FileDao filedao = new FileDao();
		String fileid = request.getParameter("fileid");
		int fid = Integer.parseInt(fileid);
		String path = request.getParameter("path");
		File file = new File(path);
		if (file.isFile()) {// 表示该文件不是文件夹
			file.delete();
			System.out.println("删除成功"+fileid);
			filedao.deleteFile(fid);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {
			System.out.println("删除失败");
		}

	        }
			
			
			
	


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	public void init() throws ServletException {

	}

}
