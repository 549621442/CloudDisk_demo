package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import CloudDisk.domain.FileMsg;
import CloudDisk.domain.Upload;
import CloudDisk.dao.*;

/**
* @ClassName: UploadHandleServlet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author: 孤傲苍狼
* @date: 2015-1-3 下午11:35:50
*
*/ 
public class UploadHandleServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 		HttpSession session = request.getSession(true);
		 		//获取用户路径
		 		String upath = (String)session.getAttribute("uid");
                //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
                String savePath = this.getServletContext().getRealPath("/WEB-INF/upload")+"\\"+upath;
                //上传时生成的临时文件保存目录
                String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
                
                
                
                File tmpFile = new File(tempPath);
                if (!tmpFile.exists()) {
                    //创建临时目录
                    tmpFile.mkdir();
                }
                File file = new File(savePath);
                System.out.println(file.exists());
                System.out.println(file.isDirectory());
                //判断上传文件的保存目录是否存在
                if (!file.exists() && !file.isDirectory()) {
                    System.out.println(savePath+"目录不存在，需要创建");
                    //创建目录
                    file.mkdir();
                }
                
                //消息提示
                @SuppressWarnings("unused")
				String message = "";               
                
              
                
                FileDao filedao = new FileDao();
                
                
                try{
                    //使用Apache文件上传组件处理文件上传步骤：
                    //1、创建一个DiskFileItemFactory工厂
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
                    factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
                    //设置上传时生成的临时文件的保存目录
                    factory.setRepository(tmpFile);
                    //2、创建一个文件上传解析器
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    //监听文件上传进度
                    upload.setProgressListener(new ProgressListener(){
                        public void update(long pBytesRead, long pContentLength, int arg2) {
                            System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
                           
                        }
                    });
                     //解决上传文件名的中文乱码
                    upload.setHeaderEncoding("UTF-8"); 
                    //3、判断提交上来的数据是否是上传表单的数据
                    if(!ServletFileUpload.isMultipartContent(request)){
                        //按照传统方式获取数据
                        return;
                    }
                    
                    //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
                    upload.setFileSizeMax(1024*1024*1024);
                    //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
                    upload.setSizeMax(1024*1024*10);
                    //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
                    @SuppressWarnings("unchecked")
					List<FileItem> list = upload.parseRequest(request);
                    
                    for(FileItem item : list){
                        //如果fileitem中封装的是普通输入项的数据
                        if(item.isFormField()){
                            String name = item.getFieldName();
                            //解决普通输入项的数据的中文乱码问题
                            String value = item.getString("UTF-8");
                            //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                            System.out.println(name + "=" + value);
                             
                        }else{//如果fileitem中封装的是上传文件
                            //得到上传的文件名称，
                            String filename = item.getName();
                            System.out.println(filename);
                            if(filename==null || filename.trim().equals("")){
                                continue;
                            }
                            //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                            //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                            filename = filename.substring(filename.lastIndexOf("\\")+1);
                        
                            //得到上传文件的扩展名
                            String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                            
                            //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
                            System.out.println("上传的文件的扩展名是："+fileExtName);
                            //获取item中的上传文件的输入流
                            InputStream in = item.getInputStream();
                            //得到文件保存的名称
                            String saveFilename = makeFileName(filename);;
                            //创建一个文件输出流
                            FileOutputStream out = new FileOutputStream(savePath + "\\" + saveFilename);
                            //创建一个缓冲区
                            byte buffer[] = new byte[1024];
                            //判断输入流中的数据是否已经读完的标识
                            int len = 0;
                            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                            while((len=in.read(buffer))>0){
                                //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                                out.write(buffer, 0, len);
                            }
                            //获取文件大小
                            file = new File(savePath+ "\\" + saveFilename);
                            long size = file.length();
                            //获取系统时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            
                            
                            System.out.println("上传用户为"+upath);
                            System.out.println("扩展名"+fileExtName);
                            System.out.println("路径"+savePath + "\\" + saveFilename);
                            System.out.println("文件名"+filename);
                            System.out.println("文件大小"+size/1024+"kb");
                            System.out.println("上传时间"+df.format(new Date()));
                            
                            FileMsg filemsg = new FileMsg();
                            filemsg.setFileName(filename);
                            filemsg.setFileSize(size/1024);
                            filemsg.setFileURL(savePath + "\\" + saveFilename);
                            filemsg.setFileType(fileExtName);
                            filemsg.setUpUser(upath);
                            filemsg.setUpDate(df.format(new Date()));
                            if(filedao.addfile(filemsg)==true){
                            	System.out.println("写入成功");
                            }else{
                            	System.out.println("写入失败");
                            }
                            Upload upload2 = new Upload(0,df.format(new Date()),upath,filename);
                            UploadDao uploaddao = new UploadDao();
                            uploaddao.addUpload(upload2);
                            //关闭输入流
                            in.close();
                            //关闭输出流
                            out.close();
                            //删除处理文件上传时生成的临时文件
                            //item.delete();
                            
                            
                        }
                    }
                }catch (FileUploadBase.FileSizeLimitExceededException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "单个文件超出最大值！！！");
                    request.getRequestDispatcher("/message.jsp").forward(request, response);
                    return;
                }catch (FileUploadBase.SizeLimitExceededException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
                    request.getRequestDispatcher("/message.jsp").forward(request, response);
                    return;
                }catch (Exception e) {
                    message= "文件上传失败！";
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
    
    /**
    * @Method: makeFileName
    * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
    * @Anthor:孤傲苍狼
    * @param filename 文件的原始名称
    * @return uuid+"_"+文件的原始名称
    */ 
    private String makeFileName(String filename){  //2.jpg
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }
    
    /**
     * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
    * @Method: makePath
    * @Description: 
    * @Anthor:孤傲苍狼
    *
    * @param filename 文件名，要根据文件名生成存储目录
    * @param savePath 文件存储路径
    * @return 新的存储目录
    */ 
/*    private String makePath(String filename,String savePath){//根据项目规模为方便管理暂时不使用随机路径
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        //如果目录不存在
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }*/

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}