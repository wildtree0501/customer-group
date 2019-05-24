package com.wildtree.crm.customergroup;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:    条件类型
 * @Creater:        wildtree
 * @CreateDate:     2019/5/23 15:26
 * @Author:
 */
public enum ConditionType {
    CHECKBOX("com.wildtree.crm.customergroup.parsetype.CheckboxParser"),
    RADIO("com.wildtree.crm.customergroup.parsetype.RadioParser"),
    DATE("com.wildtree.crm.customergroup.parsetype.DateParser"),
    NUMBER("com.wildtree.crm.customergroup.parsetype.NumberParser"),
    RANGE("com.wildtree.crm.customergroup.parsetype.RangeParser"),
    TEXT("com.wildtree.crm.customergroup.parsetype.TextParser"),
    ;

    private String parser;
    public String getParser() {
        return parser;
    }
    public void setParser(String parser) {
        this.parser = parser;
    }
    private ConditionType(String parser) {
        this.parser = parser;
    }

    public static String getParser(String type) {
        if(StringUtils.isBlank(type)) return null;
        ConditionType[] types = ConditionType.values();
        for(int i = 0; i < types.length; i++) {
            if(types[i].equals(type)) {
                return types[i].getParser();
            }
        }
        return null;
    }
}
