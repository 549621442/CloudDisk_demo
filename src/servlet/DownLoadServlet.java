package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CloudDisk.dao.downloadDao;
import CloudDisk.domain.Download;

public class DownLoadServlet extends HttpServlet {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //�õ�Ҫ���ص��ļ���
        String fileName = request.getParameter("filename");  //23239283-92489-������.avi
        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
		String path = request.getParameter("path");
		//�õ�Ҫ���ص��ļ�
        File file = new File(path);
        //����ļ�������
        if(!file.exists()){
            request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        //��ȡϵͳʱ��
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //��ȡ�����û�
        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("uid");
       
        //�����ļ���
        String realname = fileName.substring(fileName.indexOf("_")+1);
        
        //�����ص��ļ���Ϣ�����download����
        Download download = new Download(0,realname,user,1,df.format(new Date()));
        downloadDao dldao = new downloadDao();
        dldao.addfile(download);
        
        //������Ӧͷ��������������ظ��ļ�
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //��ȡҪ���ص��ļ������浽�ļ�������
        FileInputStream in = new FileInputStream(path);
        //���������
        OutputStream out = response.getOutputStream();
        //����������
        byte buffer[] = new byte[1024];
        int len = 0;
        //ѭ�����������е����ݶ�ȡ������������
        while((len=in.read(buffer))>0){
            //��������������ݵ��������ʵ���ļ�����
            out.write(buffer, 0, len);
        }
        //�ر��ļ�������
        in.close();
        //�ر������
        out.close();
    }
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}