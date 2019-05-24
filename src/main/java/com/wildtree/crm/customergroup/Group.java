package com.wildtree.crm.customergroup;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
/**
 * @Description:    客户分群 支持同类分群功能
 * @Creater:        wildtree
 * @CreateDate:     2019/5/23 14:05
 * @Author:
 */
public class Group {
    public List group(String conditions, PrimaryTable primaryTable, GroupMode mode) {
        if(conditions == null || conditions.isEmpty()) {
            return Collections.emptyList();
        }
        if(primaryTable == null) primaryTable = PrimaryTable.CUSTOMER;
        if(mode == null) mode = GroupMode.SIMPLEMODE;
        if(StringUtils.isBlank(primaryTable.getPrimaryTableName()) ||
                StringUtils.isBlank(primaryTable.getPrimaryKey()) ||
                StringUtils.isBlank(mode.getMode())) {
            return Collections.emptyList();
        }
        Group groupMode;
        try {
            groupMode = (Group)Class.forName(mode.getMode()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return groupMode.group(conditions, primaryTable, mode);
    }

}
