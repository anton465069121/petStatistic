package com.petstatistic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.petstatistic.domain.Device;

@Component
public class DeviceDAO {
	@PersistenceContext
    transient EntityManager entityManager;
	public List<Device> getDevices() {
		return entityManager.createQuery("SELECT o FROM Device o", Device.class).getResultList();
	}


}
