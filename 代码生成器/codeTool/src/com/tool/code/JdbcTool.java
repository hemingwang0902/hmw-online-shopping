package  com.tool.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTool {
	private static String url = "jdbc:mysql://localhost:3306/baizhi?useUnicode=true&amp;characterEncoding=UTF-8";
	private static String name = "root";
	private static String pass = "root";
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, name, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭链接
	 * @param rs
	 * @param ps
	 * @param co
	 */
	public static void close(ResultSet rs,PreparedStatement ps,Connection co){
		if(null != rs){
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(null != ps){
			try {ps.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(null != co){
			try {co.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
