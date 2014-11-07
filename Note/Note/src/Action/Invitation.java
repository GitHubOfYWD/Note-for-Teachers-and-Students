package Action;

import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.Action;


public class Invitation implements Action{
	public String username=new String();
	public String password=new String();
	public List<Invite> iv;
	

	public void setIv(List<Invite> Iv){
		this.iv=iv;
	}
	public List<Invite> getIv(){
		return this.iv;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}

	/*public String Login(){
		Mysql sql=new Mysql();
		System.out.println(password);
		ht=new ArrayList<UserTopic>();
		it=new ArrayList<UserTopic>();
		if(sql.Login(username,password).equals("success")){
			message="login success";
			if(sql.HasInvitation(username).equals("yes")){
				newinvitation="你收到了新的邀请";
			}
			else{
				newinvitation="";
			}
			System.out.println(message);
			sql.UserTopic(username,ht,it);
			System.out.println("here");
			return "login success";
		}
		else{
			message="the username doesn't exist or the password is not correct";
			return "login fail";
		}
	}*/
	
	public String Register(){
		return "go to register";
	}
	
	public String execute() throws Exception {
		Mysql sql=new Mysql();
		System.out.println(password);
		iv=new ArrayList<Invite>();
		sql.InvitationList(iv,username);
		return "success";
	}
}

class Invite{
	public String invited=new String();
	public String inviting=new String();
	public String host=new String();
	public String topic=new String();
}