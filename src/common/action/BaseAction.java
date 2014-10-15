package common.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	//获取HttpServletRequest中parameter
	public String obtainParameter(String paramName){
		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		String[] strs = (String[]) parameters.get(paramName);
		return strs[0];
	}
	//获取HttpServletRequest中parameter数组
	public String[] obtainParameters(String paramName){
		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		return (String[]) parameters.get(paramName);
	}
	
	//获取模拟HttpSession的Map对象
	public Map<String, Object> obtainSession(){
		return ActionContext.getContext().getSession();
	}
	
	//获取模拟ServletContext的Map对象
	public Map<String, Object> obtainApplication(){
		return ActionContext.getContext().getApplication();
	}
	
	//获取根目录文件的realPath
	public String obtainRealPath(String path){
		return ServletActionContext.getServletContext().getRealPath("/");
	}
}
