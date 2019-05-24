package com.wildtree.crm.customergroup.parsetype;

import com.wildtree.crm.customergroup.Condition;
/**
 * @Description:    范围解析
 * @Creater:        wildtree
 * @CreateDate:     2019/5/24 11:35
 * @Author:
 */
public class RangeParser implements TypePaser {
    /**
     * content: {}
     * @param condition
     * @return
     */
    @Override
    public String parse(Condition condition) {
        return null;
    }

    private enum range {
        BETWEEN, LARGER, SMALLER
    }
}
