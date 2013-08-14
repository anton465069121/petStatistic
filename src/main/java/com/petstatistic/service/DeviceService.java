package com.petstatistic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petstatistic.dao.DeviceDAO;
import com.petstatistic.domain.Device;

@Service
public class DeviceService {
	@Autowired
	DeviceDAO deviceDao;
	
	public List<Device> getDevices() {
		return deviceDao.getDevices();
	}

}
