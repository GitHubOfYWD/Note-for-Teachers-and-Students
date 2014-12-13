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
	public List<Time>time;
	public String date;
	public List<UserTopic> ht;
	
	public String invitename=new String();
	public String author=new String();
	public int id;
	public int parentid;
	public String parentmessage=new String();
	
	
	
	public void setHt(List<UserTopic> ht){
		this.ht=ht;
	}
	public List<UserTopic> getHt(){
		return this.ht;
	}
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return this.date;
	}
	public void setTime(List<Time> time){
		this.time=time;
	}
	public List<Time> getTime(){
		return this.time;
	}
	public void setParentmessage(String parentmessage){
		this.parentmessage=parentmessage;
	}
	public String getParentmessage(){
		return this.parentmessage;
	}
	public void setParentid(String parentid){
		this.parentid=Integer.valueOf(parentid).intValue();
	}
	public int getParentid(){
		return this.parentid;
	}
	public void setId(String id){
		this.id=Integer.valueOf(id).intValue();
	}
	public int getId(){
		return this.id;
	}
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
	
	public String ShowAll(){
		ht=new ArrayList<UserTopic>();
		Mysql sql=new Mysql();
		sql.ShowAllTopic(ht,username);
		System.out.println("show host topic success");
		return "show all topic";
	}
	
	public String VisitTopic(){
		tmm=new ArrayList<TopicMemMessage>();
		Mysql sql=new Mysql();
		sql.ShowAllMessage(tmm,topic,author,host,parentid);
		System.out.print("show here");
		for(int i=0;i<tmm.size();i++){
			System.out.print(tmm.get(i).message);
		}
		System.out.println("show all message in a topic");
		return "visit topic";
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
		if(sql.PublishMessage(host,topic,pmessage,author,parentid).equals("success")){
			message="发布成功";
		}
		else{
			message="发布失败";
		}
		return "publish";
	}
	
	public String ShowTime(){
		Mysql sql=new Mysql();
		time=new ArrayList<Time>();
		sql.ShowTime(host,topic,time);
		return "show time";
	}
	
	public String ShowMember(){
		Mysql sql=new Mysql();
		member=new ArrayList<Member>();
		sql.ShowMember(host,topic,member);
		return "show member";
	}
	
	public String Join(){
		Mysql sql=new Mysql();
		if(sql.JoinTopic(username,topic,host).equals("success")){;
			message="join successfully";
			return "join topic";
		}
		else
		{
			message="the user is already in the group";
			return "join topic";
		}
	}
	
	
	public String SentInvitation(){
		Mysql sql=new Mysql();
		String tmp=new String();
		tmp=sql.SentInvitation(topic,username,invitename,host);
		if(tmp.equals("success")){
			message="Invite successfully";
		}
		else{
			message=tmp;
		}
		tmm=new ArrayList<TopicMemMessage>();
		sql.ShowMessage(tmm,topic,author,host,parentid);
		return "sent invitation";
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
		sql.ShowMessage(tmm,topic,author,host,parentid);
		return "invite";
	}
	
	
	public String ShowMessageOfTime(){
		tmm=new ArrayList<TopicMemMessage>();
		Mysql sql=new Mysql();
		sql.ShowMessageOfTime(tmm,topic,author,host,parentid,date);
		System.out.print("show here");
		for(int i=0;i<tmm.size();i++){
			System.out.print(tmm.get(i).message);
		}
		System.out.println("show topic member message success");
		return "show my topic message";
	}
	
	public String ShowAllMessage(){
		tmm=new ArrayList<TopicMemMessage>();
		Mysql sql=new Mysql();
		sql.ShowAllMessage(tmm,topic,author,host,parentid);
		System.out.print("show here");
		for(int i=0;i<tmm.size();i++){
			System.out.print(tmm.get(i).message);
		}
		System.out.println("show all message in a topic");
		return "show all message in a topic";
	}
	
	
	public String ShowMessage(){
		tmm=new ArrayList<TopicMemMessage>();
		Mysql sql=new Mysql();
		sql.ShowMessage(tmm,topic,author,host,parentid);
		System.out.println("show topic member message success");
		if(author.equals(username)&&parentid==0){
			return "show my topic message";
		}
		if(parentid>0){
			return "show the relavant discussion";
		}
		else{
			return "show others topic message";
		}
	}
	public String AddFavorite(){
		Mysql sql=new Mysql();
		sql.AddFavorite(username,parentid);
		message="添加成功";
		tmm=new ArrayList<TopicMemMessage>();
		sql.ShowMessage(tmm,topic,author,host,parentid);
		System.out.println("show topic member message success");
		if(author.equals(username)&&parentid==0){
			return "show my topic message";
		}
		if(parentid>0){
			return "show the relavant discussion";
		}
		else{
			return "show others topic message";
		}
	}
	/*public String ShowFavorite(){
		Mysql sql=new Mysql();
		fm=new ArrayList<FavoriteMessage>();
		sql.ShowFavorite(username,fm);
		return "show favorite";
	}*/
	
}


class Member{
	public String name=new String();
}
class Time{
	public String t=new String();
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
	public int id;
	public int parentid;
}
