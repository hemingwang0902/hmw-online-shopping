package com.baizhi.commons.component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.geeboo.component.excelsupport.write.WriteExcelINTF;
import com.geeboo.component.excelsupport.write.WriteExcelSupport;

/**
 * 类名： ExcelUtils<br>
 * 描述：导出Excel帮助类<br>
 * 创建者：江红<br>
 * 创建日期：2011-3-31 <br>
 * 版本：<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class ExcelUtils implements Serializable {
	
	private static final long serialVersionUID = -5549138194060119097L;
	
	private HttpServletResponse response=null;
	
	/**
	 * 
	 * @param response
	 */
	public ExcelUtils(HttpServletResponse response){
		this.response=response;
	}
	
	/**
	 * 写Excel文件
	 * @param response   response对象
	 * @param title      标题
	 * @param columnname 列名
	 * @param list       导出数据
	 */
	public void writeExcel(String title, String[] columnname, List<List<String>> list) {
		PrintStream out = null;
		ByteArrayOutputStream bos = null;
		WriteExcelINTF writeexcel=null;
		try {
			writeexcel=new WriteExcelSupport();
			//设置标题
			int colspan=0;
			if(columnname!=null){
				colspan=(columnname.length-1);
			}
			writeexcel.setTitle(title, colspan, 0, 0);
			//设置列名
			writeexcel.setColumnName(1, 0, columnname);
			//设置列表数据
			writeexcel.setColumnData(2, 0, list);
			
			// 设置定义类型
			response.reset();
			response.setContentType("application/msexcel");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "max-age=30");
			response.setHeader("Content-disposition", "attachment; filename=*.xls");
			out = new PrintStream(response.getOutputStream());
			// 写入字节流
			bos = new ByteArrayOutputStream();
			writeexcel.getWorkbook().write(bos);
			response.setContentLength(bos.size());
			bos.writeTo(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
				out = null;
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			try {
				bos.flush();
				bos.close();
				bos = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
