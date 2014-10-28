package Action;

import com.opensymphony.xwork2.Action;

public class CreateTopic implements Action {
	public String topic=new String();
	public String topicmessage=new String();
	public String username=new String();
	public String invitename=new String();
	
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
	
	public String Invite(){
		Mysql sql=new Mysql();
		if(sql.InviteUser(topic,username,invitename).equals("success")){
			topicmessage="Invite successfully";
			return "invite success";
		}
		else{
			topicmessage="The user has been already invited";
			return "invite fail";
		}
	}

}
