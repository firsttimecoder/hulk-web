package com.hulk;

import com.google.common.collect.Sets;
import com.hulk.data.model.*;
import com.hulk.data.repository.AgentRepository;
import com.hulk.data.repository.CallInfoRepository;
import com.hulk.data.repository.CallStatusChangeRepository;
import com.hulk.data.repository.EntityRepository;
import com.hulk.enums.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Created by vijayvar on 10/10/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HulkApplication.class)
@WebAppConfiguration
public class DbIntegrationTests {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private CallInfoRepository callInfoRepository;

    @Autowired
    private CallStatusChangeRepository callStatusChangeRepository;

    //@Test
    public void test1() {
        Agent a = new Agent();
        a.setId(1L);
        a.setDateOfBirth(new Date());
        a.setFirstName("ffddd");
        a.setHashedPassword("dafda");
        a.setLastName("la");
        a.setLoginId("faadfa");
        a.setRole(AgentRole.MANUFACTURER_EMPLOYEE);

        Address add = new Address();
        add.setCity(IndianCity.BENGALURU);
        add.setFirstLine("dafddda");
        add.setPincode("333333");
        add.setState(IndianState.HARYANA);
        a.setAddress(add);

        agentRepository.save(a);
    }

    //@Test
    public void test2() {
        Agent a = agentRepository.findOne(1L);
        String b = "";
    }

    //@Test
    public void test3() {
        Entity e = new Entity();
        e.setName("dddddddd");
        e.setDisplayName("dfafa");
        e.setType(EntityType.SERVICE_CENTRE);
        //e.setId(1L);

        Address add = new Address();
        add.setCity(IndianCity.CHANDIGARH);
        add.setFirstLine("dafddda");
        add.setPincode("333333");
        add.setState(IndianState.PUNJAB);
        //add.setId(4L);
        e.setAddress(add);

        entityRepository.save(e);
    }

//    @Test
    public void test4() {
        Entity e = entityRepository.findOne(2L);
        e.setType(EntityType.MANUFACTURER);

        Agent a = agentRepository.findOne(1L);
        a.getAddress().setState(IndianState.PUNJAB);

        e.setAgents(Sets.newHashSet(a));
        //a.setEntities(Sets.newHashSet(e));

        entityRepository.save(e);
    }

    //@Test
    public void test5() {
        CallInfo ci = new CallInfo();

        Address add = new Address();
        add.setCity(IndianCity.CHANDIGARH);
        add.setFirstLine("bb");
        add.setPincode("332221");
        add.setState(IndianState.PUNJAB);
        ci.setAddress(add);

        Agent a = new Agent();
        a.setId(1L);
        ci.setAssignedAgent(a);

        Entity e = new Entity();
        e.setId(2L);
        ci.setAssignedEntity(e);

        ci.setCurrentStatus(CallStatus.UNKNOWN);
        ci.setCustomerName("customername22");
        ci.setPriority(2);

        callInfoRepository.save(ci);
    }

//    @Test
    public void test6() {
        CallInfo ci = callInfoRepository.findOne(2L);
        ci.setCurrentStatus(CallStatus.UNKNOWN);

        callInfoRepository.save(ci);
    }

    //@Test
    public void test7() {
        CallStatusChange c = new CallStatusChange();

        CallInfo ci = new CallInfo();
        ci.setId(2L);
        c.setCallInfo(ci);

        Agent a = new Agent();
        a.setId(2L);
        c.setChangedByAgent(a);

        c.setNewStatus(CallStatus.COMPLETE);
        c.setOldStatus(CallStatus.UNKNOWN);

        callStatusChangeRepository.save(c);
    }

//    @Test
    public void test8() {
        CallInfo ci= callInfoRepository.findOne(2L);
        String a = "";
    }

//    @Test
    public void test9() {
        CallStatusChange c = callStatusChangeRepository.findOne(3L);
        String a = "";
    }
}
