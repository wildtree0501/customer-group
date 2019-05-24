package com.wildtree.crm.customergroup.parsetype;

import com.wildtree.crm.customergroup.Condition;
/**
 * @Description:    条件类型解析
 * @Creater:        wildtree
 * @CreateDate:     2019/5/23 15:27
 * @Author:
 */
public interface TypePaser {
    public String parse(Condition condition);
}
