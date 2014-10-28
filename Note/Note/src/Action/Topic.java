package Action;

import com.opensymphony.xwork2.Action;

public class Topic implements Action {
	public String topic=new String();
	public String username=new String();
	
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
	
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String ShowHost(){
		System.out.println("show host topic success");
		return "show host topic success";
	}
	
	public String GoPublish(){
		return "go publish";
	}
	
}

class TopicMessage{
	String topic=new String();
	String host=new String();
	String time=new String();
	String message=new String();
}