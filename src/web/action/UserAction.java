package web.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import common.valuebean.UserCount;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;

import service.UserService;
import common.model.User;

public class UserAction implements Action{
	private User user;
	private List users;
	private Map map;
	@Autowired
	private UserService userService;
	public  void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@Override
	public String execute() {
		users = userService.find("from User where birthday < now()");
		System.out.println("==" + users.size() + "--" + users.get(0).getClass());
		
		/*for(Object u : users){
			Map t = (Map)u;
			tt.add(new UserCount((String)t.get(0), (long)t.get(1)));
			//System.out.println("==" + tt.get(0));
		}*/
		
		/*user = userService.get(24);
		System.out.println("---" + user.getMoney());*/
		return "success";
	}

	public String regist(){
		System.out.println("---"+user.getMoney());
		user.setBirthday(new Date());
		userService.save(user);
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	
	public List getUsers(){
		return users;
	}
	
}
