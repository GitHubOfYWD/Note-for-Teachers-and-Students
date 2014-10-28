package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;






public class Mysql {
	static Connection conn;

	static Statement st;

	private String driver = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "123456";

	public static void main(String[] args) {
	}

	public Mysql() {
	}

	public static String Login(String username, String password) {
		conn = getConnection();
		String result = new String();
		try {
			st = (Statement) conn.createStatement();
			String sql = "select * from user where username='" + username + "'and password='"+password+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				conn.close();
				return "success";
			}
			else{
				conn.close();
				return "fail";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}
	
	public String CreateTopic(String topic,String username) {
		conn = getConnection();
		try {
			String sql = "select * from userinfo where username='"+username+ "' and topic='"+topic+"' and host='"+username+"'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return "fail";
			}
			sql = "insert into userinfo(username,topic,host,flag) values('"+ username + "','" + topic + "','"+username+"','1')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}
	
	public String InviteUser(String topic,String username,String invitename) {
		conn = getConnection();
		try {
			String sql = "select * from userinfo where username='"+invitename+ "' and topic='"+topic+"' and host='"+username+"'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return "fail";
			}
			sql = "insert into userinfo(username,topic,host,flag) values('"+ invitename + "','" + topic + "','"+username+"','0')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}
	
	public String Register(String username,String password) {
		conn = getConnection();
		try {
			String sql = "insert into user(username,password) values('"+ username + "','" + password + "')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}
	
	public void UserTopic(String username,List<UserTopic> ht,List<UserTopic> it) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "select * from userinfo where username='"+username+"'";
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			UserTopic tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new UserTopic();
				tmp.username= rs.getString("username");
				tmp.topic=rs.getString("topic");
				tmp.host=rs.getString("host");
				tmp.flag=rs.getString("flag");
				if(tmp.flag.equals("1")){
					ht.add(tmp);
				}
				else{
					it.add(tmp);
				}
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static Connection getConnection() {
		Connection con = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/note", "root", "123456");
		} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return con;
	}
}
