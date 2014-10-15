package common.model;

import java.util.Date;

public class User implements java.io.Serializable {

	private Integer id;
	private String name;
	private Date birthday;
	private Double money;
	public User(){}
	public User(String name, Date birthday, Double money){
		this.birthday = birthday;
		this.name = name;
		this.money = money;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
}
