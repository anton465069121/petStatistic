// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.HistoryLog;
import java.util.Date;

privileged aspect HistoryLog_Roo_JavaBean {
    
    public long HistoryLog.getUserId() {
        return this.userId;
    }
    
    public void HistoryLog.setUserId(long userId) {
        this.userId = userId;
    }
    
    public Date HistoryLog.getHistoryDate() {
        return this.historyDate;
    }
    
    public void HistoryLog.setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }
    
    public long HistoryLog.getConnectTimes() {
        return this.connectTimes;
    }
    
    public void HistoryLog.setConnectTimes(long connectTimes) {
        this.connectTimes = connectTimes;
    }
    
}
