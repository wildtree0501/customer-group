package com.wildtree.crm.customergroup.parsetype;

import com.wildtree.crm.customergroup.Condition;
import org.apache.commons.lang3.StringUtils;
/**
 * @Description:    文本解析
 * @Creater:        wildtree
 * @CreateDate:     2019/5/24 11:31
 * @Author:
 */
public class TextParser implements TypePaser {
    @Override
    public String parse(Condition condition) {
        String content = condition.getContent();
        if(StringUtils.isBlank(content)) return null;
        StringBuilder sb = new StringBuilder(" and ")
                .append(condition.getTableName()).append(".")
                .append(condition.getColumnName()).append(" likes '%")
                .append(content).append("%'");
        return sb.toString();
    }
}
