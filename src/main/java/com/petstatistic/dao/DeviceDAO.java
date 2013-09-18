package com.petstatistic.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class DeviceDAO {
	@PersistenceContext
    transient EntityManager entityManager;
//	public List<Device> getDevices() {
//		return entityManager.createQuery("SELECT o FROM Device o", Device.class).getResultList();
//	}


}
