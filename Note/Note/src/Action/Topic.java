package Action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class Topic implements Action {
	public String topic=new String();
	public String username=new String();
	public String pmessage=new String();
	public String message=new String();
	public String host=new String();
	public String password=new String();
	public List<TopicMessage> tpm;
	public List<TopicMemMessage> tmm;
	public List<Member>member;
	public String invitename=new String();
	public String author=new String();
	
	
	public void setAuthor(String author){
		this.author=author;
	}
	public String getAuthor(){
		return this.author;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setHost(String host){
		this.host=host;
	}
	public String getHost(){
		return this.host;
	}
	public void setMember(List<Member> mem){
		this.member=mem;
	}
	public List<Member> getMember(){
		return this.member;
	}
	public void setTmm(List<TopicMemMessage> tmm){
		this.tmm=tmm;
	}
	public List<TopicMemMessage> getTmm(){
		return this.tmm;
	}
	public void setTpm(List<TopicMessage> tpm){
		this.tpm=tpm;
	}
	public List<TopicMessage> getTpm(){
		return this.tpm;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setTopic(String topic){
		this.topic=topic;
	}
	public String getTopic(){
		return this.topic;
	}
	public void setPmessage(String pmessage){
		this.pmessage=pmessage;
	}
	public String getPmessage(){
		return this.pmessage;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public String getMessage(){
		return this.message;
	}
	public void setInvitename(String invitename){
		this.invitename=invitename;
	}
	public String getInvitename(){
		return this.invitename;
	}
	
	
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String ShowHost(){
		tpm=new ArrayList<TopicMessage>();
		Mysql sql=new Mysql();
		sql.GetTopic(tpm,topic,host);
		System.out.println("show host topic success");
		return "show host topic success";
	}
	
	public String ShowInvited(){
		tpm=new ArrayList<TopicMessage>();
		Mysql sql=new Mysql();
		sql.GetTopic(tpm,topic,host);
		System.out.println("show host topic success");
		return "show invited topic success";
	}
	
	public String GoPublish(){
		return "go publish";
	}
	
	public String Publish(){
		Mysql sql=new Mysql();
		if(sql.PublishMessage(host,topic,pmessage,author).equals("success")){
			message="发布成功";
		}
		else{
			message="发布失败";
		}
		return "publish";
	}
	
	public String ShowMember(){
		Mysql sql=new Mysql();
		member=new ArrayList<Member>();
		sql.ShowMember(host,topic,member);
		return "show member";
	}
	
	public String Invite(){
		Mysql sql=new Mysql();
		if(sql.InviteUser(topic,username,invitename,host).equals("success")){
			message="Invite successfully";
		}
		else{
			message="The user has been already invited or no such user";
		}
		tmm=new ArrayList<TopicMemMessage>();
		sql.ShowMessage(tmm,topic,author,host);
		return "invite";
	}
	
	
	public String ShowMessage(){
		tmm=new ArrayList<TopicMemMessage>();
		Mysql sql=new Mysql();
		sql.ShowMessage(tmm,topic,author,host);
		System.out.println("show topic member message success");
		if(author.equals(username)){
			return "show my topic message";
		}
		else{
			return "show others topic message";
		}
	}
	
}


class Member{
	public String name=new String();
}

class TopicMessage{
	public String topic=new String();
	public String host=new String();
	public String time=new String();
	public String message=new String();
}
class TopicMemMessage{
	public String host=new String();
	public String topic=new String();
	public String author=new String();
	public String time=new String();
	public String message=new String();
}