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
	
	public static void main(String[] args){
		TextCode code = new TextCode();
		//TODO 运行之前先修改此处
		code.create("何明旺", "t_user", "用户信息","F:/workspace/google_myEclipseWorkspace2/百知网/1.代码区/1.项目/baizhi");
	}
	
	/**
	 * 创建文件
	 * @param auth      作者
	 * @param tablename 表名
	 * @param tablecomtent 表注释
	 * @param directory 存放目录
	 */
	public void create(String auth,String tablename,String tablecomtent,String directory){
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
		String filename= (tablename.toUpperCase().startsWith("T_") ? tablename.substring(2) : tablename).toLowerCase();
		
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("tableName", tablename.toUpperCase());
		root.put("className", this.toFistUpp(filename));
		root.put("packageName", filename);
		root.put("packageNameUpperCase", filename.toUpperCase());
		root.put("sysName", SYSTEM_NAME);
		root.put("lis", this.getColumn(tablename));
		root.put("tabCon", tablecomtent);
		root.put("auth", auth);
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
		this.convert(root, modelpath, "webapp/listjsp.ftl", jsppath+filename.toLowerCase()+"list.jsp");
		this.convert(root, modelpath, "webapp/listjs.ftl",  jsppath+filename.toLowerCase()+"list.js");
		
		this.convert(root, modelpath, "webapp/formjsp.ftl", jsppath+filename.toLowerCase()+"form.jsp");
		this.convert(root, modelpath, "webapp/formjs.ftl",  jsppath+filename.toLowerCase()+"form.js");
		//生成Action文件
		this.convert(root, modelpath, "src/action/ActionList.ftl",  actionpath+toFistUpp(filename)+"List.java");
		this.convert(root, modelpath, "src/action/ActionTurn.ftl",  actionpath+toFistUpp(filename)+"Turn.java");
		this.convert(root, modelpath, "src/action/ActionSave.ftl",  actionpath+toFistUpp(filename)+"Save.java");
		this.convert(root, modelpath, "src/action/GetAction.ftl",   actionpath+"Get"+toFistUpp(filename)+".java");
		this.convert(root, modelpath, "src/action/ActionDel.ftl",   actionpath+toFistUpp(filename)+"Del.java");
		this.convert(root, modelpath, "src/action/ActionCheck.ftl", actionpath+toFistUpp(filename)+"Check.java");
		//生成Dao文件
		this.convert(root, modelpath, "src/dao/Dao.ftl",     daopath+toFistUpp(filename)+"Dao.java");
		this.convert(root, modelpath, "src/dao/ImplDao.ftl", daopath+toFistUpp(filename)+"ImplDao.java");
		//生成Service文件
		this.convert(root, modelpath, "src/service/Service.ftl", servicepath+toFistUpp(filename)+"Service.java");
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
		StringBuffer sql=new StringBuffer("select c.TABLE_NAME, c.COLUMN_NAME, c.CHARACTER_MAXIMUM_LENGTH, c.DATA_TYPE, c.COLUMN_COMMENT")
		.append(" from information_schema.columns c")
		.append(" where c.table_schema='" + TABLE_SCHEMA + "' and c.table_name=?")
		.append(" order by c.ordinal_position");
		
		Connection conn=JdbcTool.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, tablename);
			ResultSet rs = ps.executeQuery();
			Column cl = null;
			String tableName, columnName;
			while (rs.next()) {
				tableName = defaultString(rs.getString("TABLE_NAME")).trim();
				columnName = defaultString(rs.getString("COLUMN_NAME")).trim();

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

				String dataType = rs.getString("DATA_TYPE").toUpperCase();
				if ("NUMBER".equals(dataType) || "DECIMAL".equals(dataType)) {
					cl.setDatatype("long");
				} else if ("BIT".equals(dataType)) {
					cl.setDatatype("boolean");
				} else if (dataType.indexOf("INT") >= 0) {
					cl.setDatatype("int");
				} else if (dataType.indexOf("FLOAT") >= 0) {
					cl.setDatatype("float");
				} else if (dataType.indexOf("DOUBLE") >= 0) {
					cl.setDatatype("double");
				} else if (dataType.indexOf("DATE") >= 0
						|| dataType.indexOf("TIME") >= 0) {
					cl.setDatatype("java.util.Date");
				} else
					cl.setDatatype("String");
			}
			list.add(cl);
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
