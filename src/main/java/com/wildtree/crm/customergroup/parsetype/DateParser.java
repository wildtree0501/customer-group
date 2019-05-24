package com.wildtree.crm.customergroup.parsetype;

import com.wildtree.crm.customergroup.Condition;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description:    日期解析
 * @Creater:        wildtree
 * @CreateDate:     2019/5/24 10:16
 * @Author:
 */
public class DateParser implements TypePaser {
    /**
     * content: yyyy-MM-dd
     * @param condition
     * @return
     */
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
