package com.wildtree.crm.customergroup.parsetype;

import com.alibaba.fastjson.JSON;
import com.wildtree.crm.customergroup.Condition;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Description:    多选框解析
 * @Creater:        wildtree
 * @CreateDate:     2019/5/23 15:29
 * @Author:
 */
public class CheckboxParser implements TypePaser {

    /**
     * content: [value1, value2, value3, ...]
     * @param condition
     * @return
     */
    @Override
    public String parse(Condition condition) {
        String content = condition.getContent();
        if(StringUtils.isBlank(content)) return null;
        List<String> values = JSON.parseArray(content, String.class);
        if(values == null || values.isEmpty()) return null;
        StringBuilder sb = new StringBuilder(" and ")
                .append(condition.getTableName()).append(".")
                .append(condition.getColumnName()).append(" in (");
        for(int i = 0; i < values.size(); i++) {
            sb.append("'").append(values.get(i)).append("'");
            if(i == values.size() - 1) {
                sb.append(") ");
            } else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
