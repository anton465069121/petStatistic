// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.AuthenticationToken;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AuthenticationToken_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager AuthenticationToken.entityManager;
    
    public static final EntityManager AuthenticationToken.entityManager() {
        EntityManager em = new AuthenticationToken().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long AuthenticationToken.countAuthenticationTokens() {
        return entityManager().createQuery("SELECT COUNT(o) FROM AuthenticationToken o", Long.class).getSingleResult();
    }
    
    public static List<AuthenticationToken> AuthenticationToken.findAllAuthenticationTokens() {
        return entityManager().createQuery("SELECT o FROM AuthenticationToken o", AuthenticationToken.class).getResultList();
    }
    
    public static AuthenticationToken AuthenticationToken.findAuthenticationToken(String token) {
        if (token == null || token.length() == 0) return null;
        return entityManager().find(AuthenticationToken.class, token);
    }
    
    public static List<AuthenticationToken> AuthenticationToken.findAuthenticationTokenEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM AuthenticationToken o", AuthenticationToken.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void AuthenticationToken.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void AuthenticationToken.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            AuthenticationToken attached = AuthenticationToken.findAuthenticationToken(this.token);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void AuthenticationToken.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void AuthenticationToken.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public AuthenticationToken AuthenticationToken.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        AuthenticationToken merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
