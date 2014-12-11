package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Mysql {
	static Connection conn;

	static Statement st;
	static Statement st1;
	static Statement st2;

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
			String sql = "select * from user where username='" + username
					+ "'and password='" + password + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				conn.close();
				return "success";
			} else {
				conn.close();
				return "fail";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public String CreateTopic(String topic, String username) {
		conn = getConnection();
		try {
			String sql = "select * from userinfo where username='" + username
					+ "' and topic='" + topic + "' and host='" + username + "'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return "fail";
			}
			sql = "insert into userinfo(username,topic,host,flag) values('"
					+ username + "','" + topic + "','" + username + "','1')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public String SentInvitation(String topic, String username,
			String invitename, String host) {
		conn = getConnection();
		try {
			String sql = "select * from user where username='" + invitename
					+ "'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
			} else {
				return "the user doesn't exist";
			}
			if (topic.equals("")) {
				return "the topic is empty";
			}
			sql = "select * from userinfo where username='" + invitename
					+ "' and topic='" + topic + "' and host='" + host + "'";
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				return "the user has been already invited in this topic";
			}
			sql = "insert into invitation(inviting,invited,topic,host) values('"
					+ username
					+ "','"
					+ invitename
					+ "','"
					+ topic
					+ "','"
					+ host + "')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public String HasInvitation(String username) {
		conn = getConnection();
		try {
			String sql = "select * from invitation where invited='" + username
					+ "'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println("invitation");
				return "yes";
			} else {
				System.out.println("no invitation");
				return "no";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public String InviteUser(String topic, String username, String invitename,
			String host) {
		conn = getConnection();
		try {
			String sql = "select * from user where username='" + invitename
					+ "'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
			} else {
				return "fail";
			}
			if (topic.equals("")) {
				return "fail";
			}
			sql = "select * from userinfo where username='" + invitename
					+ "' and topic='" + topic + "' and host='" + host + "'";
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				return "fail";
			}
			sql = "insert into userinfo(username,topic,host,flag) values('"
					+ invitename + "','" + topic + "','" + host + "','0')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public String Register(String username, String password) {
		conn = getConnection();
		try {
			String sql = "insert into user(username,password) values('"
					+ username + "','" + password + "')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public String PublishMessage(String username, String topic, String message,
			String author, int parentid) {
		conn = getConnection();
		try {
			Date date = new Date();
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
			String now = String.valueOf(nowTime);
			String day =now.substring(0,10);
			String sql = "insert into board(host,topic,message,time,date,author,parentid) values('"
					+ username
					+ "','"
					+ topic
					+ "','"
					+ message
					+ "','"
					+ now
					+ "','"
					+ day
					+ "','" 
					+ author
					+ "','" 
					+ parentid 
					+ "')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close();
			return "success";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "fail";
		}
	}

	public void InvitationList(List<Invite> iv, String username) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "select * from invitation where invited='" + username
					+ "'";
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			Invite tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new Invite();
				tmp.host = rs.getString("host");
				tmp.topic = rs.getString("topic");
				tmp.invited = rs.getString("invited");
				tmp.inviting = rs.getString("inviting");
				iv.add(tmp);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void AcceptInvitation(String topic, String inviting, String invited,
			String host) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "delete from invitation where invited='" + invited
					+ "' and inviting='" + inviting + "' and topic='" + topic
					+ "'";
			System.out.println(sql);
			st = (Statement) conn.createStatement();
			st.execute(sql);
			sql = "insert into userinfo(username,topic,host,flag) values('"
					+ invited + "','" + topic + "','" + host + "','0')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void GetTopic(List<TopicMessage> tp, String topic, String username) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "select * from board where host='" + username
					+ "' and topic='" + topic + "'";
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			TopicMessage tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new TopicMessage();
				tmp.host = rs.getString("host");
				tmp.topic = rs.getString("topic");
				tmp.time = rs.getString("time");
				tmp.message = rs.getString("message");
				System.out.println(tmp.message);
				tp.add(tmp);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void ShowMessage(List<TopicMemMessage> tmm, String topic,
			String author, String host, int parentid) {

		conn = getConnection();
		String result = new String();
		String sql = new String();
		try {
			if (parentid != 0) {
				sql = "select * from board where parentid='" + parentid
						+ "' and topic='" + topic + "'and host='" + host + "'";
			} else {
				sql = "select * from board where author='" + author
						+ "' and topic='" + topic + "'and host='" + host
						+ "'and parentid=\'0\'";
			}
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			TopicMemMessage tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new TopicMemMessage();
				tmp.host = rs.getString("host");
				tmp.author = rs.getString("author");
				tmp.topic = rs.getString("topic");
				tmp.time = rs.getString("time");
				tmp.message = rs.getString("message");
				tmp.id = rs.getInt("id");
				tmp.parentid = rs.getInt("parentid");
				System.out.println(tmp.message);
				tmm.add(tmp);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void ShowMessageOfTime(List<TopicMemMessage> tmm, String topic,
			String author, String host, int parentid,String date) {

		conn = getConnection();
		String result = new String();
		String sql = new String();
		try {
				sql = "select * from board where date='" 
						+ date
						+ "' and topic='"
						+ topic
						+ "'and host='" 
						+ host
						+ "'and parentid=\'0\'";
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			TopicMemMessage tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new TopicMemMessage();
				tmp.host = rs.getString("host");
				tmp.author = rs.getString("author");
				tmp.topic = rs.getString("topic");
				tmp.time = rs.getString("time");
				tmp.message = rs.getString("message");
				tmp.id = rs.getInt("id");
				tmp.parentid = rs.getInt("parentid");
				System.out.println(tmp.message);
				tmm.add(tmp);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void ShowMember(String host, String topic, List<Member> member) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "select username from userinfo where host='" + host
					+ "' and topic='" + topic + "'";
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			Member tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new Member();
				tmp.name = rs.getString("username");
				System.out.println(tmp);
				member.add(tmp);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void ShowTime(String host, String topic, List<Time> time) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "select distinct date from board where topic='" 
					+ topic
					+ "' and parentid="
					+ 0;
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			Time tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new Time();
				tmp.t = rs.getString("date");
				System.out.println(tmp);
				time.add(tmp);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void UserTopic(String username, List<UserTopic> ht,
			List<UserTopic> it) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "select * from userinfo where username='" + username
					+ "'";
			st = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			UserTopic tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new UserTopic();
				tmp.username = rs.getString("username");
				tmp.topic = rs.getString("topic");
				tmp.host = rs.getString("host");
				tmp.flag = rs.getString("flag");
				ht.add(tmp);
				it.add(tmp);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void ShowFavorite(String username, List<FavoriteMessage> fm) {

		conn = getConnection();
		String result = new String();
		try {
			String sql = "select * from favorite where username='" + username
					+ "'";
			st1 = (Statement) conn.createStatement();
			System.out.println(sql);
			ResultSet rs = st1.executeQuery(sql);
			FavoriteMessage tmp;
			while (rs.next()) { // 判断是否还有下一个数据
				tmp = new FavoriteMessage();
				tmp.username = rs.getString("username");
				tmp.id = rs.getInt("id");
				String sql1 = "select * from board where id='" + tmp.id + "'";
				System.out.println(sql1);
				st2 = (Statement) conn.createStatement();
				ResultSet rs1 = st2.executeQuery(sql1);
				while (rs1.next()) {
					tmp.host = rs1.getString("host");
					tmp.author = rs1.getString("author");
					tmp.topic = rs1.getString("topic");
					tmp.time = rs1.getString("time");
					tmp.message = rs1.getString("message");
					tmp.parentid = rs1.getInt("parentid");
				}
				fm.add(tmp);
				System.out.println(sql1);
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void AddFavorite(String username, int parentid) {
		conn = getConnection();
		String result = new String();
		try {
			String sql = "insert into favorite(username,id) values('"
					+ username + "','" + parentid + "')";
			st = (Statement) conn.createStatement();
			st.execute(sql);
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
	public static Connection getConnectiona() {
		Connection con = null; // 创建用于连接数据库的Connection对象
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

			con = DriverManager.getConnection(
					"jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_noteforse", "20x0kxlkwn", "0mxjm0012wl5053l42wwl42wxwk3zz2jxy03l4mm");// 创建数据连接
																			// "root"为用户名，123456为密码

		} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return con; // 返回所建立的数据库连接

	}
}
