// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.petstatistic.domain;

import com.petstatistic.domain.HistoryLog;
import com.petstatistic.domain.HistoryLogDataOnDemand;
import com.petstatistic.domain.HistoryLogIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HistoryLogIntegrationTest_Roo_IntegrationTest {
    
    declare @type: HistoryLogIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: HistoryLogIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: HistoryLogIntegrationTest: @Transactional;
    
    @Autowired
    private HistoryLogDataOnDemand HistoryLogIntegrationTest.dod;
    
    @Test
    public void HistoryLogIntegrationTest.testCountHistoryLogs() {
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", dod.getRandomHistoryLog());
        long count = HistoryLog.countHistoryLogs();
        Assert.assertTrue("Counter for 'HistoryLog' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void HistoryLogIntegrationTest.testFindHistoryLog() {
        HistoryLog obj = dod.getRandomHistoryLog();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to provide an identifier", id);
        obj = HistoryLog.findHistoryLog(id);
        Assert.assertNotNull("Find method for 'HistoryLog' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'HistoryLog' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void HistoryLogIntegrationTest.testFindAllHistoryLogs() {
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", dod.getRandomHistoryLog());
        long count = HistoryLog.countHistoryLogs();
        Assert.assertTrue("Too expensive to perform a find all test for 'HistoryLog', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<HistoryLog> result = HistoryLog.findAllHistoryLogs();
        Assert.assertNotNull("Find all method for 'HistoryLog' illegally returned null", result);
        Assert.assertTrue("Find all method for 'HistoryLog' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void HistoryLogIntegrationTest.testFindHistoryLogEntries() {
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", dod.getRandomHistoryLog());
        long count = HistoryLog.countHistoryLogs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<HistoryLog> result = HistoryLog.findHistoryLogEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'HistoryLog' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'HistoryLog' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void HistoryLogIntegrationTest.testFlush() {
        HistoryLog obj = dod.getRandomHistoryLog();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to provide an identifier", id);
        obj = HistoryLog.findHistoryLog(id);
        Assert.assertNotNull("Find method for 'HistoryLog' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyHistoryLog(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'HistoryLog' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void HistoryLogIntegrationTest.testMergeUpdate() {
        HistoryLog obj = dod.getRandomHistoryLog();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to provide an identifier", id);
        obj = HistoryLog.findHistoryLog(id);
        boolean modified =  dod.modifyHistoryLog(obj);
        Integer currentVersion = obj.getVersion();
        HistoryLog merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'HistoryLog' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void HistoryLogIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", dod.getRandomHistoryLog());
        HistoryLog obj = dod.getNewTransientHistoryLog(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'HistoryLog' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'HistoryLog' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void HistoryLogIntegrationTest.testRemove() {
        HistoryLog obj = dod.getRandomHistoryLog();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HistoryLog' failed to provide an identifier", id);
        obj = HistoryLog.findHistoryLog(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'HistoryLog' with identifier '" + id + "'", HistoryLog.findHistoryLog(id));
    }
    
}
