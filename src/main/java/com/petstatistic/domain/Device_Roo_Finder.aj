// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.Device;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect Device_Roo_Finder {
    
    public static TypedQuery<Device> Device.findDevicesByImei(String imei) {
        if (imei == null || imei.length() == 0) throw new IllegalArgumentException("The imei argument is required");
        EntityManager em = Device.entityManager();
        TypedQuery<Device> q = em.createQuery("SELECT o FROM Device AS o WHERE o.imei = :imei", Device.class);
        q.setParameter("imei", imei);
        return q;
    }
    
    public static TypedQuery<Device> Device.findDevicesByMac(String mac) {
        if (mac == null || mac.length() == 0) throw new IllegalArgumentException("The mac argument is required");
        EntityManager em = Device.entityManager();
        TypedQuery<Device> q = em.createQuery("SELECT o FROM Device AS o WHERE o.mac = :mac", Device.class);
        q.setParameter("mac", mac);
        return q;
    }
    
}
