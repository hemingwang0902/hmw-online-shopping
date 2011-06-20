package com.tool.code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class TextCode {
	private static final String TABLE_SCHEMA = "baizhi";
	private static final String SYSTEM_NAME = "baizhi";
	Map<String,Object> root = new HashMap<String,Object>();
	
	public static void main(String[] args){
		TextCode code = new TextCode();
		//TODO 运行之前先修改此处
		code.create("江红", "T_AD","E:/work/baizhi");
	}
	
	/**
	 * 创建文件
	 * @param auth      作者
	 * @param tablename 表名
	 * @param tablecomtent 表注释
	 * @param directory 存放目录
	 */
	public void create(String auth,String tablename,String directory){
		//设置表名大写
		if(tablename!=null){
			tablename=tablename.toUpperCase();
		}
		//获取当前模板路径
		String modelpath= null;
		try {
			modelpath = new File(ClassLoader.getSystemResource("").toURI()).getAbsolutePath();
		} catch (URISyntaxException e) {
			//发生异常则直接退出
			e.printStackTrace();
			System.exit(1);
		}
		
		//获取文件命名
		String filename= "";
		String classname="";
		String beanname="";
		if(tablename.indexOf("_")>-1){
			String[] temptablename = tablename.split("_");
			if(temptablename.length>1){
				for (int i = 1; i < temptablename.length; i++) {
					classname+=this.toFistUpp(temptablename[i]);
					if(i==1){
						beanname+=temptablename[i].toLowerCase();
					}else{
						beanname+=this.toFistUpp(temptablename[i]);
					}
				}
			}
			filename=classname.toLowerCase();
		}
		//filename= (tablename.toUpperCase().startsWith("T_") ? tablename.substring(2) : tablename).toLowerCase();
		
		
		root.put("tableName", tablename.toUpperCase());
		root.put("className", classname);
		root.put("packageName", filename);
		root.put("packageNameUpperCase", filename.toUpperCase());
		root.put("sysName", SYSTEM_NAME);
		root.put("lis", this.getColumn(tablename));
		root.put("auth", auth);
		root.put("beanname", beanname);
		//获取当前时间
		Calendar calendar = new GregorianCalendar();
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curtime = format.format(calendar.getTime());
		root.put("createDate", curtime);
		
		String jsppath=directory+"/webapp/"+filename+"/";
		String actionpath=directory+"/src/com/"+SYSTEM_NAME+"/"+filename+"/action/";
		String daopath=directory+"/src/com/"+SYSTEM_NAME+"/"+filename+"/dao/";
		String servicepath=directory+"/src/com/"+SYSTEM_NAME+"/"+filename+"/service/";
		String entitypath=directory+"/src/com/"+SYSTEM_NAME+"/entity/";
		String strutspath=directory+"/configuration/struts2/";
		String strutsxmlpath=directory+"/configuration/";
		String springpath=directory+"/configuration/spring/";
		String databasepath=directory+"/configuration/spring/";
		
		this.mkdirs(daopath);
		this.mkdirs(jsppath);
		this.mkdirs(actionpath);
		this.mkdirs(servicepath);
		this.mkdirs(entitypath);
		this.mkdirs(strutspath);
		this.mkdirs(springpath);
		
		//生成页面文件
		this.convert(root, modelpath, "webapp/listjsp.ftl", jsppath+filename+"list.jsp");
		this.convert(root, modelpath, "webapp/listjs.ftl",  jsppath+filename+"list.js");
		
		this.convert(root, modelpath, "webapp/formjsp.ftl", jsppath+filename+"form.jsp");
		this.convert(root, modelpath, "webapp/formjs.ftl",  jsppath+filename+"form.js");
		//生成Action文件
		this.convert(root, modelpath, "src/action/GetActionList.ftl",  actionpath+"Get"+classname+"List.java");
		this.convert(root, modelpath, "src/action/InitActionForm.ftl",  actionpath+"Init"+classname+"Form.java");
		this.convert(root, modelpath, "src/action/SaveAction.ftl",  actionpath+"Save"+classname+".java");
		this.convert(root, modelpath, "src/action/GetActionById.ftl",   actionpath+"Get"+classname+"ById.java");
		this.convert(root, modelpath, "src/action/DelAction.ftl",   actionpath+"Del"+classname+".java");
		//this.convert(root, modelpath, "src/action/ActionCheck.ftl", actionpath+classname+"Check.java");
		this.convert(root, modelpath, "src/action/ActionForm.ftl",  actionpath+classname+"Form.java");
		//生成Dao文件
		this.convert(root, modelpath, "src/dao/Dao.ftl",     daopath+classname+"Dao.java");
		this.convert(root, modelpath, "src/dao/ImplDao.ftl", daopath+classname+"ImplDao.java");
		//生成Service文件
		this.convert(root, modelpath, "src/service/Service.ftl", servicepath+classname+"Service.java");
		//生成配置文件
		this.convert(root, modelpath, "src/entity/hbxml.ftl",   entitypath+tablename.toUpperCase()+".hbm.xml");
		//生成struts文件
		this.convert(root, modelpath, "configuration/struts/s-struts.ftl", strutspath+"s-"+filename+".xml");
		this.convert(root, modelpath, "configuration/struts.ftl", strutsxmlpath+"struts("+filename+").xml");
		
		//生成spring文件
		this.convert(root, modelpath, "configuration/spring/ac-spring.ftl", springpath+"ac-"+filename+".xml");
		
		this.convert(root, modelpath, "configuration/ac-database.ftl", databasepath+"ac-database("+filename+").xml");
		
		System.out.println("生成文件成功!");
	}
	
	/**
	 * 获取表列名信息
	 * @param tablename
	 * @return
	 */
	public List<Column> getColumn(String tablename){
		List<Column> list = new ArrayList<Column>();
		/*
		// 针对于 Oracle 的
		StringBuffer sql=new StringBuffer("SELECT T.TABLE_NAME,C.COLUMN_NAME,T.DATA_LENGTH,C.COMMENTS,T.DATA_TYPE  ")
								  .append("FROM USER_TAB_COLUMNS T,USER_COL_COMMENTS C ")
								  .append("WHERE T.TABLE_NAME=C.table_name AND T.COLUMN_NAME=C.column_name AND T.TABLE_NAME=?");
		*/
		// 针对于 mySql 的
		StringBuffer sql=new StringBuffer("select c.TABLE_NAME, c.COLUMN_NAME, c.CHARACTER_MAXIMUM_LENGTH, c.DATA_TYPE, c.COLUMN_COMMENT,c.COLUMN_KEY,d.TABLE_COMMENT ")
		.append(" from information_schema.columns c,information_schema.tables d ")
		.append(" where c.table_schema='" + TABLE_SCHEMA + "' and c.table_name=? and c.table_name=d.table_name ")
		.append(" order by c.ordinal_position");
		
		Connection conn=JdbcTool.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, tablename);
			ResultSet rs = ps.executeQuery();
			Column cl = null;
			String tableName, columnName,tabCon="",PK_KEY="";
			int totalcount=0;
			while (rs.next()) {
				totalcount++;
				tableName = defaultString(rs.getString("TABLE_NAME")).trim();
				columnName = defaultString(rs.getString("COLUMN_NAME")).trim();
				tabCon=defaultString(rs.getString("TABLE_COMMENT")).trim();

				cl = new Column();

				cl.setOldCl(columnName);
				cl.setUppcase(columnName.toLowerCase());
				cl.setLowcase(columnName.toLowerCase());
				cl.setFistLow(columnName);
				cl.setFistUpp(this.toFistUpp(columnName));

				cl.setOldTab(tableName);
				cl.setUppTab(tableName.toLowerCase());
				cl.setLowTab(tableName.toLowerCase());
				cl.setFistLowTab(tableName);
				cl.setFistUppTab(this.toFistUpp(tableName));

				cl.setLen(defaultString(rs.getString("CHARACTER_MAXIMUM_LENGTH")));

				cl.setContent(defaultString(rs.getString("COLUMN_COMMENT")));
				
				cl.setColumnkey(defaultString(rs.getString("COLUMN_KEY")));

				String dataType = rs.getString("DATA_TYPE").toUpperCase();
				if(rs.getString("COLUMN_KEY")!=null&&rs.getString("COLUMN_KEY").trim().equals("PRI")){
					PK_KEY=columnName;
				}
				if ("INT".equals(dataType)) {
					cl.setDatatype("int");
				} else if (dataType.indexOf("FLOAT") >= 0) {
					cl.setDatatype("double");
				} else if (dataType.indexOf("DOUBLE") >= 0) {
					cl.setDatatype("double");
				} else if (dataType.indexOf("DATETIME") >= 0
						|| dataType.indexOf("TIME") >= 0) {
					cl.setDatatype("java.util.Date");
				} else{
					cl.setDatatype("string");
				}
				
				list.add(cl);
			}
			root.put("PK_KEY", PK_KEY);
			root.put("tabCon", tabCon);
			root.put("totalcount", totalcount);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}
	
	/**
	 * 将首字母大写,首字母后面全部小写
	 * @param filename
	 * @return
	 */
	public String toFistUpp(String filename){
		if(filename!=null&&!filename.trim().equals("")){
			return filename.substring(0,1).toUpperCase()+filename.substring(1).toLowerCase();
		}
		return filename;
	}
	
	public void mkdirs(String path){
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	public void convert(Map<String,Object> rootMap,String modelpath,String modelname,String filepath){
		Writer out = null;
		Configuration cfg = new Configuration();
		//读取模板目录
		File file = new File(modelpath);
		if(!file.exists()){
			file.mkdir();
		}
		//读取要生成的文件，如果已经存在，则删除
		File fil = new File(filepath);
		if(fil.exists()){
			fil.delete();
		}
		try {
			//生成新文件
			fil.createNewFile();
			//按模板生成文件
			cfg.setDirectoryForTemplateLoading(file);
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			cfg.setDefaultEncoding("UTF-8");
			Template temp=cfg.getTemplate(modelname);
			out = new OutputStreamWriter(new FileOutputStream(filepath));
			temp.process(rootMap, out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String defaultString(String str){
		return str == null ? "" : str;
	}
	
}
