package web.action;

import common.action.BaseAction;

public class TestAction extends BaseAction {
	
	public String execute(){
		System.out.println(obtainRealPath("/upload"));
		System.out.println("name:" + obtainParameter("name").toString());
		for(String s : obtainParameters("age")){
			System.out.println(s);
		}
		return SUCCESS;
	}
}
