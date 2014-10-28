package login;
import java.sql.Connection;  
//import java.sql.Date;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
  
public class mysqltest {  
    // 创建静态全局变量  
    static Connection conn;  
  
    static Statement st;  
  
    public static void main(String[] args) 
    {
    	mysqltest sql=new mysqltest();
    }
    public mysqltest(){ 
//    	query();
//        insert();   //插入添加记录  
//        update();   //更新记录数据  
//        query();
//        delete("\'Gernet\'");   //删除记录  
//        query();    //查询记录并显示  
    }  
      
    /* 插入数据记录，并输出插入的数据记录数*/  
    public static boolean insert(String str1,String str2) {  
          
        conn = getConnection(); // 首先要获取连接，即连接到数据库  
  
        try {  
            String sql = "INSERT INTO member(username, password)"  
                    + " VALUES ('"+str1+"','"+str2+"')";  // 插入数据的sql语句  
              
            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
              
            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
              
            System.out.println("向member表中插入 " + count + " 条数据"); //输出插入操作的处理结果  
              
            conn.close();   //关闭数据库连接  
            return true;
              
        } catch (SQLException e) {  
            System.out.println("插入数据失败" + e.getMessage());  
            return false;
        }  
    }  
     
    public static String Check (String str){
    	 conn = getConnection(); //同样先要获取连接，即连接到数据库  
         try {  
             String sql = "select *from member where username='"+str+"'";     // 查询数据的sql语句  
             st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
               
             ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
             String pw=new String();
             while (rs.next()) { // 判断是否还有下一个数据  
                 pw = rs.getString("password");
                 System.out.println(pw);
             }  
             conn.close();   //关闭数据库连接    
             return pw;
               
         } catch (SQLException e) {  
             System.out.println("查询数据失败");
             return null;
         }  
    }
    //public static void getInformation(String str,String name,String age,String gender,String motto,String lastlogin){
    public static void getInformation(String str,inform i){
    	conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
        	 System.out.println(str);
        	 String sql = "select *from information where name='"+str+"'";     // 查询数据的sql语句  
             st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量   
             System.out.println(sql);  
             ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
            System.out.println(sql);  
            while (rs.next()) { // 判断是否还有下一个数据  
                  
            	 i.name=rs.getString("name");
                 i.age=String.valueOf(rs.getInt("age"));
                 i.gender=rs.getString("gender");
                 i.motto=rs.getString("motto");
                 i.lastlogin=rs.getString("lastlogin");
//                 System.out.println(name);
//                 System.out.println(age);
//                 System.out.println(motto); 
              
            }
            System.out.println(sql);  
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            System.out.println("查询数据失败");  
        }
    }
    
    
    public static void getDiaryInform(String str,diaryInform di){
    	conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
        	di.name=str;
        	 String sql = "select title,time from diary where name='"+str+"'";     // 查询数据的sql语句  
             st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量   
             System.out.println(sql);  
             ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
            System.out.println(sql); 
            di.number=0;
            while (rs.next()) { // 判断是否还有下一个数据  
            	 di.time[di.number]=rs.getString("time");
            	 System.out.println( di.time[di.number]);
            	 di.title[di.number]=rs.getString("title");
            	 System.out.println( di.title[di.number]);
            	 di.number++;
//                 System.out.println(name);
//                 System.out.println(age);
//                 System.out.println(motto); 
              
            }
            System.out.println(sql);  
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            System.out.println("查询数据失败");  
        }
    }
    
    
    
    
    public static void getDiary(int i,diaryInform di){
    	conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
       	 	 di.selectedTime=di.time[i];
        	 String sql = "select title,text from diary where time='"+di.time[i]+"'and title='"+di.title[i]+"'and name='"+di.name+"'";     // 查询数据的sql语句  
             st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量   
             System.out.println(sql);  
             ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
            while (rs.next()) { // 判断是否还有下一个数据  
            	 di.selectedDiary=rs.getString("text");
            	 di.selectedTitle=rs.getString("title");
            }
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            System.out.println("查询数据失败");  
        }
    }
    
    
    
    
    //saveModifiedDiary(name1.getText(),title1.getText(),text1.getText(),tmp_time);
    
    public static void saveModifiedDiary(String n,String title,String text,String time) {  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
        	 Date date = new Date();//获得系统时间.
             String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
             String now = String.valueOf(nowTime);//把时间转换
            String sql = "update diary set title='" +title+"',text='"+text+"',time='"+now+"'  where name ='"+n+"' and time='"+time+"'";// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("person表中更新 " + count + " 条数据");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("更新数据失败");  
        }  
    }  
    
    
    
    /* 更新符合要求的记录，并返回更新的记录数目*/  
    public static void updateLastLogin(String str) {  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
        	 Date date = new Date();//获得系统时间.
             String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
             String now = String.valueOf(nowTime);//把时间转换
            String sql = "update information set lastlogin='" +now+"' where name ='"+str+"'";// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("person表中更新 " + count + " 条数据");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("更新数据失败");  
        }  
    }  
    public static void createInformation(String n){
    	conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "insert into information(name) values('"+n+"')";// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("person表中更新 " + count + " 条数据");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("更新数据失败");  
        } 
    }
    //modifyInformation(age1.getText(),gender1.getText(),motto1.getText());
    public static void modifyInformation(String n,String a,String g,String m){
    	conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "update information set age='"+a+"',gender='"+g+"',motto='"+m+" 'where name='"+n+"'";// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("person表中更新 " + count + " 条数据");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("更新数据失败");  
        } 
    }
    
    
    //saveDiary(name1.getText(),title1.getText(),text1.getText())
    public static void saveDiary(String n,String ti,String te){
    	conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
        	Date date = new Date();//获得系统时间.
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
            String now = String.valueOf(nowTime);//把时间转换
            String sql = "insert into diary(name,title,text,time) values('"+n+"','"+ti+"','"+te+"','"+now+"')";// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("person表中更新 " + count + " 条数据");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) { 
        	System.out.println(e.getMessage());  
            System.out.println("更新数据失败");  
        } 
    }
    
    /* 查询数据库，输出符合要求的记录的情况*/  
    public static void query() {  
          
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "select * from person";     // 查询数据的sql语句  
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
            System.out.println("最后的查询结果为：");  
            while (rs.next()) { // 判断是否还有下一个数据  
                  
                // 根据字段名获取相应的值   
                int id = rs.getInt("id");  
                String name = rs.getString("name");  
                String age = rs.getString("age"); 
                  
                //输出查到的记录的各个字段的值  
                System.out.println(id+" "+name + " " + age +"\n");  
              
            }  
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("查询数据失败");  
        }  
    }  
  
    /* 删除符合要求的记录，输出情况*/  
    public static void delete(String tmp) {  
  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "delete from person  where name = "+tmp;// 删除数据的sql语句  
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行sql删除语句，返回删除数据的数量  
              
            System.out.println("person表中删除 " + count + " 条数据\n");    //输出删除操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("删除数据失败");  
        }  
          
    }  
      
    /* 获取数据库连接的函数*/  
    public static Connection getConnection() {  
        Connection con = null;  //创建用于连接数据库的Connection对象  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/ywd", "root", "123456");// 创建数据连接  "root"为用户名，123456为密码
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
        return con; //返回所建立的数据库连接  
    }  
}  
