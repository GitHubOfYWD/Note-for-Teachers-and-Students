package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

public class CreateTopic implements Action {
	public String topic=new String();
	public String topicmessage=new String();
	public String invitemessage=new String();
	public String username=new String();
	public String password=new String();
	public String host=new String();
	public String invitename=new String();
	public String author=new String();
	
	
	public void setAuthor(String author){
		this.author=author;
	}
	public String getAuthor(){
		return this.author;
	}
	public void setHost(String host){
		this.host=host;
	}
	public String getHost(){
		return this.host;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setInvitename(String invitename){
		this.invitename=invitename;
	}
	public String getInvitename(){
		return this.invitename;
	}
	
	public void setTopic(String topic){
		this.topic=topic;
	}
	public String getTopic(){
		return this.topic;
	}
	
	public void setInvitemessage(String invite){
		this.invitemessage=invitemessage;
	}
	public String getInvitemessage(){
		return this.invitemessage;
	}
	public void setTopicmessage(String topic){
		this.topicmessage=topicmessage;
	}
	public String getTopicmessage(){
		return this.topicmessage;
	}

	public String execute() throws Exception {
		return null;
	}
	
	public String Set() throws Exception {
		Mysql sql=new Mysql();
		if(sql.CreateTopic(topic,username).equals("success")){
			topicmessage="The topic is created successfully";
			return "create success";
		}
		else{
			topicmessage="The topic has already existed";
			return "create fail";
		}
	}
	
	public String Go(){
		System.out.println("go to create");
		return "go to create";
	}
	
	public String SentInvitation(){
		Mysql sql=new Mysql();
		String tmp=new String();
		tmp=sql.SentInvitation(topic,username,invitename,username);
		if(tmp.equals("success")){
			topicmessage="Invite successfully";
		}
		else{
			topicmessage=tmp;
		}
		return "sent invitation";
	}
	
	public String Invite(){
		Mysql sql=new Mysql();
		if(sql.InviteUser(topic,username,invitename,author).equals("success")){
			topicmessage="Invite successfully";
			return "invite success";
		}
		else{
			topicmessage="The user has been already invited or no such user";
			return "invite fail";
		}
	}
	

}
