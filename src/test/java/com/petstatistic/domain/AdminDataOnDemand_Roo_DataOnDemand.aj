// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.Admin;
import com.petstatistic.domain.AdminDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect AdminDataOnDemand_Roo_DataOnDemand {
    
    declare @type: AdminDataOnDemand: @Component;
    
    private Random AdminDataOnDemand.rnd = new SecureRandom();
    
    private List<Admin> AdminDataOnDemand.data;
    
    public Admin AdminDataOnDemand.getNewTransientAdmin(int index) {
        Admin obj = new Admin();
        setPassword(obj, index);
        setUserName(obj, index);
        return obj;
    }
    
    public void AdminDataOnDemand.setPassword(Admin obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }
    
    public void AdminDataOnDemand.setUserName(Admin obj, int index) {
        String userName = "userName_" + index;
        obj.setUserName(userName);
    }
    
    public Admin AdminDataOnDemand.getSpecificAdmin(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Admin obj = data.get(index);
        Long id = obj.getId();
        return Admin.findAdmin(id);
    }
    
    public Admin AdminDataOnDemand.getRandomAdmin() {
        init();
        Admin obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Admin.findAdmin(id);
    }
    
    public boolean AdminDataOnDemand.modifyAdmin(Admin obj) {
        return false;
    }
    
    public void AdminDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Admin.findAdminEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Admin' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Admin>();
        for (int i = 0; i < 10; i++) {
            Admin obj = getNewTransientAdmin(i);
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
