package com.wildtree.crm.customergroup;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerGroupApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        List<Condition> conditions = new ArrayList();
        Condition condition = new Condition();
        condition.setTableName("t1");
        condition.setColumnName("c1");
        condition.setJoinColumnName("cusid");
        condition.setType("range");
        Map content = new HashMap();
        content.put("type", "between");
        content.put("start", 1);
        content.put("end", 6);
        condition.setContent(JSON.toJSONString(content));
        Condition condition1 = new Condition();
        condition1.setTableName("t1");
        condition1.setColumnName("c1");
        condition1.setJoinColumnName("cusid");
        condition1.setType("range");
        Map content1 = new HashMap();
        content1.put("type", "larger");
        content1.put("value", 1);
        condition1.setContent(JSON.toJSONString(content1));
        conditions.add(condition);
        conditions.add(condition1);
        Group group = new Group();
        group.group(JSON.toJSONString(conditions), null, null);
    }

}
