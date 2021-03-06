// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.HistoryLog;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HistoryLog_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager HistoryLog.entityManager;
    
    public static final EntityManager HistoryLog.entityManager() {
        EntityManager em = new HistoryLog().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long HistoryLog.countHistoryLogs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM HistoryLog o", Long.class).getSingleResult();
    }
    
    public static List<HistoryLog> HistoryLog.findAllHistoryLogs() {
        return entityManager().createQuery("SELECT o FROM HistoryLog o", HistoryLog.class).getResultList();
    }
    
    public static HistoryLog HistoryLog.findHistoryLog(Long id) {
        if (id == null) return null;
        return entityManager().find(HistoryLog.class, id);
    }
    
    public static List<HistoryLog> HistoryLog.findHistoryLogEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM HistoryLog o", HistoryLog.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void HistoryLog.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void HistoryLog.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            HistoryLog attached = HistoryLog.findHistoryLog(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void HistoryLog.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void HistoryLog.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public HistoryLog HistoryLog.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        HistoryLog merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
