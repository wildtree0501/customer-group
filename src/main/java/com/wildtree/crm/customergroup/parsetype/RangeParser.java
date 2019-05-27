package com.wildtree.crm.customergroup.parsetype;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wildtree.crm.customergroup.Condition;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description:    范围解析
 * @Creater:        wildtree
 * @CreateDate:     2019/5/24 11:35
 * @Author:
 */
public class RangeParser implements TypePaser {
    /**
     * content: {type: between/larger/smaller, start: '', end: '', value: ''}
     * @param condition
     * @return
     */
    @Override
    public String parse(Condition condition) {
        String content = condition.getContent();
        if(StringUtils.isBlank(content)) return null;
        JSONObject obj = JSON.parseObject(content);
        String type;
        if(obj == null || StringUtils.isBlank(type = obj.getString("type"))) return null;
        StringBuilder sb = new StringBuilder(" and ")
                .append(condition.getTableName()).append(".")
                .append(condition.getColumnName());
        if(StringUtils.equalsIgnoreCase(type, "between")) {
            sb.append(" between ").append(obj.getString("start"))
                    .append(" and ").append(obj.getString("end"));
        } else if(StringUtils.equalsIgnoreCase(type, "larger")) {
            sb.append(" > ").append(obj.getString("value"));
        } else if(StringUtils.equalsIgnoreCase(type, "smaller")) {
            sb.append(" < ").append(obj.getString("value"));
        } else {
            sb.append(" 1=1 ");
        }
        return sb.toString();
    }

}

