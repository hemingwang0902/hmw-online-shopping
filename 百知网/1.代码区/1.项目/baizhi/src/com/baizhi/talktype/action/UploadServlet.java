package com.baizhi.talktype.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.talktype.service.TalktypeService;

public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		boolean isMutipart = ServletFileUpload.isMultipartContent(request);
		Element element = null;
		String picturePath="";
		String talkTypeId="";
		String typeName="";
		String remark="";
		String modifyTime="";
		String keyid="";
		try {
			if (isMutipart) {
				// 很明显这里也是使用了工厂方法产生一个factory
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// 这里定义文件保存地址，我就直接保存到根目录下了
				String path = "d:\\test";
				System.out.println(path);
				// 这里是设置临时文件的存储目录
				factory.setRepository(new File(path));
				//设置缓冲区大小
				factory.setSizeThreshold(1024 * 1024);
				// ServletFileUpload是主要的操作
				ServletFileUpload upload = new ServletFileUpload(factory);
				//设置最大文件尺寸(10M)
				upload.setSizeMax(10485760);
				// 将表单读取过来,获取所有的文件
				List parseRequest = upload.parseRequest(request);
				List<FileItem> items = parseRequest;
				
				Iterator<FileItem> itr=items.iterator();
				// 遍历这个list
				while(itr.hasNext()) {
					FileItem fileitem=itr.next();
					//如果不是上传文件
					if(fileitem.isFormField()){
						String fieldName=fileitem.getFieldName();
						String fieldValue=fileitem.getString();
						
						
						//话题ID
						if(fieldName.equals("TALKTYPE_ID")){
							if(StringUtils.isNotEmpty(fieldValue)){
								talkTypeId=fieldValue;
							}
						}
						//类型名称
						if(fieldName.equals("TYPE_NAME")){
							typeName=fieldValue;
						}
						//备注
						if(fieldName.equals("REMARK")){
							remark=fieldValue;
						}
						//修改时间
						if(fieldName.equals("MODIFY_TIME")){
							modifyTime=fieldValue;
						}
						
						
						System.out.println("-------------------------FiledName--------"+fieldName);
						
						System.out.println("-------------------------Name--------"+fieldValue);
						
					}else{
						//获取文件名包含文件路径
						String filename = fileitem.getName();
						if(filename!=null){
							File fullfile=new File(filename);
							File uploadFile=new File(path,fullfile.getName());
							fileitem.write(uploadFile);
							picturePath=path+fullfile.getName();
						}
					}
				}
				
				//如果话题类型表ID为""，则为新增话题类型表，否则更新话题类型表
				if(StringUtils.isNotEmpty(talkTypeId)){
					element = talktypeService.getTalktypeEleById("TALKTYPE_ID");
					Elements.setElementValue(element, "TALKTYPE_ID", talkTypeId);// 话题类型ID
					Elements.setElementValue(element, "TYPE_NAME", typeName);// 类型名称
					Elements.setElementValue(element, "REMARK", remark);// 备注
					Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
					Elements.setElementValue(element, "PICLOGO",picturePath);//话题图片
					//如果保存成功，返回主键
					keyid = talktypeService.saveOrUpdateTalktype(element);
					/*if(StringUtils.isNotEmpty(keyid)){
						this.setMessage("话题类型表信息编辑成功");
						return UPDATESUCCESS;
					}*/
					if(StringUtils.isNotEmpty(keyid)){
						response.sendRedirect("/talktype/talktypelist.jsp");
						return;
					}
				}else{
					element = new DefaultElement("T_TALKTYPE");
					Elements.setElementValue(element, "TYPE_NAME",talkTypeId);// 类型名称
					Elements.setElementValue(element, "REMARK", typeName);// 备注
					Elements.setElementValue(element, "CREATE_TIME",DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
					Elements.setElementValue(element, "PICLOGO", picturePath);//图片
					//如果保存成功，返回主键
					keyid = talktypeService.saveOrUpdateTalktype(element);
					/*if(StringUtils.isNotEmpty(keyid)){
						this.setMessage("话题类型表信息编辑成功");
						return UPDATESUCCESS;
					}*/
					if(StringUtils.isNotEmpty(keyid)){
						request.getRequestDispatcher("/talktype/talktypeform.jsp").forward(request, response);
						return;
					}
				}
				request.getRequestDispatcher("/talktype/talktypeform.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private TalktypeService talktypeService=null;//话题类型表业务类
	
	public TalktypeService getTalktypeService() {
		return talktypeService;
	}

	public void setTalktypeService(TalktypeService talktypeService) {
		this.talktypeService = talktypeService;
	}
}
