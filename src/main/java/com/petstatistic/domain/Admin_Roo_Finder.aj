// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.Admin;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect Admin_Roo_Finder {
    
    public static TypedQuery<Admin> Admin.findAdminsByPasswordEquals(String password) {
        if (password == null || password.length() == 0) throw new IllegalArgumentException("The password argument is required");
        EntityManager em = Admin.entityManager();
        TypedQuery<Admin> q = em.createQuery("SELECT o FROM Admin AS o WHERE o.password = :password", Admin.class);
        q.setParameter("password", password);
        return q;
    }
    
}
