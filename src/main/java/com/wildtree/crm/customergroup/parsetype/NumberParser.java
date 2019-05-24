package com.wildtree.crm.customergroup.parsetype;

import com.wildtree.crm.customergroup.Condition;
import org.apache.commons.lang3.StringUtils;
/**
 * @Description:    数值解析
 * @Creater:        wildtree
 * @CreateDate:     2019/5/24 11:30
 * @Author:
 */
public class NumberParser implements TypePaser {
    @Override
    public String parse(Condition condition) {
        String content = condition.getContent();
        if(StringUtils.isBlank(content)) return null;
        StringBuilder sb = new StringBuilder(" and ")
                .append(condition.getTableName()).append(".")
                .append(condition.getColumnName()).append(" = ")
                .append(content);
        return sb.toString();
    }
}
