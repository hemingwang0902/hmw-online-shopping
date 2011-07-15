package com.baizhi.area.action;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import net.sf.json.JSONObject;
import org.dom4j.io.OutputFormat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.baizhi.area.service.AreaService;


/**
 * 类名：CreateJsonData.java<br>
 * 描述：创建区域json数据<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-15 上午01:27:59<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CreateJsonData  extends HttpServlet {
	
	private static final long serialVersionUID = -5142036513932269040L;
	
	private AreaService areaService;
	
	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}



	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext wac=WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		areaService=(AreaService)wac.getBean("areaService");
		//获取字典列表
		Map<String, Object> returnMap =new HashMap<String, Object>();
		List<Map<String, Object>> list = areaService.getAreaListByData();
		if(list!=null&&list.size()>0){
			returnMap.put("list", list);
		}
		JSONObject jspn_obj = JSONObject.fromObject(returnMap);
		StringBuffer data=new StringBuffer();
		data.append("var data=[")
			.append( jspn_obj.toString())
			.append("];");
		
		OutputStreamWriter  output;
	    //输出格式化
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("UTF-8");
        try {
        	output=new OutputStreamWriter(new FileOutputStream(config.getServletContext().getRealPath("/areadata.js")),"UTF-8");
            output.write(data.toString());
            output.close();
            System.out.println("*****地区创建成功*****");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
