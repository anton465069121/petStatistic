// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.Device;
import com.petstatistic.domain.DeviceDataOnDemand;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect DeviceDataOnDemand_Roo_DataOnDemand {
    
    declare @type: DeviceDataOnDemand: @Component;
    
    private Random DeviceDataOnDemand.rnd = new SecureRandom();
    
    private List<Device> DeviceDataOnDemand.data;
    
    public Device DeviceDataOnDemand.getNewTransientDevice(int index) {
        Device obj = new Device();
        setChannel(obj, index);
        setCreateTime(obj, index);
        setImei(obj, index);
        setMac(obj, index);
        setUserid(obj, index);
        return obj;
    }
    
    public void DeviceDataOnDemand.setChannel(Device obj, int index) {
        String channel = "channel_" + index;
        obj.setChannel(channel);
    }
    
    public void DeviceDataOnDemand.setCreateTime(Device obj, int index) {
        Date createTime = null;
        obj.setCreateTime(createTime);
    }
    
    public void DeviceDataOnDemand.setImei(Device obj, int index) {
        String imei = "imei_" + index;
        obj.setImei(imei);
    }
    
    public void DeviceDataOnDemand.setMac(Device obj, int index) {
        String mac = "mac_" + index;
        obj.setMac(mac);
    }
    
    public void DeviceDataOnDemand.setUserid(Device obj, int index) {
        Long userid = new Integer(index).longValue();
        obj.setUserid(userid);
    }
    
    public Device DeviceDataOnDemand.getSpecificDevice(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Device obj = data.get(index);
        Long id = obj.getId();
        return Device.findDevice(id);
    }
    
    public Device DeviceDataOnDemand.getRandomDevice() {
        init();
        Device obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Device.findDevice(id);
    }
    
    public boolean DeviceDataOnDemand.modifyDevice(Device obj) {
        return false;
    }
    
    public void DeviceDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Device.findDeviceEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Device' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Device>();
        for (int i = 0; i < 10; i++) {
            Device obj = getNewTransientDevice(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
