package com.petstatistic.vo;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity
@RooJpaActiveRecord
public class OverView {
	private String channel;//渠道
	private Integer newUsers;//新增用户
	private Integer dailyLiving;//日活
	private Integer weeklyLiving;//周活
	private Integer mounthlyLiving;//月活
	private Integer newRegistors;//新增注册用户
	private Integer allRegistors;//所有注册用户
	private Double registrationRate;//注册率
	private Integer allUsers;//所有用户
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Integer getNewUsers() {
		return newUsers;
	}
	public void setNewUsers(Integer newUsers) {
		this.newUsers = newUsers;
	}
	public Integer getDailyLiving() {
		return dailyLiving;
	}
	public void setDailyLiving(Integer dailyLiving) {
		this.dailyLiving = dailyLiving;
	}
	public Integer getWeeklyLiving() {
		return weeklyLiving;
	}
	public void setWeeklyLiving(Integer weeklyLiving) {
		this.weeklyLiving = weeklyLiving;
	}
	public Integer getMounthlyLiving() {
		return mounthlyLiving;
	}
	public void setMounthlyLiving(Integer mounthlyLiving) {
		this.mounthlyLiving = mounthlyLiving;
	}
	public Integer getNewRegistors() {
		return newRegistors;
	}
	public void setNewRegistors(Integer newRegistors) {
		this.newRegistors = newRegistors;
	}
	public Integer getAllRegistors() {
		return allRegistors;
	}
	public void setAllRegistors(Integer allRegistors) {
		this.allRegistors = allRegistors;
	}
	public Double getRegistrationRate() {
		return registrationRate;
	}
	public void setRegistrationRate(Double registrationRate) {
		this.registrationRate = registrationRate;
	}
	public Integer getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(Integer allUsers) {
		this.allUsers = allUsers;
	}
	
}
