// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.PetUser;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect PetUser_Roo_Jpa_Entity {
    
    declare @type: PetUser: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long PetUser.id;
    
    @Version
    @Column(name = "version")
    private Integer PetUser.version;
    
    public Long PetUser.getId() {
        return this.id;
    }
    
    public void PetUser.setId(Long id) {
        this.id = id;
    }
    
    public Integer PetUser.getVersion() {
        return this.version;
    }
    
    public void PetUser.setVersion(Integer version) {
        this.version = version;
    }
    
}
