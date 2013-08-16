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
	private String channel;//����
	private Integer newUsers;//�����û�
	private Integer dailyLiving;//�ջ�
	private Integer weeklyLiving;//�ܻ�
	private Integer mounthlyLiving;//�»�
	private Integer newRegistors;//����ע���û�
	private Integer allRegistors;//����ע���û�
	private Double registrationRate;//ע����
	private Integer allUsers;//�����û�
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
