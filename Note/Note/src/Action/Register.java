package Action;

import com.opensymphony.xwork2.Action;


public class Register implements Action {
	public String username=new String();
	public String password=new String();
	public String message=new String();
	
	public void setMessage(String message){
		this.message=message;
	}
	public String getMessage(){
		return this.message;
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

	public String execute() throws Exception {
		Mysql sql=new Mysql();
		System.out.println(username);
		if(sql.Register(username,password).equals("success")){
			message="register success";
			return "register success";
		}
		else{
			message= "the username has already existed";
			return "register fail";
		}
	}

}
