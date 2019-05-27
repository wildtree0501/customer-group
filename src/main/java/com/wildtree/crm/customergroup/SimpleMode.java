package com.wildtree.crm.customergroup;

import com.alibaba.fastjson.JSON;
import com.wildtree.crm.customergroup.parsetype.TypePaser;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Description:    简单模式 = all and
 * @Creater:        wildtree
 * @CreateDate:     2019/5/23 15:25
 * @Author:
 */
public class SimpleMode extends Group {

    private Map<String, String> sqlMap = new HashMap<>();
    private StringBuilder primaryCondition = new StringBuilder(" where 1=1 ");

    @Override
    public List group(String conditions, PrimaryTable primaryTable, GroupMode mode) {
        initPrimaryTableSql(primaryTable.getPrimaryTableName());
        List<Condition> condList = JSON.parseArray(conditions, Condition.class);
        for(Condition cond : condList) {
            if(!sqlMap.containsKey(cond.getTableName())) {
                initJoinTableSql(primaryTable, cond);
            }
            String parser = ConditionType.getParser(cond.getType());
            if(StringUtils.isBlank(parser)) return Collections.emptyList();
            TypePaser parserClass;
            try {
                parserClass = (TypePaser)Class.forName(parser).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
            if(cond.getTableName().equals(primaryTable.getPrimaryTableName())) {
                primaryCondition.append(parserClass.parse(cond));
            } else {
                concatTableSql(cond.getTableName(), parserClass.parse(cond));
            }
        }
        //拼接sql并执行
        StringBuilder sb = new StringBuilder();
        for(Map.Entry entry : sqlMap.entrySet()) {
            sb.append(entry.getValue());
        }
        sb.append(primaryCondition);
        System.out.println(sb.toString());
        return Collections.emptyList();
    }

    /**
     * 初始化主表sql
     * @param primaryTableName
     */
    private void initPrimaryTableSql(String primaryTableName) {
        StringBuilder sb = new StringBuilder("select ").append(primaryTableName)
                .append(".* from ").append(primaryTableName);
        sqlMap.put(primaryTableName, sb.toString());
    }

    /**
     * 初始化关联表sql
     * @param primaryTable
     * @param cond
     */
    private void initJoinTableSql(PrimaryTable primaryTable, Condition cond) {
        StringBuilder sb = new StringBuilder(" inner join ").append(cond.getTableName())
                .append(" on ").append(cond.getTableName()).append(".")
                .append(cond.getJoinColumnName()).append("=")
                .append(primaryTable.getPrimaryTableName())
                .append(".").append(primaryTable.getPrimaryKey());
        sqlMap.put(cond.getTableName(), sb.toString());
    }

    /**
     * 拼接sql
     * @param tableName
     * @param sql
     */
    private void concatTableSql(String tableName, String sql) {
        if(StringUtils.isNotBlank(sql)) {
            StringBuilder sb = new StringBuilder(sqlMap.get(tableName)).append(sql);
            sqlMap.put(tableName, sb.toString());
        }
    }

}
