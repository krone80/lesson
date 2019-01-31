package CDI;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "myInfo")
@RequestScoped
public class MyInfo implements Serializable {
	private String myName;
	private String myId;
	
	public MyInfo() {	}
	
	public MyInfo(String myName, String myId) {
		this.myName = myName;
		this.myId = myId;
	}

	public void setMyInfo(String myName, String myId) {
		this.myName = myName;
		this.myId = myId;
	}
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}
}
